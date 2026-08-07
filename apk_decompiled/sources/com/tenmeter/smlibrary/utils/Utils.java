package com.tenmeter.smlibrary.utils;

import android.R;
import android.app.Activity;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class Utils {
    private static Activity sActivity;

    public static void hideVirtualButton() {
        if (sActivity != null) {
            int iIntValue = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION")).intValue();
            int iIntValue2 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN")).intValue();
            int iIntValue3 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_HIDE_NAVIGATION")).intValue();
            int iIntValue4 = ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_FULLSCREEN")).intValue();
            Cocos2dxReflectionHelper.invokeInstanceMethod(sActivity.getWindow().getDecorView(), "setSystemUiVisibility", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(iIntValue | ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_LAYOUT_STABLE")).intValue() | iIntValue2 | iIntValue3 | iIntValue4 | ((Integer) Cocos2dxReflectionHelper.getConstantValue(View.class, "SYSTEM_UI_FLAG_IMMERSIVE_STICKY")).intValue())});
        }
    }

    public static void setActivity(Activity activity) {
        sActivity = activity;
    }

    public static void setDarkStatusWhite(Activity activity, boolean z) {
        View decorView = activity.getWindow().getDecorView();
        activity.getWindow().setStatusBarColor(activity.getResources().getColor(R.color.white));
        if (decorView != null) {
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }
}
