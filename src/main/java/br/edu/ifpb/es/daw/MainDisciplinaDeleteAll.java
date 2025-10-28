package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.DisciplinaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.DisciplinaDAOImpl;
import br.edu.ifpb.es.daw.entities.Disciplina;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainDisciplinaDeleteAll {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")){

            DisciplinaDAO dao = new DisciplinaDAOImpl(emf);

            List<Disciplina> disciplinaList = dao.getAll();

            for(Disciplina disciplina : disciplinaList){

                dao.delete(disciplina.getId());
            }



        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
    }

