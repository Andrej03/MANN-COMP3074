package com.example.a2_comp3074;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2_comp3074.ui.BudgetViewModel;

import java.util.ArrayList;
import java.util.List;
public class BudgetFragment extends Fragment {

    private EditText bdgtInp;
    private Spinner itmCat;
    private Button addBdgtBtn;
    private TextView bdgtTotalTxt;
    private RecyclerView bdgtListView;

    private BudgetAdapter bdgtAdapter;
    private double bdgtTot;

    private BudgetViewModel budgetViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budget, container, false);

        bdgtInp = view.findViewById(R.id.bdgtInp);
        itmCat = view.findViewById(R.id.itmCat);
        addBdgtBtn = view.findViewById(R.id.addBdgtBtn);
        bdgtTotalTxt = view.findViewById(R.id.bdgtTotTxt);
        bdgtListView = view.findViewById(R.id.bdgtListView);

        // Initialize ViewModel
        budgetViewModel = new ViewModelProvider(requireActivity()).get(BudgetViewModel.class);

        // Set up RecyclerView
        bdgtAdapter = new BudgetAdapter(new ArrayList<>());
        bdgtListView.setLayoutManager(new LinearLayoutManager(getContext()));
        bdgtListView.setAdapter(bdgtAdapter);

        // Set up spinner categories
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        itmCat.setAdapter(adapter);

        addBdgtBtn.setOnClickListener(v -> addBdgtItm());

        // Observe the LiveData from ViewModel
        budgetViewModel.getTransactionList().observe(getViewLifecycleOwner(), transactionItems -> {
            // Update the RecyclerView when data changes
            bdgtAdapter.updateList(transactionItems);
        });

        return view;
    }

    private void addBdgtItm() {
        String itm = bdgtInp.getText().toString();
        String cat = itmCat.getSelectedItem().toString();

        if (!itm.isEmpty()) {
            try {
                double amount = Double.parseDouble(itm);

                // Create a new transaction item and add it to the ViewModel
                TransactionItem transactionItem = new TransactionItem(amount, cat);
                budgetViewModel.addTransaction(transactionItem);

                // Update the total budget
                bdgtTot += amount;
                bdgtTotalTxt.setText("Total Budget: $" + String.format("%.2f", bdgtTot));

                // Clear the input field for the next entry
                bdgtInp.setText("");
            } catch (NumberFormatException e) {
                Toast.makeText(getContext(), "Please enter a valid amount", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getContext(), "Please enter an amount", Toast.LENGTH_SHORT).show();
        }
    }
}
