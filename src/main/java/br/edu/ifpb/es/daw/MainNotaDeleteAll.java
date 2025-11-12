package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.NotaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.NotaDAOImpl;
import br.edu.ifpb.es.daw.entities.Nota;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainNotaDeleteAll {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            NotaDAO dao = new NotaDAOImpl(emf);

            List<Nota> notas = dao.getAll();

            for (Nota n : notas) {
                dao.delete(n.getId());
            }



        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao excluir notas", e);
        }
    }
}