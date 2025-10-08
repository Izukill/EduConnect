package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Coordenadores")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Coordenador extends Pessoa{

    public Coordenador() {
    }

    private float salario;


    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}
