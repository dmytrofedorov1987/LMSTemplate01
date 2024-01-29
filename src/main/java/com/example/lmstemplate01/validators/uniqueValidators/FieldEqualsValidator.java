package com.example.lmstemplate01.validators.uniqueValidators;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Method;
import java.util.List;

public class FieldEqualsValidator implements ConstraintValidator<FieldUnique, String> {
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
    public boolean isValid(String valueDTO, ConstraintValidatorContext context) {

        try {
            final Object fieldObject = getProperty(valueDTO, field);
            final Object equalsToObject = getProperty(value, field);

            if (fieldObject == null && equalsToObject == null) {
                return true;
            }

            boolean matches = (fieldObject != null)
                    && fieldObject.equals(equalsToObject);

            if (!matches) {
                String msg = this.message;
                if (this.message == null
                        || "".equals(this.message)
                        || FieldUnique.MESSAGE.equals(this.message)) {
                    msg = field + " is not equal to " + field;
                }
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(msg)
                        .addNode(field).addConstraintViolation();
            }

            return matches;
        } catch (final Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    private Object getProperty(String value, String fieldName) {
        Class<?> cl = value.getClass();
        String methodName = "get" + Character.toUpperCase(fieldName.charAt(0))
                + fieldName.substring(1);
        try {
            Method method = cl.getDeclaredMethod(methodName, new Class[0]);
            return method.invoke(value);
        } catch (Exception e) {
        }
        return null;
    }
    private List<Object> getValue(String fieldName, String table){

    }

}
