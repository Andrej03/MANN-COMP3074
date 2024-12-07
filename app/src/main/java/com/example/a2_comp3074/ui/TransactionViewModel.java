package com.example.a2_comp3074.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a2_comp3074.TransactionItem;

import java.util.List;
import java.util.ArrayList;

public class TransactionViewModel extends ViewModel {
    private MutableLiveData<List<TransactionItem>> transactions = new MutableLiveData<>(new ArrayList<>());

    // Get the list of transactions
    public MutableLiveData<List<TransactionItem>> getTransactions() {
        return transactions;
    }

    // Add a new transaction to the list
    public void addTransaction(TransactionItem transaction) {
        List<TransactionItem> currentTransactions = transactions.getValue();
        if (currentTransactions != null) {
            currentTransactions.add(transaction);
            transactions.setValue(currentTransactions);
        }
    }
}
