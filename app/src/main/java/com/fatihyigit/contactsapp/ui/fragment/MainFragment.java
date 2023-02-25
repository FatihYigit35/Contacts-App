package com.fatihyigit.contactsapp.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
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

import java.util.ArrayList;

public class MainFragment extends Fragment implements SearchView.OnQueryTextListener {
    private FragmentMainBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false);

        binding.setMainFragment(this);
        binding.setToolbarMainTitle("Contacts");
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarMain); //action bar definition for search feature to work

        ArrayList<Persons> persons = new ArrayList<>();

        Persons p1 = new Persons(1,"Fatih","0xxx1111111");
        Persons p2 = new Persons(2,"Songül","0xxx2222222");
        Persons p3 = new Persons(3,"Eymen","0xxx3333333");
        Persons p4 = new Persons(4,"Evren","0xxx4444444");

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);

        PersonsAdapter adapter = new PersonsAdapter(requireContext(),persons);
        binding.setPersonsAdapter(adapter);

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
        });

        return binding.getRoot();
    }

    public void fabClick(View v){
        Navigation.findNavController(v).navigate(R.id.actionFragment_main_to_personSave);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        search(query);
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        search(newText);
        return true;
    }

    public void search(String word){
        Log.e("Person search",word);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("Anasayfaya", "dönüldü.");
    }
}