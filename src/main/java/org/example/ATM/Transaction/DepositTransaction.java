package org.example.ATM.Transaction;

import org.example.ATM.Account;

public class DepositTransaction extends Transaction{
    public DepositTransaction(String transactionId, double amount, Account account) {
        super(transactionId, amount, account);
    }

    @Override
    public void execute() {
        account.credit(amount);
    }
}
