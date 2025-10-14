package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.CoordenadorDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.CoordenadorDAOImpl;
import br.edu.ifpb.es.daw.entities.Coordenador;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainCoordenadorDeleteAll {

    public static void main(String[] args) {

        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")){

            CoordenadorDAO dao = new CoordenadorDAOImpl(emf);

            List<Coordenador> coordenadorList = dao.getAll();

            for(Coordenador coordenador : coordenadorList){

                dao.delete(coordenador.getId());
            }



        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
