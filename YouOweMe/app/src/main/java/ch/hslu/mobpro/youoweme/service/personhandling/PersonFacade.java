package ch.hslu.mobpro.youoweme.service.personhandling;

import ch.hslu.mobpro.youoweme.database.Person;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 */
public interface PersonFacade {
    void createPerson(Person person);
    void updatePerson(Person person);
    boolean deletePerson(int id);
    List<Person> readPeople();
    Person getPerson(int id);
    int authenticate(Person person);
}
