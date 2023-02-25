package com.fatihyigit.contactsapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_detail, container, false);

        binding.setPersonDetailFragment(this);
        binding.setToolbarPersonDetailTitle("Person Detail");

        PersonDetailFragmentArgs bundle = PersonDetailFragmentArgs.fromBundle(getArguments());
        Persons person = bundle.getPerson();
        binding.setPersonObject(person);

        return binding.getRoot();
    }

    public void buttonUpdate(int id, String name, String phone) {
        Log.e("Person update", id + " - " + name + " - " + phone);
    }

}