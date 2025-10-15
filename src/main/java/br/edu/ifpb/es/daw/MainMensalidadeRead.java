package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.MensalidadeDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.MensalidadeDAOImpl;
import br.edu.ifpb.es.daw.entities.Mensalidade;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainMensalidadeRead {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            MensalidadeDAO dao = new MensalidadeDAOImpl(emf);

            Long idMensalidade = 1L;
            Mensalidade readMensalidade = dao.getByID(idMensalidade);

            if (readMensalidade != null) {
                System.out.println("Mensalidade encontrada:");
                System.out.println("ID: " + readMensalidade.getId());
                System.out.println("Valor: " + readMensalidade.getValor());
                System.out.println("Status: " + readMensalidade.getStatus());
            } else {
                System.out.println("Mensalidade com ID " + idMensalidade + " não encontada.");
            }
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao ler a mensalidade", e);
        }
    }
}