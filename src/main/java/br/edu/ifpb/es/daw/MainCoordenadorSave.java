package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.CoordenadorDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.CoordenadorDAOImpl;
import br.edu.ifpb.es.daw.entities.Coordenador;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCoordenadorSave {


    public static void main(String[] args) {


        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            CoordenadorDAO dao = new CoordenadorDAOImpl(emf);

            Coordenador coordenador= new Coordenador();

            coordenador.setSalario(2390.10f);


            System.out.println(coordenador.toString());

            dao.save(coordenador);

            System.out.println(coordenador.toString());

        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }


}
