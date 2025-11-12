package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.DisciplinaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.DisciplinaDAOImpl;
import br.edu.ifpb.es.daw.entities.Disciplina;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainDisciplinaDeleteAll {
    public static void main(String[] args) {


        //numa relação manytomany precisa limpar as relações das tabelas relacional para excluir a tabela desejada
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            List<Disciplina> disciplinas = em.createQuery("SELECT d FROM Disciplina d", Disciplina.class).getResultList();

            for (Disciplina disciplina : disciplinas) {

                //Remove vínculos ManyToMany antes de excluir
                for (Turma turma : disciplina.getTurmas()) {
                    turma.getDisciplinas().remove(disciplina);
                    em.merge(turma);
                }

                disciplina.getTurmas().clear(); //Limpa o lado da disciplina
                em.merge(disciplina); //Atualiza no banco

                em.remove(em.contains(disciplina) ? disciplina : em.merge(disciplina));
            }

            tx.commit();
            em.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}