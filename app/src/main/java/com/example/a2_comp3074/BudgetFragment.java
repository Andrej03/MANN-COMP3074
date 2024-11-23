package com.example.a2_comp3074;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BudgetFragment extends Fragment {

    private EditText etBudgetItem;
    private Spinner spinnerCategory;
    private Button btnAddBudgetItem;
    private TextView tvBudgetTotal;
    private RecyclerView rvBudgetList;

    private BudgetAdapter budgetAdapter;
    private List<String> budgetList;
    private double totalBudget;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budget, container, false);

        etBudgetItem = view.findViewById(R.id.et_budget_item);
        spinnerCategory = view.findViewById(R.id.spinner_category);
        btnAddBudgetItem = view.findViewById(R.id.btn_add_budget_item);
        tvBudgetTotal = view.findViewById(R.id.tv_budget_total);
        rvBudgetList = view.findViewById(R.id.rv_budget_list);

        budgetList = new ArrayList<>();
        budgetAdapter = new BudgetAdapter(budgetList);
        rvBudgetList.setLayoutManager(new LinearLayoutManager(getContext()));
        rvBudgetList.setAdapter(budgetAdapter);

        btnAddBudgetItem.setOnClickListener(v -> addBudgetItem());

        return view;
    }

    private void addBudgetItem() {
        String item = etBudgetItem.getText().toString();
        String category = spinnerCategory.getSelectedItem().toString();

        if (!item.isEmpty()) {
            budgetList.add(item + " (" + category + ")");
            budgetAdapter.notifyDataSetChanged();

            // For simplicity, assume every item is $100
            totalBudget += 100;
            tvBudgetTotal.setText("Total Budget: $" + totalBudget);

            etBudgetItem.setText("");
        }
    }
}
