package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.CoordenadorDAO;
import br.edu.ifpb.es.daw.entities.Coordenador;
import jakarta.persistence.EntityManagerFactory;

public class CoordenadorDAOImpl extends AbstractDAOImpl<Coordenador, Long> implements CoordenadorDAO {
    public CoordenadorDAOImpl(EntityManagerFactory emf) {
        super(Coordenador.class, emf);
    }
}
