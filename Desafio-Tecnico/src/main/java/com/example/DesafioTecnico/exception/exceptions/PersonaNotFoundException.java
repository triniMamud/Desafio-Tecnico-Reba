package com.example.DesafioTecnico.exception.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class PersonaNotFoundException extends RuntimeException {
    public PersonaNotFoundException(String message) {
        super(message);
    }
}
