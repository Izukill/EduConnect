package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Notas")
public class Nota {

    public Nota() {}

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private Double nota_linguagens;
    private Double nota_redacao;
    private Double nota_ciencHumanas;
    private Double nota_ciencNatureza;
    private Double nota_matematica;




    public Long getId() {
        return id;
    }

    public Double getNota_linguagens() {
        return nota_linguagens;
    }

    public void setNota_linguagens(Double nota_linguagens) {
        this.nota_linguagens = nota_linguagens;
    }

    public Double getNota_redacao() {
        return nota_redacao;
    }

    public void setNota_redacao(Double nota_redacao) {
        this.nota_redacao = nota_redacao;
    }

    public Double getNota_ciencHumanas() {
        return nota_ciencHumanas;
    }

    public void setNota_ciencHumanas(Double nota_ciencHumanas) {
        this.nota_ciencHumanas = nota_ciencHumanas;
    }

    public Double getNota_ciencNatureza() {
        return nota_ciencNatureza;
    }

    public void setNota_ciencNatureza(Double nota_ciencNatureza) {
        this.nota_ciencNatureza = nota_ciencNatureza;
    }

    public Double getNota_matematica() {
        return nota_matematica;
    }

    public void setNota_matematica(Double nota_matematica) {
        this.nota_matematica = nota_matematica;
    }

}
