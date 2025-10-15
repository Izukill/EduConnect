package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.MensalidadeDAO;
import br.edu.ifpb.es.daw.entities.Mensalidade;
import jakarta.persistence.EntityManagerFactory;

public class MensalidadeDAOImpl extends AbstractDAOImpl<Mensalidade, Long> implements MensalidadeDAO {
    public MensalidadeDAOImpl(EntityManagerFactory emf) {
        super(Mensalidade.class, emf);
    }
}
