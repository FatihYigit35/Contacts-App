package com.fatihyigit.contactsapp.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.fatihyigit.contactsapp.data.entity.Persons;

@Database(entities = {Persons.class},version = 1,exportSchema = false)
public abstract class PersonsDatabase extends RoomDatabase {
    public abstract PersonsDao getPersonsDao();
}
