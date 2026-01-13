package br.edu.ifpb.es.daw.dao;

import br.edu.ifpb.es.daw.entities.Aluno;
import br.edu.ifpb.es.daw.entities.Turma;

import java.util.List;

public interface AlunoDAO extends DAO<Aluno, Long>{


    Aluno findByMatricula(String matricula) throws PersistenciaDawException;


    List<Aluno> findByTurma(Turma turma) throws PersistenciaDawException;


    Aluno findByNomeAndEmail(String nome, String email) throws PersistenciaDawException;


    Long countAlunosByNomeTurma(String nomeTurma) throws PersistenciaDawException;


    Aluno findAlunoWithMensalidades(Long id) throws PersistenciaDawException;

}
