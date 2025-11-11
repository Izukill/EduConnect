package br.edu.ifpb.es.daw.entities;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Alunos")
public class Aluno{


    public Aluno(String matricula) {
        this.matricula = matricula;
    }

    public Aluno() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "turma_id")
    private Turma turma;


    @Column(unique = true, nullable = false)
    private String matricula;


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Aluno)) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(getId(), aluno.getId());
    }

    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "matricula=" + matricula +
                "id=" + Id +
                "pessoa_id= " + pessoa.getId() +
                "turma_id= " + turma.getId() + "}";
    }
}
