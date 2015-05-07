package ch.hslu.mobpro.youoweme.database;

import java.util.ArrayList;
import java.util.List;

import ch.hslu.mobpro.youoweme.database.AsyncTasks.GetDebtTask;
import ch.hslu.mobpro.youoweme.database.AsyncTasks.GetPeopleTask;

/**
 * Created by livio on 04.05.2015.
 */
public class EntityListGetterImpl implements EntityListGetter {
    @Override
    public List<Debt> getDebtList() {
        try {
            //ToDo: Übergebe current user in debt
            GetDebtTask GetDebtTask = new GetDebtTask();
            return GetDebtTask.execute().get();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Person> getPersonList() {
        try {
            GetPeopleTask getPeopleTask = new GetPeopleTask();
            return  getPeopleTask.execute().get();
        }catch(Exception ex){ex.printStackTrace();}
        return null;
    }
}
