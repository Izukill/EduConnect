package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Simulados")
public class Simulado {

    public Simulado() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    private Integer qtdQuestoes;

    private Long fk_idTurma;

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

    public Long getFk_idTurma() {
        return fk_idTurma;
    }

    public void setFk_idTurma(Long fk_idTurma) {
        this.fk_idTurma = fk_idTurma;
    }
}
