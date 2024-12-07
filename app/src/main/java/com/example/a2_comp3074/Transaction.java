package com.example.a2_comp3074;

public class Transaction {
    private String accNum;
    private String transDesc;
    private double amountSet;

    public Transaction(String accNum, String transDesc, double amountSet) {
        this.accNum = accNum;
        this.transDesc = transDesc;
        this.amountSet = amountSet;
    }

    public String getAccNum() {
        return accNum;
    }

    public String getTransDesc() {
        return transDesc;
    }

    public double getAmountSet() {
        return amountSet;
    }
}
