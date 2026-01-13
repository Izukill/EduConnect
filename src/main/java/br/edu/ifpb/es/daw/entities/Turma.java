package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.net.DatagramSocket;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "turmas")
public class Turma {

    public Turma() {
    }

    public Turma(List<Aluno> alunos, List<Disciplina> disciplinas, Long id, String nome, String turno) {
        this.alunos = alunos;
        this.disciplinas = disciplinas;
        this.id = id;
        this.nome = nome;
        this.turno = turno;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)


    private Long id;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.PERSIST)
    private List<Aluno> alunos;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.REMOVE)
    private List<Aula> aulas;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "turma_disciplina", joinColumns = @JoinColumn(name = "fk_idTurma"),
            inverseJoinColumns = @JoinColumn(name = "fk_idDisciplina"))
    private List<Disciplina> disciplinas;



    private String turno;
    private String nome;


    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    @Override
    public String toString() {
        return "Turma{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", turno='" + turno + '\'' +
                ", alunos=" + (alunos != null ? alunos.stream().map(a -> a.getId().toString()).toList() : "[]") +
                ", disciplinas=" + (disciplinas != null ? disciplinas.stream().map(d -> d.getId().toString()).toList() : "[]") +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, turno);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Turma)) return false;
        Turma other = (Turma) obj;
        return Objects.equals(id, other.id);
    }

}
