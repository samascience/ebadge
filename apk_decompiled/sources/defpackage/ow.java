package defpackage;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.s;
import androidx.camera.core.impl.t;
import androidx.camera.core.impl.u;
import androidx.camera.core.impl.w;

/* JADX INFO: loaded from: classes.dex */
public class ow implements w {
    private final Config I;

    public static final class a implements oj0 {
        private final t a = t.c0();

        public static a e(final Config config) {
            final a aVar = new a();
            config.c("camera2.captureRequest.option.", new Config.b() { // from class: nw
                @Override // androidx.camera.core.impl.Config.b
                public final boolean a(Config.a aVar2) {
                    return ow.a.f(this.a, config, aVar2);
                }
            });
            return aVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ boolean f(a aVar, Config config, Config.a aVar2) {
            aVar.a().s(aVar2, config.g(aVar2), config.a(aVar2));
            return true;
        }

        @Override // defpackage.oj0
        public s a() {
            return this.a;
        }

        public ow d() {
            return new ow(u.a0(this.a));
        }
    }

    public ow(Config config) {
        this.I = config;
    }

    @Override // androidx.camera.core.impl.w
    public Config n() {
        return this.I;
    }
}
