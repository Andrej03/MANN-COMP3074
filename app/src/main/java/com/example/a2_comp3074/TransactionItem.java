package com.example.a2_comp3074;

public class TransactionItem {
    private double amount;
    private String category;

    // Constructor
    public TransactionItem(double amount, String category) {
        this.amount = amount;
        this.category = category;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }
}
