package com.king.kingpromote;

import android.os.Bundle;

import com.king.kingpromote.base.BaseActivity;

/**
 * Created by king.zhou on 2016/3/30.
 */
public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initView() {
        setTitle("MainActivityTitle");
    }

    @Override
    protected void initData() {

    }
}
