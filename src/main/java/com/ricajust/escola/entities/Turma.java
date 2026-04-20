package com.ricajust.escola.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "Turma")
@Data
public class Turma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idTurma", nullable = false)
    private int idTurma;

    @NotBlank(message = "O período deve ser informado (Manhã/Tarde/Noite)")
    @Column(name = "periodo", length = 10)
    private String periodo;

    @NotBlank(message = "O nome da turma não pode estar vazio")
    @Column(name = "turma", length = 20)
    private String turma;

}
