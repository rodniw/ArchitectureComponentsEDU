package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel.fragments;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel.SharedViewModel;

public class DetailFragment extends Fragment {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedViewModel model = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        //model.getSelected().observe(this, { item ->
        //        // Update the UI.
        //});
    }
}
