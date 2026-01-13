package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.TurmaDAO;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class TurmaDAOImpl extends AbstractDAOImpl<Turma, Long> implements TurmaDAO {
    public TurmaDAOImpl(EntityManagerFactory emf) {
        super(Turma.class, emf);
    }

    @Override
    public Turma findByname(String nome) throws PersistenciaDawException {
        try (EntityManager em = getEntityManager()) {

            String jpql = "SELECT t FROM Turma t WHERE t.nome = :nome";

            TypedQuery<Turma> query = em.createQuery(jpql, Turma.class);
            query.setParameter("nome", nome);


            return query.getSingleResult();

        } catch (Exception e) {

            throw new PersistenciaDawException("Erro ao buscar turma pelo nome: " + nome, e);
        }
    }
}

