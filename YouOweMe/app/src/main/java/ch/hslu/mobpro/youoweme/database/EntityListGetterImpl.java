package ch.hslu.mobpro.youoweme.database;

import java.util.List;

/**
 * Created by livio on 04.05.2015.
 */
public class EntityListGetterImpl implements EntityListGetter {
    @Override
    public List<Debt> getDebtList() {
        try {
            //ToDo: Übergebe current user in debt
            getDebtTask getDebtTask = new getDebtTask();
            return getDebtTask.execute().get();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> getPersonList() {
        try {
            getPeopleTask getPeopleTask = new getPeopleTask();
            return getPeopleTask.execute().get();
        }catch(Exception ex){ex.printStackTrace();}
        return null;
    }
}
