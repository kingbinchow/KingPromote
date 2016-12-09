package com.king.kingpromote.base;

import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.king.kingpromote.R;
import com.king.kingpromote.utils.UIUtils;

import butterknife.ButterKnife;

/**
 * Created by king.zhou on 2016/3/30.
 */
public abstract class BaseActivity extends AppCompatActivity{
    public final static int REQUEST_CODE_ASK_PERMISSIONS = 0x1212;
    Toolbar toolbar;
    private TextView centerTitleTv;
    private TextView leftTitleTv;
    private TextView rightTitleTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addToolbar();

    }


    private void addToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            centerTitleTv = (TextView) toolbar.findViewById(R.id.toolbar_center_title);
            leftTitleTv = (TextView) toolbar.findViewById(R.id.toolbar_left_title);
            rightTitleTv = (TextView) toolbar.findViewById(R.id.toolbar_right_title);

            if (centerTitleTv != null && getSupportActionBar() != null) {
                getSupportActionBar().setDisplayShowTitleEnabled(false);
            }
        }
    }
    /**
     * initial view,bindListener,etc.
     */
    protected abstract void initView();
    /**
     * initial Data,send request,etc.
     */
    protected abstract void initData();

    @Override
    protected void onTitleChanged(CharSequence title, int color) {
        super.onTitleChanged(title, color);
        if (toolbar != null && centerTitleTv != null) {
            centerTitleTv.setText(title);
        }
    }
    /**
     * <p>Android 6.0新特性，敏感权限需要申请，若直接调用未被允许的权限,App将会在Android6.0的机器上crash
     */
    private void getPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] permissions = new String[2];
            permissions[0] = "android.permission.READ_PHONE_STATE";
            permissions[1] = "android.permission.WRITE_EXTERNAL_STORAGE";
            for (String permission : permissions) {
                int hasPermission = ContextCompat.checkSelfPermission(this, permission);
                if (hasPermission != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(permissions, REQUEST_CODE_ASK_PERMISSIONS);
                    return;
                }
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_ASK_PERMISSIONS:
                for (int grantResult : grantResults) {
                    if (grantResult != PackageManager.PERMISSION_GRANTED) {
                        new AlertDialog.Builder(this)
                                .setTitle("注意")
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .setMessage("你已拒绝某些权限,这将有可能导致程序运行不正常,请在设置中重新开启")
                                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                }).create().show();
                        break;
                    }
                }
                break;
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * 设置标题栏左侧图标和点击事件
     *
     * @param iconResId
     * @param onClickListener
     */
    public void setLeftIcon(int iconResId, @Nullable View.OnClickListener onClickListener) {
        if (leftTitleTv != null) {
            leftTitleTv.setVisibility(View.VISIBLE);
            Drawable icon = getResources().getDrawable(iconResId);
            icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            leftTitleTv.setCompoundDrawables(icon, null, null, null);
            leftTitleTv.setCompoundDrawablePadding(UIUtils.dip2px(this, 4));
            leftTitleTv.setOnClickListener(onClickListener);
        }
    }

    /**
     * 设置标题栏右侧图标和点击事件
     *
     * @param iconResId
     * @param onClickListener
     */
    public void setRightIcon(int iconResId, @Nullable View.OnClickListener onClickListener) {
        if (rightTitleTv != null) {
            rightTitleTv.setVisibility(View.VISIBLE);
            Drawable icon = getResources().getDrawable(iconResId);
            icon.setBounds(0, 0, icon.getIntrinsicWidth(), icon.getIntrinsicHeight());
            rightTitleTv.setCompoundDrawables(icon, null, null, null);
            rightTitleTv.setCompoundDrawablePadding(UIUtils.dip2px(this, 4));
            rightTitleTv.setOnClickListener(onClickListener);
        }
    }

    /**
     * 设置标题栏右侧文本和点击事件
     *
     * @param text
     * @param onClickListener
     */
    public void setRightText(String text,int color, @Nullable View.OnClickListener onClickListener) {
        if (rightTitleTv != null) {
            rightTitleTv.setVisibility(View.VISIBLE);
            rightTitleTv.setText(text);
            rightTitleTv.setTextColor(color);
            rightTitleTv.setOnClickListener(onClickListener);
        }
    }

}
