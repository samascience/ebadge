package com.blankj.utilcode.util;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class r {
    public static boolean a() {
        return TextUtils.getLayoutDirectionFromLocale(o.a().getResources().getConfiguration().getLocales().get(0)) == 1;
    }

    public static View b(int i) {
        return ((LayoutInflater) o.a().getSystemService("layout_inflater")).inflate(i, (ViewGroup) null);
    }

    public static void c(Runnable runnable) {
        q.N(runnable);
    }

    public static void d(Runnable runnable, long j) {
        q.O(runnable, j);
    }
}
