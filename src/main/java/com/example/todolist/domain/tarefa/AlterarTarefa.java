package com.example.todolist.domain.tarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AlterarTarefa(@NotNull Long id, String descricao, Boolean feito, String tipo) {
}
