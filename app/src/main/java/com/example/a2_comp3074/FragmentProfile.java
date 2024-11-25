package com.example.a2_comp3074;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentProfile extends Fragment {

    private ImageView profileImage;
    private EditText firstNameInput, lastNameInput, emailInput, phoneNumberInput, professionInput;
    private Button changeProfileButton, saveProfileButton;
    private SharedPreferences profilePreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        profileImage = view.findViewById(R.id.profileImage);
        firstNameInput = view.findViewById(R.id.firstNameInput);
        lastNameInput = view.findViewById(R.id.lastNameInput);
        emailInput = view.findViewById(R.id.emailInput);
        phoneNumberInput = view.findViewById(R.id.phoneNumberInput);
        professionInput = view.findViewById(R.id.professionInput);
        changeProfileButton = view.findViewById(R.id.changeProfileButton);
        saveProfileButton = view.findViewById(R.id.saveProfileButton);

        profilePreferences = requireContext().getSharedPreferences("UserProfile", 0);
        loadProfileData();

        changeProfileButton.setOnClickListener(v -> {
            Toast.makeText(getContext(), "Change Picture functionality not implemented yet", Toast.LENGTH_SHORT).show();
        });

        saveProfileButton.setOnClickListener(v -> saveProfileData());

        return view;
    }

    private void loadProfileData() {
        firstNameInput.setText(profilePreferences.getString("first_name", ""));
        lastNameInput.setText(profilePreferences.getString("last_name", ""));
        emailInput.setText(profilePreferences.getString("email", ""));
        phoneNumberInput.setText(profilePreferences.getString("phone_number", ""));
        professionInput.setText(profilePreferences.getString("profession", ""));
    }

    private void saveProfileData() {
        SharedPreferences.Editor editor = profilePreferences.edit();
        editor.putString("first_name", firstNameInput.getText().toString());
        editor.putString("last_name", lastNameInput.getText().toString());
        editor.putString("email", emailInput.getText().toString());
        editor.putString("phone_number", phoneNumberInput.getText().toString());
        editor.putString("profession", professionInput.getText().toString());
        editor.apply();

        Toast.makeText(getContext(), "Profile saved successfully!", Toast.LENGTH_SHORT).show();
    }
}
