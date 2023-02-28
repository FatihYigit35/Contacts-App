package com.fatihyigit.contactsapp.data.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.fatihyigit.contactsapp.data.entity.Persons;

import java.util.ArrayList;
import java.util.List;

public class PersonsDao {
    private MutableLiveData<List<Persons>> personsLiveData;

    public PersonsDao() {
        personsLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Persons>> getPersons() {
        return personsLiveData;
    }

    public void getAllPersons() {
        ArrayList<Persons> personList = new ArrayList<>();

        Persons p1 = new Persons(1, "Fatih", "0xxx1111111");
        Persons p2 = new Persons(2, "Songül", "0xxx2222222");
        Persons p3 = new Persons(3, "Eymen", "0xxx3333333");
        Persons p4 = new Persons(4, "Evren", "0xxx4444444");

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);

        personsLiveData.setValue(personList);
    }

    public void personSave(String name, String phone) {
        Log.e("Person", name + " - " + phone);
    }

    public void personUpdate(int id, String name, String phone) {
        Log.e("Person update", id + " - " + name + " - " + phone);
    }

    public void personSearch(String word) {
        Log.e("Person search", word);
    }

    public void personDelete(int id) {
        Log.e("Person delete", String.valueOf(id));
    }
}
