package ir.TahaMohammadi;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import util.Hibernate;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManager entityManager = Hibernate.getEntityManagerFactory().createEntityManager();

        Person person1 = new Person();
    }
}