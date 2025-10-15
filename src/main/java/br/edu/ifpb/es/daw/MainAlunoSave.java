package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AlunoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.AlunoDAOImpl;
import br.edu.ifpb.es.daw.entities.Aluno;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainAlunoSave {


    public static void main(String[] args) {

        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){

            AlunoDAO dao = new AlunoDAOImpl(emf);

            Aluno aluno= new Aluno();


            aluno.setMatricula("" + System.nanoTime());

            System.out.println(aluno.toString());

            dao.save(aluno);

            System.out.println(aluno.toString());


        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }

    }
}
