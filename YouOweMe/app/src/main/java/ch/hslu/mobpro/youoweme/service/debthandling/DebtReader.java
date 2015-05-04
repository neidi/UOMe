package ch.hslu.mobpro.youoweme.service.debthandling;

import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.database.EntityListGetter;
import ch.hslu.mobpro.youoweme.database.EntityListGetterImpl;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 */
public class DebtReader {

    private final EntityListGetter entityListGetter;
    private static DebtReader instance;

    DebtReader(EntityListGetter entityListGetter) {
        this.entityListGetter = entityListGetter;
    }

    public static DebtReader getInstance() {
        if (instance == null) {
            instance = new DebtReader(new EntityListGetterImpl());
        }
        return instance;
    }

    public List<Debt> readDebts() {
        return entityListGetter.getDebtList();
    }

    public Debt readDebt(int id) {
        return null;
    }
}
