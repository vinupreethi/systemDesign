package org.example.ATM;

public class Card {
    private String cardNo;
    private String pinNo;
    private Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card(String cardNo, String pinNo) {
        this.cardNo = cardNo;
        this.pinNo = pinNo;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }
}
