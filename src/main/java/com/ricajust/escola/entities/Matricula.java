package com.ricajust.escola.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "Matricula")
@Data
public class Matricula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMatricula")
    private int idMatricula;

    @Column(name = "dataMatricula")
    private LocalDate dataMatricula;

    @ManyToOne
    @JoinColumn(name = "idTurma", referencedColumnName = "idTurma", nullable = false)
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "idAluno", referencedColumnName = "idAluno", nullable = false)
    private Aluno aluno;
}
