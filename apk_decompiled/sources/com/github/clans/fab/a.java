package com.github.clans.fab;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
abstract class a {
    static int a(Context context, float f) {
        return Math.round(f * context.getResources().getDisplayMetrics().density);
    }

    static boolean b() {
        return true;
    }

    static boolean c() {
        return true;
    }
}
