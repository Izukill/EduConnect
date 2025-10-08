package br.edu.ifpb.es.daw.dao.impl;

import br.edu.ifpb.es.daw.dao.PessoaDAO;
import br.edu.ifpb.es.daw.entities.Pessoa;
import jakarta.persistence.EntityManagerFactory;

public class PessoaDAOImpl extends AbstractDAOImpl<Pessoa,Long> implements PessoaDAO {
    public PessoaDAOImpl( EntityManagerFactory emf) {
        super(Pessoa.class, emf);
    }
}
