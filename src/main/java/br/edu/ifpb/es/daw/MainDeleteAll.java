package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainDeleteAll {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            try {
                tx.begin();

                //começa disvinculando as chaves nas relações many2many para apagar tudo
                desvincularDisciplinas(em);
                desvincularSimulados(em);

                //força o banco a processar essas desvinculações antes de continuar
                em.flush();




                deleteAll(em, Presenca.class);
                deleteAll(em, Nota.class);
                deleteAll(em, Mensalidade.class);
                deleteAll(em, Aula.class);
                deleteAll(em, Simulado.class);
                deleteAll(em, Disciplina.class);
                deleteAll(em, Aluno.class);
                deleteAll(em, Turma.class);
                deleteAll(em, Professor.class);
                deleteAll(em, Coordenador.class);

                tx.commit();
                System.out.println("bd limpo");

            } catch (Exception e) {
                if (tx.isActive()) tx.rollback();
                e.printStackTrace();
            } finally {
                em.close();
            }
        }
    }

    //método para discinvular chaves (many2many)
    private static void desvincularDisciplinas(EntityManager em) {
        List<Disciplina> disciplinas = em.createQuery("SELECT d FROM Disciplina d", Disciplina.class).getResultList();

        for (Disciplina d : disciplinas) {

            if (d.getTurmas() != null) {
                for (Turma t : d.getTurmas()) {
                    if (t.getDisciplinas() != null) {
                        t.getDisciplinas().remove(d);
                        em.merge(t);
                    }
                }

                d.getTurmas().clear();
                em.merge(d);
            }
        }
    }

    //método para discinvular chaves (many2many)
    private static void desvincularSimulados(EntityManager em) {
        List<Simulado> simulados = em.createQuery("SELECT s FROM Simulado s", Simulado.class).getResultList();

        for (Simulado s : simulados) {

            if (s.getTurma() != null) {
                s.getTurma().clear();
                em.merge(s);
            }
        }
    }

    private static void deleteAll(EntityManager em, Class<?> clazz) {
        List<?> entities = em.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
        for (Object entity : entities) {
            em.remove(entity);
        }
        System.out.println("Deletados " + entities.size() + " registros de " + clazz.getSimpleName());
    }
}