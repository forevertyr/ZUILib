/*
 * *********************************************************
 *   author   colin
 *   company  fosung
 *   email    wanglin2046@126.com
 *   date     16-12-23 下午4:36
 * ********************************************************
 */

package com.fosung.gui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.fosung.frame.utils.ScreenUtil;

/**
 * Dialog使用的固定高度的Scrollview
 */
class DialogFixHeightScrollView extends ScrollView {
    private int maxHeight;

    public DialogFixHeightScrollView(Context context) {
        super(context);
        init(context);
    }

    public DialogFixHeightScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DialogFixHeightScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        maxHeight = ScreenUtil.getScreenHeight(context) / 2;
    }

    /**
     * 设置Scrollview的最大高度
     */
    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
        requestLayout();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, MeasureSpec.AT_MOST);

        //重新计算控件高、宽
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}