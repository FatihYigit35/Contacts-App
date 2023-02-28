package com.fatihyigit.contactsapp.di;

import com.fatihyigit.contactsapp.data.repository.PersonsDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class) //Allows the object to be accessed from anywhere
public class AppModule {
    @Provides
    @Singleton
    public PersonsDao providesPersonsDao() {
        return new PersonsDao();
    }
}
