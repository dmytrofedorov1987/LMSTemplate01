package com.example.lmstemplate01.validators.uniqueValidators;

import com.example.lmstemplate01.model.Account;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Method;
import java.util.Optional;

public class FieldEqualsValidator implements ConstraintValidator<FieldEquals, Object> {
    private String field;
    //private String equalsTo;
    private String message = FieldEquals.MESSAGE;

    @Override
    public void initialize(FieldEquals constraintAnnotation) {
        this.message = constraintAnnotation.message();
        this.field = constraintAnnotation.field();
        //this.equalsTo = constraintAnnotation.equalsTo();
    }

    @Override
    public boolean isValid(Object usernameDTO, ConstraintValidatorContext context) {
        
        try {
            final Object fieldObject = getProperty(usernameDTO, field);
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
                        || FieldEquals.MESSAGE.equals(this.message)) {
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

    private Object getProperty(Object value, String fieldName) {
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

}
