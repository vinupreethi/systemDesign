package org.example.AirlineManagement.payment;

public class BalanceInsuffice extends Throwable {
    public BalanceInsuffice(String balanceIsInsuffice) {
        super(balanceIsInsuffice);
    }
}
