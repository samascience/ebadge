package defpackage;

import android.os.Trace;

/* JADX INFO: loaded from: classes.dex */
abstract class m43 {
    public static void a(String str) {
        Trace.beginSection(str);
    }

    public static void b() {
        Trace.endSection();
    }
}
