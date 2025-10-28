package br.edu.ifpb.es.daw.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "presenças")
public class Presenca {
    public Presenca() {

    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum tipoStatus{Presente,Faltou,Justificado}

    @Enumerated(EnumType.STRING)
    private tipoStatus Status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public tipoStatus getStatus() {
        return Status;
    }

    public void setStatus(tipoStatus status) {
        Status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Presenca presenca = (Presenca) o;
        return Objects.equals(id, presenca.id) && Objects.equals(Status, presenca.Status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Status);
    }

    @Override
    public String toString() {
        return "Presenca{" +
                "id=" + id +
                ", Status='" + Status + '\'' +
                '}';
    }
}
