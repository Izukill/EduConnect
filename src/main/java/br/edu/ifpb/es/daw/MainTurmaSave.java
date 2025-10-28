package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.TurmaDAO;
import br.edu.ifpb.es.daw.dao.impl.TurmaDAOImpl;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainTurmaSave {
    public static void main(String[] args) {

        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            TurmaDAO dao = new TurmaDAOImpl(emf);

            Turma turma = new Turma();


            turma.setTurno("Manhã");

            System.out.println(turma.toString());

            dao.save(turma);

            System.out.println(turma.toString());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
