package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Coordenadores")
public class Coordenador {



    public Coordenador() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private float salario;


    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coordenador)) return false;
        Coordenador coordenador = (Coordenador) o;
        return Objects.equals(getId(), coordenador.getId());
    }

    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Professor{" +
                "salario=" + salario +
                "id=" + Id +"}";
    }
}


