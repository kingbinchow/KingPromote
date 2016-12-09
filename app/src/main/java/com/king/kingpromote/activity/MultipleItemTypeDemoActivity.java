package com.king.kingpromote.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.OvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.king.kingpromote.R;
import com.king.kingpromote.base.BaseActivity;
import com.king.kingpromote.base.adapterhelper.BaseAdapterHelper;
import com.king.kingpromote.base.adapterhelper.InsertableAdapter;
import com.king.kingpromote.base.adapterhelper.MultiItemTypeSupport;
import com.king.kingpromote.base.adapterhelper.QuickAdapter;
import com.king.kingpromote.bean.MutilpleItemBean;
import com.king.kingpromote.component.HeartLoadingPathView;
import com.king.kingpromote.component.RotateClockView;
import com.king.kingpromote.utils.UIUtils;
import com.nhaarman.listviewanimations.itemmanipulation.DynamicListView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by king.zhou on 2016/3/30.
 */
public class MultipleItemTypeDemoActivity extends BaseActivity {

    @Bind(R.id.lv_multiple_demo)
    DynamicListView multipleLv;

    @Bind(R.id.btn_click_to_animation)
    Button clickToAnimation;
    @Bind(R.id.btn_click_to_add)
    Button clickToAdd;

    List<View> itemsList = new ArrayList<>();

    private ArrayList<MutilpleItemBean> mListViewDatas = new ArrayList<MutilpleItemBean>();

    private QuickAdapter<MutilpleItemBean> mAdapter;

//    final int MOVE_DISTANCE = 200;

