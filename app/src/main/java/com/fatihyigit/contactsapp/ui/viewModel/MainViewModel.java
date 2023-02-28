package com.fatihyigit.contactsapp.ui.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fatihyigit.contactsapp.data.entity.Persons;
import com.fatihyigit.contactsapp.data.repository.PersonsDaoRepository;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends ViewModel {
    private PersonsDaoRepository personsDaoRepository;
    private MutableLiveData<List<Persons>> personsLiveData;

    @Inject
    public MainViewModel(PersonsDaoRepository personsDaoRepository){
        this.personsDaoRepository = personsDaoRepository;
        getAll();
        personsLiveData = personsDaoRepository.getPersons();
    }

    public MutableLiveData<List<Persons>> getPersonsLiveData() {
        return personsLiveData;
    }

    public void getAll() {
        personsDaoRepository.getAllPersons();
    }

    public void search(String word) {
        personsDaoRepository.personSearch(word);
    }

    public void delete(int id) {
        personsDaoRepository.personDelete(id);
    }


}
