package com.example.a2_comp3074;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

public class TransactionFragment extends Fragment {

    private EditText accNum;
    private EditText transDesc;
    private EditText amountSet;
    private Button submitTransaction;
    private TextView transactionStatus;
    private SharedViewModel sharedViewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        accNum = view.findViewById(R.id.accNum);
        transDesc = view.findViewById(R.id.transDesc);
        amountSet = view.findViewById(R.id.amountSet);
        submitTransaction = view.findViewById(R.id.submitTransaction);
        transactionStatus = view.findViewById(R.id.transactionStatus);

        sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        submitTransaction.setOnClickListener(v -> handleTransaction());

        return view;
    }

    private void handleTransaction() {
        String accNumText = accNum.getText().toString();
        String transDescText = transDesc.getText().toString();
        String amountSetText = amountSet.getText().toString();

        if (accNumText.isEmpty() || transDescText.isEmpty() || amountSetText.isEmpty()) {
            transactionStatus.setText("All fields are required!");
            transactionStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            transactionStatus.setVisibility(View.VISIBLE);
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountSetText);
        } catch (NumberFormatException e) {
            transactionStatus.setText("Invalid amount!");
            transactionStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            transactionStatus.setVisibility(View.VISIBLE);
            return;
        }

        Transaction transaction = new Transaction(accNumText, transDescText, amount);

        sharedViewModel.addTransaction(transaction);

        String successMessage = "Transaction Successful!\nAccount: " + accNumText + "\nDescription: " + transDescText + "\nAmount: " + amount;
        transactionStatus.setText(successMessage);
        transactionStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        transactionStatus.setVisibility(View.VISIBLE);

        accNum.setText("");
        transDesc.setText("");
        amountSet.setText("");
    }
}
