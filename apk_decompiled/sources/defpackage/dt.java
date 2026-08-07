package defpackage;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.g;
import androidx.camera.core.impl.u;

/* JADX INFO: loaded from: classes.dex */
public abstract class dt {
    private static final g a = new a();

    static final class a implements g {
        private final az0 I = az0.a(new Object());

        a() {
        }

        @Override // androidx.camera.core.impl.g
        public az0 Q() {
            return this.I;
        }

        @Override // androidx.camera.core.impl.w
        public Config n() {
            return u.Z();
        }
    }

    public static g a() {
        return a;
    }
}
