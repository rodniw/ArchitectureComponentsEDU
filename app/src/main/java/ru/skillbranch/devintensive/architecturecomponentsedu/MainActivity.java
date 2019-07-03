package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private MyServer myServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myServer = new MyServer();
    }

    @Override
    protected void onStart() {
        super.onStart();
        myServer.connect();
    }


    @Override
    protected void onStop() {
        super.onStop();
        myServer.disconnect();
    }
}
