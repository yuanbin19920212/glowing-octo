package com.wj.yuanbin.checkableview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.FrameLayout;

/**
 * Created by yuanbin on 16/7/20.
 *
 * 配合listview 实现选择页面
 */
public class CheckableLayout extends FrameLayout implements Checkable{

    /***
     * 选择框
     */
    private CheckBox mCheckBox;

    /**
     *
     * @param context
     */
    public CheckableLayout(Context context) {
        super(context);
    }

    /***
     *
     * @param context
     * @param attrs
     */
    public CheckableLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public CheckableLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    public CheckableLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    /***
     * 初始化
     * @param context
     * @param attrs
     * @param defStyleAttr
     * @param defStyleRes
     */
    private void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){

        /****
         *
         *before 5.0 TypedArray array = context.obtainStyledAttributes(attrs,null);
         */
        TypedArray array = context.obtainStyledAttributes(attrs,R.styleable.CheckableLayout,defStyleAttr,defStyleRes);

        int layout = array.getResourceId(R.styleable.CheckableLayout_layout,-1);

        if (layout == -1){
            throw new IllegalArgumentException("CheckableView's layout must need");
        }

        View layoutView = LayoutInflater.from(context).inflate(layout,null);

        if (layoutView == null){
            throw new NullPointerException("LayoutView is null");
        }

        int checkBoxId = array.getResourceId(R.styleable.CheckableLayout_checkboxId,-1);

        if (checkBoxId == -1){
            throw new IllegalArgumentException("CheckableView's checkboxId must need");
        }

        View checkView = layoutView.findViewById(checkBoxId);

        if (checkView == null){
            throw new NullPointerException("checkView is null");
        }
        if (checkView instanceof CheckBox){
            mCheckBox = (CheckBox)checkView;
        }else {
            throw new IllegalArgumentException("checkView must be Checkbox");
        }

        array.recycle();
    }


    /**
     * check
     * @param checked
     */
    @Override
    public void setChecked(boolean checked) {
        if (mCheckBox == null) return;
        mCheckBox.setChecked(checked);
    }

    @Override
    public boolean isChecked() {
        if (mCheckBox == null)
        return false;
        return mCheckBox.isChecked();
    }

    @Override
    public void toggle() {
        if (mCheckBox == null) return;
        mCheckBox.toggle();
    }
}
