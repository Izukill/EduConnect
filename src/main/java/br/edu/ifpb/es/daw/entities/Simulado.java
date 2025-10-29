package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Simulados")
public class Simulado {

    public Simulado() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nome;

    private String dataAplicacao;

    private Double notaMaxima;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataAplicacao() {
        return dataAplicacao;
    }

    public void setDataAplicacao(String dataAplicacao) {
        this.dataAplicacao = dataAplicacao;
    }

    public Double getNotaMaxima() {
        return notaMaxima;
    }

    public void setNotaMaxima(Double notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Simulado)) return false;
        Simulado simulado = (Simulado) o;
        return id != null && id.equals(simulado.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Simulado{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", dataAplicacao='" + dataAplicacao + '\'' +
                ", notaMaxima=" + notaMaxima +
                '}';
    }
}