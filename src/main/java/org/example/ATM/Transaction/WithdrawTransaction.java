package org.example.ATM.Transaction;

import org.example.ATM.Account;

public class WithdrawTransaction extends Transaction{
    public WithdrawTransaction(String transactionId, double amount, Account account) {
        super(transactionId, amount, account);
    }

    @Override
    public void execute() {
        account.debit(amount);
    }
}
