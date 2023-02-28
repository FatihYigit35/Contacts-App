package com.fatihyigit.contactsapp.ui.viewModel;

import androidx.lifecycle.ViewModel;

import com.fatihyigit.contactsapp.data.repository.PersonsDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class PersonDetailViewModel  extends ViewModel {
    private PersonsDaoRepository personsDaoRepository;

    @Inject
    public PersonDetailViewModel(PersonsDaoRepository personsDaoRepository){
        this.personsDaoRepository = personsDaoRepository;
    }

    public void update(int id, String name, String phone) {
        personsDaoRepository.personUpdate(id, name, phone);
    }
}
