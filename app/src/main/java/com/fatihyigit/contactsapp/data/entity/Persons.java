package com.fatihyigit.contactsapp.data.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "persons")
public class Persons implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id")
    private int personId;
    @ColumnInfo(name = "person_name")
    @NonNull
    private String personName;
    @ColumnInfo(name = "person_phone")
    @NonNull
    private String personPhone;

    public Persons(int personId, @NonNull String personName, @NonNull String personPhone) {
        this.personId = personId;
        this.personName = personName;
        this.personPhone = personPhone;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    @NonNull
    public String getPersonName() {
        return personName;
    }

    public void setPersonName(@NonNull String personName) {
        this.personName = personName;
    }

    @NonNull
    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(@NonNull String personPhone) {
        this.personPhone = personPhone;
    }
}
