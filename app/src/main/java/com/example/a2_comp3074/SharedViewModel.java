package com.example.a2_comp3074;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class SharedViewModel extends ViewModel {
    private final MutableLiveData<List<Transaction>> transactions = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Transaction>> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        List<Transaction> currentTransactions = transactions.getValue();
        if (currentTransactions != null) {
            currentTransactions.add(transaction);
            transactions.setValue(currentTransactions);
        }
    }
}
