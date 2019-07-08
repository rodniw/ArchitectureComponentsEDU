package ru.skillbranch.devintensive.architecturecomponentsedu.roomwork;

import android.app.Application;
import android.arch.persistence.room.Room;

import ru.skillbranch.devintensive.architecturecomponentsedu.roomwork.database.AppDatabase;

public class MyApp extends Application {

    public static MyApp instance;

    private AppDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "database")
                .build();
    }

    public static MyApp getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }
}
