package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.MensalidadeDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.MensalidadeDAOImpl;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class MainMensalidadeSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            MensalidadeDAO dao = new MensalidadeDAOImpl(emf);
            Mensalidade mensalidade = new Mensalidade();


            //Criação de mensalidade
            mensalidade.setData(LocalDate.now());
            mensalidade.setVencimento(LocalDate.now().plusMonths(1));
            mensalidade.setValor(150.00);
            mensalidade.setStatus(StatusMensalidade.PAGO);





            //criação da turma
            Turma turma= new Turma();
            turma.setNome("2-A");


            Aluno aluno= new Aluno();

            aluno.setMatricula("" + System.nanoTime());
            aluno.setNome("Luan loreto");
            aluno.setCpf("153.232.256-13");
            aluno.setTelefone("839981635");
            aluno.setEmail("luanloreto@gmail.com");
            aluno.setSenha_hash("1234323424");
            aluno.setTurma(turma);
            turma.setAlunos(List.of(aluno));

            mensalidade.setAluno(aluno);

            aluno.getMensalidades().add(mensalidade);


            dao.save(mensalidade);

            System.out.println("Mensalidede salva com sucesso!");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar a mensalidade", e);
        }
    }
}