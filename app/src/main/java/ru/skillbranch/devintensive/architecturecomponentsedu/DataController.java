package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

public class DataController {

    private static DataController dataControllerInstance;

    private MutableLiveData<String> liveData = new MutableLiveData<>();

    private DataController() {

    }

    public static DataController getInstance() {
        if(dataControllerInstance == null) {
            dataControllerInstance = new DataController();
        }

        return dataControllerInstance;
    }

    //Наружу мы передаем LiveData, который позволит внешним объектам только получать данные.
    //Но внутри DataController мы используем объект MutableLiveData, который позволяет помещать в него данные.
    //Чтобы поместить значение в MutableLiveData, используется метод setValue:
    //liveData.setValue("new value");

    LiveData<String> getData() {
        return liveData;
    }
}
