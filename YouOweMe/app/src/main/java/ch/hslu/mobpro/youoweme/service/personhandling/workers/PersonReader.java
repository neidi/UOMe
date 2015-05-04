package ch.hslu.mobpro.youoweme.service.personhandling.workers;

import ch.hslu.mobpro.youoweme.database.EntityListGetter;
import ch.hslu.mobpro.youoweme.database.EntityPerIdGetter;
import ch.hslu.mobpro.youoweme.service.dto.DtoPerson;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 */
public class PersonReader {
    private static PersonReader instance;
    private final EntityListGetter entityListGetter;
    private final EntityPerIdGetter entityPerIdGetter;

    PersonReader(EntityListGetter entityListGetter, EntityPerIdGetter entityPerIdGetter){
        this.entityListGetter = entityListGetter;
        this.entityPerIdGetter = entityPerIdGetter;
    }

    public List<DtoPerson> readPeople() {
        return null;
    }

    public DtoPerson readPerson(int id) {
        return null;
    }

    public static PersonReader getInstance() {
        if(instance == null){
            instance = new PersonReader(new EntityListGetter(), new EntityPerIdGetter());
        }
        return instance;
    }
}
