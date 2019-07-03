package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.arch.lifecycle.Lifecycle;
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

        //Узнать текущее состояние Activity, то у его объекта Lifecycle есть метод getCurrentState:
        if (getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) {
            // ...
        }

        //Метод isAtLeast здесь проверяет, что состояние Activity не ниже, чем STARTED. Т.е. либо STARTED, либо RESUMED.
        //проверить, что текущее состояние Activity не ниже определенного состояния.
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            // ...
        }
    }

    //А методы onStart и onStop в Activity нам больше не нужны, их можно удалить.

    /*Теперь, при переходе Activity из состояния CREATED в состояние STARTED,
    его объект Lifecycle вызовет метод myServer.connect.
    А при переходе из STARTED в CREATED - Lifecycle вызовет myServer disconnect.*/
}
