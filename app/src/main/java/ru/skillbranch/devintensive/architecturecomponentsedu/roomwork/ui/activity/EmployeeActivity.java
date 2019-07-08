package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.skillbranch.devintensive.architecturecomponentsedu.R;
import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.database.AppDatabase;

public class EmployeeActivity extends AppCompatActivity {

    private AppDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee);

        //i dont need this for my example i was just playing around
        //database = new AppDatabase(this);
    }
}
