package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.location.Location;

public class LocationService {

    public static void addListener(LocationListener listener) {
        //
    }

    public static void removeListener(LocationListener listener) {
        //
    }

    static class LocationListener {
        public void onLocationChanged(Location location) {
            //setValue(location);
        }
    }
}
