package com.example.a2_comp3074;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a2_comp3074.ui.BudgetViewModel;
import com.example.a2_comp3074.ui.TransactionViewModel;

import java.util.List;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.ArrayList;
public class DashboardFragment extends Fragment {

    private RecyclerView dashboardRecyclerView;
    private BudgetAdapter dashboardAdapter;

    private BudgetViewModel budgetViewModel;

    private RecyclerView reportsRecyclerView;
    private TransactionAdapter transactionAdapter;
    private SharedViewModel sharedViewModel;

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        reportsRecyclerView = view.findViewById(R.id.reportsRecyclerView);
        reportsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        transactionAdapter = new TransactionAdapter();
        reportsRecyclerView.setAdapter(transactionAdapter);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        sharedViewModel.getTransactions().observe(getViewLifecycleOwner(), new Observer<List<Transaction>>() {
            @Override
            public void onChanged(List<Transaction> transactions) {
                transactionAdapter.setTransactionList(transactions);
            }
        });

 //       return view;
   // }

        // Initialize RecyclerView and Adapter
        dashboardRecyclerView = view.findViewById(R.id.recyclerview);
        dashboardAdapter = new BudgetAdapter(new ArrayList<>());
        dashboardRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        dashboardRecyclerView.setAdapter(dashboardAdapter);

        // Initialize ViewModel
        budgetViewModel = new ViewModelProvider(requireActivity()).get(BudgetViewModel.class);

        // Observe the LiveData from ViewModel
        budgetViewModel.getTransactionList().observe(getViewLifecycleOwner(), transactionItems -> {
            // Update the RecyclerView when data changes
            dashboardAdapter.updateList(transactionItems);
        });

        return view;
    }
}
