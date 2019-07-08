package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Car {

    @PrimaryKey
    public long id;

    public String model;

    public int year;

}