package ch.hslu.mobpro.youoweme.service.personhandling;

import ch.hslu.mobpro.youoweme.database.EntityListGetter;
import ch.hslu.mobpro.youoweme.database.EntityListGetterImpl;
import ch.hslu.mobpro.youoweme.database.Person;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 * Klasse zur Personenauthentifizierung.
 */
public final class PersonAuthenticator {
    private static PersonAuthenticator instance;
    private final EntityListGetter entityListGetter;

    PersonAuthenticator(EntityListGetter entityListGetter) {
        this.entityListGetter = entityListGetter;
    }

    /**
     * Singletonmethode
     *
     * @return die Instanz
     */
    public static PersonAuthenticator getInstance() {
        if (instance == null) {
            instance = new PersonAuthenticator(new EntityListGetterImpl());
        }
        return instance;
    }

    public int authenticate(Person person) {
        List<Person> people = PersonReader.getInstance().readPeople();
        for (Person dtoPerson : people) {
            if (dtoPerson.geteMailAddress() == person.geteMailAddress() && dtoPerson.getPassword() == person.getPassword()) {
                return dtoPerson.getId();
            }
        }
        return -1;
    }
}
