package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.TurmaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.TurmaDAOImpl;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainTurmaDeleteAll {
    public static void main(String[] args) {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            TurmaDAO dao = new TurmaDAOImpl(emf);

            List<Turma> turmas = dao.getAll();

            for (Turma turma : turmas) {
                dao.delete(turma.getId());
            }



        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao excluir turmas", e);
        }
    }
}