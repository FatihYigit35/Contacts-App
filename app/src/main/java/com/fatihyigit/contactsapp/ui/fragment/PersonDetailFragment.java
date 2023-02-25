package com.fatihyigit.contactsapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fatihyigit.contactsapp.R;
import com.fatihyigit.contactsapp.data.entity.Persons;
import com.fatihyigit.contactsapp.databinding.FragmentPersonDetailBinding;

public class PersonDetailFragment extends Fragment {
    private FragmentPersonDetailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentPersonDetailBinding.inflate(inflater, container, false);

        binding.toolbarPersonUpdate.setTitle("Person Detail");

        PersonDetailFragmentArgs bundle = PersonDetailFragmentArgs.fromBundle(getArguments());

        Persons person = bundle.getPerson();

        binding.editTextDetailName.setText(person.getPerson_name());
        binding.editTextDetailPhone.setText(person.getPerson_phone());

        binding.buttonUpdate.setOnClickListener(v -> {
            String person_name = binding.editTextDetailName.getText().toString();
            String person_phone = binding.editTextDetailPhone.getText().toString();

            update(person.getPerson_id(), person_name, person_phone);
        });

        return binding.getRoot();
    }

    public void update(int id, String name, String phone) {
        Log.e("Person update", id + " - " + name + " - " + phone);
    }

}