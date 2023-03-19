package com.fatihyigit.contactsapp.data.repository;

import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.navigation.Navigation;

import com.fatihyigit.contactsapp.R;
import com.fatihyigit.contactsapp.data.entity.Persons;
import com.fatihyigit.contactsapp.room.PersonsDao;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.CompletableObserver;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PersonsDaoRepository {
    private MutableLiveData<List<Persons>> personsLiveData;
    private PersonsDao personsDao;

    public PersonsDaoRepository(PersonsDao personsDao) {
        this.personsDao = personsDao;
        personsLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<List<Persons>> getPersons() {
        return personsLiveData;
    }

    public void getAllPersons() {
        personsDao.getAllPersons().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Persons>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Persons> persons) {
                        personsLiveData.setValue(persons);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void personSave(String name, String phone, View v) {
        Persons person = new Persons(0,name,phone);
        personsDao.personSave(person).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {
                        Navigation.findNavController(v).navigate(R.id.action_personSaveFragment_to_mainFragment);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void personUpdate(int id, String name, String phone, View v) {
        Persons person = new Persons(id,name,phone);
        personsDao.personUpdate(person).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {
                        Navigation.findNavController(v).navigate(R.id.action_personDetailFragment_to_mainFragment);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void personSearch(String word) {
        personsDao.personSearch(word).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Persons>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onSuccess(List<Persons> persons) {
                        personsLiveData.setValue(persons);
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }

    public void personDelete(int id) {
        Persons person = new Persons(id,"","");
        personsDao.personDelete(person).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new CompletableObserver() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onComplete() {
                        getAllPersons();
                    }

                    @Override
                    public void onError(Throwable e) {}
                });
    }
}
