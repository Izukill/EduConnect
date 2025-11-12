package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.MensalidadeDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.MensalidadeDAOImpl;
import br.edu.ifpb.es.daw.entities.Mensalidade;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainMensalidadeDeleteAll {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            MensalidadeDAO dao = new MensalidadeDAOImpl(emf);

            List<Mensalidade> mensalidades = dao.getAll();

            for (Mensalidade m : mensalidades) {
                dao.delete(m.getId());
            }



        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao excluir mensalidades", e);
        }
    }
}