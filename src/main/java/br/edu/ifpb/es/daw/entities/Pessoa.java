package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Pessoas")
public class Pessoa {


    public Pessoa(Long id, String nome, String email, String senha_hash, String telefone, String cpf) {
        Id = id;
        this.nome = nome;
        this.email = email;
        this.senha_hash = senha_hash;
        this.telefone = telefone;
        this.cpf = cpf;
    }

    public Pessoa() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long Id;


    private String nome;

    private String email;

    private String senha_hash;

    private String  telefone;

    private String cpf;

    public Long getId() {
        return Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha_hash() {
        return senha_hash;
    }

    public void setSenha_hash(String senha_hash) {
        this.senha_hash = senha_hash;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pessoa)) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(Id, pessoa.Id);
    }

    public int hashCode() {
        return Objects.hashCode(Id);
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "Id=" + Id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha_hash='" + senha_hash + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
