package ru.skillbranch.devintensive.architecturecomponentsedu.lifecyclerandlivedata;

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
