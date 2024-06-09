package com.example.todolist.domain.tarefa;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name="tarefa")
@Entity(name="tarefa")
@EqualsAndHashCode(of = "id")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tarefa {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private Boolean feito;
    private String tipo;
    private LocalDateTime tempo;

    public Tarefa(RequisitarTarefa data) {
        this.descricao = data.descricao();
        this.feito = false;
        this.tipo = data.tipo();
        this.tempo = LocalDateTime.now();
    }

}
