package ch.hslu.mobpro.youoweme.database;

import java.text.SimpleDateFormat;

import ch.hslu.mobpro.youoweme.database.AsyncTasks.CreateDebtTask;
import ch.hslu.mobpro.youoweme.database.AsyncTasks.CreateUserTask;

/**
 * Created by livio on 04.05.2015.
 */
public class EntityPersistorImpl implements EntityPersistor {
    @Override
    public void savePerson(Person person) {
        CreateUserTask createUserTask = new CreateUserTask();
        createUserTask.execute(person.getFirstName(), person.getLastName(), person.geteMailAddress(), person.getPassword());
    }

    @Override
    public void saveDebt(Debt debt) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CreateDebtTask createDebtTask = new CreateDebtTask();
        createDebtTask.execute(simpleDateFormat.format(debt.getCreationDate()), simpleDateFormat.format(debt.getDueDate()), Double.toString(debt.getAmount()), Integer.toString(debt.getCreditor()), Integer.toString(debt.getDebitor()), debt.getReason());
    }
}
