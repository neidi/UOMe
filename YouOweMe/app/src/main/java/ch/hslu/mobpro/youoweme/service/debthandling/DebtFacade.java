package ch.hslu.mobpro.youoweme.service.debthandling;

import ch.hslu.mobpro.youoweme.database.Debt;

import java.util.List;

/**
 * Created by simonneidhart on 04.05.15.
 */
public interface DebtFacade {
    void createDebt(Debt debt);
    void updateDebt(Debt debt);
    boolean deleteDebt(int debtId);
    List<Debt> readDebts();
    Debt getDebt(int id);
}
