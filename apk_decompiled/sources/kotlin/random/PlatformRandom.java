package kotlin.random;

import defpackage.l1;
import defpackage.p31;
import defpackage.y70;
import java.io.Serializable;

/* JADX INFO: loaded from: classes4.dex */
final class PlatformRandom extends l1 implements Serializable {
    private static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    private final java.util.Random impl;

    private static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public PlatformRandom(java.util.Random random) {
        p31.f(random, "impl");
        this.impl = random;
    }

    @Override // defpackage.l1
    public java.util.Random getImpl() {
        return this.impl;
    }
}
