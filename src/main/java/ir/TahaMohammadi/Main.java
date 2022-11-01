package ir.TahaMohammadi;

import entity.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import menu.Home;
import util.Hibernate;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Home home = new Home();
        home.showMenu();
    }
}