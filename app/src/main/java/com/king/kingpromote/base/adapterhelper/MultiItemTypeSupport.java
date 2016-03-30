package com.king.kingpromote.base.adapterhelper;

/**
 * support for Multiple Item type in ListView
 * @author King
 * @param <T>
 */
public interface MultiItemTypeSupport<T>
{
	int getLayoutId(int position, T t);
	
	int getViewTypeCount();
	
	int getItemViewType(int postion, T t);
}