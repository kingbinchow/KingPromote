package com.king.kingpromote.materialrefreshlayout;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.king.kingpromote.R;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    /**
     * 加载布局的
     */
    private LayoutInflater mInflater;
    private List<String> mLists;
    private OnItemClickListener mListener;


    public OnItemClickListener getListener() {
        return mListener;
    }

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public List<String> getLists() {
        return mLists;
    }

    public void addLists(List<String> lists) {
        addLists(0, lists);
    }


    /**
     * 添加数据
     * @param position
     * @param lists
     */
    public void addLists(int position, List<String> lists) {
        //mLists = lists;
        if (lists != null && lists.size() > 0) {
            mLists.addAll(lists);
            notifyItemRangeChanged(position, mLists.size());
        }
    }


    public MyAdapter(List<String> items) {
        mLists = items;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mInflater = LayoutInflater.from(parent.getContext());
        View view = mInflater.inflate(R.layout.list_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.tv_text.setText(mLists.get(position));
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_text;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_text = (TextView) itemView.findViewById(R.id.tv_item);

            tv_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        mListener.onClick(v, getLayoutPosition(), mLists.get(getLayoutPosition()));
                    }
                }
            });

        }
    }

    //RecycleView的事件监听，这个要自己去写，里面的参数也是根据自己的需要去定义
    //不像listview中，已经有了item的点击监听事件
    interface OnItemClickListener {
        //自己定义
        void onClick(View v, int position, String item);
    }
}
