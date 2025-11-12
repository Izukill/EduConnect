package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "presencas")
public class Presenca {


    public Presenca() {

    }

    public Presenca(Aluno aluno, Aula aula, Integer id, StatusPresenca status) {
        this.aluno = aluno;
        this.aula = aula;
        this.id = id;
        this.status = status;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_idAluno", nullable = false)
    private Aluno aluno;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_idAula", nullable = false)
    private Aula aula;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPresenca status;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public StatusPresenca getStatus() {
        return status;
    }

    public void setStatus(StatusPresenca status) {
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Presenca{" +
                "id=" + id +
                ", aluno_id=" + (aluno != null ? aluno.getId() : "null") +
                ", aula_id=" + (aula != null ? aula.getId() : "null") +
                ", status=" + status +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, aluno, aula, status);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Presenca)) return false;
        Presenca other = (Presenca) obj;
        return Objects.equals(id, other.id);
    }

}
