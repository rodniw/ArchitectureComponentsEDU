package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.repository;

import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.database.AppDatabase;

public class EmployeeRepository {

    AppDatabase db;

    public EmployeeRepository(AppDatabase db) {
        this.db = db;
    }

}
