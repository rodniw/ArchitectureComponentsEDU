package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.ClipData;

//SharedViewModel - модель с двумя методами: один позволяет поместить данные в LiveData,
//другой - позволяет получить этот LiveData. Соответственно,
//если два фрагмента будут иметь доступ к этой модели,
//то один сможет помещать данные в его LiveData, а другой - подпишется и будет получать эти данные.
//Таким образом два фрагмента будут обмениваться данными ничего не зная друг о друге.
public class SharedViewModel extends ViewModel {
    private final MutableLiveData<ClipData.Item> selected = new MutableLiveData<ClipData.Item>();

    public void select(ClipData.Item item) {
        selected.setValue(item);
    }

    public LiveData<ClipData.Item> getSelected() {
        return selected;
    }
}

/*
в качестве примера рассмотрим Activity,
которое отображает список каких-то данных и может выполнять поиск по ним.
Пользователь открывает Activity и выполняет поиск. Activity отображает результаты этого поиска.
Пользователь сворачивает приложение. Когда он его снова откроет,
он ожидает, что там все останется в этом же состоянии.

Но тут внезапно системе не хватает памяти и она убивает это свернутое приложение.
Когда пользователь снова запустит его, Activity ничего не будет знать о поиске,
и просто покажет все данные. В этом случае ViewModel нам никак не поможет,
потому что модель будет убита вместе с приложением. А вот onSavedInstanceState будет выполнен.
В нем мы сможем сохранить поисковый запрос,
и при последующем запуске получить его из объекта savedInstanceState и выполнить поиск.
В результате пользователь увидит тот же экран, который был, когда приложение было свернуто.
 */
