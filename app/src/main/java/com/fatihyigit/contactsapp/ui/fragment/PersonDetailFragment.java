package com.fatihyigit.contactsapp.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.fatihyigit.contactsapp.R;
import com.fatihyigit.contactsapp.data.entity.Persons;
import com.fatihyigit.contactsapp.databinding.FragmentPersonDetailBinding;
import com.fatihyigit.contactsapp.ui.viewModel.PersonDetailViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PersonDetailFragment extends Fragment {
    private FragmentPersonDetailBinding binding;
    private PersonDetailViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(PersonDetailViewModel.class);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_person_detail, container, false);

        binding.setPersonDetailFragment(this);
        binding.setToolbarPersonDetailTitle("Person Detail");

        PersonDetailFragmentArgs bundle = PersonDetailFragmentArgs.fromBundle(requireArguments());
        Persons person = bundle.getPerson();
        binding.setPersonObject(person);

        return binding.getRoot();
    }

    public void buttonUpdate(int id, String name, String phone, View v) {
        viewModel.update(id, name, phone,v);
    }

}