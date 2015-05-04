package ch.hslu.mobpro.youoweme.service.personhandling.workers;

import ch.hslu.mobpro.youoweme.database.EntityListGetter;
import ch.hslu.mobpro.youoweme.database.EntityListGetterImpl;
import ch.hslu.mobpro.youoweme.database.EntityPersistor;
import ch.hslu.mobpro.youoweme.database.Person;

/**
 * Created by simonneidhart on 04.05.15.
 * Klasse zur Personenerstellung
 */
public class PersonCreator {
    private static PersonCreator instance;
    private final EntityListGetter entityListGetter;
    private final EntityPersistor entityPersistor;

    PersonCreator(EntityListGetter entityListGetter, EntityPersistor entityPersistor){
        this.entityListGetter = entityListGetter;
        this.entityPersistor = entityPersistor;
    }

    /**
     * Singletonmethode
     * @return
     */
    public static PersonCreator getInstance(){
        if(instance==null){
            //instance = new PersonCreator(new EntityListGetterImpl(), new EntityPersistorImpl());
        }
        return instance;
    }

    /**
     * Erstellt anhand der Personeninformationen einen Eintrag in die Personentabelle
     * @param person das Data Transfer Object mit den Personeninformationen
     * @return die ID des neu erstellten Datenbankeintrages
     */
    public int createPerson(Person person) {
        return 0;
    }
}
