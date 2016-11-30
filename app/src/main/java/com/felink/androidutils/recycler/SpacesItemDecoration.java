package com.felink.androidutils.recycler;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2016/9/18.
 *
 * recycler item 之间的间距
 */
public class SpacesItemDecoration extends RecyclerView.ItemDecoration {
    private int dirction;
    private int space;

    public SpacesItemDecoration(int space, int dir) {
        this.space = space;
        this.dirction = dir;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view,
                               RecyclerView parent, RecyclerView.State state) {

        if (dirction == RecyclerView.HORIZONTAL){
            if (parent.getChildPosition(view) == 0){
                outRect.right = space;
            }else {
                outRect.left = space;
                outRect.right = space;
            }
        }else{
            outRect.bottom = space;
        }

//        outRect.bottom = space;
//
//        // Add top margin only for the first item to avoid double space between items
//        if(parent.getChildPosition(view) == 0)
//            outRect.top = space;
    }

}
