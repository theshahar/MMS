package com.example.shaharraz.mms.application;

import android.app.Application;

import com.example.shaharraz.mms.dependecies.ApiComponent;
import com.example.shaharraz.mms.dependecies.DaggerApiComponent;
import com.example.shaharraz.mms.dependecies.DaggerNetworkComponent;
import com.example.shaharraz.mms.dependecies.NetworkComponent;
import com.example.shaharraz.mms.dependecies.NetworkModule;
import com.example.shaharraz.mms.models.Constant;

/**
 * Created by ShaharRaz on 20/01/2017.
 */
public class MovieApplication extends Application {

    private ApiComponent mApiComponent;

    public ApiComponent getApiComponent() {
        return mApiComponent;
    }

    @Override
    public void onCreate() {
        resolveDependency();
        super.onCreate();
    }

    private void resolveDependency() {
        mApiComponent = DaggerApiComponent.builder()
                .networkComponent(getNetworkComponent())
                .build();

    }

    public NetworkComponent getNetworkComponent() {
        return DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Constant.BASE_URL))
                .build();


    }
}
