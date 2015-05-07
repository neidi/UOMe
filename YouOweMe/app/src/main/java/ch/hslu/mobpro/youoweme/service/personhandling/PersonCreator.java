package ch.hslu.mobpro.youoweme.service.personhandling;

import ch.hslu.mobpro.youoweme.database.*;

/**
 * Created by simonneidhart on 04.05.15.
 * Klasse zur Personenerstellung
 */
public final class PersonCreator {
    private static PersonCreator instance;

    private final EntityListGetter entityListGetter;
    private final EntityPersistor entityPersistor;

    PersonCreator(EntityListGetter entityListGetter, EntityPersistor entityPersistor) {
        this.entityListGetter = entityListGetter;
        this.entityPersistor = entityPersistor;
    }

    /**
     * Singletonmethode
     *
     * @return
     */
    public static PersonCreator getInstance() {
        if (instance == null) {
            instance = new PersonCreator(new EntityListGetterImpl(), new EntityPersistorImpl());
        }
        return instance;
    }

    /**
     * Erstellt anhand der Personeninformationen einen Eintrag in die Personentabelle
     *
     * @param person das Data Transfer Object mit den Personeninformationen
     * @return die ID des neu erstellten Datenbankeintrages
     */
    public int createPerson(Person person) {
        try {
            entityPersistor.savePerson(person);
        }catch(Exception ex){
            ex.printStackTrace();
            return -1;
        }
        return person.getId();
    }

}
