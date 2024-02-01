package com.example.lmstemplate01.validators.uniqueValidators;

import com.example.lmstemplate01.model.Account;
import com.example.lmstemplate01.model.Role;
import com.example.lmstemplate01.repositoryJPA.AccountRepository;
import com.example.lmstemplate01.repositoryJPA.RoleRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class FieldUniqueValidator implements ConstraintValidator<FieldUnique, Object> {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
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
        List<Object> list = getObjectsFromTable(table);
        return list.stream().map(a -> {
            Object value = null;
            Class<?> cl = a.getClass();
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

    private List<Object> getObjectsFromTable(String table) {
        List<Object> list = new ArrayList<>();
        switch (table) {
            case "Account" -> {
                List<Account> listAccount = accountRepository.findAll();
                list.addAll(listAccount);
            }
            case "Role" -> {
                List<Role> listRole = roleRepository.findAll();
                list.addAll(listRole);
            }
        }
        return list;
    }
}




