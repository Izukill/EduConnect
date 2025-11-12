package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Notas")
public class Nota {

    public Nota() {

    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_idAluno", nullable = false)
    private Aluno aluno;


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_idSimulado", nullable = false)
    private Simulado simulado;




    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Simulado getSimulado() {
        return simulado;
    }

    public void setSimulado(Simulado simulado) {
        this.simulado = simulado;
    }

    private Double notaLinguagens;
    private Double notaRedacao;
    private Double notaCienciasHumanas;
    private Double notaCienciasNatureza;
    private Double notaMatematica;





    public Long getId() {
        return id;
    }

    public Double getNotaCienciasHumanas() {
        return notaCienciasHumanas;
    }

    public void setNotaCienciasHumanas(Double notaCienciasHumanas) {
        this.notaCienciasHumanas = notaCienciasHumanas;
    }

    public Double getNotaCienciasNatureza() {
        return notaCienciasNatureza;
    }

    public void setNotaCienciasNatureza(Double notaCienciasNatureza) {
        this.notaCienciasNatureza = notaCienciasNatureza;
    }

    public Double getNotaLinguagens() {
        return notaLinguagens;
    }

    public void setNotaLinguagens(Double notaLinguagens) {
        this.notaLinguagens = notaLinguagens;
    }

    public Double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(Double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public Double getNotaRedacao() {
        return notaRedacao;
    }

    public void setNotaRedacao(Double notaRedacao) {
        this.notaRedacao = notaRedacao;
    }

    @Override
    public String toString() {
        return "Nota [id=" + id +
                ", aluno=" + (aluno != null ? aluno.getId() : "null") +
                ", simulado=" + (simulado != null ? simulado.getId() : "null") +
                ", notaLinguagens=" + notaLinguagens +
                ", notaRedacao=" + notaRedacao +
                ", notaCienciasHumanas=" + notaCienciasHumanas +
                ", notaCienciasNatureza=" + notaCienciasNatureza +
                ", notaMatematica=" + notaMatematica + "]";
    }

    @Override
    public int hashCode() {
        return (id != null) ? id.hashCode() : 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Nota)) return false;
        Nota other = (Nota) obj;
        return id != null && id.equals(other.getId());
    }

}
