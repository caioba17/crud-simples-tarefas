package com.example.todolist.domain.tarefa;

import jakarta.validation.constraints.NotBlank;

public record RequisitarTarefa(Long id, @NotBlank String descricao, Boolean feito, @NotBlank String tipo) {
}
