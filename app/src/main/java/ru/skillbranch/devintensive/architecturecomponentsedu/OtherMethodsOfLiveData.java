package ru.skillbranch.devintensive.architecturecomponentsedu;

public class OtherMethodsOfLiveData {
    /*
    hasActiveObservers() - проверка наличия активных подписчиков

    hasObservers() - проверка наличия любых подписчиков

    observeForever (Observer<T> observer) - позволяет подписаться без учета Lifecycle.
    Т.е. этот подписчик будет всегда считаться активным.

    removeObserver (Observer<T> observer) - позволяет отписать подписчика

    removeObservers (LifecycleOwner owner) - позволяет отписать всех подписчиков,
    которые завязаны на Lifecycle от указанного LifecycleOwner.
     */
}
