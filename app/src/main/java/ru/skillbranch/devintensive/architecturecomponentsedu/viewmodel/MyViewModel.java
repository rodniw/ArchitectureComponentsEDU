package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

//ViewModel - класс, позволяющий Activity и фрагментам сохранять необходимые им объекты живыми при повороте экрана.
//Не храните в ViewModel ссылки на Activity, фрагменты, View и пр. Это может привести к утечкам памяти.
//Модель жива, пока Activity не закроется окончательно.
public class MyViewModel extends ViewModel {

    MutableLiveData<String> data;

    public LiveData<String> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
            //loadData();
        }
        return data;
    }

    private void loadData() {
        /*dataRepository.loadData(new Callback<String>() {
            @Override
            public void onLoad(String s) {
                data.postValue(s);
            }
        });*/
    }
}
