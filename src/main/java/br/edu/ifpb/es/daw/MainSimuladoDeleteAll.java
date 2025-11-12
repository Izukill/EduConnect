package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.SimuladoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.SimuladoDAOImpl;
import br.edu.ifpb.es.daw.entities.Simulado;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainSimuladoDeleteAll {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            SimuladoDAO dao = new SimuladoDAOImpl(emf);

            List<Simulado> simulados = dao.getAll();

            for (Simulado s : simulados) {
                dao.delete(s.getId());
            }



        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao excluir simulados", e);
        }
    }
}