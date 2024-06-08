package com.example.todolist.controllers;

import com.example.todolist.domain.tarefa.AlterarTarefa;
import com.example.todolist.domain.tarefa.RequisitarTarefa;
import com.example.todolist.domain.tarefa.Tarefa;
import com.example.todolist.domain.tarefa.TarefaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaRepository repositorio;

    @GetMapping
    public ResponseEntity getTarefas() {
        var tarefas = repositorio.findAll();
        return ResponseEntity.ok(tarefas);
    }

    @PostMapping
    public ResponseEntity addTarefas(@RequestBody @Valid RequisitarTarefa data) {
        Tarefa tarefa = new Tarefa(data);
        repositorio.save(tarefa);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity alterTarefas(@RequestBody @Valid AlterarTarefa data) {
        Optional<Tarefa> tarefa = repositorio.findById(data.id());
        if (tarefa.isPresent()) {
            Tarefa tar = tarefa.get();

            if (data.descricao() != null) {
                tar.setDescricao(data.descricao());
            }
            if (data.tipo() != null) {
                tar.setTipo(data.tipo());
            }
            if (data.feito() != null) {
                tar.setFeito(data.feito());
            }

            return ResponseEntity.ok(tar);
        } else {
            throw new EntityNotFoundException();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteTarefas(@PathVariable Long id) {
        Optional<Tarefa> tarefaOpc = repositorio.findById(id);

        if (tarefaOpc.isPresent()) {
            Tarefa tarefa = tarefaOpc.get();
            repositorio.delete(tarefa);
            return ResponseEntity.ok().build();
        } else {
            throw new EntityNotFoundException();
        }
    }
}
