package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Mensalidades")
public class Mensalidade {

    public Mensalidade() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private LocalDate vencimento;
    private Double valor;
    private String status;

    //relacionamemto com aluno
    @ManyToOne
    @JoinColumn(name = "fk_idAluno")
    private Aluno aluno;

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
}
