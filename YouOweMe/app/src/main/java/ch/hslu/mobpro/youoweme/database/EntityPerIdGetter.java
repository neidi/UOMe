package ch.hslu.mobpro.youoweme.database;

/**
 * Created by simonneidhart on 03.05.15.
 */
public interface EntityPerIdGetter {
    Person getPerson(int id);

    Debt getDebt(int id);
}
