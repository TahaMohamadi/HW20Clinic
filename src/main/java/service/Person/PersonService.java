package service.Person;

import base.service.BaseService;
import entity.Person;

import java.util.Optional;

public interface PersonService extends BaseService<Person> {
    Optional<Person> findPersonByNationalCode(Long nationalCode);
//    Optional<Person> findPerson(String username, String password);

}
