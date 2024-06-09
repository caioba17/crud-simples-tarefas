package com.example.todolist.infra;


import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExcecaoDto {
    private String message;
    private Integer erro;
    private HttpStatus status;

    public ExcecaoDto(String message, Integer erro, HttpStatus status) {
        this.message = message;
        this.erro = erro;
        this.status = status;
    }
}
