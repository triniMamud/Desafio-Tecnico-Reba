package com.example.DesafioTecnico.exception.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PersonaAlreadyExistsException extends RuntimeException {
    public PersonaAlreadyExistsException(String message) {
        super(message);
    }
}
