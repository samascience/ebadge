package com.tencent.open.utils;

import android.content.Context;
import com.tencent.connect.common.Constants;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public final class g {
    private static Context a;

    public static final Context a() {
        Context context = a;
        if (context == null) {
            return null;
        }
        return context;
    }

    public static final String b() {
        return a() == null ? Constants.STR_EMPTY : a().getPackageName();
    }

    public static final File c() {
        if (a() == null) {
            return null;
        }
        return a().getFilesDir();
    }

    public static final File d() {
        Context contextA = a();
        if (contextA != null) {
            return contextA.getCacheDir();
        }
        return null;
    }

    public static final File e() {
        return a((String) null);
    }

    public static final void a(Context context) {
        a = context;
    }

    public static final File a(String str) {
        return l.h(a(), str);
    }
}
