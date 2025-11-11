package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AlunoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.PessoaDAO;
import br.edu.ifpb.es.daw.dao.impl.AlunoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.PessoaDAOImpl;
import br.edu.ifpb.es.daw.entities.Aluno;
import br.edu.ifpb.es.daw.entities.Pessoa;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAlunoSave {


    public static void main(String[] args) {

        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            AlunoDAO dao = new AlunoDAOImpl(emf);

            //criação de pessoa
            Pessoa pessoa=new Pessoa();

            pessoa.setNome("Luan loreto");
            pessoa.setCpf("153.232.256-13");
            pessoa.setTelefone("839981635");
            pessoa.setEmail("luanloreto@gmail.com");
            pessoa.setSenha_hash("1234323424");


            //criação da turma


            Aluno aluno= new Aluno();

            aluno.setMatricula("" + System.nanoTime());
            aluno.setPessoa(pessoa);
            //aluno.setTurma();

            System.out.println(aluno.toString());

            dao.save(aluno);

            System.out.println(aluno.toString());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