    boolean lineInRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_type_demo);
        ButterKnife.bind(this);

        setTitle("afaddf");
        initView();
        initData();
    }

    @OnClick(R.id.btn_click_to_add)
    void add(){
        MutilpleItemBean bean = null;
        bean = new MutilpleItemBean("sssss", MutilpleItemBean.Item_Type_3);
        multipleLv.insert(0, bean);
//        UIUtils.expand(multipleLv.getChildAt(1));
    }

    @OnClick(R.id.btn_click_to_animation)
    void setClickToAnimation()
    {
//        for (int i=0;i<multipleLv.getChildCount();i++){
//            LinearLayout layout = (LinearLayout)multipleLv.getChildAt(i);
//            TextView itemText2 = (TextView)layout.findViewById(R.id.tv_multiple_item2_type_3);
//            if (itemText2!=null&&!itemsList.contains(itemText2)){
//                itemsList.add(itemText2);
//            }
//
//        }
//        Log.i("TB","item view list size"+itemsList.size());
//        if(!lineInRight){
//
//            for (View item:itemsList){
//                slideview(item,0, UIUtils.dip2px(this,100));
//                lineInRight = true;
//            }
//        }else{
//            for (View item:itemsList){
//                slideview(item,0,-UIUtils.dip2px(this,100));
//                lineInRight = false;
//            }
//        }

//        if(!lineInRight){
//
//                slideview(multipleLv,0, UIUtils.dip2px(this,50));
//                lineInRight = true;
//            mAdapter.notifyDataSetChanged();
////            for (View item:itemsList){
////               item.setVisibility(View.INVISIBLE);
////            }
//        }else{
//                slideview(multipleLv,0,-UIUtils.dip2px(this,50));
//                lineInRight = false;
//            mAdapter.notifyDataSetChanged();
////            for (View item:itemsList){
////                item.setVisibility(View.VISIBLE);
////            }
//        }
//        UIUtils.collapse(multipleLv.getChildAt(1));

        }

    public void slideview(final View view,final float p1, final float p2) {
        TranslateAnimation animation = new TranslateAnimation(p1, p2, 0, 0);
        animation.setInterpolator(new OvershootInterpolator());
        animation.setDuration(300);
        animation.setStartOffset(50);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                int left = view.getLeft()+(int)(p2-p1);
                int top = view.getTop();
                int width = view.getWidth();
                int height = view.getHeight();
                view.clearAnimation();
                view.layout(left, top, left+width, top+height);
            }
        });
        view.startAnimation(animation);
    }
    @Override
    protected void initView() {
        setTitle("MultipleItemTypeDemoActivity");
    }

    @Override
    protected void initData() {

        MultiItemTypeSupport<MutilpleItemBean> multiItemTypeSupport = new MultiItemTypeSupport<MutilpleItemBean>() {
            @Override
            public int getLayoutId(int position, MutilpleItemBean bean) {
                switch (bean.type) {

                    case MutilpleItemBean.Item_Type_1:
                            return R.layout.item_multiple_item_type_1;
                    case MutilpleItemBean.Item_Type_2:
                            return R.layout.item_multiple_item_type_2;
                    case MutilpleItemBean.Item_Type_3:

                        return R.layout.item_multiple_item_type_3;

                    default:
                            return R.layout.item_multiple_item_type_1;

                }


            }

            @Override
            public int getViewTypeCount() {
                return MutilpleItemBean.Type_Num;
            }

            @Override
            public int getItemViewType(int postion, MutilpleItemBean bean) {
                return bean.type;
            }
        };
        initListViewData();
//        try {
//           Class c =  Class.forName("");
//            Field[]f =c.getDeclaredFields();
//            Object c1 = c.newInstance();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        mAdapter = new InsertableAdapter<MutilpleItemBean>(MultipleItemTypeDemoActivity.this, mListViewDatas,
                multiItemTypeSupport) {
            @Override
            public void add(int index, @NonNull Object item) {
                mListViewDatas.add(index,(MutilpleItemBean)item);
            }

            @Override
            protected void convert(BaseAdapterHelper helper, MutilpleItemBean bean, int position) {

                if (!lineInRight) {

                    switch (helper.layoutId) {
                        case R.layout.item_multiple_item_type_1:
//                        helper.getView(R.id.tv_multiple_item_type_1);
                            helper.setText(R.id.tv_multiple_item_type_1, bean.content);
                            helper.setText(R.id.tv_multiple_item2_type_1, "10000");
                            helper.getView(R.id.iv_icon).setVisibility(View.VISIBLE);
                            break;
                        case R.layout.item_multiple_item_type_2:
                            helper.setText(R.id.tv_multiple_item_type_2, bean.content);
                            break;
                        case R.layout.item_multiple_item_type_3:
                            helper.setText(R.id.tv_multiple_item_type_3, bean.content);
                            helper.setText(R.id.tv_multiple_item2_type_3, "10000");

                            break;

                    }
                } else {
                    switch (helper.layoutId) {
                        case R.layout.item_multiple_item_type_1:
//                        helper.getView(R.id.tv_multiple_item_type_1);
                            helper.setText(R.id.tv_multiple_item_type_1, bean.content);
                            helper.setText(R.id.tv_multiple_item2_type_1, "10000");
                            helper.getView(R.id.iv_icon).setVisibility(View.GONE);
                            break;
                        case R.layout.item_multiple_item_type_2:
                            helper.setText(R.id.tv_multiple_item_type_2, bean.content);
                            break;
                        case R.layout.item_multiple_item_type_3:
                            helper.setText(R.id.tv_multiple_item_type_3, bean.content);
                            helper.setText(R.id.tv_multiple_item2_type_3, "10000");

                            break;


                    }
                }
            }

        };
//		mAdapter.showIndeterminateProgress(true);
        // 设置适配器
        multipleLv.setAdapter(mAdapter);

//        RotateClockView view = new RotateClockView(this);
//        ((ViewGroup)multipleLv.getParent()).addView(view);
//        HeartLoadingPathView view = new HeartLoadingPathView(this);
//        ((ViewGroup)multipleLv.getParent()).addView(view);

    }

    private void initListViewData() {
        MutilpleItemBean bean = null;
        bean = new MutilpleItemBean("text1", MutilpleItemBean.Item_Type_1);
        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);
//        for (int i=0;i<2000;i++){
//            mListViewDatas.add(bean);
//        }
        bean = new MutilpleItemBean("text2", MutilpleItemBean.Item_Type_2);
        mListViewDatas.add(bean);
        bean = new MutilpleItemBean("text3", MutilpleItemBean.Item_Type_3);
        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);

//        mListViewDatas.add(bean);
        bean = new MutilpleItemBean("text2", MutilpleItemBean.Item_Type_2);
        mListViewDatas.add(bean);
//        mListViewDatas.add(bean);
    }
}
