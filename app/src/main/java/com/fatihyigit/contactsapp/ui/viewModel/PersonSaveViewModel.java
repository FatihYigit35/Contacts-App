package com.fatihyigit.contactsapp.ui.viewModel;

import android.view.View;

import androidx.lifecycle.ViewModel;

import com.fatihyigit.contactsapp.data.repository.PersonsDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PersonSaveViewModel extends ViewModel {
    private PersonsDaoRepository personsDaoRepository;

    @Inject
    public PersonSaveViewModel(PersonsDaoRepository personsDaoRepository){
        this.personsDaoRepository = personsDaoRepository;
    }

    public void save(String name, String phone, View v){
        personsDaoRepository.personSave(name,phone,v);
    }
}
