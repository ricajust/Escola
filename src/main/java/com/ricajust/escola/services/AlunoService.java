package com.ricajust.escola.services;

import com.ricajust.escola.entities.Aluno;
import com.ricajust.escola.exceptions.BusinessException;
import com.ricajust.escola.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {
    @Autowired
    private AlunoRepository repository;

    public void salvar(Aluno aluno) {
        repository.save(aluno);
    }

    public Aluno localizarPorId(int idAluno) {
        return repository
                .findById(idAluno)
                .orElseThrow(() -> new BusinessException("Aluno " + idAluno + " não foi localizado!"));
    }

    public List<Aluno> localizarTodos() {
        return repository.findAll();
    }

    public Aluno editar(int idAluno, Aluno dadosAtualizados) {
        Aluno alunoLocalizado = localizarPorId(idAluno);

        alunoLocalizado.setNome(dadosAtualizados.getNome());
        alunoLocalizado.setEndereco(dadosAtualizados.getEndereco());
        alunoLocalizado.setBairro(dadosAtualizados.getBairro());
        alunoLocalizado.setCidade(dadosAtualizados.getCidade());
        alunoLocalizado.setEstado(dadosAtualizados.getEstado());
        alunoLocalizado.setTelefone(dadosAtualizados.getTelefone());

        return repository.save(alunoLocalizado);
    }

    public void excluir(int idAluno) {
        this.localizarPorId(idAluno);

        repository.deleteById(idAluno);
    }
}
