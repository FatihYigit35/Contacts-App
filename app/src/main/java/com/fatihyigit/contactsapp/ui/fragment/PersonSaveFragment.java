package com.fatihyigit.contactsapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fatihyigit.contactsapp.R;
import com.fatihyigit.contactsapp.databinding.FragmentPersonSaveBinding;

public class PersonSaveFragment extends Fragment {
    private FragmentPersonSaveBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPersonSaveBinding.inflate(inflater, container, false);

        binding.toolbarPersonSave.setTitle("New Person Save");

        binding.buttonSave.setOnClickListener(v -> {
            String person_name = binding.editTextName.getText().toString();
            String person_phone = binding.editTextPhone.getText().toString();

            save(person_name,person_phone);
        });

        return binding.getRoot();
    }

    public void save(String name, String phone){
        Log.e("Person", name + " - " + phone);
    }
}