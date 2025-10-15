package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.SimuladoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.SimuladoDAOImpl;
import br.edu.ifpb.es.daw.entities.Simulado;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import br.edu.ifpb.es.daw.entities.Turma;

public class MainSimuladoSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            SimuladoDAO dao = new SimuladoDAOImpl(emf);
            Simulado simulado = new Simulado();

            simulado.setDescricao("Simulado ENEM 2025");
            simulado.setQtdQuestoes(90);

            dao.save(simulado);

            System.out.println("Simulado salvo com sucesso!");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar o simulado", e);
        }
    }
}