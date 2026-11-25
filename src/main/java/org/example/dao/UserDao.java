package org.example.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.TransactionManager;
import org.example.entity.User;

import java.util.List;

public class UserDao {
    private final EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    public User find(Long id) {
        User user = em.find(User.class, id);
        System.out.println("Found user: " + user);
        return user;
    }

    public void save(User u) {
        EntityTransaction tx = em.getTransaction();
        try {
            System.out.println("Transaction started");
            tx.begin();
            System.out.println("Resource persist starts");
            em.persist(u);
            System.out.println("Transaction committed");
            tx.commit();
        } catch (Exception e) {
            System.out.println("Transaction rollback");
            tx.rollback();
            throw e;
        }
    }
}
