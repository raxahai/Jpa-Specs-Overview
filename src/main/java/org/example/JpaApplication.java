package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JpaApplication {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-overview");
        System.out.println("Interface you asked for: EntityManagerFactory (from the spec)");
        System.out.println("Object you actually got: " + emf.getClass().getName());
        emf.close();
    }
}
