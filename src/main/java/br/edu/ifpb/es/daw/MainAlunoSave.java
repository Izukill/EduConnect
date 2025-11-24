package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AlunoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.PessoaDAO;
import br.edu.ifpb.es.daw.dao.impl.AlunoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.PessoaDAOImpl;
import br.edu.ifpb.es.daw.entities.Aluno;
import br.edu.ifpb.es.daw.entities.Pessoa;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainAlunoSave {


    public static void main(String[] args) {

        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            AlunoDAO dao = new AlunoDAOImpl(emf);






            //criação da turma
            Turma turma= new Turma();
            turma.setNome("2-A");

            //criação do aluno
            Aluno aluno= new Aluno();

            aluno.setMatricula("" + System.nanoTime());
            aluno.setNome("Luan loreto");
            aluno.setCpf("153.232.256-10");
            aluno.setTelefone("839981635");
            aluno.setEmail("EmailTeste@gmail.com");
            aluno.setSenha_hash("234534@@#$dfg");
            aluno.setTurma(turma);
            turma.setAlunos(List.of(aluno));

            System.out.println(aluno.toString());

            dao.save(aluno);

            System.out.println(aluno.toString());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
