package com.example.a2_comp3074;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;
import java.util.List;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.BdgtViewHolder> {

    private List<TransactionItem> bdgtList;

    public BudgetAdapter(List<TransactionItem> bdgtList) {
        this.bdgtList = bdgtList;
    }

    @NonNull
    @Override
    public BdgtViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_budget, parent, false);
        return new BdgtViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BdgtViewHolder holder, int position) {
        TransactionItem transaction = bdgtList.get(position);
        holder.amountTextView.setText("$" + String.format("%.2f", transaction.getAmount()));
        holder.categoryTextView.setText(transaction.getCategory());
    }

    @Override
    public int getItemCount() {
        return bdgtList.size();
    }

    // Method to update the list of transactions
    public void updateList(List<TransactionItem> newList) {
        bdgtList = newList;
        notifyDataSetChanged();
    }

    static class BdgtViewHolder extends RecyclerView.ViewHolder {
        TextView amountTextView;
        TextView categoryTextView;

        public BdgtViewHolder(@NonNull View itemView) {
            super(itemView);
            amountTextView = itemView.findViewById(R.id.amountTextView);
            categoryTextView = itemView.findViewById(R.id.categoryTextView);
        }
    }
}
