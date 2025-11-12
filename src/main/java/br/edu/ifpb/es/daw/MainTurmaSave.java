package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.TurmaDAO;
import br.edu.ifpb.es.daw.dao.impl.TurmaDAOImpl;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainTurmaSave {
    public static void main(String[] args) {


        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            TurmaDAO dao = new TurmaDAOImpl(emf);

            //Criação da pessoa do professor
            Pessoa pessoaProfessor = new Pessoa();
            pessoaProfessor.setNome("Ricardo Gomes");
            pessoaProfessor.setCpf("123.987.456-00");
            pessoaProfessor.setEmail("ricardo@ifpb.edu.br");
            pessoaProfessor.setTelefone("83991234567");
            pessoaProfessor.setSenha_hash("senhaRicardo");

            //Criação do professor
            Professor professor = new Professor();
            professor.setPessoa(pessoaProfessor);

            //Criação da disciplina
            Disciplina disciplina = new Disciplina();
            disciplina.setNome("Matemática Básica");
            disciplina.setEmenta("Operações fundamentais, frações, equações e raciocínio lógico.");
            disciplina.setCh(60);
            disciplina.setProfessor(professor);

            //Criação da turma
            Turma turma = new Turma();
            turma.setNome("2º Ano - B");
            turma.setTurno("Manhã");
            turma.setDisciplinas(List.of(disciplina));

            //Criação da pessoa (aluno)
            Pessoa pessoaAluno = new Pessoa();
            pessoaAluno.setNome("Luan Loreto");
            pessoaAluno.setCpf("111.222.333-44");
            pessoaAluno.setEmail("luanloreto@gmail.com");
            pessoaAluno.setTelefone("839981635");
            pessoaAluno.setSenha_hash("123456");

            //Criação do aluno
            Aluno aluno = new Aluno();
            aluno.setMatricula("" + System.nanoTime());
            aluno.setPessoa(pessoaAluno);
            aluno.setTurma(turma);

            turma.setAlunos(List.of(aluno));
            disciplina.setTurmas(List.of(turma));


            dao.save(turma);

        }catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar turma", e);
        }
    }
}
