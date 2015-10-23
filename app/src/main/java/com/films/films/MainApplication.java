package com.films.films;

import android.app.Application;
import android.content.Context;

import com.squareup.otto.Bus;


/**
 * Created by mauriziofolcini on 02/10/2015.
 */

public class MainApplication extends Application {

    private static Context appContext;
    private static Bus bus;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static Bus getBus() {
        if (bus == null) {
            bus = new Bus();
        }
        return bus;
    }
}
