package ru.skillbranch.devintensive.architecturecomponentsedu;

import android.arch.lifecycle.LiveData;
import android.location.Location;

public class LocationLiveData extends LiveData<Location> {

    private static LocationLiveData locationLiveDataInstance;

    private LocationLiveData() {

    }

    public static LocationLiveData getInstance() {
        if(locationLiveDataInstance == null) {
            locationLiveDataInstance = new LocationLiveData();
        }

        return locationLiveDataInstance;
    }

    LocationService.LocationListener locationListener = new LocationService.LocationListener() {
        @Override
        public void onLocationChanged(Location location) {
            setValue(location);
        }
    };

    @Override
    protected void onActive() {
        LocationService.addListener(locationListener);
    }

    @Override
    protected void onInactive() {
        LocationService.removeListener(locationListener);
    }

}