package com.example.DesafioTecnico.customValidators;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContactInfoValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidContactInfo {

    String message() default "La persona deben tener al menos un dato de contacto.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
