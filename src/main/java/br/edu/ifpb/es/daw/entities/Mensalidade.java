package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Mensalidades")
public class Mensalidade {

    public Mensalidade() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double valor;

    private String mes;

    private String dataPagamento;

    @Enumerated(EnumType.STRING)
    private StatusMensalidade status;

    public enum StatusMensalidade {
        PAGA,
        ATRASADA,
        PENDENTE
    }

    public Long getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public StatusMensalidade getStatus() {
        return status;
    }

    public void setStatus(StatusMensalidade status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Mensalidade)) return false;
        Mensalidade that = (Mensalidade) o;
        return id != null && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
    @Override
    public String toString() {
        return "Mensalidade{" +
                "id=" + id +
                ", valor=" + valor +
                ", mes='" + mes + '\'' +
                ", dataPagamento='" + dataPagamento + '\'' +
                ", status=" + status +
                '}';
    }
}