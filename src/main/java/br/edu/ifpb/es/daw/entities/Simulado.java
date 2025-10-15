package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "Simulado")
public class Simulado {

    public Simulado() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Column(name = "qtd_questoes")
    private Integer qtdQuestoes;



    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQtdQuestoes() {
        return qtdQuestoes;
    }

    public void setQtdQuestoes(Integer qtdQuestoes) {
        this.qtdQuestoes = qtdQuestoes;
    }


}