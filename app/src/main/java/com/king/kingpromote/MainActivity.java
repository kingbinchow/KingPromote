package com.king.kingpromote;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.king.kingpromote.activity.LoginActivity;
import com.king.kingpromote.activity.MultipleItemTypeDemoActivity;
import com.king.kingpromote.base.BaseActivity;


import java.util.Arrays;

import butterknife.Bind;

/**
 * Created by king.zhou on 2016/3/30.
 */
public class MainActivity extends ListActivity {

    @Bind(R.id.lv_multiple_demo)
    ListView multipleLv;


    String listArray[] = {
            "Simple Adapter Text",
            "MultiItemStyleText",
            "LoginActivity DataBinding"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getListView().setAdapter(
                new ArrayAdapter<String>(this,
                        android.R.layout.simple_list_item_1, Arrays.asList(listArray
                        )));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        Intent intent = null;
        switch (position)
        {
            case 0:
                intent = new Intent(this, MultipleItemTypeDemoActivity.class);
                break;
            case 1:
                intent = new Intent(this, MultipleItemTypeDemoActivity.class);
                break;
            case 2:
                intent = new Intent(this, LoginActivity.class);
                break;
        }
        if (intent != null)
            startActivity(intent);
    }
}
