package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PresencaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.PresencaDAOImpl;
import br.edu.ifpb.es.daw.entities.Presenca;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainPresencaDeleteAll {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            PresencaDAO dao = new PresencaDAOImpl(emf);

            List<Presenca> presencas = dao.getAll();

            for (Presenca p : presencas) {
                dao.delete(p.getId());
            }


        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao excluir presenças", e);
        }
    }
}