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

import com.example.a2_comp3074.TransactionData;

public class TransactionFragment extends Fragment {

    private EditText etAccountNumber, etDescription, etAmount;
    private Button btnSubmitTransaction;
    private TextView tvTransactionStatus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        // Initialize views
        etAccountNumber = view.findViewById(R.id.et_account_number);
        etDescription = view.findViewById(R.id.et_description);
        etAmount = view.findViewById(R.id.et_amount);
        btnSubmitTransaction = view.findViewById(R.id.btn_submit_transaction);
        tvTransactionStatus = view.findViewById(R.id.tv_transaction_status);

        // Handle button click
        btnSubmitTransaction.setOnClickListener(v -> handleTransaction());

        return view;
    }

    private void handleTransaction() {
        String accountNumber = etAccountNumber.getText().toString();
        String description = etDescription.getText().toString();
        String amount = etAmount.getText().toString();

        if (accountNumber.isEmpty() || description.isEmpty() || amount.isEmpty()) {
            tvTransactionStatus.setText("All fields are required!");
            tvTransactionStatus.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            tvTransactionStatus.setVisibility(View.VISIBLE);
            return;
        }

        // Display success message
        String successMessage = "Transaction Successful!\n" +
                "Account: " + accountNumber + "\n" +
                "Description: " + description + "\n" +
                "Amount: " + amount;
        tvTransactionStatus.setText(successMessage);
        tvTransactionStatus.setTextColor(getResources().getColor(android.R.color.holo_green_dark));
        tvTransactionStatus.setVisibility(View.VISIBLE);

        // Send data to Reports Screen (for simplicity, we'll use a shared list here)
        TransactionData.addTransaction(accountNumber, description, amount);

        // Clear input fields
        etAccountNumber.setText("");
        etDescription.setText("");
        etAmount.setText("");
    }
}
