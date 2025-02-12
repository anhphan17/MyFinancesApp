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

    public int getLoansId() {
        return accountId;
    }

    public void setLoansId(int i) {
        accountId = i;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int i) {
        accountNumber = i;
    }

    public double getInitialBalance() {
        return initialBalance;
    }

    public void setInitialBalance(double d) {
        initialBalance = d;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double d) {
        currentBalance = d;
    }

    public double getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(double d) {
        paymentAmount = d;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float f) {
        interestRate = f;
    }

}
