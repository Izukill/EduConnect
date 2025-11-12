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

            //criação de pessoa
            Pessoa pessoa=new Pessoa();

            pessoa.setNome("Luan loreto");
            pessoa.setCpf("153.232.256-13");
            pessoa.setTelefone("839981635");
            pessoa.setEmail("luanloreto@gmail.com");
            pessoa.setSenha_hash("1234323424");


            //criação da turma
            Turma turma= new Turma();
            turma.setNome("2-A");


            Aluno aluno= new Aluno();

            aluno.setMatricula("" + System.nanoTime());
            aluno.setPessoa(pessoa);
            aluno.setTurma(turma);
            turma.setAlunos(List.of(aluno));

            mensalidade.setAluno(aluno);


            dao.save(mensalidade);

            System.out.println("Mensalidede salva com sucesso!");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar a mensalidade", e);
        }
    }
}