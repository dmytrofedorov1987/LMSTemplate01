package com.example.lmstemplate01.validators.uniqueValidators;


import com.example.lmstemplate01.model.Account;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Constraint(validatedBy = FieldEqualsValidator.class)
@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
public @interface FieldEquals {
    String MESSAGE = "fields.notMatches";

    String message() default MESSAGE;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Documented
    @Target({TYPE, FIELD, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @interface List {
        FieldEquals[] value();
    }

    String field();

       //String equalsTo();


}
