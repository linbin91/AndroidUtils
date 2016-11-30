package com.felink.androidutils.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/11/19.
 *
 * 视图基类
 */

public abstract class AMainView {

    protected Context mContext;
    protected View mView;

    public AMainView(Context context) {
        mContext = context;
    }

    public void release() {
        if (mView instanceof ViewGroup) {
            ((ViewGroup) mView).removeAllViewsInLayout();
            mView.setDrawingCacheEnabled(true);
            mView.destroyDrawingCache();
            mView.setBackgroundDrawable(null);
            mView.setDrawingCacheEnabled(false);
        }

        mView = null;
        mContext = null;
    }

    public View getView() {
        return mView;
    }

    public abstract void init();

    protected abstract void findViews();

    protected abstract void setListeners();

    protected abstract void setViews();
}

