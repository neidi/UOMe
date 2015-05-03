package ch.hslu.mobpro.youoweme.database;

/**
 * Created by simonneidhart on 03.05.15.
 */
public interface EntityPersistor {
    void savePerson(Person person);

    void saveDebt(Debt debt);
}
