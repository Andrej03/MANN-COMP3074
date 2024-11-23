package com.example.a2_comp3074;

import java.util.ArrayList;
import java.util.List;

public class TransactionData {

    private static final List<String> transactions = new ArrayList<>();

    public static void addTransaction(String account, String description, String amount) {
        String transaction = "Account: " + account + ", Description: " + description + ", Amount: " + amount;
        transactions.add(transaction);
    }

    public static List<String> getTransactions() {
        return transactions;
    }
}

