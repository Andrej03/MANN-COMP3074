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

    private EditText bdgtInp;
    private Spinner itmCat;
    private Button addBdgtBtn;
    private TextView bdgtTotalTxt;
    private RecyclerView bdgtListView;

    private BudgetAdapter bdgtAdapter;
    private List<String> bdgtList;
    private double bdgtTot;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_budget, container, false);

        bdgtInp = view.findViewById(R.id.bdgtInp);
        itmCat = view.findViewById(R.id.itmCat);
        addBdgtBtn = view.findViewById(R.id.addBdgtBtn);
        bdgtTotalTxt = view.findViewById(R.id.bdgtTotTxt);
        bdgtListView = view.findViewById(R.id.bdgtListView);

        bdgtList = new ArrayList<>();
        bdgtAdapter = new BudgetAdapter(bdgtList);
        bdgtListView.setLayoutManager(new LinearLayoutManager(getContext()));
        bdgtListView.setAdapter(bdgtAdapter);

        addBdgtBtn.setOnClickListener(v -> addBdgtItm());

        return view;
    }

    private void addBdgtItm() {
        String itm = bdgtInp.getText().toString();
        String cat = itmCat.getSelectedItem().toString();

        if (!itm.isEmpty()) {
            bdgtList.add(itm + " (" + cat + ")");
            bdgtAdapter.notifyDataSetChanged();
            bdgtTot += 100;
            bdgtTotalTxt.setText("Total Budget: $" + bdgtTot);
            bdgtInp.setText("");
        }
    }
}
