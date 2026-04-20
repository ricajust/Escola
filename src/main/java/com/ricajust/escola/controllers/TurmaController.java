package com.ricajust.escola.controllers;

import com.ricajust.escola.entities.Turma;
import com.ricajust.escola.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {
    @Autowired
    private TurmaService service;

    @PostMapping
    public void criarNovaTurma(@Validated @RequestBody Turma turma) {
        service.salvar(turma);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> localizarTurmaPorId(@PathVariable int id) {
        Turma turma = service.localizarPorId(id);

        return ResponseEntity.ok(turma);
    }

    @GetMapping
    public ResponseEntity<List<Turma>> localizarTodasTurmas() {
        List<Turma> turmas = service.localizarTodos();

        return ResponseEntity.ok(turmas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> editarUmaTurma(@PathVariable("id") int id, @RequestBody Turma dadosAtualizados) {
        Turma turma = service.editar(id, dadosAtualizados);

        return ResponseEntity.ok(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUmaTurma(@PathVariable("id") int id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
