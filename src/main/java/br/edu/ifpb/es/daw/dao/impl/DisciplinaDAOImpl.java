package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.DisciplinaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.entities.Disciplina;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class DisciplinaDAOImpl extends AbstractDAOImpl<Disciplina, Long> implements DisciplinaDAO {
    public DisciplinaDAOImpl(EntityManagerFactory emf) {
        super(Disciplina.class, emf);
    }


}
