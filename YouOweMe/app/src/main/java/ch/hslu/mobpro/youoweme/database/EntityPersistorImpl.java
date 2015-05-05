package ch.hslu.mobpro.youoweme.database;

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

    }
}
