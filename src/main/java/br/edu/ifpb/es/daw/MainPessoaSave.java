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

            pessoa.setNome("Luan loreto");
            pessoa.setCpf("153.232.256-13");
            pessoa.setTelefone("839981635");
            pessoa.setEmail("luanloreto@gmail.com");
            pessoa.setSenha_hash("1234323424");

            dao.save(pessoa);

            System.out.println("pessoa salva");


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }


    }

}
