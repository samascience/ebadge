package defpackage;

import android.content.res.Configuration;

/* JADX INFO: loaded from: classes.dex */
public final class fm1 {
    private final boolean a;
    private Configuration b;

    public fm1(boolean z) {
        this.a = z;
    }

    public final boolean a() {
        return this.a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fm1(boolean z, Configuration configuration) {
        this(z);
        p31.f(configuration, "newConfig");
        this.b = configuration;
    }
}
