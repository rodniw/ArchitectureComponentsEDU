package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

public class MultiDataController {

    private static MultiDataController multiDataControllerInstance;



    private MultiDataController() {
    }

    public static MultiDataController getInstance() {
        if(multiDataControllerInstance == null) {
            multiDataControllerInstance = new MultiDataController();
        }

        return multiDataControllerInstance;
    }

    /*LiveData<String> getData() {
        return mediatorLiveData;
    }*/
}
