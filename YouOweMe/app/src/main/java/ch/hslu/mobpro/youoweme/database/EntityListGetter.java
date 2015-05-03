package ch.hslu.mobpro.youoweme.database;

import java.util.List;

/**
 * Created by simonneidhart on 03.05.15.
 */
public interface EntityListGetter {
    List<Debt> getDebtList();

    List<Person> getPersonList();
}
