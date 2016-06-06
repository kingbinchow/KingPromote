package com.king.kingpromote.bean;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.view.ContextThemeWrapper;

/**
 * Created by king.zhou on 2016/4/26.
 */
public class User {
    public final String id;
    public final String name;
    public final String password;
    public final String tel;

    public User(String id, String name, String password, String tel) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.tel = tel;
    }

}
