package br.edu.ifpb.es.daw.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "Alunos")
@PrimaryKeyJoinColumn(name = "pessoa_id")
public class Aluno extends Pessoa {


    public Aluno() {
    }

    private int matricula;


    public int getMatricula() {
        return matricula;
    }
}
