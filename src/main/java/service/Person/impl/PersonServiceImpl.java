package service.Person.impl;

import base.repository.impl.BaseRepositoryImpl;
import base.service.impl.BaseServiceImpl;
import entity.Person;
import jakarta.persistence.EntityManager;
import repository.person.PersonRepo;
import repository.person.impl.PersonRepoImpl;
import service.Person.PersonService;
import util.Hibernate;

import java.util.Optional;

public class PersonServiceImpl extends BaseServiceImpl<Person, PersonRepo> implements PersonService {
//    private final PersonRepo personRepo = new PersonRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public PersonServiceImpl(PersonRepoImpl repo) {
        super(repo);
    }

//    public Optional<Person> findPerson(String firstName, String lastName){
//        try {
//            return personRepo.findPerson(firstName,lastName);
//        }catch (Exception e){
//            return Optional.empty();
//        }
//    }

//    public Optional<Person> findPerson(String username, String password) {
//        try {
//            return personRepo.findPerson(username, password);
//        } catch (Exception e) {
//            return Optional.empty();
//        }
//    }
}
