package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.TurmaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.TurmaDAOImpl;
import br.edu.ifpb.es.daw.entities.Disciplina;
import br.edu.ifpb.es.daw.entities.Simulado;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainTurmaDeleteAll {
    public static void main(String[] args) throws PersistenciaDawException {

        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            try {
                tx.begin();

                List<Turma> turmas = em.createQuery("SELECT t FROM Turma t", Turma.class)
                        .getResultList();

                List<Simulado> simulados = em.createQuery("SELECT s FROM Simulado s", Simulado.class)
                        .getResultList();

                for (Turma turma : turmas) {
                    //Remove vínculo com Disciplinas (ManyToMany)
                    if (turma.getDisciplinas() != null) {
                        for (Disciplina disciplina : turma.getDisciplinas()) {
                            disciplina.getTurmas().remove(turma);
                            em.merge(disciplina);
                        }
                        turma.getDisciplinas().clear();
                    }

                    //Remove vínculos com Simulados
                    for (Simulado simulado : simulados) {
                        if (simulado.getTurma() != null && simulado.getTurma().contains(turma)) {
                            simulado.getTurma().remove(turma);
                            em.merge(simulado);
                        }
                    }

                    em.merge(turma);
                    em.remove(em.contains(turma) ? turma : em.merge(turma));
                }

                tx.commit();


            } catch (Exception e) {
                if (tx.isActive()) tx.rollback();
                throw new PersistenciaDawException("Erro ao excluir turmas", e);
            } finally {
                em.close();
            }
        }
    }
}