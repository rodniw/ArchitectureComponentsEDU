package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.repository;

import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.MyApp;
import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.dao.EmployeeDao;
import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.database.AppDatabase;

public class EmployeeRepository {

    AppDatabase db = MyApp.getInstance().getDatabase();

    EmployeeDao employeeDao = db.employeeDao();

    /*
    -------Добавление нового сотрудника в базу будет выглядеть так:

    Employee employee = new Employee();
    employee.id = 1;
    employee.name = "John Smith";
    employee.salary = 10000;
    employeeDao.insert(employee);


    -------Метод getAll вернет нам всех сотрудников в List<Employee>:

    List<Employee> employees = employeeDao.getAll();


    -------Получение сотрудника по id:

    Employee employee = employeeDao.getById(1);



    -------Обновление данных по сотруднику:

    employee.salary = 20000;
    employeeDao.update(employee);



    -------Удаление сотрудника:

    employeeDao.delete(employee);
     */

}
