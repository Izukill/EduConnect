package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.TurmaDAO;
import br.edu.ifpb.es.daw.dao.impl.AlunoDAOImpl;
import br.edu.ifpb.es.daw.dao.impl.TurmaDAOImpl;
import br.edu.ifpb.es.daw.entities.Aluno;
import br.edu.ifpb.es.daw.entities.Turma;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainConsultas {
    public static void main(String[] args) {
        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("daw")){
            AlunoDAOImpl dao = new AlunoDAOImpl(emf);
            TurmaDAO turmaDAO = new TurmaDAOImpl(emf);

            System.out.println(dao.findByMatricula("202613011561"));



            List<Turma> turmas = turmaDAO.getAll();
            Turma turma = turmas.get(0);
            System.out.println("Alunos da "+ turma.getNome());

            List<Aluno> alunosDaTurma = dao.findByTurma(turma);
            for (Aluno a : alunosDaTurma){
                System.out.println("Aluno: "+ a.getNome());
            }




            System.out.println(dao.findByNomeAndEmail("Aluno 5","aluno5@educonnect.com"));

            System.out.println(dao.countAlunosByNomeTurma("Turma ENEM 2"));

            System.out.println(dao.findAlunoWithMensalidades(2812L));

        } catch (PersistenciaDawException e) {
            throw new RuntimeException(e);
        }
    }
}
