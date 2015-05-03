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
    private Person creditor;
    private Person debitor;

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

    public Person getCreditor() {
        return creditor;
    }

    public void setCreditor(Person creditor) {
        this.creditor = creditor;
    }

    public Person getDebitor() {
        return debitor;
    }

    public void setDebitor(Person debitor) {
        this.debitor = debitor;
    }
}
