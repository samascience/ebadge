package defpackage;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class x12 {
    private final boolean a;
    private Configuration b;

    public x12(boolean z) {
        this.a = z;
    }

    public final boolean a() {
        return this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public x12(boolean z, Configuration configuration) {
        this(z);
        p31.f(configuration, "newConfig");
        this.b = configuration;
    }
}
