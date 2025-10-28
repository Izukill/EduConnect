package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.PresencaDAO;
import br.edu.ifpb.es.daw.dao.impl.PresencaDAOImpl;
import br.edu.ifpb.es.daw.entities.Presenca;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPresencaSave {
    public static void main(String[] args) {

        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            PresencaDAO dao = new PresencaDAOImpl(emf);

            Presenca presenca = new Presenca();


            presenca.setStatus(Presenca.tipoStatus.valueOf("presente"));

            System.out.println(presenca.toString());

            dao.save(presenca);

            System.out.println(presenca.toString());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
