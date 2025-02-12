package com.example.myfinances;

public class Checkings {
    private int checkingsId;
    private int accountNumber;
    private double currentBalance;

    public Checkings() {
        checkingsId = -1;
    }

    public int getCheckingsId() {
        return checkingsId;
    }

    public void setCheckingsId(int i) {
        checkingsId = i;
    }

    public int getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(int i) {
        accountNumber = i;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double d) {
        currentBalance = d;
    }


}
