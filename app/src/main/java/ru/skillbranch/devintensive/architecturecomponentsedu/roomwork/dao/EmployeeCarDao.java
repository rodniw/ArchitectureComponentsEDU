package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Transaction;

import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.entity.Car;
import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.entity.Employee;

//EmployeeCarDao - отдельный Dao объект для работы с комбинацией Car и Employee.
//В нем описываем методы для вставки объектов по отдельности,
//а затем оба этих метода вызываем в одном методе с аннотацией Transaction.
//В итоге вставятся либо оба объекта, либо, в случае возникновения ошибки, ни один из них.
@Dao
public abstract class EmployeeCarDao {

    @Insert
    public abstract void insertEmployee(Employee employee);

    @Insert
    public abstract void insertCar(Car car);


    @Transaction
    public void insertCarAndEmployee(Car car, Employee employee) {
        insertCar(car);
        insertEmployee(employee);
    }

}