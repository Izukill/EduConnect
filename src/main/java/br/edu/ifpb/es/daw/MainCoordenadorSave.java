package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.CoordenadorDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.CoordenadorDAOImpl;
import br.edu.ifpb.es.daw.entities.Coordenador;
import br.edu.ifpb.es.daw.entities.Pessoa;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainCoordenadorSave {


    public static void main(String[] args) {


        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            CoordenadorDAO dao = new CoordenadorDAOImpl(emf);

            //criação de pessoa
            Pessoa pessoa=new Pessoa();

            pessoa.setNome("Luan loreto");
            pessoa.setCpf("153.232.256-13");
            pessoa.setTelefone("839981635");
            pessoa.setEmail("luanloreto@gmail.com");
            pessoa.setSenha_hash("1234323424");

            Coordenador coordenador= new Coordenador();


            coordenador.setPessoa(pessoa);
            coordenador.setSalario(2390.10f);


            System.out.println(coordenador.toString());

            dao.save(coordenador);

            System.out.println(coordenador.toString());

        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }


}
