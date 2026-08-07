package defpackage;

import android.graphics.Bitmap;

/* JADX INFO: loaded from: classes3.dex */
public class u00 implements p70 {
    private final Class a;
    private final Bitmap.Config b;

    public u00(Class cls) {
        this(cls, null);
    }

    @Override // defpackage.p70
    public Object a() {
        return this.b == null ? this.a.newInstance() : this.a.getConstructor(Bitmap.Config.class).newInstance(this.b);
    }

    public u00(Class cls, Bitmap.Config config) {
        this.a = cls;
        this.b = config;
    }
}
