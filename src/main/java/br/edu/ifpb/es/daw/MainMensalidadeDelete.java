package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.MensalidadeDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.MensalidadeDAOImpl;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainMensalidadeDelete {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            MensalidadeDAO dao = new MensalidadeDAOImpl(emf);

            Long idMensalidadeParaDeletar = 1L;
            dao.delete(idMensalidadeParaDeletar);

            System.out.println("Mensalidade com ID " + idMensalidadeParaDeletar + " deletada com sucesso!");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao deletar a mensalidade", e);
        }
    }
}