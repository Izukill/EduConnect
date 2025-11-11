package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.MensalidadeDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.MensalidadeDAOImpl;
import br.edu.ifpb.es.daw.entities.Mensalidade;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainMensalidadeSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            MensalidadeDAO dao = new MensalidadeDAOImpl(emf);
            Mensalidade mensalidade = new Mensalidade();

            // Ajustando para refletir a nova estrutura da entidade
            mensalidade.setValor(150.00);
            mensalidade.setMes("Outubro");
            mensalidade.setDataPagamento("2025-10-14");
            mensalidade.setStatus(Mensalidade.StatusMensalidade.PENDENTE);

            dao.save(mensalidade);

            System.out.println("Mensalidade salva com sucesso!");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar a mensalidade", e);
        }
    }
}
