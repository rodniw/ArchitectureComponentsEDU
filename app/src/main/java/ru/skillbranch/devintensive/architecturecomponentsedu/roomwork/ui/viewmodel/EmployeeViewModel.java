package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.ui.viewmodel;

import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.repository.EmployeeRepository;

public class EmployeeViewModel {

    EmployeeRepository repository;

    public EmployeeViewModel(EmployeeRepository repository) {
        this.repository = repository;
    }
}
