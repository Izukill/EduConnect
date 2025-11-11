package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.ProfessorDAO;
import br.edu.ifpb.es.daw.dao.impl.ProfessorDAOImpl;
import br.edu.ifpb.es.daw.entities.Pessoa;
import br.edu.ifpb.es.daw.entities.Professor;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainProfessorSave {

    public static void main(String[] args) {


        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            ProfessorDAO dao = new ProfessorDAOImpl(emf);

            //criação de pessoa
            Pessoa pessoa=new Pessoa();

            pessoa.setNome("Luan loreto");
            pessoa.setCpf("153.232.256-13");
            pessoa.setTelefone("839981635");
            pessoa.setEmail("luanloreto@gmail.com");
            pessoa.setSenha_hash("1234323424");

            Professor professor= new Professor();

            professor.setSalario(1.00f);
            professor.setPessoa(pessoa);


            System.out.println(professor.toString());

            dao.save(professor);

            System.out.println(professor.toString());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
