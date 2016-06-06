package com.king.kingpromote.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.king.kingpromote.R;
import com.king.kingpromote.base.BaseActivity;
import com.king.kingpromote.bean.User;
import com.king.kingpromote.databinding.LoginLayoutBinding;


/**
 * Created by king.zhou on 2016/4/26.
 */
public class LoginActivity extends BaseActivity {

    private LoginLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,
                R.layout.login_layout);
        User user = new User("001","Jack","abc123","13200018898");
        binding.setUser(user);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
