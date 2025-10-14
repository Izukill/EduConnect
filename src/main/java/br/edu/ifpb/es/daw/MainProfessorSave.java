package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.ProfessorDAO;
import br.edu.ifpb.es.daw.dao.impl.ProfessorDAOImpl;
import br.edu.ifpb.es.daw.entities.Professor;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainProfessorSave {

    public static void main(String[] args) {


        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            ProfessorDAO dao = new ProfessorDAOImpl(emf);

            Professor professor= new Professor();

            professor.setSalario(1.00f);


            System.out.println(professor.toString());

            dao.save(professor);

            System.out.println(professor.toString());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
