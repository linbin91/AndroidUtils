package com.felink.androidutils.utils;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Administrator on 2016/11/21.
 */

public class HideInputUtils {
    /**
     * 强制隐藏软键盘
     *
     * @param ctx
     */
    public static void hideInputMethod(Activity ctx) {
        ctx.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    /**
     * 强制隐藏软键盘
     *
     * @param
     */
    public static void hideInputMethod(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (android.os.Build.VERSION.SDK_INT < 11) {
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        } else {
            imm.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}
