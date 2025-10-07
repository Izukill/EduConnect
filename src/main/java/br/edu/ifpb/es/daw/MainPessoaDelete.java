package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.PessoaDAO;
import br.edu.ifpb.es.daw.dao.impl.PessoaDAOImpl;
import br.edu.ifpb.es.daw.entities.Pessoa;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPessoaDelete {

    public static void main(String[] args) {

        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            PessoaDAO dao= new PessoaDAOImpl(emf);
            Pessoa pessoa=new Pessoa();

            pessoa.setNome("asdasd");
            pessoa.setCpf("sdfdf");
            pessoa.setTelefone("sdfsdf");
            pessoa.setEmail("asdasd");
            pessoa.setSenha_hash("fggh");

            dao.save(pessoa);

            dao.delete(pessoa.getId());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }


    }

}
