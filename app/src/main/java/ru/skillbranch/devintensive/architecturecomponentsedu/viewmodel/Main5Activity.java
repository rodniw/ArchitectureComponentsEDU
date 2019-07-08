package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.skillbranch.devintensive.architecturecomponentsedu.R;
//Цепочка ссылок:
//Repository -> LiveData -> Activity
public class Main5Activity extends AppCompatActivity {

    //i mocked it
    long id = 4363;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        MyViewModel2 model = ViewModelProviders.of(this, new ModelFactory(id))
                .get(MyViewModel2.class);
    }
}
/*
У LiveData есть одно большое преимущество - он учитывает состояние Activity.
Т.е. он не будет слать данные, если Activity свернуто. И он отпишет от себя Activity, которое закрывается.

А вот Flowable этого не умеет. Если в модели есть Flowable,
и Activity подпишется на него, то этот Flowable будет держать Activity,
пока оно само явно не отпишется (или пока Flowable не завершится).
 */