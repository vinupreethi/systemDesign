package org.example.ATM;

public class Account {
    private String accountNo;
    private String userName;
    private String password;
    private String bank;
    private Card card;
    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Account(String accountNo, String userName, String password, String bank, Card card, double balance) {
        this.accountNo = accountNo;
        this.userName = userName;
        this.password = password;
        this.bank = bank;
        this.card = card;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void debit(double amount) {
    }

    public void credit(double amount) {
        
    }
}
