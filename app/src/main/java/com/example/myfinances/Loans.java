package com.example.myfinances;

public class Loans {
    private int accountId;
    private int accountNumber;
    private double initialBalance;
    private double currentBalance;
    private double paymentAmount;
    private float interestRate;

    public Loans() {
        accountId = -1;
    }

    private int getAccountId() {
        return accountId;
    }

    private void setAccountId(int i) {
        accountId = i;
    }

    private int getAccountNumber() {
        return accountNumber;
    }

    private void setAccountNumber(int i) {
        accountNumber = i;
    }

    private double getInitialBalance() {
        return initialBalance;
    }

    private void setInitialBalance(double d) {
        initialBalance = d;
    }

    private double getCurrentBalance() {
        return currentBalance;
    }

    private void setCurrentBalance(double d) {
        currentBalance = d;
    }

    private double getPaymentAmount() {
        return paymentAmount;
    }

    private void setPaymentAmount(double d) {
        paymentAmount = d;
    }

    private float getInterestRate() {
        return interestRate;
    }

    private void setInterestRate(float f) {
        interestRate = f;
    }

}
