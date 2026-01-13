package br.edu.ifpb.es.daw;

import br.edu.ifpb.es.daw.dao.EduConnectDataGenerator;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class MainDataGenerator {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("daw")) {
            EduConnectDataGenerator dao = new EduConnectDataGenerator(emf);
            dao.generateData();
        }
    }
}
