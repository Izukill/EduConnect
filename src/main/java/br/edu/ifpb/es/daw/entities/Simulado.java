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

    //relacionamento manyto0ne com a entidade turma
    @ManyToOne
    @JoinColumn(name = "fk_idTurma")
    private Turma turma;

    @OneToMany(mappedBy = "simulado")
    private Set<Nota> notas;

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

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Set<Nota> getNotas() {
        return notas;
    }

    public void setNotas(Set<Nota> notas) {
        this.notas = notas;
    }
}