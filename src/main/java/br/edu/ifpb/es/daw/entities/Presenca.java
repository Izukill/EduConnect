package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "presenças")
public class Presenca {
    public Presenca() {

    }

    @JoinColumn(name = "fk_idAluno", nullable = false)
    private Aluno aluno;

    @JoinColumn(name = "fk_idAula", nullable = false)
    private Aula aula;

    private String Status;

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Presenca [aluno=" + aluno + ", aula=" + aula + ", Status=" + Status + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
        result = prime * result + ((aula == null) ? 0 : aula.hashCode());
        result = prime * result + ((Status == null) ? 0 : Status.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Presenca other = (Presenca) obj;
        if (aluno == null) {
            if (other.aluno != null)
                return false;
        } else if (!aluno.equals(other.aluno))
            return false;
        if (aula == null) {
            if (other.aula != null)
                return false;
        } else if (!aula.equals(other.aula))
            return false;
        if (Status == null) {
            if (other.Status != null)
                return false;
        } else if (!Status.equals(other.Status))
            return false;
        return true;
    }

}
