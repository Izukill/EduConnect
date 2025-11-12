package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "aulas")
public class Aula {



    public Aula() {
    }

    public Aula(String conteudo, LocalDate data, Long id, String observacoes, Professor professor, Turma turma) {
        this.conteudo = conteudo;
        this.data = data;
        this.id = id;
        this.observacoes = observacoes;
        this.professor = professor;
        this.turma = turma;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_idProfessor")
    private Professor professor;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_idTurma")
    private Turma turma;

    @OneToMany(mappedBy = "aula", cascade = CascadeType.REMOVE)
    private List<Presenca> presencas;

    private String conteudo;
    private LocalDate data;
    private String observacoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "id=" + id +
                ", professor_id=" + (professor != null ? professor.getId() : "null") +
                ", turma_id=" + (turma != null ? turma.getId() : "null") +
                ", conteudo='" + conteudo + '\'' +
                ", data=" + data +
                ", observacoes='" + observacoes + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Aula)) return false;
        Aula other = (Aula) obj;
        return Objects.equals(id, other.id);
    }

}
