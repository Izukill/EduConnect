package br.edu.ifpb.es.daw.dao;


import br.edu.ifpb.es.daw.entities.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EduConnectDataGenerator {

    private EntityManagerFactory emf;
    private Random random = new Random();

    public EduConnectDataGenerator(EntityManagerFactory emf) {
        this.emf = emf;
    }

    private EntityManager em() {
        return emf.createEntityManager();
    }

    public void generateData() {

        EntityManager em = em();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            // ===================== COORDENADORES =====================
            for (int i = 1; i <= 2; i++) {
                Coordenador c = new Coordenador();
                c.setNome("Coordenador " + i);
                c.setEmail("coord" + i + "@educonnect.com");
                c.setCpf("111.222.333-0" + i);
                c.setTelefone("83 9999-000" + i);
                c.setSenha_hash("#$as153F5#$5");
                c.setSalario(6000.00f);
                em.persist(c);
            }

            // ===================== TURMAS =====================
            List<Turma> turmas = new ArrayList<>();
            String[] turnos = {"Manhã", "Tarde", "Noite"};
            for (int i = 1; i <= 3; i++) {
                Turma t = new Turma();
                t.setNome("Turma ENEM " + i);
                t.setTurno(turnos[i % 3]);
                t.setAlunos(new ArrayList<>());

                em.persist(t);
                turmas.add(t);
            }

            // ===================== PROFESSORES =====================
            List<Professor> professores = new ArrayList<>();
            for (int i = 1; i <= 5; i++) {
                Professor p = new Professor();
                p.setNome("Professor " + i);
                p.setEmail("prof" + i + "@educonnect.com");
                p.setCpf("222.333.444-0" + i);
                p.setTelefone("83 9888-000" + i);
                p.setSenha_hash("asddfs!@#$#%");
                p.setSalario(4000f);
                em.persist(p);
                professores.add(p);
            }

            // ===================== DISCIPLINAS =====================
            List<Disciplina> disciplinas = new ArrayList<>();
            String[] nomesDisciplinas = {"Matemática", "Português", "História", "Geografia", "Física"};

            for (int i = 0; i < nomesDisciplinas.length; i++) {
                Disciplina d = new Disciplina();
                d.setNome(nomesDisciplinas[i]);
                d.setCh(60 + (i * 10));


                d.setProfessor(professores.get(i % professores.size()));
                d.setTurmas(turmas);

                for (Turma t : turmas) {
                    if (t.getDisciplinas() == null) {
                        t.setDisciplinas(new ArrayList<>());
                    }

                    t.getDisciplinas().add(d);
                }


                em.persist(d);
                disciplinas.add(d);
            }

            // ===================== SIMULADOS =====================
            List<Simulado> simulados = new ArrayList<>();
            for (Turma t : turmas) {
                for (int i = 1; i <= 2; i++) {
                    Simulado s = new Simulado();
                    s.setDescricao("Simulado " + i + " - " + t.getNome());
                    s.setQtdQuestoes(90);


                    List<Turma> listaTurmas = new ArrayList<>();
                    listaTurmas.add(t);
                    s.setTurma(listaTurmas);

                    em.persist(s);
                    simulados.add(s);
                }
            }

            // ===================== ALUNOS =====================
            List<Aluno> alunos = new ArrayList<>();
            for (int i = 1; i <= 15; i++) {
                Aluno a = new Aluno();
                a.setNome("Aluno " + i);
                a.setEmail("aluno" + i + "@educonnect.com");
                a.setTelefone("83 9812-457" + i);
                a.setCpf("333.444.555-" + (i < 10 ? "0"+i : i));
                a.setMatricula("20261301156" + i);
                a.setSenha_hash("aluno123");

                Turma turmaDoAluno = turmas.get(i % turmas.size());


                a.setTurma(turmaDoAluno);

                if (turmaDoAluno.getAlunos() == null) {
                    turmaDoAluno.setAlunos(new ArrayList<>());
                }
                turmaDoAluno.getAlunos().add(a);

                em.persist(a);
                alunos.add(a);
            }

            // ===================== AULAS =====================
            List<Aula> aulas = new ArrayList<>();
            for (Turma t : turmas) {
                for (Disciplina d : disciplinas) {
                    Aula aula = new Aula();
                    aula.setConteudo("Aula introdutória de " + d.getNome());
                    aula.setData(LocalDate.now().minusDays(random.nextInt(30)));
                    aula.setObservacoes("Aula normal");

                    aula.setTurma(t);
                    aula.setProfessor(d.getProfessor());

                    em.persist(aula);
                    aulas.add(aula);
                }
            }

            // ===================== PRESENÇAS =====================
            for (Aula aula : aulas) {
                Turma turmaDaAula = aula.getTurma();

                if (turmaDaAula.getAlunos() != null) {
                    for (Aluno a : turmaDaAula.getAlunos()) {
                        Presenca p = new Presenca();
                        p.setAluno(a);
                        p.setAula(aula);

                        StatusPresenca[] statusPossiveis = StatusPresenca.values();
                        p.setStatus(statusPossiveis[random.nextInt(statusPossiveis.length)]);

                        em.persist(p);
                    }
                }
            }

            // ===================== NOTAS =====================
            for (Simulado s : simulados) {
                List<Turma> turmasDoSimulado = s.getTurma();

                for (Turma t : turmasDoSimulado) {
                    if (t.getAlunos() != null) {
                        for (Aluno a : t.getAlunos()) {
                            Nota n = new Nota();
                            n.setAluno(a);
                            n.setSimulado(s);


                            n.setNotaMatematica(geraNota());
                            n.setNotaLinguagens(geraNota());
                            n.setNotaRedacao(geraNota());
                            n.setNotaCienciasHumanas(geraNota());
                            n.setNotaCienciasNatureza(geraNota());

                            em.persist(n);
                        }
                    }
                }
            }

            // ===================== MENSALIDADES =====================
            for (Aluno a : alunos) {
                for (int mes = 1; mes <= 3; mes++) {
                    Mensalidade m = new Mensalidade();


                    m.setAluno(a);
                    m.setValor(500.0);
                    m.setData(LocalDate.now().minusMonths(mes));
                    m.setVencimento(LocalDate.now().minusMonths(mes).plusDays(10));

                    StatusMensalidade[] statusPossiveis = StatusMensalidade.values();
                    m.setStatus(statusPossiveis[random.nextInt(statusPossiveis.length)]);


                    if (a.getMensalidades() == null) {
                        a.setMensalidades(new ArrayList<>());
                    }
                    a.getMensalidades().add(m);

                    em.persist(m);
                }
            }

            tx.commit();
            System.out.println("Dados do EduConnect gerados com sucesso!");

        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }


    private Double geraNota() {
        return 400.0 + (random.nextInt() * 600.0);

    }
}
