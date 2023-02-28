package com.fatihyigit.contactsapp.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.fatihyigit.contactsapp.data.entity.Persons;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface PersonsDao {
    @Query("SELECT * FROM persons")
    Single<List<Persons>> getAllPersons();

    @Query("SELECT * FROM persons WHERE person_name like '%' || :word || '%'")
    Single<List<Persons>> personSearch(String word);

    @Delete
    Completable personDelete(Persons person);

    @Insert
    Completable personSave(Persons person);

    @Update
    Completable personUpdate(Persons person);

}
