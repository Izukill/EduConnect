package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Professores")
public class Professor {


    public Professor() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;

    private float salario;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }


    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Professor)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(getId(), professor.getId());
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
