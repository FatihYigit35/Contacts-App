package com.fatihyigit.contactsapp.data.entity;

import java.io.Serializable;

public class Persons implements Serializable {
    private int person_id;
    private String person_name;
    private String person_phone;

    public Persons() {
    }

    public Persons(int person_id, String person_name, String person_phone) {
        this.person_id = person_id;
        this.person_name = person_name;
        this.person_phone = person_phone;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public String getPerson_name() {
        return person_name;
    }

    public void setPerson_name(String person_name) {
        this.person_name = person_name;
    }

    public String getPerson_phone() {
        return person_phone;
    }

    public void setPerson_phone(String person_phone) {
        this.person_phone = person_phone;
    }
}
