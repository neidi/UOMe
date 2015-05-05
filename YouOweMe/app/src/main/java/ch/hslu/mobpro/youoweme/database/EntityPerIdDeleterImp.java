package ch.hslu.mobpro.youoweme.database;

import ch.hslu.mobpro.youoweme.database.AsyncTasks.DeleteDebtTask;
import ch.hslu.mobpro.youoweme.database.AsyncTasks.DeletePersonTask;

/**
 * Created by livio on 05.05.2015.
 */
public class EntityPerIdDeleterImp implements EntityPerIdDeleter {
    @Override
    public boolean deleteDebt(int id) {

        try {
            //ToDo: Momentan gibt es immer 2 ID's pro Debt -> Muss beide löschen nicht nur eine?
            DeleteDebtTask deleteDebtTask = new DeleteDebtTask();
            deleteDebtTask.execute(id);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deletePerson(int id) {
        try {
            DeletePersonTask deletePersonTask = new DeletePersonTask();
            deletePersonTask.execute(id);
            return true;
        }catch(Exception ex){
            ex.printStackTrace();
            return false;
        }
    }
}
