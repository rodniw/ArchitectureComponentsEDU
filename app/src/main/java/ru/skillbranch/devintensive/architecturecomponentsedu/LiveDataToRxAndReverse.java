package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.LiveDataReactiveStreams;

import io.reactivex.Flowable;

public class LiveDataToRxAndReverse {

    //Чтобы получить LiveData из Flowable или Observable, используем метод fromPublisher:

    //flowable = ...
    //implementation is not important for me here
    Flowable<String> flowable;
    LiveData<String> liveData = LiveDataReactiveStreams.fromPublisher(flowable);
    //LiveData будет подписан на Flowable, пока у него (у LiveData) есть подписчики.
    //LiveData не сможет обработать или получить onError от Flowable. Если в Flowable возникнет ошибка, то будет крэш.
    //Неважно в каком потоке работает Flowable, результат в LiveData всегда придет в UI потоке.

    //Чтобы получить Flowable или Observable из LiveData нужно выполнить два преобразования.
    //Сначала используем метод toPublisher, чтобы получить Publisher.
    //Затем полученный Publisher передаем в метод Flowable.fromPublisher:

    //liveData = ...
    //implementation is not important for me here
    //LiveData<String> liveData;
    //Flowable<String> flowable = Flowable.fromPublisher(
    //        LiveDataReactiveStreams.toPublisher(this, liveData));
    //i cannot implement this method here because i do not have any application context
}
