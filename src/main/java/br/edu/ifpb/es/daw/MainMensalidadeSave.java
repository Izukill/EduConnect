package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.MensalidadeDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.MensalidadeDAOImpl;
import br.edu.ifpb.es.daw.entities.Mensalidade;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainMensalidadeSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            MensalidadeDAO dao = new MensalidadeDAOImpl(emf);
            Mensalidade mensalidade = new Mensalidade();

            // Ajustando para refletir a nova estrutura da entidade
            mensalidade.setValor(1500.00);
            mensalidade.setData(LocalDate.of(2025,11,11));
            mensalidade.setVencimento(LocalDate.of(2025,12,11));
            mensalidade.setStatus("Pendente");

            dao.save(mensalidade);

            System.out.println("Mensalidade salva com sucesso!");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar a mensalidade", e);
        }
    }
}
