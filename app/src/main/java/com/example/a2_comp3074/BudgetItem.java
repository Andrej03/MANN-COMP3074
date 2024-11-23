package com.example.a2_comp3074;

public class BudgetItem {
    private final String name;
    private final String category;
    private final double amount;

    public BudgetItem(String name, String category, double amount) {
        this.name = name;
        this.category = category;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}
