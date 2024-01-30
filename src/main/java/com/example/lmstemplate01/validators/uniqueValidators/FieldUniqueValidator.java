package com.example.lmstemplate01.validators.uniqueValidators;

import com.example.lmstemplate01.model.Account;
import com.example.lmstemplate01.repositoryJPA.AccountRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
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
            try {
                final Object fieldObject = getProperty(valueDTO, field);
                final Object equalsToObject = getProperty(a, field);

                if (fieldObject == null && equalsToObject == null) {
                    return true;
                }
                if ((fieldObject != null) && fieldObject.equals(equalsToObject)) {
                    return false;
                }

            } catch (final Exception e) {
                e.printStackTrace();
            }
            return true;
        };

        if (valueList.stream().allMatch(predicate)) {
            return true;
        } else {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(this.message)
                    .addNode(field).addConstraintViolation();
            return false;
        }
    }

    private Object getProperty(Object value, String fieldName) {
        Class<?> cl = value.getClass();
        String methodName = "get" + Character.toUpperCase(fieldName.charAt(0))
                + fieldName.substring(1);
        try {
            Method method = cl.getDeclaredMethod(methodName, new Class[0]);
            return method.invoke(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Object> getValue(String fieldName) {
        List<Account> accountList = accountRepository.findAll();
        return accountList.stream().map(a -> {
            Object value = null;
            try {
                Field field1 = a.getClass().getDeclaredField(fieldName);
                field1.setAccessible(true);
                value = field1.get(a);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
            return value;
        }).collect(Collectors.toList());
    }
}
