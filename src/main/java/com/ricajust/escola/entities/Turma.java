package com.ricajust.escola.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Turma")
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTurma", nullable = false)
    private int idTurma;

    @Column(name = "periodo", length = 10)
    private String periodo;

    @Column(name = "turma", length = 20)
    private String turma;

}
