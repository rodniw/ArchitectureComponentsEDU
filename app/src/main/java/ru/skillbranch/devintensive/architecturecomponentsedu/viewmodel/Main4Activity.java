package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.skillbranch.devintensive.architecturecomponentsedu.R;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        //getting our viewmodel
        MyViewModel model = ViewModelProviders.of(this).get(MyViewModel.class);
        LiveData<String> data = model.getData();
        data.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                // ...
            }
        });
        //У метода get, который возвращает нам модель из провайдера, есть еще такой вариант вызова:
        //T get (String key, Class<T> modelClass)
    }
}

/* EXPLANATION
- Activity вызывает метод модели getData
- модель создает MutableLiveData и стартует асинхронный процесс получения данных от репозитория
- Activity подписывается на полученный от модели LiveData и ждет данные
- происходит поворот экрана
- на модели этот поворот никак не сказывается, она спокойно сидит в провайдере и ждет ответ от репозитория
- Activity пересоздается, получает ту же самую модель от провайдера, получает тот же самый LiveData от модели и подписывается на него и ждет данные
- репозиторий возвращает данные, модель передает их в MutableLiveData
- Activity получает данные данные от LiveData
 */
