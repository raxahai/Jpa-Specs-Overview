package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.UserDao;
import org.example.entity.User;

public class JpaApplication {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-overview");
        EntityManager em = emf.createEntityManager();
        UserDao userDao = new UserDao(em);
        System.out.println("Interface you asked for: EntityManagerFactory (from the spec)");
        System.out.println("Object you actually got: " + emf.getClass().getName());

        userDao.save(new User("syedrazahaider019@gmail.com", "Raza Haider"));

        // Register checking -> Identity map (a == b)
        User a = userDao.find(1L);
        User b = userDao.find(1L);
        System.out.println("Register checking returns same " +
                "result without calling additional select: " + (a == b));

        // Dirty checking - Saves the name
        User u = userDao.find(1L);
        u.setName("Irteza Haider");

        // Retrieval to check dirty checking
        User r = userDao.find(1L);

        em.close();
        emf.close();
    }
}
