package defpackage;

import android.os.Environment;

/* JADX INFO: loaded from: classes4.dex */
public abstract class rz2 {
    public static boolean a() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
