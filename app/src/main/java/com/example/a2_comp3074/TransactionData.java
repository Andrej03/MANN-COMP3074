package com.example.a2_comp3074;

import java.util.ArrayList;
import java.util.List;

public class TransactionData {

    private static final List<String> transactions = new ArrayList<>();

    public static void addTransaction(String accNum, String transDesc, String amountSet) {
        String transaction = "Account: " + accNum + ", Description: " + transDesc + ", Amount: " + amountSet;
        transactions.add(transaction);
    }

    public static List<String> getTransactions() {
        return transactions;
    }
}
