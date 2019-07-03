package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.arch.lifecycle.LiveData;

public class DataController {

    private static DataController dataControllerInstance;

    LiveData<String> liveData = null;

    private DataController() {

    }

    public static DataController getInstance() {
        if(dataControllerInstance == null) {
            dataControllerInstance = new DataController();
        }

        return dataControllerInstance;
    }

    public LiveData<String> getData() {
        return liveData;
    }
}
