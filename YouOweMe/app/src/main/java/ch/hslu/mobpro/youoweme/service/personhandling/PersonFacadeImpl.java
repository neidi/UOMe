package ch.hslu.mobpro.youoweme.service.personhandling;

import ch.hslu.mobpro.youoweme.database.Person;
import ch.hslu.mobpro.youoweme.service.personhandling.workers.*;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 */
public class PersonFacadeImpl implements PersonFacade {
    PersonCreator personCreator = PersonCreator.getInstance();
    PersonUpdater personUpdater = PersonUpdater.getInstance();
    PersonDeleter personDeleter = new PersonDeleter();
    PersonReader personReader = PersonReader.getInstance();
    PersonAuthenticator personAuthenticator = PersonAuthenticator.getInstance();

    @Override
    public void createPerson(Person person) {
        person.setId(personCreator.createPerson(person));
    }

    @Override
    public void updatePerson(Person person) {
        personUpdater.updatePerson(person);
    }

    @Override
    public boolean deletePerson(int id) {
        return personDeleter.deletePerson(id);
    }

    @Override
    public List<Person> readPeople() {
        return personReader.readPeople();
    }

    @Override
    public Person getPerson(int id) {
        return personReader.readPerson(id);
    }

    @Override
    public int authenticate(Person person) {
        return personAuthenticator.authenticate(person);
    }
}
