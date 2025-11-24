package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.SimuladoDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.SimuladoDAOImpl;
import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainSimuladoSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            SimuladoDAO dao = new SimuladoDAOImpl(emf);





            //Criação do PROFESSOR
            Professor professor = new Professor();
            professor.setNome("Mariana Lima");
            professor.setCpf("321.654.987-00");
            professor.setEmail("mariana@ifpb.edu.br");
            professor.setTelefone("83999887766");
            professor.setSenha_hash("prof456");
            professor.setSalario(0.f);

            //Criação da DISCIPLINA
            Disciplina disciplina = new Disciplina();
            disciplina.setNome("Física Geral");
            disciplina.setCh(80);
            disciplina.setEmenta("Estudo dos princípios da física clássica e moderna.");
            disciplina.setProfessor(professor);

            //Criação da TURMA
            Turma turma = new Turma();
            turma.setNome("3º Ano - C");
            turma.setTurno("Tarde");
            turma.setDisciplinas(List.of(disciplina));
            disciplina.setTurmas(List.of(turma));

            //Criação do SIMULADO
            Simulado simulado = new Simulado();
            simulado.setDescricao("Simulado ENEM - Física e Matemática");
            simulado.setQtdQuestoes(90);
            simulado.setTurma(List.of(turma));


            dao.save(simulado);




        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar o simulado", e);
        }
    }
}