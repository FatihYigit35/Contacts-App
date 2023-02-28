package com.fatihyigit.contactsapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.fatihyigit.contactsapp.R;
import com.fatihyigit.contactsapp.data.entity.Persons;
import com.fatihyigit.contactsapp.databinding.FragmentMainBinding;
import com.fatihyigit.contactsapp.ui.adapter.PersonsAdapter;
import com.fatihyigit.contactsapp.ui.viewModel.MainViewModel;

import java.util.ArrayList;

public class MainFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentMainBinding binding;
    private MainViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false);

        binding.setMainFragment(this);
        binding.setToolbarMainTitle("Contacts");
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarMain); //action bar definition for search feature to work

        viewModel.getPersonsLiveData().observe(getViewLifecycleOwner(),list->{
            PersonsAdapter adapter = new PersonsAdapter(requireContext(),list,viewModel);
            binding.setPersonsAdapter(adapter);
        });

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_main_menu, menu);

                //Required codes to activate the search feature
                MenuItem item = menu.findItem(R.id.action_search);
                SearchView searchView = (SearchView) item.getActionView();
                searchView.setOnQueryTextListener(MainFragment.this);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        }
        ,getViewLifecycleOwner(), Lifecycle.State.RESUMED); //Added to fix multiple search icon errors when we come back to the homepage

        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);
    }

    public void fabClick(View v){
        Navigation.findNavController(v).navigate(R.id.actionFragment_main_to_personSave);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        viewModel.search(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        viewModel.search(newText);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();
        viewModel.getAll();
    }
}