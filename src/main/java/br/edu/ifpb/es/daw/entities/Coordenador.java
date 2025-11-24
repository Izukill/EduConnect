package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Coordenadores")
public class Coordenador extends Pessoa {



    public Coordenador()  {
    }



    private float salario;




    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
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
        return "Coordenador{" +
                ", salario=" + salario +
                "} " + super.toString();
    }
}


