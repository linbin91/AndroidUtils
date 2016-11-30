package com.felink.androidutils.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2016/11/21.
 */

public class PreferenceUtil {

    private static Context appContext;
    public static final String SETTING_NORMAL_GROUP = "SETTING_NORMAL_GROUP";

    public static void setAppContext(Context applicationContext) {
        appContext = applicationContext;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static Boolean getNormalBooleanValue(String key, boolean defaultValue) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(SETTING_NORMAL_GROUP, Context.MODE_MULTI_PROCESS);
        return mPrefs.getBoolean(key, defaultValue);
    }

    public static void setNormalBooleanValue(String key, boolean value) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(SETTING_NORMAL_GROUP, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putBoolean(key, value);
        ed.commit();
    }

    public static int getNormalIntValue(String key, int defaultValue) {
        return getIntValue(SETTING_NORMAL_GROUP, key, defaultValue);
    }

    public static void setNormalIntValue(String key, int value) {
        setIntValue(SETTING_NORMAL_GROUP, key, value);
    }

    public static long getNormalLongValue(String key, long defaultValue) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(SETTING_NORMAL_GROUP, Context.MODE_MULTI_PROCESS);
        return mPrefs.getLong(key, defaultValue);
    }

    public static void setNormalLongValue(String key, long value) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(SETTING_NORMAL_GROUP, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putLong(key, value);
        ed.commit();
    }

    public static String getNormalValue(String key, String defaultValue) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(SETTING_NORMAL_GROUP, Context.MODE_MULTI_PROCESS);
        return mPrefs.getString(key, defaultValue);
    }

    public static void setNormalValue(String key, String value) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(SETTING_NORMAL_GROUP, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putString(key, value);
        ed.commit();
    }

    public static int getIntValue(String settingGroup, String key, int defaultValue) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(settingGroup, Context.MODE_MULTI_PROCESS);
        return mPrefs.getInt(key, defaultValue);
    }

    public static void setIntValue(String settingGroup, String key, int value) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(settingGroup, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putInt(key, value);
        ed.commit();
    }

    public static String getValue(String settingGroup, String key) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(settingGroup, Context.MODE_MULTI_PROCESS);
        return mPrefs.getString(key, "");
    }

    public static void setValue(String settingGroup, String key, String value) {
        SharedPreferences mPrefs = appContext.getSharedPreferences(settingGroup, Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor ed = mPrefs.edit();
        ed.putString(key, value);
        ed.commit();
    }
}
