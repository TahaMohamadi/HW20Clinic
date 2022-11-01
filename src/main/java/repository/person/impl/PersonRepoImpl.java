package repository.person.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Patient;
import entity.Person;
import jakarta.persistence.EntityManager;
import repository.patient.PatientRepo;
import repository.person.PersonRepo;
import util.Hibernate;

import java.util.Optional;

public class PersonRepoImpl extends BaseRepositoryImpl<Person> implements PersonRepo {
    private final PersonRepo userRepository = new PersonRepoImpl(Hibernate.getEntityManagerFactory().createEntityManager());

    public PersonRepoImpl(EntityManager em) {
        super(em);
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }

    @Override
    public Optional<Person> findPerson(String firstName, String lastname) {
        String jpql = """
                select p from Person p where p.firstName = :username and p.lastName = :lastname
                """;
        return Optional.ofNullable(Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Person.class)
                .setParameter("firstName", firstName).setParameter("lastname",lastname).getSingleResult());
    }

    @Override
    public Optional<Person> findPersonByNationalCode(Long nationalCode) {
        String jpql = """
                select p from Person p where p.nationalCode = :nationalCode
                """;
        return Optional.ofNullable(Hibernate.getEntityManagerFactory().createEntityManager().createQuery(jpql, Person.class)
                .setParameter("nationalCode", nationalCode).getSingleResult());
    }
}
