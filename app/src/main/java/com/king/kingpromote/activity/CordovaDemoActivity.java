package com.king.kingpromote.activity;

import android.os.Bundle;

import org.apache.cordova.CordovaActivity;

/**
 * Created by king.zhou on 2016/5/31.
 */
public class CordovaDemoActivity extends CordovaActivity
{
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        // Set by <content src="index.html" /> in config.xml
        loadUrl("http://www.baidu.com");
    }
}
