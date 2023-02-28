package com.fatihyigit.contactsapp.ui.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fatihyigit.contactsapp.data.entity.Persons;
import com.fatihyigit.contactsapp.data.repository.PersonsDao;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private PersonsDao personsDao;
    private MutableLiveData<List<Persons>> personsLiveData;

    @Inject
    public MainViewModel(PersonsDao personsDao){
        this.personsDao = personsDao;
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
