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

    private int getCdId() {
        return cdId;
    }

    private void setCdId(int i) {
        cdId = i;
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

    private float getInterestRate() {
        return interestRate;
    }

    private void setInterestRate(float f) {
        interestRate = f;
    }

}
