package ch.hslu.mobpro.youoweme.service.personhandling;

import ch.hslu.mobpro.youoweme.service.dto.DtoPerson;
import ch.hslu.mobpro.youoweme.service.personhandling.workers.*;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 */
public class PersonFacadeImpl implements PersonFacade {
    PersonCreator personCreator = new PersonCreator();
    PersonUpdater personUpdater = new PersonUpdater();
    PersonDeleter personDeleter = new PersonDeleter();
    PersonReader personReader = new PersonReader();
    PersonAuthenticator personAuthenticator = new PersonAuthenticator();

    @Override
    public void createPerson(DtoPerson person) {
        person.id = personCreator.createPerson(person);
    }

    @Override
    public void updatePerson(DtoPerson person) {
        personUpdater.updatePerson(person);
    }

    @Override
    public boolean deletePerson(int id) {
        return personDeleter.deletePerson(id);
    }

    @Override
    public List<DtoPerson> readPeople() {
        return personReader.readPeople();
    }

    @Override
    public DtoPerson getPerson(int id) {
        return personReader.readPerson(id);
    }

    @Override
    public boolean authenticate(DtoPerson person) {
        return personAuthenticator.authenticate(person);
    }
}
