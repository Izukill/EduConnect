package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.PresencaDAO;
import br.edu.ifpb.es.daw.dao.impl.PresencaDAOImpl;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;

public class MainPresencaSave {
    public static void main(String[] args) {


        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            PresencaDAO dao = new PresencaDAOImpl(emf);




            //criação professor
            Professor professor = new Professor();
            professor.setNome("Carlos Mendes");
            professor.setCpf("111.222.333-44");
            professor.setEmail("carlos@ifpb.edu.br");
            professor.setTelefone("83998765432");
            professor.setSenha_hash("prof123");
            professor.setSalario(0.f);

            //criação turma
            Turma turma = new Turma();
            turma.setNome("2º Ano - B");
            turma.setTurno("Manhã");

            //criação aula
            Aula aula = new Aula();
            aula.setProfessor(professor);
            aula.setTurma(turma);
            aula.setConteudo("Equações de 2º grau");
            aula.setData(LocalDate.now());
            aula.setObservacoes("Aula introdutória de revisão para ENEM.");




            //criação aluno
            Aluno aluno = new Aluno();
            aluno.setNome("João Pedro");
            aluno.setCpf("999.888.777-66");
            aluno.setEmail("joao@ifpb.edu.br");
            aluno.setTelefone("83998887777");
            aluno.setSenha_hash("aluno123");
            aluno.setTurma(turma);
            aluno.setMatricula("" + System.nanoTime());
            turma.setAlunos(List.of(aluno));

            //criação presenca
            Presenca presenca = new Presenca();
            presenca.setAluno(aluno);
            presenca.setAula(aula);
            presenca.setStatus(StatusPresenca.PRESENTE);


            dao.save(presenca);


        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar presença", e);
        }

    }
}
