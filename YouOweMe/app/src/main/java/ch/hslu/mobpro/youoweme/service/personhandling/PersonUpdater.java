package ch.hslu.mobpro.youoweme.service.personhandling;

import ch.hslu.mobpro.youoweme.database.EntityPersistor;
import ch.hslu.mobpro.youoweme.database.EntityPersistorImpl;
import ch.hslu.mobpro.youoweme.database.Person;

/**
 * Created by simonneidhart on 04.05.15.
 * Klasse, die Personen aktualisiert.
 */
public class PersonUpdater {

    private static PersonUpdater instance;
    private final EntityPersistor entityPersistor;

    PersonUpdater(EntityPersistor entityPersistor) {
        this.entityPersistor = entityPersistor;
    }

    /**
     * Singletonmethode
     *
     * @return die Instanz
     */
    public static PersonUpdater getInstance() {
        if (instance == null) {
            instance = new PersonUpdater(new EntityPersistorImpl());
        }
        return instance;
    }

    /**
     * Aktualisiert eine Person anhand der im Objekt gespeicherten Daten
     *
     * @param person das Personenobjekt mit den zu aktualisierenden Daten.
     */
    public void updatePerson(Person person) {

    }
}
