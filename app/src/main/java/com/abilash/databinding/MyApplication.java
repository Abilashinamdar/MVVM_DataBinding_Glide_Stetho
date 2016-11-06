package com.abilash.databinding;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Created by Abilash on 11/7/2016.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // create an InitializerBuilder
        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);

        // enable chrome dev tools
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));

        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));

        Stetho.Initializer initializer = initializerBuilder.build();

        Stetho.initialize(initializer);

    }
}
