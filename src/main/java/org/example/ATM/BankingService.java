package org.example.ATM;

import org.example.ATM.Transaction.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BankingService {
    List<Account> accountList = new ArrayList<>();

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }


    public void executeTransaction(Transaction transaction) {
        transaction.execute();
    }


    public double getCardAccountbalance(Card card) {
        return card.getAccount().getBalance();
    }
}
