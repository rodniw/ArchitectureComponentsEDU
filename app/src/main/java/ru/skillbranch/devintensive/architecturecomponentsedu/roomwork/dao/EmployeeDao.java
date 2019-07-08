package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.entity.Employee;

@Dao
public interface EmployeeDao {

    @Query("SELECT * FROM employees")
    List<Employee> getAll();

    @Query("SELECT * FROM employees WHERE id = :id")
    Employee getById(long id);

    //Аннотация Insert - это простой способ вставить объект в базу данных.
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Employee employee);

    @Update
    void update(Employee employee);

    @Delete
    void delete(Employee employee);

}

// ------ INSERT

/*
Вставка нескольких объектов.

------ Мы можем передавать в метод не один, а несколько объектов, используя varargs:

@Insert
void insertMany(Employee... employees);


------ Также, это может быть список:

@Insert
void insert(List<Employee> employees);


------ Или это вообще может быть любой Iterable:

@Insert
void insert(Iterable<Employee> employees);
При вызове этого метода вы можете использовать массив или коллекцию.
 */

//------  INSERT ID WITH LONG

/*
Получение id

------ При вставке метод Insert может возвращать id только что добавленной записи.
Для этого надо описать метод так, чтобы он возвращал long.

@Insert
long insert(Employee employee);
Если в Employee есть числовой первичный ключ, то именно его значение вы и получите.



------ В случае добавления нескольких записей, необходимо использовать long[]

@Insert
long[] insert(List<Employee> employees);


------ или List<Long>

@Insert
List<Long> insert(List<Employee> employees);
 */



// ------- UPDATE

/*
Мы можем получить количество обновленных записей. Для этого опишите метод так, чтобы он возвращал int.

@Update
int update(List<Employee> employee);
 */



// ------- DELETE

/*
@Delete
void delete(Employee employee);

В Delete методах мы также можем использовать коллекции и varargs, чтобы удалять несколько объектов сразу.

Delete ищет в бд запись по ключу.

Мы можем получить количество удаленных записей. Для этого необходимо описать метод так, чтобы он возвращал int.

@Delete
int delete(List<Employee> employee);
 */
