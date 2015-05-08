package ch.hslu.mobpro.youoweme.database;

/**
 * Created by simonneidhart on 03.05.15.
 */
public interface EntityPerIdDeleter {
    boolean deleteDebt(int id);

    boolean deletePerson(int id);

    boolean markDebtAsDeleted(int id);
}
