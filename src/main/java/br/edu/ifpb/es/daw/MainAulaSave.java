package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AulaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.AulaDAOImpl;
import br.edu.ifpb.es.daw.entities.Aula;
import br.edu.ifpb.es.daw.entities.Pessoa;
import br.edu.ifpb.es.daw.entities.Professor;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainAulaSave {
    public static void main(String[] args) {

        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            AulaDAO dao = new AulaDAOImpl(emf);

            //Criação da Pessoa
            Pessoa pessoaProfessor = new Pessoa();
            pessoaProfessor.setNome("Carlos Henrique");
            pessoaProfessor.setCpf("123.456.789-10");
            pessoaProfessor.setEmail("carlos.professor@ifpb.edu.br");
            pessoaProfessor.setTelefone("83998765432");
            pessoaProfessor.setSenha_hash("senhaSegura123");

            //Criação do Professor
            Professor professor = new Professor();
            professor.setPessoa(pessoaProfessor);


            //Criação da Turma
            Turma turma = new Turma();
            turma.setNome("3º Ano - B");
            turma.setTurno("Manhã");

            //Criação da Aula
            Aula aula = new Aula();
            aula.setProfessor(professor);
            aula.setTurma(turma);
            aula.setConteudo("Funções Quadráticas");
            aula.setData(LocalDate.now());
            aula.setObservacoes("A turma participou muito bem da explicação.");

            dao.save(aula);


        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar a aula", e);
        }


    }
}
