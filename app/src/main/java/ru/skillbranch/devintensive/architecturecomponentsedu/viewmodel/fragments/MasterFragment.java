package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel.SharedViewModel;

public class MasterFragment extends Fragment {
    private SharedViewModel model;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        //itemSelector.setOnClickListener(item -> {
        //    model.select(item);
        //});
    }
}
