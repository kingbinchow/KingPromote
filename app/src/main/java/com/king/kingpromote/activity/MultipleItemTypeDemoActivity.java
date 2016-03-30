package com.king.kingpromote.activity;

import android.os.Bundle;
import android.widget.ListView;

import com.king.kingpromote.R;
import com.king.kingpromote.base.BaseActivity;
import com.king.kingpromote.base.adapterhelper.BaseAdapterHelper;
import com.king.kingpromote.base.adapterhelper.MultiItemTypeSupport;
import com.king.kingpromote.base.adapterhelper.QuickAdapter;
import com.king.kingpromote.bean.MutilpleItemBean;

import java.util.ArrayList;

import butterknife.Bind;

/**
 * Created by king.zhou on 2016/3/30.
 */
public class MultipleItemTypeDemoActivity extends BaseActivity {

    @Bind(R.id.lv_multiple_demo)
    ListView multipleLv;

    private ArrayList<MutilpleItemBean> mListViewDatas = new ArrayList<MutilpleItemBean>();

    private QuickAdapter<MutilpleItemBean> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_item_type_demo);
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

        mAdapter = new QuickAdapter<MutilpleItemBean>(MultipleItemTypeDemoActivity.this, mListViewDatas,
                multiItemTypeSupport) {
            @Override
            protected void convert(BaseAdapterHelper helper, MutilpleItemBean bean, int position) {
                switch (helper.layoutId) {
                    case R.layout.item_multiple_item_type_1:
//                        helper.getView(R.id.tv_multiple_item_type_1);
                        helper.setText(R.id.tv_multiple_item_type_1, bean.content);
                        break;
                    case R.layout.item_multiple_item_type_2:
                        helper.setText(R.id.tv_multiple_item_type_2, bean.content);
                        break;
                    case R.layout.item_multiple_item_type_3:
                        helper.setText(R.id.tv_multiple_item_type_3, bean.content);
                        break;
                }
            }

        };
//		mAdapter.showIndeterminateProgress(true);
        // 设置适配器
        multipleLv.setAdapter(mAdapter);

    }

    private void initListViewData() {
        MutilpleItemBean bean = null;
        bean = new MutilpleItemBean("text1", MutilpleItemBean.Item_Type_1);
        mListViewDatas.add(bean);
        mListViewDatas.add(bean);
        mListViewDatas.add(bean);
        bean = new MutilpleItemBean("text2", MutilpleItemBean.Item_Type_2);
        mListViewDatas.add(bean);
        bean = new MutilpleItemBean("text3", MutilpleItemBean.Item_Type_3);
        mListViewDatas.add(bean);
        mListViewDatas.add(bean);
        bean = new MutilpleItemBean("text2", MutilpleItemBean.Item_Type_2);
        mListViewDatas.add(bean);
        mListViewDatas.add(bean);
    }
}
