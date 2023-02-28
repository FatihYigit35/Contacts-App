package com.fatihyigit.contactsapp.ui.viewModel;

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

    public void save(String name, String phone){
        personsDaoRepository.personSave(name,phone);
    }
}
