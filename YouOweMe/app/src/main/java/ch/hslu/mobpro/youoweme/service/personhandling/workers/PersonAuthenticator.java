package ch.hslu.mobpro.youoweme.service.personhandling.workers;

import ch.hslu.mobpro.youoweme.database.EntityListGetter;
import ch.hslu.mobpro.youoweme.database.EntityPersistor;
import ch.hslu.mobpro.youoweme.service.dto.DtoPerson;

/**
 * Created by simonneidhart on 04.05.15.
 */
public class PersonAuthenticator {
    private static PersonAuthenticator instance;
    private final EntityListGetter entityListGetter;
    private final EntityPersistor entityPersistor;

    PersonAuthenticator(EntityListGetter entityListGetter, EntityPersistor entityPersistor){
        this.entityListGetter = entityListGetter;
        this.entityPersistor = entityPersistor;
    }

    /**
     * Singletonmethode
     * @return
     */
    public static PersonAuthenticator getInstance(){
        if(instance==null){
            instance = new PersonAuthenticator(new EntityListGetterImpl(), new EntityPersistorImpl());
        }
        return instance;
    }
    public int authenticate(DtoPerson person) {
        for(DtoPerson dtoPerson : PersonReader.getInstance().readPeople()){
            if(dtoPerson.emailAddress == person.emailAddress && dtoPerson.password == person.password){
                return dtoPerson.id;
            }
        }
        return -1;
    }
}
