package ch.hslu.mobpro.youoweme.database;

import java.util.List;

/**
 * Created by livio on 04.05.2015.
 */
public class EntityListGetterImpl implements EntityListGetter {
    @Override
    public List<Debt> getDebtList() {
        return null;
    }

    @Override
    public List<Person> getPersonList() {
        try {
            getPeopleTask loginTask = new getPeopleTask();
            return loginTask.execute().get();
        }catch(Exception ex){ex.printStackTrace();}
        return null;
    }
}
