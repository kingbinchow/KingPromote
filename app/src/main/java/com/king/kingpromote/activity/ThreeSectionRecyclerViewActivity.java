package com.king.kingpromote.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.king.kingpromote.R;
import com.zaihuishou.expandablerecycleradapter.adapter.BaseExpandableAdapter;
import com.zaihuishou.expandablerecycleradapter.model.ExpandableListItem;
import com.zaihuishou.expandablerecycleradapter.viewholder.AbstractExpandableAdapterItem;

import java.util.List;

/**
 * Created by king.zhou on 2016/8/12.
 */
public class ThreeSectionRecyclerViewActivity extends Activity {

    private final int ITEM_TYPE_1 = 1;
    private final int ITEM_TYPE_2 = 2;
    private final int ITEM_TYPE_3 = 3;

    private RecyclerView mRecyclerView;
    private BaseExpandableAdapter mBaseExpandableAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_section_recycler_view);
    }







    class OuterGroup implements ExpandableListItem {

        public boolean mExpanded = false;
        public String name;
        public List<MiddleGroup> outerList;

        @Override
        public List<?> getChildItemList() {
            return outerList;
        }

        @Override
        public boolean isExpanded() {
            return mExpanded;
        }

        @Override
        public void setExpanded(boolean isExpanded) {
            mExpanded = isExpanded;
        }

    }


    class MiddleGroup implements ExpandableListItem {

        private boolean mExpand = false;
        public String name;
        public List<APieceOfAccount> middleList;

        @Override
        public List<?> getChildItemList() {
            return middleList;
        }

        @Override
        public boolean isExpanded() {
            return mExpand;
        }

        @Override
        public void setExpanded(boolean isExpanded) {
            mExpand = isExpanded;
        }

    }

    class APieceOfAccount{
        public String name;
    }

}
