package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.arch.core.util.Function;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.Transformations;
import android.support.annotation.Nullable;
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

        LiveData<String> liveData = DataController.getInstance().getData();

        //LifecycleOwner - это интерфейс с методом getLifecycle.
        //Activity и фрагменты в Support Library, начиная с версии 26.1.0 реализуют этот интерфейс,
        //поэтому мы передаем this.
        //Теперь, когда DataController поместит какой-либо String объект в LiveData,
        //мы сразу получим этот объект в Activity, если Activity находится в состоянии STARTED или RESUMED.
        liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String value) {
                //textView.setText(value);
            }
        });

        //поменять типа данных в LiveData с помощью Transformations.map.
        //Рассмотрим пример, в котором LiveData<String> будем превращать в LiveData<Integer>:
        //we also have switchMap to, for example, get User(obj) by his id(long)
        LiveData<Integer> liveDataInt = Transformations.map(liveData, new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return Integer.parseInt(input);
            }
        });
    }

    //LIFECYCLE
    //А методы onStart и onStop в Activity нам больше не нужны, их можно удалить.

    /*Теперь, при переходе Activity из состояния CREATED в состояние STARTED,
    его объект Lifecycle вызовет метод myServer.connect.
    А при переходе из STARTED в CREATED - Lifecycle вызовет myServer disconnect.*/

    //LIVEDATA
    /*LiveData - хранилище данных, работающее по принципу паттерна Observer (наблюдатель).
    Это хранилище умеет делать две вещи:
    1) В него можно поместить какой-либо объект
    2) На него можно подписаться и получать объекты, которые в него помещают.
    Т.е. с одной стороны кто-то помещает объект в хранилище,
    а с другой стороны кто-то подписывается и получает этот объект.

           Нюансы поведения:

    Если Activity было не активно во время обновления данных в LiveData, то при возврате в активное состояние, его observer получит последнее актуальное значение данных.
    В момент подписки, observer получит последнее актуальное значение из LiveData.
    Если Activity будет закрыто, т.е. перейдет в статус DESTROYED, то LiveData автоматически отпишет от себя его observer.
    Если Activity в состоянии DESTROYED попробует подписаться, то подписка не будет выполнена.
    Если Activity уже подписывало свой observer, и попробует сделать это еще раз, то просто ничего не произойдет.
    Вы всегда можете получить последнее значение LiveData с помощью его метода getValue.
    Как видите, подписывать Activity на LiveData - это удобно. Поворот экрана и полное закрытие Activity - все это корректно и удобно обрабатывается автоматически без каких-либо усилий с нашей стороны.*/
}
