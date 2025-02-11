package com.example.myfinances;

public class Checkings {
    private int checkingsId;
    private int accountNumber;
    private double currentBalance;

    public Checkings() {
        checkingsId = -1;
    }

    private int getCheckingsId() {
        return checkingsId;
    }

    private void setCheckingsId(int i) {
        checkingsId = i;
    }

    private int getAccountNumber() {
        return accountNumber;
    }
    private void setAccountNumber(int i) {
        accountNumber = i;
    }

    private double getCurrentBalance() {
        return currentBalance;
    }

    private void setCurrentBalance(double d) {
        currentBalance = d;
    }


}
