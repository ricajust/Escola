package com.ricajust.escola.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Aluno")
@Data
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAluno", nullable = false)
    private int idAluno;

    @Column(name = "nome", length = 40)
    private String nome;

    @Column(name = "endereco", length = 40)
    private String endereco;

    @Column(name = "bairro", length = 25)
    private String bairro;

    @Column(name = "cidade", length = 25)
    private String cidade;

    @Column(name = "estado", length = 2)
    private String estado;

    @Column(name = "telefone", length = 14)
    private String telefone;
}
