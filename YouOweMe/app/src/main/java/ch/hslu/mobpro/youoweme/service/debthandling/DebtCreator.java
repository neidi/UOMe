package ch.hslu.mobpro.youoweme.service.debthandling;

import ch.hslu.mobpro.youoweme.database.Debt;
import ch.hslu.mobpro.youoweme.database.EntityPersistor;
import ch.hslu.mobpro.youoweme.database.EntityPersistorImpl;

/**
 * Created by simonneidhart on 04.05.15.
 */
public class DebtCreator {

    private static DebtCreator instance;
    private final EntityPersistor entityPersistor;

    DebtCreator(EntityPersistor entityPersistor) {
        this.entityPersistor = entityPersistor;
    }

    /**
     * Singletonmethode
     *
     * @return die Instanz
     */
    public static DebtCreator getInstance() {
        if (instance == null) {
            instance = new DebtCreator(new EntityPersistorImpl());
        }
        return instance;
    }

    /**
     * Erstellt einen Schuldeintrag in der Datenbank
     *
     * @param debt das Schuldenobjekt
     * @return die ID des Schuldenobjekts
     */
    public int createDebt(Debt debt) {
        return 0;
    }
}
