package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.DisciplinaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.DisciplinaDAOImpl;
import br.edu.ifpb.es.daw.entities.Disciplina;
import br.edu.ifpb.es.daw.entities.Pessoa;
import br.edu.ifpb.es.daw.entities.Professor;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainDisciplinaSave {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            DisciplinaDAO dao = new DisciplinaDAOImpl(emf);




            //Criação do Professor
            Professor professor = new Professor();
            professor.setNome("Carlos Henrique");
            professor.setCpf("123.456.789-10");
            professor.setEmail("carlos.professor@ifpb.edu.br");
            professor.setTelefone("83998765432");
            professor.setSenha_hash("senhaSegura123");



            //Criação da Turma
            Turma turma = new Turma();
            turma.setNome("3º Ano - B");
            turma.setTurno("Manhã");



            //Criação da Disciplina
            Disciplina disciplina = new Disciplina();
            disciplina.setNome("Física Moderna");
            disciplina.setCh(60);
            disciplina.setEmenta("Estudo da relatividade, quântica e suas aplicações.");
            disciplina.setProfessor(professor);
            disciplina.setTurmas(List.of(turma));
            turma.setDisciplinas(List.of(disciplina));

            dao.save(disciplina);




        }catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar a disciplina", e);
        }
    }
}
