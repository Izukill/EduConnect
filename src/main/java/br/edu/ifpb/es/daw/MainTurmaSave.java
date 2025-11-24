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




            //Criação do professor
            Professor professor = new Professor();
            professor.setNome("Ricardo Gomes");
            professor.setCpf("123.987.456-00");
            professor.setEmail("ricardo@ifpb.edu.br");
            professor.setTelefone("83991234567");
            professor.setSenha_hash("senhaRicardo");
            professor.setSalario(0f);

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




            //Criação do aluno
            Aluno aluno = new Aluno();
            aluno.setMatricula("" + System.nanoTime());
            aluno.setNome("Luan Loreto");
            aluno.setCpf("111.222.333-44");
            aluno.setEmail("luanloreto@gmail.com");
            aluno.setTelefone("839981635");
            aluno.setSenha_hash("123456");
            aluno.setTurma(turma);

            turma.setAlunos(List.of(aluno));
            disciplina.setTurmas(List.of(turma));


            dao.save(turma);

        }catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar turma", e);
        }
    }
}
