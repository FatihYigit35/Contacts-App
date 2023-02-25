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
import com.fatihyigit.contactsapp.databinding.FragmentPersonSaveBinding;

public class PersonSaveFragment extends Fragment {
    private FragmentPersonSaveBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_person_save, container, false);

        binding.setPersonSaveFragment(this);
        binding.setToolbarPersonSaveTitle("New Person Save");

        return binding.getRoot();
    }

    public void buttonSave(String name, String phone){
        Log.e("Person", name + " - " + phone);
    }
}