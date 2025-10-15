package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.NotaDAO;
import br.edu.ifpb.es.daw.dao.PersistenciaDawException;
import br.edu.ifpb.es.daw.dao.impl.NotaDAOImpl;
import br.edu.ifpb.es.daw.entities.Nota;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainNotaSave {

    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            NotaDAO dao = new NotaDAOImpl(emf);
            Nota nota = new Nota();

            nota.setNota_linguagens(8.5);
            nota.setNota_redacao(9.0);
            nota.setNota_ciencHumanas(7.5);
            nota.setNota_ciencNatureza(8.0);
            nota.setNota_matematica(6.5);

            dao.save(nota);

            System.out.println("Nota salva com sucesso!");
        } catch (PersistenciaDawException e) {
            throw new RuntimeException("Erro ao salvar a nota", e);
        }
    }
}