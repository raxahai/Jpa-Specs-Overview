package org.example;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.dao.UserDao;
import org.example.entity.User;

public class JpaApplication {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa-overview");
        UserDao userDao = new UserDao(emf);
        System.out.println("Interface you asked for: EntityManagerFactory (from the spec)");
        System.out.println("Object you actually got: " + emf.getClass().getName());

        userDao.save(new User("syedrazahaider019@gmail.com", "Raza Haider"));
        userDao.find(1L);

        emf.close();
    }
}
