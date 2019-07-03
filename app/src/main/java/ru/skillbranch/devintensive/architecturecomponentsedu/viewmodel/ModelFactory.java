package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

public class ModelFactory extends ViewModelProvider.NewInstanceFactory {

    private final long id;

    public ModelFactory(long id) {
        super();
        this.id = id;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == MyViewModel2.class) {
            return (T) new MyViewModel2(id);
        }
        return null;
    }
}
