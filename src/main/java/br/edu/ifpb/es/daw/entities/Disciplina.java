package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "disciplinas")

public class Disciplina {


    public Disciplina() {
    }

    public Disciplina(Integer ch, String ementa, Long id, String nome, Professor professor, List<Turma> turmas) {
        this.ch = ch;
        this.ementa = ementa;
        this.id = id;
        this.nome = nome;
        this.professor = professor;
        this.turmas = turmas;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(mappedBy = "disciplinas")
    private List<Turma> turmas;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_idProfessor", nullable = true)
    private Professor professor;

    private Integer ch;
    private String ementa;
    private String nome;

    public List<Turma> getTurmas() {
        return turmas;
    }

    public void setTurmas(List<Turma> turmas) {
        this.turmas = turmas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Integer getCh() {
        return ch;
    }

    public void setCh(Integer ch) {
        this.ch = ch;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Disciplina{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", ch=" + ch +
                ", professor_id=" + (professor != null ? professor.getId() : "null") +
                ", turmas=" + (turmas != null ? turmas.stream().map(t -> t.getId().toString()).toList() : "[]") +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, ch);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Disciplina)) return false;
        Disciplina other = (Disciplina) obj;
        return Objects.equals(id, other.id);
    }

}
