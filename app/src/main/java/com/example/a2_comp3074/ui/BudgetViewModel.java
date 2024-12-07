package com.example.a2_comp3074.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.a2_comp3074.TransactionItem;

import java.util.ArrayList;
import java.util.List;

public class BudgetViewModel extends ViewModel {

    // LiveData to hold the list of transaction items
    private final MutableLiveData<List<TransactionItem>> transactionList = new MutableLiveData<>();

    public BudgetViewModel() {
        transactionList.setValue(new ArrayList<>());
    }

    // Get the list of transactions
    public MutableLiveData<List<TransactionItem>> getTransactionList() {
        return transactionList;
    }

    // Add a new transaction
    public void addTransaction(TransactionItem transactionItem) {
        List<TransactionItem> currentList = transactionList.getValue();
        if (currentList != null) {
            currentList.add(transactionItem);
            transactionList.setValue(currentList); // Update the LiveData
        }
    }
}
