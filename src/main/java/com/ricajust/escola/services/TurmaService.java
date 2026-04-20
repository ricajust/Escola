package com.ricajust.escola.services;

import com.ricajust.escola.entities.Turma;
import com.ricajust.escola.exceptions.BusinessException;
import com.ricajust.escola.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ExpressionException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaService {
    @Autowired
    private TurmaRepository repository;

    public void salvar(Turma turma) {
        repository.save(turma);
    }

    public Turma localizarPorId(int idTurma) {
        return repository
                .findById(idTurma)
                .orElseThrow(() -> new ExpressionException("Turma " + idTurma + " não localizada!"));
    }

    public List<Turma> localizarTodos() {
        return repository.findAll();
    }

    public Turma editar(int idTurma, Turma dadosAtualizados) {
        Turma turmaSelecionada = this.localizarPorId(idTurma);

        turmaSelecionada.setPeriodo(dadosAtualizados.getPeriodo());
        turmaSelecionada.setTurma(dadosAtualizados.getTurma());

        return repository.save(turmaSelecionada);
    }

    public void excluir(int idTurma) {
        this.localizarPorId(idTurma);

        repository.deleteById(idTurma);
    }
}
