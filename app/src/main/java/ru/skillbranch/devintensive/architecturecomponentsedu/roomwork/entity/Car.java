package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(
        foreignKeys
        = @ForeignKey(entity = Employee.class, parentColumns = "id", childColumns = "employee_id", onDelete = CASCADE),
        indices = {@Index(value = {"first_name", "last_name"}, unique = true)}
)
public class Car {

    @PrimaryKey(autoGenerate = true)
    public long id;

    public String model;

    public int year;

    @ColumnInfo(name = "employee_id")
    public long employeeId;

}

/*
Еще один параметр аннотации ForeignKey - это deferred, имеющий по умолчанию значение false.
Если задать этому параметру значение true, то внешний ключ станет отложенным.
Это может быть полезно при вставке данных в разные таблицы в рамках одной транзакции.
Вы сможете внести все необходимые изменения,
и проверка на корректность внешних ключей будет выполнена в самом конце, при выполнении commit.
 */