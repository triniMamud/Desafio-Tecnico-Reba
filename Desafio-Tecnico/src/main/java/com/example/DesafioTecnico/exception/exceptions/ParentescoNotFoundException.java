package com.example.DesafioTecnico.exception.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ParentescoNotFoundException extends RuntimeException {
    public ParentescoNotFoundException(String message) {
        super(message);
    }
}
