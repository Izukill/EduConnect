package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.PessoaDAO;
import br.edu.ifpb.es.daw.dao.impl.PessoaDAOImpl;
import br.edu.ifpb.es.daw.entities.Pessoa;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainPessoaDeleteAll {


    public static void main(String[] args) {

        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")){

            PessoaDAO dao = new PessoaDAOImpl(emf);

            List<Pessoa> pessoaList= dao.getAll();

            for(Pessoa pessoa : pessoaList){

                dao.delete(pessoa.getId());
            }




        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }





}
