package com.fatihyigit.contactsapp.di;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Room;

import com.fatihyigit.contactsapp.data.repository.PersonsDaoRepository;
import com.fatihyigit.contactsapp.room.PersonsDao;
import com.fatihyigit.contactsapp.room.PersonsDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class) //Allows the object to be accessed from anywhere
public class AppModule {
    @Provides
    @Singleton
    public PersonsDaoRepository providesPersonsDaoRepository(PersonsDao personsDao) {
        return new PersonsDaoRepository(personsDao);
    }

    @Provides
    @Singleton
    public PersonsDao providesPersonsDao(@NonNull PersonsDatabase db) {
        return db.getPersonsDao();
    }

    @Provides
    @Singleton
    public PersonsDatabase providesPersonsDatabase(@ApplicationContext Context context) {
//        return Room.databaseBuilder(context,PersonsDatabase.class,"directory.sqlite")
//                .createFromAsset("directory.sqlite") //copy from file
//                .build();

        return Room.databaseBuilder(context,PersonsDatabase.class,"directory.sqlite").build();
    }
}
