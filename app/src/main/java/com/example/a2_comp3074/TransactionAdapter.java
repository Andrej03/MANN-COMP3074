package com.example.a2_comp3074;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class TransactionAdapter extends RecyclerView.Adapter<TransactionAdapter.TransactionViewHolder> {

    private List<Transaction> transactionList = new ArrayList<>();

    @NonNull
    @Override
    public TransactionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_transaction, parent, false);
        return new TransactionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TransactionViewHolder holder, int position) {
        Transaction transaction = transactionList.get(position);
        holder.bind(transaction);
    }

    @Override
    public int getItemCount() {
        return transactionList.size();
    }

    public void setTransactionList(List<Transaction> transactions) {
        this.transactionList = transactions;
        notifyDataSetChanged();
    }

    static class TransactionViewHolder extends RecyclerView.ViewHolder {

        private final TextView accNum;
        private final TextView transDesc;
        private final TextView amountSet;

        public TransactionViewHolder(@NonNull View itemView) {
            super(itemView);
            accNum = itemView.findViewById(R.id.accNum);
            transDesc = itemView.findViewById(R.id.transDesc);
            amountSet = itemView.findViewById(R.id.amountSet);
        }

        public void bind(Transaction transaction) {
            accNum.setText("Account: " + transaction.getAccNum());
            transDesc.setText("Description: " + transaction.getTransDesc());
            amountSet.setText("Amount: $" + transaction.getAmountSet());
        }
    }
}
