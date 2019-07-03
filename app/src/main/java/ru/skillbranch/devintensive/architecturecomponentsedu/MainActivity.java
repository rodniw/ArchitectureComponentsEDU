package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyServer myServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myServer = new MyServer();
        getLifecycle().addObserver(myServer);
    }

    //А методы onStart и onStop в Activity нам больше не нужны, их можно удалить.

    /*Теперь, при переходе Activity из состояния CREATED в состояние STARTED,
    его объект Lifecycle вызовет метод myServer.connect.
    А при переходе из STARTED в CREATED - Lifecycle вызовет myServer disconnect.*/
}
