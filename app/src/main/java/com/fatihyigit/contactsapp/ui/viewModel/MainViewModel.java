package com.fatihyigit.contactsapp.ui.viewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fatihyigit.contactsapp.data.entity.Persons;
import com.fatihyigit.contactsapp.data.repository.PersonsDao;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    private final PersonsDao personsDao = new PersonsDao();
    private MutableLiveData<List<Persons>> personsLiveData;

    public MainViewModel(){
        getAll();
        personsLiveData = personsDao.getPersons();
    }

    public MutableLiveData<List<Persons>> getPersonsLiveData() {
        return personsLiveData;
    }

    public void getAll() {
        personsDao.getAllPersons();
    }

    public void search(String word) {
        personsDao.personSearch(word);
    }

    public void delete(int id) {
        personsDao.personDelete(id);
    }


}
