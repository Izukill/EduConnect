package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.PessoaDAO;
import br.edu.ifpb.es.daw.dao.impl.PessoaDAOImpl;
import br.edu.ifpb.es.daw.entities.Pessoa;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainPessoaRead {


    public static void main(String[] args) {


        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {

            PessoaDAO dao= new PessoaDAOImpl(emf);
            Pessoa pessoa=new Pessoa();

            pessoa.setNome("afg");
            pessoa.setCpf("dfdfb");
            pessoa.setTelefone("c124");
            pessoa.setEmail("dsdfdf");
            pessoa.setSenha_hash("edfsdf");

            dao.save(pessoa);

            Pessoa readPessoa= dao.getByID(pessoa.getId());
            readPessoa.toString();


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
