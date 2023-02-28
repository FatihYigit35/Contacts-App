package com.fatihyigit.contactsapp.ui.viewModel;

import androidx.lifecycle.ViewModel;

import com.fatihyigit.contactsapp.data.repository.PersonsDao;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PersonDetailViewModel  extends ViewModel {
    private PersonsDao personsDao;

    @Inject
    public PersonDetailViewModel(PersonsDao personsDao){
        this.personsDao = personsDao;
    }

    public void update(int id, String name, String phone) {
        personsDao.personUpdate(id, name, phone);
    }
}
