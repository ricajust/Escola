package com.ricajust.escola.controllers;

import com.ricajust.escola.entities.Matricula;
import com.ricajust.escola.services.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matricula")
public class MatriculaController {
    @Autowired
    private MatriculaService service;

    @PostMapping
    public ResponseEntity<Void> criarNovaMatricula(@Validated @RequestBody Matricula matricula) {
        service.salvar(matricula);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Matricula> localizarMatriculaPorId(@PathVariable("id") int id) {
        Matricula matriculaLocalizada = service.localizarPorId(id);

        return ResponseEntity.ok(matriculaLocalizada);
    }

    @GetMapping
    public ResponseEntity<List<Matricula>> localizarTodasMatriculas() {
        List<Matricula> matriculas = service.localizarTodos();

        return ResponseEntity.ok(matriculas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Matricula> editarUmaMatricula(@PathVariable("id") int id, @RequestBody Matricula dadosAtualizados) {
        Matricula matricula = service.editar(id, dadosAtualizados);

        return ResponseEntity.ok(matricula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirUmaMatricula(@PathVariable("id") int id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
