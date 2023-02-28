package com.fatihyigit.contactsapp.ui.viewModel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.fatihyigit.contactsapp.data.repository.PersonsDao;

public class PersonDetailViewModel  extends ViewModel {
    private PersonsDao personsDao = new PersonsDao();

    public void update(int id, String name, String phone) {
        personsDao.personUpdate(id, name, phone);
    }
}
