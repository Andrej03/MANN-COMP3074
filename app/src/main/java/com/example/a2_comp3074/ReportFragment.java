package com.example.a2_comp3074;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReportFragment extends Fragment {

    private RecyclerView rvTransactionReports;
    private TransactionAdapter transactionAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_report, container, false);

        rvTransactionReports = view.findViewById(R.id.rv_transaction_reports);

        // Get transactions from shared data
        List<String> transactions = TransactionData.getTransactions();

        // Set up RecyclerView
        transactionAdapter = new TransactionAdapter(transactions);
        rvTransactionReports.setLayoutManager(new LinearLayoutManager(getContext()));
        rvTransactionReports.setAdapter(transactionAdapter);

        return view;
    }
}
