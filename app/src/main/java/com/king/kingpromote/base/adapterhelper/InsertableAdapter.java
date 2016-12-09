package com.king.kingpromote.base.adapterhelper;

import android.content.Context;

import com.nhaarman.listviewanimations.util.Insertable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by king.zhou on 2016/11/21.
 */
public abstract class InsertableAdapter<T> extends QuickAdapter<T> implements Insertable {

    public InsertableAdapter(Context context, ArrayList<T> data, MultiItemTypeSupport<T> multiItemSupport) {
        super(context, data, multiItemSupport);
    }

    public InsertableAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    public InsertableAdapter(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }

}
