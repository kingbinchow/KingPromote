package com.king.kingpromote.utils;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * @author fyales
 */
public class UIUtils {
    public static int dipToPx(DisplayMetrics dm, int dip) {
        return (int) (dip * dm.density + 0.5f);
    }

    public static int dip2px(Context context, float dipValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static DisplayMetrics getDisplayMetrics(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm;
    }

    public static void setParamsByDensity(Context mContext, View viewGroup, int width, int high, int screenWidth) {
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int imageWidth = screenWidth;
        int imageHeight = high * imageWidth / width;
        layoutParams.height = imageHeight;
    }


    private static int replaceViewTag=0x2193194;
    public static void replaceDefaultView(View innerview,View replaceView){

        if(innerview!=null){
            ViewParent parent = innerview.getParent();
            if(parent  instanceof ViewGroup){
                ViewGroup parentView=(ViewGroup) parent;
                View view = parentView.findViewWithTag(replaceViewTag);
                innerview.setVisibility(View.GONE);
                if(view!=null){
                    view.setVisibility(View.VISIBLE);
                }else{
                    ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    replaceView.setTag(replaceViewTag);
                    parentView.addView(replaceView,params);
                }
            }

        }

    }


}
