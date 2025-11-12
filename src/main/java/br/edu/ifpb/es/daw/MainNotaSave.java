package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.NotaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.NotaDAOImpl;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainNotaSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            NotaDAO dao = new NotaDAOImpl(emf);
            Nota nota = new Nota();

            Turma turma= new Turma();
            turma.setNome("1-A");

            Pessoa pessoa = new Pessoa();
            pessoa.setNome("João da Silva");
            pessoa.setCpf("12082839851");
            pessoa.setEmail("joao@email.com");

            Aluno aluno = new Aluno();
            turma.setAlunos(List.of(aluno));
            aluno.setTurma(turma);
            aluno.setPessoa(pessoa);
            aluno.setMatricula("" + System.nanoTime());

            Simulado simulado= new Simulado();


            nota.setAluno(aluno);
            nota.setSimulado(simulado);
            nota.setNotaLinguagens(9.5);
            nota.setNotaRedacao(9.5);
            nota.setNotaMatematica(9.5);
            nota.setNotaCienciasHumanas(9.5);
            nota.setNotaCienciasNatureza(9.5);

            dao.save(nota);

            System.out.println("Nota salva com sucesso!");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar a nota", e);
        }
    }
}