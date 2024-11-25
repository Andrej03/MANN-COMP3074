package com.example.a2_comp3074;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BudgetAdapter extends RecyclerView.Adapter<BudgetAdapter.BdgtViewHolder> {

    private final List<String> bdgtList;

    public BudgetAdapter(List<String> bdgtList) {
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
        String bdgt = bdgtList.get(position);
        holder.bdgtTxt.setText(bdgt);
    }

    @Override
    public int getItemCount() {
        return bdgtList.size();
    }

    static class BdgtViewHolder extends RecyclerView.ViewHolder {
        TextView bdgtTxt;

        public BdgtViewHolder(@NonNull View itemView) {
            super(itemView);
            bdgtTxt = itemView.findViewById(R.id.bdgtTxt);
        }
    }
}
