package com.example.myfinances;

public class CertificatesOfDeposit {
    private int cdId;
    private int accountNumber;
    private double initialBalance;
    private double currentBalance;
    private float interestRate;

    public CertificatesOfDeposit() {
        cdId = -1;
    }

    public int getCdId() {
        return cdId;
    }

    public void setCdId(int i) {
        cdId = i;
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

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float f) {
        interestRate = f;
    }

}
