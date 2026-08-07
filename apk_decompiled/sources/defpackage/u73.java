package defpackage;

import android.content.Context;

/* JADX INFO: loaded from: classes4.dex */
public abstract class u73 {
    public static int a(int i) {
        return q30.c(hg.l(), i);
    }

    public static String b(int i) {
        Context contextL = hg.l();
        return contextL != null ? contextL.getString(i) : " ";
    }
}
