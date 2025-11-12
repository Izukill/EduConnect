package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Mensalidades")
public class Mensalidade {

    public Mensalidade() {

    }

    public Mensalidade(Aluno aluno, LocalDate data, Long id, StatusMensalidade status, Double valor, LocalDate vencimento) {
        this.aluno = aluno;
        this.data = data;
        this.id = id;
        this.status = status;
        this.valor = valor;
        this.vencimento = vencimento;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_idAluno", nullable = false)
    private Aluno aluno;

    private LocalDate data;
    private LocalDate vencimento;
    private Double valor;


    @Enumerated(EnumType.STRING)
    private StatusMensalidade status;



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

    public StatusMensalidade getStatus() {
        return status;
    }

    public void setStatus(StatusMensalidade status) {
        this.status = status;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Mensalidade [id=" + id + ", aluno=" + (aluno != null ? aluno.getId() : "null")
                + ", data=" + data + ", vencimento=" + vencimento
                + ", valor=" + valor + ", status=" + status + "]";
    }

    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Mensalidade)) return false;
        Mensalidade other = (Mensalidade) obj;
        return id != null && id.equals(other.getId());
    }
}
