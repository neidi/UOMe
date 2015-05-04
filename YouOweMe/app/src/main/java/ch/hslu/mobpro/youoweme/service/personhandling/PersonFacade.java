package ch.hslu.mobpro.youoweme.service.personhandling;

import ch.hslu.mobpro.youoweme.service.dto.DtoPerson;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 */
public interface PersonFacade {
    void createPerson(DtoPerson person);
    void updatePerson(DtoPerson person);
    boolean deletePerson(int id);
    List<DtoPerson> readPeople();
    DtoPerson getPerson(int id);
    boolean authenticate(DtoPerson person);
}
