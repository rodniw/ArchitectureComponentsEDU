package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.dao.CarDao;
import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.dao.EmployeeDao;
import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.entity.Car;
import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.entity.Employee;

@Database(entities = {Employee.class, Car.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract EmployeeDao employeeDao();
    public abstract CarDao carDao();
}
