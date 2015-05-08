package ch.hslu.mobpro.youoweme.database;

import java.util.Date;

/**
 * Created by simonneidhart on 03.05.15.
 */
public class Debt {
    private int id;
    private Date creationDate;
    private Date dueDate;
    private double amount;
    private String reason;
    private int creditorid;
    private int debitorid;
    private boolean markedAsDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getCreditor() {
        return creditorid;
    }

    public void setCreditor(int creditor) {
        this.creditorid = creditor;
    }

    public int getDebitor() {
        return debitorid;
    }

    public void setDebitor(int debitor) {
        this.debitorid = debitor;
    }

    public boolean isMarkedAsDeleted() {
        return markedAsDeleted;
    }

    public void setMarkedAsDeleted(boolean markedAsDeleted) {
        this.markedAsDeleted = markedAsDeleted;
    }
}
