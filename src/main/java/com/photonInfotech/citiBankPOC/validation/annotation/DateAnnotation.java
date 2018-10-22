package com.photonInfotech.citiBankPOC.validation.annotation;

import com.photonInfotech.citiBankPOC.validation.*;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateAnnotation {


    String message() default "{Date}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}