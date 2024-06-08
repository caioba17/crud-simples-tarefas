package com.example.todolist.infra;


import lombok.Getter;

@Getter
public class ExcecaoDto {
    protected String message;
    protected Integer erro;

    public ExcecaoDto(String message, Integer erro) {
        this.message = message;
        this.erro = erro;
    }
}
