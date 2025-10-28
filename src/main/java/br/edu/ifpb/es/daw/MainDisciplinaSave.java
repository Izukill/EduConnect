package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.DisciplinaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.DisciplinaDAOImpl;
import br.edu.ifpb.es.daw.entities.Disciplina;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainDisciplinaSave {
    public static void main(String[] args) {

        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            DisciplinaDAO dao = new DisciplinaDAOImpl(emf);

            Disciplina disciplina= new Disciplina();


            disciplina.setEmenta("a");

            System.out.println(disciplina.toString());

            dao.save(disciplina);

            System.out.println(disciplina.toString());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
