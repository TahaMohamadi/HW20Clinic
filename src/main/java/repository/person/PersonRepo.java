package repository.person;

import base.repository.BaseRepository;
import entity.Person;

import java.util.Optional;

public interface PersonRepo extends BaseRepository<Person> {
    Optional<Person> findPerson(String username, String password);
}
