package defpackage;

import android.text.Editable;

/* JADX INFO: loaded from: classes.dex */
final class rf0 extends Editable.Factory {
    private static final Object a = new Object();
    private static volatile Editable.Factory b;
    private static Class c;

    private rf0() {
        try {
            c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, rf0.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (b == null) {
            synchronized (a) {
                try {
                    if (b == null) {
                        b = new rf0();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class cls = c;
        return cls != null ? ms2.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
