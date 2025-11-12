package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Simulado")
public class Simulado {

    public Simulado() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "simulado_turma", joinColumns = @JoinColumn(name = "fk_idSimulado"),
            inverseJoinColumns = @JoinColumn(name = "fk_idTurma"))
    private List<Turma> turma;


    @OneToMany(mappedBy = "simulado", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Nota> notas;

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

    public void setId(Long id) {
        this.id = id;
    }

    public List<Nota> getNotas() {
        return notas;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public List<Turma> getTurma() {
        return turma;
    }

    public void setTurma(List<Turma> turma) {
        this.turma = turma;
    }

    @Override
    public String toString() {
        String turmaIds = (turma != null)
                ? turma.stream().map(t -> String.valueOf(t.getId())).toList().toString()
                : "[]";

        return "Simulado{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", qtdQuestoes=" + qtdQuestoes +
                ", turmas=" + turmaIds +
                '}';
    }



    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
        result = prime * result + ((qtdQuestoes == null) ? 0 : qtdQuestoes.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Simulado)) return false;
        Simulado other = (Simulado) obj;
        return id != null && id.equals(other.getId());
    }
}