package com.blankj.utilcode.util;

import android.os.Environment;
import com.tencent.connect.common.Constants;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    private static final char a = File.separatorChar;

    private static String a(File file) {
        return file == null ? Constants.STR_EMPTY : file.getAbsolutePath();
    }

    public static String b() {
        return !q.G() ? Constants.STR_EMPTY : a(o.a().getExternalCacheDir());
    }

    public static String c() {
        return !q.G() ? Constants.STR_EMPTY : a(o.a().getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS));
    }

    public static String d() {
        return !q.G() ? Constants.STR_EMPTY : a(o.a().getExternalFilesDir(null));
    }
}
