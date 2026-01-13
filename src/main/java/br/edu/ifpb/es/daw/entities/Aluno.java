package br.edu.ifpb.es.daw.entities;


import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Alunos")
public class Aluno extends Pessoa{


    public Aluno() {
    }

    public Aluno(Long id, String nome, String email, String senha_hash, String telefone, String cpf, String matricula, Turma turma) {
        super(id, nome, email, senha_hash, telefone, cpf);
        this.matricula = matricula;
        this.turma = turma;
    }


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Nota> notas;


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, orphanRemoval = true) //o padrão do one2many já é lazy
    private List<Mensalidade> mensalidades;


    @OneToMany(mappedBy = "aluno", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Presenca> presencas;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "turma_id", nullable = true)
    private Turma turma;


    @Column(unique = true, nullable = false)
    private String matricula;


    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Mensalidade> getMensalidades() {
        return mensalidades;
    }

    public void setMensalidades(List<Mensalidade> mensalidades) {
        this.mensalidades = mensalidades;
    }

    public List<Presenca> getPresencas() {
        return presencas;
    }

    public void setPresencas(List<Presenca> presencas) {
        this.presencas = presencas;
    }


    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
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
                "matricula='" + matricula + '\'' +
                "turma= " + turma.getNome() +
                "} " + super.toString();
    }
}
