package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.PessoaDAO;
import br.edu.ifpb.es.daw.dao.impl.PessoaDAOImpl;
import br.edu.ifpb.es.daw.entities.Pessoa;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPessoaSave {

    public static void main(String[] args) {


        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            PessoaDAO dao= new PessoaDAOImpl(emf);
            Pessoa pessoa=new Pessoa();

            pessoa.setNome("a");
            pessoa.setCpf("b");
            pessoa.setTelefone("c");
            pessoa.setEmail("d");
            pessoa.setSenha_hash("e");

            dao.save(pessoa);

            System.out.println("pessoa salva");


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }


    }

}
