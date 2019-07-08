package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.entity.Car;

@Dao
public interface CarDao {

    @Query("SELECT * FROM car")
    List<Car> getAll();

    @Insert
    void insert(Car car);

    @Delete
    void delete(Car car);

}
