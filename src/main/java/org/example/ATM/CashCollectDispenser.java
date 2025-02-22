package org.example.ATM;

public class CashCollectDispenser {
    private double Amount;

    public CashCollectDispenser(double Amount) {
        this.Amount = Amount;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double amount) {
        Amount = amount;
    }

    public void dispenseCash(double balance) {
        this.Amount-=balance;
    }

    public void collectCash(double depositbalance) {
        this.Amount+=depositbalance;
    }
}
