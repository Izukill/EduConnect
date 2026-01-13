package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.AlunoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.entities.Aluno;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AlunoDAOImpl extends AbstractDAOImpl<Aluno, Long> implements AlunoDAO {
    public AlunoDAOImpl(EntityManagerFactory emf) {
        super(Aluno.class, emf);
    }




    @Override
    public Aluno findByMatricula(String matricula) throws PersistenciaDawException {

        //consulta com String (parâmetro primitivo)


        try (EntityManager em = getEntityManager()) {
            TypedQuery<Aluno> query = em.createQuery(
                    "SELECT a FROM Aluno a WHERE a.matricula = :matricula",
                    Aluno.class
            );
            query.setParameter("matricula", matricula);
            return query.getSingleResult();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaDawException("Erro ao buscar aluno pela matrícula.", pe);
        }

    }

    @Override
    public List<Aluno> findByTurma(Turma turma) throws PersistenciaDawException {

        //consulta onde o parâmetro é uma entidade (turma)

        try (EntityManager em = getEntityManager()) {
            TypedQuery<Aluno> query = em.createQuery(
                    "SELECT a FROM Aluno a WHERE a.turma = :turma",
                    Aluno.class
            );
            query.setParameter("turma", turma);
            return query.getResultList();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaDawException("Erro ao buscar alunos pela turma.", pe);
        }
    }

    @Override
    public Aluno findByNomeAndEmail(String nome, String email) throws PersistenciaDawException {

        //consulta com dois parâmetros sendo eles primitivos

        try (EntityManager em = getEntityManager()) {
            TypedQuery<Aluno> query = em.createQuery(
                    "SELECT a FROM Aluno a WHERE a.nome = :nome AND a.email = :email",
                    Aluno.class
            );
            query.setParameter("nome", nome);
            query.setParameter("email", email);
            return query.getSingleResult();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaDawException("Erro ao buscar aluno por nome e email.", pe);
        }
    }

    @Override
    public Long countAlunosByNomeTurma(String nomeTurma) throws PersistenciaDawException {

        //consulta com função de agregação (no caso o count)

        try (EntityManager em = getEntityManager()) {
            TypedQuery<Long> query = em.createQuery(
                    "SELECT COUNT(a) FROM Aluno a WHERE a.turma.nome = :nomeTurma",
                    Long.class
            );
            query.setParameter("nomeTurma", nomeTurma);
            return query.getSingleResult();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaDawException("Erro ao contar alunos da turma.", pe);
        }
    }

    @Override
    public Aluno findAlunoWithMensalidades(Long id) throws PersistenciaDawException {

        //consulta com fetch com relaciomento lazy

        try (EntityManager em = getEntityManager()) {
            TypedQuery<Aluno> query = em.createQuery(
                    "SELECT DISTINCT a FROM Aluno a LEFT JOIN FETCH a.mensalidades WHERE a.id = :id",
                    Aluno.class
            );
            query.setParameter("id", id);
            return query.getSingleResult();
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            throw new PersistenciaDawException("Erro ao buscar aluno com mensalidades.", pe);
        }
    }

}
