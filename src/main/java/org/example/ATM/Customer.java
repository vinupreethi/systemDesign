package org.example.ATM;

public class Customer {
    private Card card;
    private String name;
    private String phoneNumber;
    private String emailId;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Customer(Card card, String name, String phoneNumber, String emailId, Account account) {
        this.card = card;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.emailId = emailId;
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
