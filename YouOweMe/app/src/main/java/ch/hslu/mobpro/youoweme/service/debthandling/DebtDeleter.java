package ch.hslu.mobpro.youoweme.service.debthandling;

import ch.hslu.mobpro.youoweme.database.EntityPerIdDeleter;
import ch.hslu.mobpro.youoweme.database.EntityPerIdDeleterImp;

/**
 * Created by simonneidhart on 04.05.15.
 */
public class DebtDeleter {

    private static DebtDeleter instance;
    private final EntityPerIdDeleter entityPerIdDeleter;
    DebtDeleter(EntityPerIdDeleter entityPerIdDeleter){
        this.entityPerIdDeleter = entityPerIdDeleter;
    }

    public static DebtDeleter getInstance() {
        if (instance == null) {
            instance = new DebtDeleter(new EntityPerIdDeleterImp());
        }
        return instance;
    }


    public boolean deleteDebt(int debtId) {
        return entityPerIdDeleter.deleteDebt(debtId);
    }
}
