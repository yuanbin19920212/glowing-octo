package com.wj.yuanbin.checkableviewtest;

import android.util.SparseArray;
import android.view.View;

/**
 * Created by yuanbin on 16/7/20.
 */
public class ViewHolder {

    public ViewHolder(View rootView){
        this.rootView = rootView;
    }
    /***
     * rootView
     */
    private View rootView;

    /***
     * finded view
     */
    private SparseArray<View> mSparseArray;

    /***
     * getView
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T getView(int id){
        if (id == -1){
            throw new IllegalArgumentException(" id is -1");
        }
        if (mSparseArray == null) mSparseArray = new SparseArray<View>();
        View view = mSparseArray.get(id);
        if (view == null){
            view = rootView.findViewById(id);
            if (view == null){
                return null;
            }else {
                mSparseArray.put(id,view);
            }
        }
        return (T)view;
    }
}
