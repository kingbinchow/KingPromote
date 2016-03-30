package com.king.kingpromote;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;

/**
 * Created by king.zhou on 2016/3/30.
 */
public class MyApplication extends Application{

    private static MyApplication myApplication;

    public static MyApplication getInstance(){
        return myApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;
        init();
    }

    private void init() {


    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public void exitApp() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //延迟半秒杀进程
                System.exit(0);
                System.gc();

                ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
                am.killBackgroundProcesses(getPackageName());
            }
        }, 500);
    }
}
