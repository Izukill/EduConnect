package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Notas")
public class Nota {

    public Nota() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double valor;

    private String descricao;

    private String dataRegistro;

    public Long getId() {
        return id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(String dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Nota)) return false;
        Nota nota = (Nota) o;
        return id != null && id.equals(nota.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Nota{" +
                "id=" + id +
                ", valor=" + valor +
                ", descricao='" + descricao + '\'' +
                ", dataRegistro='" + dataRegistro + '\'' +
                '}';
    }
}