package com.ricajust.escola.services;

import com.ricajust.escola.entities.Matricula;
import com.ricajust.escola.exceptions.BusinessException;
import com.ricajust.escola.repositories.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository repository;

    public void salvar(Matricula matricula) {
        repository.save(matricula);
    }

    public Matricula localizarPorId(int idMatricula) {
        return repository
                    .findById(idMatricula)
                    .orElseThrow(() -> new BusinessException("Matrícula " + idMatricula + " não localizada!"));
    }

    public List<Matricula> localizarTodos() {
        return repository.findAll();
    }

    public Matricula editar(int idMatricula, Matricula dadosAtualizados) {
        Matricula matriculaLocalizada = this.localizarPorId(idMatricula);

        matriculaLocalizada.setDataMatricula(dadosAtualizados.getDataMatricula());
        matriculaLocalizada.setTurma(dadosAtualizados.getTurma());
        matriculaLocalizada.setAluno(dadosAtualizados.getAluno());

        return repository.save(matriculaLocalizada);
    }

    public void excluir(int idMatricula) {
        this.localizarPorId(idMatricula);

        repository.deleteById(idMatricula);
    }
}
