package com.junerver.testo2oapp.app;

import android.app.Application;
import android.content.Context;

import java.util.List;

/**
 * Created by junerver on 2015/11/24.
 */
public class AppContext extends Application {
    private static Context context;
    private int screenWidth;
    private int screenHeight;

    @Override
    public void onCreate() {
        context=getApplicationContext();
    }
    public static Context getContext(){
        return context;
    }
    public int getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(int screenWidth) {
        this.screenWidth = screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(int screenHeight) {
        this.screenHeight = screenHeight;
    }

}
