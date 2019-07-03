package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;

//ViewModel - класс, позволяющий Activity и фрагментам сохранять необходимые им объекты живыми при повороте экрана.
//Не храните в ViewModel ссылки на Activity, фрагменты, View и пр. Это может привести к утечкам памяти.
//Модель жива, пока Activity не закроется окончательно.
//в модели понадобился объект Context, то вы можете наследовать не ViewModel, а AndroidViewModel
public class MyViewModel extends AndroidViewModel {

    MutableLiveData<String> data;

    public MyViewModel(@NonNull Application application) {
        super(application);
    }

    //При создании этой модели, провайдер передаст ей в конструктор класс Application,
    //который является Context. Вы сможете до него добраться методом getApplication.
    public void doSomething() {
        Context context = getApplication();
        // ....
    }

    public LiveData<String> getData() {
        if (data == null) {
            data = new MutableLiveData<>();
            //loadData();
        }
        return data;
    }

    /*
    ViewModel asks data from the repository:

    LiveData<String> data;

    public LiveData<String> getData() {
        if (data == null) {
            data = dataRepository.loadData();
        }
        return data;
    }
     */

    //В методе loadData происходит асинхронное получение данных из какого-нибудь репозитория.
    //Как только данные будут получены (в методе onLoad), мы передаем их в MutableLiveData.
    private void loadData() {
        /*dataRepository.loadData(new Callback<String>() {
            @Override
            public void onLoad(String s) {
                data.postValue(s);
            }
        });*/
    }

    //Когда Activity окончательно закрывается, провайдер удаляет ViewModel, предварительно вызвав его метод onCleared
    @Override
    protected void onCleared() {
        // clean up resources

    }
}
