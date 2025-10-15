package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.PresencaDAO;
import br.edu.ifpb.es.daw.entities.Presenca;
import jakarta.persistence.EntityManagerFactory;

public class PresencaDAOImpl extends AbstractDAOImpl<Presenca, Long> implements PresencaDAO {
    public PresencaDAOImpl(EntityManagerFactory emf) {
        super(Presenca.class, emf);
    }
}
