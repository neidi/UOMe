package ch.hslu.mobpro.youoweme.service.debthandling;

import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.database.EntityPersistor;
import ch.hslu.mobpro.youoweme.database.EntityPersistorImpl;

/**
 * Created by simonneidhart on 04.05.15.
 */
public class DebtUpdater {

    private static DebtUpdater instance;
    private final EntityPersistor entityPersistor;

    public DebtUpdater(EntityPersistor entityPersistor) {
        this.entityPersistor = entityPersistor;
    }

    /**
     * Singletonmethode
     * @return die Instanz
     */
    public static DebtUpdater getInstance() {
        if (instance == null) {
            instance = new DebtUpdater(new EntityPersistorImpl());
        }
        return instance;
    }

    /**
     * Aktualisiert eine Schuld anhand eines Schuldobjekts
     * @param debt das Schuldobjekt mit den aktualisierten Daten
     */
    public void updateDebt(Debt debt) {

    }
}
