package com.example.todolist.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@RestControllerAdvice
public class TratarExcecoes {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExcecaoDto> error404() {
        ExcecaoDto resposta = new ExcecaoDto("Conteúdo não encontrado com ID fornecido", 404);
        return ResponseEntity.badRequest().body(resposta);
    }
}
