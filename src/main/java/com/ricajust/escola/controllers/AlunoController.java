package com.ricajust.escola.controllers;

import com.ricajust.escola.entities.Aluno;
import com.ricajust.escola.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {
    @Autowired
    private AlunoService service;

    @PostMapping
    public void criarNovoAluno(@Validated @RequestBody Aluno aluno) {
        service.salvar(aluno);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> localizarAlunoPorId(@PathVariable("id") int id) {
        Aluno alunoLocalizado = service.localizarPorId(id);

        return ResponseEntity.ok(alunoLocalizado);
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> localizarTodosAlunos() {
        List<Aluno> alunos = service.localizarTodos();

        return ResponseEntity.ok(alunos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> editarUmAluno(@PathVariable("id") int id, @RequestBody Aluno dadosAtualizados) {
        Aluno aluno =  service.editar(id, dadosAtualizados);

        return ResponseEntity.ok(aluno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUmAluno(@PathVariable("id") int id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
