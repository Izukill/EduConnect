package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AulaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.AulaDAOImpl;
import br.edu.ifpb.es.daw.entities.Aula;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAulaSave {
    public static void main(String[] args) {

        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            AulaDAO dao = new AulaDAOImpl(emf);

            Aula aula= new Aula();


            aula.setConteudo("Herança");

            System.out.println(aula.toString());

            dao.save(aula);

            System.out.println(aula.toString());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
