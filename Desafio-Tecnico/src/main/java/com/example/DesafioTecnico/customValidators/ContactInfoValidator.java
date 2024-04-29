package com.example.DesafioTecnico.customValidators;

import com.example.DesafioTecnico.dto.request.PersonaRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static io.micrometer.common.util.StringUtils.isBlank;
import static io.micrometer.common.util.StringUtils.isNotBlank;

public class ContactInfoValidator implements ConstraintValidator<ValidContactInfo, PersonaRequest> {

    @Override
    public void initialize(ValidContactInfo constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(PersonaRequest request, ConstraintValidatorContext context) {
        return (request.getNumeroTelefonico() == 0 && isBlank(request.getEmail()))
                || (request.getNumeroTelefonico() == 0 && isNotBlank(request.getEmail()))
                || (request.getNumeroTelefonico() != 0 && isBlank(request.getEmail()));
    }
}
