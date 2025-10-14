package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.AlunoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.AlunoDAOImpl;
import br.edu.ifpb.es.daw.entities.Aluno;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainAlunoDeleteAll {

    public static void main(String[] args) {

        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")){

            AlunoDAO dao = new AlunoDAOImpl(emf);

            List<Aluno> alunoList = dao.getAll();

            for(Aluno aluno : alunoList){

                dao.delete(aluno.getId());
            }

        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }


    }


}
