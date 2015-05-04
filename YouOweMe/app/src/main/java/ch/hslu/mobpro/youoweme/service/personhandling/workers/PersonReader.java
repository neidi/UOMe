package ch.hslu.mobpro.youoweme.service.personhandling.workers;

import ch.hslu.mobpro.youoweme.database.EntityListGetter;
import ch.hslu.mobpro.youoweme.database.EntityListGetterImpl;
import ch.hslu.mobpro.youoweme.database.EntityPerIdGetter;
import ch.hslu.mobpro.youoweme.database.Person;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 * Klasse zum Personenlesen
 */
public class PersonReader {
    private static PersonReader instance;
    private final EntityListGetter entityListGetter;

    PersonReader(EntityListGetter entityListGetter){
        this.entityListGetter = entityListGetter;
    }

    /**
     * Singletonmethode
     * @return die Instanz
     */
    public static PersonReader getInstance() {
        if(instance == null){
            instance = new PersonReader(new EntityListGetterImpl());
        }
        return instance;
    }

    /**
     * Liest alle Personen aus der Datenbank aus.
     * @return eine Liste aller Personen
     */
    public List<Person> readPeople() {
        return entityListGetter.getPersonList();
    }

    /**
     * Liest eine einzelne Person anhand ihrer ID aus der Datenbank.
     * @param id die ID der Person
     * @return Ein Personenobjekt
     */
    public Person readPerson(int id) {
        return null;
    }
}
