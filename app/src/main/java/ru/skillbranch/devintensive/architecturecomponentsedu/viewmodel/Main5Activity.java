package ru.skillbranch.devintensive.architecturecomponentsedu.viewmodel;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.skillbranch.devintensive.architecturecomponentsedu.R;

public class Main5Activity extends AppCompatActivity {

    long id = 4363;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        MyViewModel2 model = ViewModelProviders.of(this, new ModelFactory(id))
                .get(MyViewModel2.class);
    }
}
