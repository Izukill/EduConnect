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

            mensalidade.setData(LocalDate.now());
            mensalidade.setVencimento(LocalDate.now().plusMonths(1));
            mensalidade.setValor(150.00);
            mensalidade.setStatus("Pendente");


            dao.save(mensalidade);

            System.out.println("Mensalidede salva com sucesso!");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar a mensalidade", e);
        }
    }
}