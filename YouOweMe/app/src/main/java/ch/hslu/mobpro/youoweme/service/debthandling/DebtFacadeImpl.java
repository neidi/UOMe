package ch.hslu.mobpro.youoweme.service.debthandling;

import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.service.debthandling.workers.DebtCreator;
import ch.hslu.mobpro.youoweme.service.debthandling.workers.DebtDeleter;
import ch.hslu.mobpro.youoweme.service.debthandling.workers.DebtReader;
import ch.hslu.mobpro.youoweme.service.debthandling.workers.DebtUpdater;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 */
public class DebtFacadeImpl implements DebtFacade {
    private DebtCreator debtCreator;
    private DebtUpdater debtUpdater;
    private DebtDeleter debtDeleter;
    private DebtReader debtReader;

    @Override
    public void createDebt(Debt debt) {
        debt.setId(debtCreator.createDebt(debt));
        updateDebt(debt);
    }

    @Override
    public void updateDebt(Debt debt) {
        debtUpdater.updateDebt(debt);
    }

    @Override
    public boolean deleteDebt(int debtId) {
        return debtDeleter.deleteDebt(debtId);
    }

    @Override
    public List<Debt> readDebts() {
        return debtReader.readDebts();
    }

    @Override
    public Debt getDebt(int id) {
        return debtReader.readDebt(id);
    }
}
