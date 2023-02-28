package com.fatihyigit.contactsapp.ui.viewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.fatihyigit.contactsapp.data.repository.PersonsDao;

public class PersonSaveViewModel extends ViewModel {
    private PersonsDao personsDao = new PersonsDao();

    public void save(String name, String phone){
        personsDao.personSave(name,phone);
    }
}
