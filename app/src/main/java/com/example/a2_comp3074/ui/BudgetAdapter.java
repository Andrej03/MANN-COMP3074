package com.example.a2_comp3074.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a2_comp3074.R;
import com.example.a2_comp3074.TransactionItem;

import java.util.List;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.BudgetViewHolder> {

    private List<TransactionItem> transactionList;

    public BudgetAdapter(List<TransactionItem> transactionList) {
        this.transactionList = transactionList;
    }

    @NonNull
    @Override
    public BudgetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_budget, parent, false);
        return new BudgetViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BudgetViewHolder holder, int position) {
        TransactionItem transaction = transactionList.get(position);
        holder.amountTextView.setText("$" + String.format("%.2f", transaction.getAmount()));
        holder.categoryTextView.setText(transaction.getCategory());
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    // ViewHolder class
    public static class BudgetViewHolder extends RecyclerView.ViewHolder {
        TextView amountTextView;
        TextView categoryTextView;

        public BudgetViewHolder(@NonNull View itemView) {
            super(itemView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
        }
    }
}
