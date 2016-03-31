package com.king.kingpromote.bean;

/**
 * Created by king.zhou on 2016/3/30.
 */
public class MutilpleItemBean {

    //从1开始
    public final static int Item_Type_1= 1;
    public final static int Item_Type_2= 2;
    public final static int Item_Type_3= 3;
    public final static int Type_Num = 3;
    public String content;
    public int type;

    private MutilpleItemBean(){

    }
    public MutilpleItemBean(String str,int t){
        content = str;
        type = t;
    }
}
