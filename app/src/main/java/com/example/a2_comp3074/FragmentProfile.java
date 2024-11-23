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

    private ImageView ivProfilePicture;
    private EditText etFirstName, etLastName, etEmail, etPhoneNumber, etProfession;
    private Button btnChangePicture, btnSaveProfile;

    private SharedPreferences sharedPreferences;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Initialize views
        ivProfilePicture = view.findViewById(R.id.iv_profile_picture);
        etFirstName = view.findViewById(R.id.et_first_name);
        etLastName = view.findViewById(R.id.et_last_name);
        etEmail = view.findViewById(R.id.et_email);
        etPhoneNumber = view.findViewById(R.id.et_phone_number);
        etProfession = view.findViewById(R.id.et_profession);
        btnChangePicture = view.findViewById(R.id.btn_change_picture);
        btnSaveProfile = view.findViewById(R.id.btn_save_profile);

        // Load saved profile data
        sharedPreferences = requireContext().getSharedPreferences("UserProfile", 0);
        loadProfileData();

        // Handle change picture button (placeholder for future implementation)
        btnChangePicture.setOnClickListener(v -> {
            // For now, just show a toast
            Toast.makeText(getContext(), "Change Picture functionality not implemented yet", Toast.LENGTH_SHORT).show();
        });

        // Handle save profile button
        btnSaveProfile.setOnClickListener(v -> saveProfileData());

        return view;
    }

    private void loadProfileData() {
        etFirstName.setText(sharedPreferences.getString("first_name", ""));
        etLastName.setText(sharedPreferences.getString("last_name", ""));
        etEmail.setText(sharedPreferences.getString("email", ""));
        etPhoneNumber.setText(sharedPreferences.getString("phone_number", ""));
        etProfession.setText(sharedPreferences.getString("profession", ""));
    }

    private void saveProfileData() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("first_name", etFirstName.getText().toString());
        editor.putString("last_name", etLastName.getText().toString());
        editor.putString("email", etEmail.getText().toString());
        editor.putString("phone_number", etPhoneNumber.getText().toString());
        editor.putString("profession", etProfession.getText().toString());
        editor.apply();

        Toast.makeText(getContext(), "Profile saved successfully!", Toast.LENGTH_SHORT).show();
    }
}
