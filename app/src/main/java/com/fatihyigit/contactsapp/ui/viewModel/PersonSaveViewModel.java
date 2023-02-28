package com.fatihyigit.contactsapp.ui.viewModel;

import androidx.lifecycle.ViewModel;

import com.fatihyigit.contactsapp.data.repository.PersonsDao;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PersonSaveViewModel extends ViewModel {
    private PersonsDao personsDao;

    @Inject
    public PersonSaveViewModel(PersonsDao personsDao){
        this.personsDao = personsDao;
    }

    public void save(String name, String phone){
        personsDao.personSave(name,phone);
    }
}
