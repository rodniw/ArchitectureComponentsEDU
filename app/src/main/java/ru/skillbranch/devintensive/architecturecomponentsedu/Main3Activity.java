package ru.skillbranch.devintensive.architecturecomponentsedu;


import android.arch.lifecycle.MediatorLiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    MutableLiveData<String> liveData1 = new MutableLiveData<>();
    MutableLiveData<String> liveData2 = new MutableLiveData<>();

    MediatorLiveData<String> mediatorLiveData = new MediatorLiveData<>();

    /*mediatorLiveData.addSource(liveData1, new Observer<String>() {
        @Override
        public void onChanged(@Nullable String s) {
            mediatorLiveData.setValue(s);
        }
    });


    mediatorLiveData.addSource(liveData2, new Observer<String>() {
        @Override
        public void onChanged(@Nullable String s) {
            mediatorLiveData.setValue(s);

        }
    });

    mediatorLiveData.observe(this, new Observer<String>() {
        @Override
        public void onChanged(@Nullable String s) {
            log("onChanged " + s);
        }
    });
    */
}
