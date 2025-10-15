package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.ProfessorDAO;
import br.edu.ifpb.es.daw.dao.impl.ProfessorDAOImpl;
import br.edu.ifpb.es.daw.entities.Professor;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainProfessorDeleteAll {

    public static void main(String[] args) {

        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            ProfessorDAO dao = new ProfessorDAOImpl(emf);
            List<Professor> professorList= dao.getAll();

            for(Professor professor : professorList){

                dao.delete(professor.getId());
            }


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }

}
