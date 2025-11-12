package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AulaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.AulaDAOImpl;
import br.edu.ifpb.es.daw.entities.Aula;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainAulaDeleteAll {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            AulaDAO dao = new AulaDAOImpl(emf);

            List<Aula> aulas = dao.getAll();

            for (Aula aula : aulas) {
                dao.delete(aula.getId());
            }



        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao excluir aulas", e);
        }
    }
}