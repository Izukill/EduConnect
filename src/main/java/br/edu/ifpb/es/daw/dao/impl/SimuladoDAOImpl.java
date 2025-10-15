package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.SimuladoDAO;
import br.edu.ifpb.es.daw.entities.Simulado;
import jakarta.persistence.EntityManagerFactory;

public class SimuladoDAOImpl extends AbstractDAOImpl<Simulado, Long> implements SimuladoDAO {
    public SimuladoDAOImpl(EntityManagerFactory emf) {
        super(Simulado.class, emf);
    }
}
