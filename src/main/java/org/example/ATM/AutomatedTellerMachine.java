package org.example.ATM;

import org.example.ATM.Transaction.DepositTransaction;
import org.example.ATM.Transaction.Transaction;
import org.example.ATM.Transaction.WithdrawTransaction;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class AutomatedTellerMachine {
    private BankingService bankingService;
    private CashCollectDispenser cashDispenser;
    private static final AtomicLong transactionCounter = new AtomicLong(0);

    public AutomatedTellerMachine(BankingService bankingService, CashCollectDispenser cashDispenser) {
        this.bankingService = bankingService;
        this.cashDispenser = cashDispenser;
    }

    public double enquireBalance(Card card) {
        return bankingService.getCardAccountbalance(card);
    }

    public void depositCash(Card card, double depositbalance) {
        List<Account> accountList = bankingService.getAccountList();
        Optional<Account> account = accountList.stream().filter(card1 -> card1.getCard().getCardNo().equals(card.getCardNo())).findFirst();
        DepositTransaction depositTransaction=new DepositTransaction(getTransactionId(),depositbalance,account.get());
        if (account.isEmpty()) {
            throw new IllegalArgumentException("Account not found for the given card.");
        }
        bankingService.executeTransaction(depositTransaction);
        cashDispenser.collectCash(depositbalance);
    }

    private String getTransactionId() {
        long transactionNumber=transactionCounter.incrementAndGet();
        return "TXN"+transactionNumber;
    }

    public void withdrawCash(Card card, double balance) {
        List<Account> accountList = bankingService.getAccountList();
        Optional<Account> account = accountList.stream().filter(card1 -> card1.getCard().getCardNo().equals(card.getCardNo())).findFirst();
        if (account.isEmpty()) {
            throw new IllegalArgumentException("Account not found for the given card.");
        }
        WithdrawTransaction depositTransaction=new WithdrawTransaction(getTransactionId(),balance,account.get());
        bankingService.executeTransaction(depositTransaction);
        cashDispenser.dispenseCash(balance);
        System.out.println(cashDispenser.getAmount());
    }

    public void authenticateCard(Card card) {

    }
}
