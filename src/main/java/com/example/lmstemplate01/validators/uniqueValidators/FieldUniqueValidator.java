package com.example.lmstemplate01.validators.uniqueValidators;

import com.example.lmstemplate01.model.Account;
import com.example.lmstemplate01.repositoryJPA.AccountRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FieldUniqueValidator implements ConstraintValidator<FieldUnique, Object> {
    @Autowired
    AccountRepository accountRepository;
    private String field;
    private String table;
    private String message = FieldUnique.MESSAGE;

    @Override
    public void initialize(FieldUnique constraintAnnotation) {
        this.message = constraintAnnotation.message();
        this.field = constraintAnnotation.field();
        this.table = constraintAnnotation.table();
    }

    @Override
    public boolean isValid(Object valueDTO, ConstraintValidatorContext context) {

        List<Object> valueList = getValue(field);
        Predicate<Object> predicate = a -> {
            if (valueDTO == null && a == null) {
                return true;
            }
            if ((valueDTO != null) && valueDTO.equals(a)) {
                return false;
            }
            return true;
        };

        if (valueList.stream().allMatch(predicate)) {
            return true;
        }
        context.buildConstraintViolationWithTemplate(this.message)
                .addConstraintViolation();
        context.disableDefaultConstraintViolation();
        return false;

    }

    private List<Object> getValue(String fieldName) {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map(a -> {
            Object value = null;
            Class cl = a.getClass();
            try {
                Field field = cl.getDeclaredField(fieldName);
                field.setAccessible(true);
                value = field.get(a);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return value;
        }).collect(Collectors.toList());
    }
}




