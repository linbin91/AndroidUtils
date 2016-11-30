package com.felink.androidutils.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/11/21.
 *
 *  * showToast(Context ctx, int msgResId)、showToast(Context ctx, String
 * msgRes)、cancelToast()
 * 以上方法实现了可自定义背景、显示文字居中、显示时长为LENGTH_SHORT,BackGroundToast为Toast实现类
 *
 * showToast(Context ctx, int resId, int time)、showToast(Context ctx, String
 * text, int time)、cancel() 以上方法调用系统默认Toast，可自定义显示时长
 */

public class ToastUtil {

    static Toast mToast = null;
    static Context mainContext = null;

    public static void init(Context ctx) {
        mainContext = ctx;
    }

    /**
     * 点击下载后的提示
     *
     * @param ctx
     *            无效，现在统一用mainActivity的context
     * @param msgResId
     *            字符串资源ID
     */
    public static void showToast(Context ctx, int msgResId) {
        if (mainContext != null) {
            BackGroundToast.getInstance(mainContext, msgResId).show();
        } else {
            BackGroundToast.getInstance(ctx, msgResId).show();
        }
    }

    /**
     * 点击下载后的提示
     *
     * @param ctx
     *            无效，现在统一用mainActivity的context
     * @param msgRes
     *            字符串
     */
    public static void showToast(Context ctx, String msgRes) {
        if (mainContext != null) {
            BackGroundToast.getInstance(mainContext, msgRes).show();
        } else {
            BackGroundToast.getInstance(ctx, msgRes).show();
        }
    }

    /**
     * 带背景的Toast
     *
     * @param ctx
     * @param msgRes
     * @param bgRes
     */
	/*
	 * public static void showBgToast(Context ctx, String msgRes,int bgRes) {
	 * BackGroundToast.getInstance(ctx, msgRes,bgRes).showCenter(); }
	 */

    /**
     * 显示引导图
     *
     * @param ctx
     *            无效，现在统一用mainActivity的context
     * @param
     *
     */
    public static void showToastGuide(Context ctx, int BGResId) {
        if (mainContext != null) {
            BackGroundToast.getInstance(mainContext, "", BGResId).showAppoint(0, ScreenUtil.dip2px(mainContext, 120));
        } else {
            BackGroundToast.getInstance(ctx, "", BGResId).showAppoint(0, ScreenUtil.dip2px(ctx, 120));
        }
    }

    public static void cancelToast() {
        BackGroundToast.cancel();
    }

    public static void showLongToast(Context ctx, int resId) {
        if (mainContext != null) {
            showToast(mainContext, resId, Toast.LENGTH_LONG);
        } else {
            showToast(ctx, resId, Toast.LENGTH_LONG);
        }
    }

    public static void showLongToast(Context ctx, String text) {
        if (mainContext != null) {
            showToast(mainContext, text, Toast.LENGTH_LONG);
        } else {
            showToast(ctx, text, Toast.LENGTH_LONG);
        }
    }

    public static void showToast(Context ctx, int resId, int time) {
        Context context;
        if (mainContext == null) {
            context = ctx;
        } else {
            context = mainContext;
        }
        if (ToastUtil.mToast == null) {
            ToastUtil.mToast = Toast.makeText(context, context.getString(resId), time);
        } else {
            ToastUtil.mToast.setText(context.getString(resId));
            ToastUtil.mToast.setDuration(time);
        }
        ToastUtil.mToast.show();
    }

    public static void showToast(Context ctx, String text, int time) {
        Context context;
        if (mainContext == null) {
            context = ctx;
        } else {
            context = mainContext;
        }
        if (ToastUtil.mToast == null) {
            ToastUtil.mToast = Toast.makeText(context, text, time);
        } else {
            ToastUtil.mToast.setText(text);
            ToastUtil.mToast.setDuration(time);
        }
        ToastUtil.mToast.show();
    }

    public static void cancel() {
        if (ToastUtil.mToast != null) {
            ToastUtil.mToast.cancel();

        }
    }

    public static void release() {
        cancel();
        ToastUtil.mToast = null;
        mainContext = null;
        BackGroundToast.release();
    }

    private static class BackGroundToast {
        private static Toast toast;

        public static BackGroundToast getInstance(Context context, String tip, int BGResID) {
            return new BackGroundToast(context, tip, BGResID);
        }

        public static BackGroundToast getInstance(Context context, int tipResID) {
            return new BackGroundToast(context, tipResID);
        }

        public static BackGroundToast getInstance(Context context, String tip) {
            return new BackGroundToast(context, tip);
        }

        public static void release() {
            toast = null;
        }

        private BackGroundToast(Context context, String tip, int BGResID) {
            toast = Toast.makeText(context, tip, Toast.LENGTH_SHORT);
            LinearLayout parentPanel = (LinearLayout) toast.getView();
            parentPanel.setBackgroundResource(BGResID);
            TextView tipView = (TextView) parentPanel.findViewById(android.R.id.message);
            if (tipView != null)
                tipView.setGravity(Gravity.CENTER);
        }

        private BackGroundToast(Context context, String tip) {
            toast = Toast.makeText(context, tip, Toast.LENGTH_SHORT);
            LinearLayout parentPanel = (LinearLayout) toast.getView();
            TextView tipView = (TextView) parentPanel.findViewById(android.R.id.message);
            if (tipView != null)
                tipView.setGravity(Gravity.CENTER);
        }

        private BackGroundToast(Context context, int tipResID, int BGResID) {
            toast = Toast.makeText(context, context.getResources().getString(tipResID), Toast.LENGTH_SHORT);
            LinearLayout parentPanel = (LinearLayout) toast.getView();
            parentPanel.setBackgroundResource(BGResID);
            TextView tipView = (TextView) parentPanel.findViewById(android.R.id.message);
            if (tipView != null)
                tipView.setGravity(Gravity.CENTER);
        }

        private BackGroundToast(Context context, int tipResID) {
            if (context != null) {
                toast = Toast.makeText(context, context.getResources().getString(tipResID), Toast.LENGTH_SHORT);
                LinearLayout parentPanel = (LinearLayout) toast.getView();
                TextView tipView = (TextView) parentPanel.findViewById(android.R.id.message);
                if (tipView != null)
                    tipView.setGravity(Gravity.CENTER);
            }
        }

        public void show() {
            if (toast != null) {
                toast.show();
            }
        }

        public void showCenter() {
            if (toast != null) {
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
            }
        }

        public void showAppoint(int x, int y) {
            if (toast != null) {
                toast.setGravity(Gravity.TOP | Gravity.CENTER_HORIZONTAL, x, y);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        }

        public static void cancel() {
            if (toast != null) {
                toast.cancel();
            }
        }
    }
}
