package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel;

import android.arch.lifecycle.ViewModelProviders;
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
        //У метода get, который возвращает нам модель из провайдера, есть еще такой вариант вызова:
        //T get (String key, Class<T> modelClass)
    }
}
