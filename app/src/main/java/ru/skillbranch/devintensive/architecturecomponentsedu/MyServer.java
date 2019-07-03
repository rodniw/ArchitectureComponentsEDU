package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.OnLifecycleEvent;

import static android.arch.lifecycle.Lifecycle.Event.ON_ANY;

public class MyServer implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void connect() {
        // ...
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void disconnect() {
        // ...
    }

    //В этом случае все события будут вызывать этот метод.
    //Используйте входящий параметр event, чтобы определить, какое именно событие произошло
    @OnLifecycleEvent(ON_ANY)
    void onAny(LifecycleOwner source, Lifecycle.Event event) {
        // ...
    }

}
