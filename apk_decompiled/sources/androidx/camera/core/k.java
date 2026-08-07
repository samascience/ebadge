package androidx.camera.core;

import android.os.Handler;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.UseCaseConfigFactory;
import defpackage.m03;
import defpackage.st;
import defpackage.tu;
import defpackage.ut;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class k implements m03 {
    static final Config.a J = Config.a.a("camerax.core.appConfig.cameraFactoryProvider", ut.a.class);
    static final Config.a K = Config.a.a("camerax.core.appConfig.deviceSurfaceManagerProvider", st.a.class);
    static final Config.a L = Config.a.a("camerax.core.appConfig.useCaseConfigFactoryProvider", UseCaseConfigFactory.b.class);
    static final Config.a M = Config.a.a("camerax.core.appConfig.cameraExecutor", Executor.class);
    static final Config.a N = Config.a.a("camerax.core.appConfig.schedulerHandler", Handler.class);
    static final Config.a O = Config.a.a("camerax.core.appConfig.minimumLoggingLevel", Integer.TYPE);
    static final Config.a P = Config.a.a("camerax.core.appConfig.availableCamerasLimiter", tu.class);
    static final Config.a Q = Config.a.a("camerax.core.appConfig.cameraOpenRetryMaxTimeoutInMillisWhileResuming", Long.TYPE);
    static final Config.a R = Config.a.a("camerax.core.appConfig.cameraProviderInitRetryPolicy", a0.class);
    private final androidx.camera.core.impl.u I;

    public static final class a {
        private final androidx.camera.core.impl.t a;

        public a() {
            this(androidx.camera.core.impl.t.c0());
        }

        private androidx.camera.core.impl.s b() {
            return this.a;
        }

        public k a() {
            return new k(androidx.camera.core.impl.u.a0(this.a));
        }

        public a c(ut.a aVar) {
            b().x(k.J, aVar);
            return this;
        }

        public a d(st.a aVar) {
            b().x(k.K, aVar);
            return this;
        }

        public a e(Class cls) {
            b().x(m03.c, cls);
            if (b().f(m03.b, null) == null) {
                f(cls.getCanonicalName() + "-" + UUID.randomUUID());
            }
            return this;
        }

        public a f(String str) {
            b().x(m03.b, str);
            return this;
        }

        public a g(UseCaseConfigFactory.b bVar) {
            b().x(k.L, bVar);
            return this;
        }

        private a(androidx.camera.core.impl.t tVar) {
            this.a = tVar;
            Class cls = (Class) tVar.f(m03.c, null);
            if (cls == null || cls.equals(CameraX.class)) {
                e(CameraX.class);
                return;
            }
            throw new IllegalArgumentException("Invalid target class configuration for " + this + ": " + cls);
        }
    }

    public interface b {
        k getCameraXConfig();
    }

    k(androidx.camera.core.impl.u uVar) {
        this.I = uVar;
    }

    public tu Y(tu tuVar) {
        return (tu) this.I.f(P, tuVar);
    }

    public Executor Z(Executor executor) {
        return (Executor) this.I.f(M, executor);
    }

    public ut.a a0(ut.a aVar) {
        return (ut.a) this.I.f(J, aVar);
    }

    public long b0() {
        return ((Long) this.I.f(Q, -1L)).longValue();
    }

    public a0 c0() {
        a0 a0Var = (a0) this.I.f(R, a0.b);
        Objects.requireNonNull(a0Var);
        return a0Var;
    }

    public st.a d0(st.a aVar) {
        return (st.a) this.I.f(K, aVar);
    }

    public Handler e0(Handler handler) {
        return (Handler) this.I.f(N, handler);
    }

    public UseCaseConfigFactory.b f0(UseCaseConfigFactory.b bVar) {
        return (UseCaseConfigFactory.b) this.I.f(L, bVar);
    }

    @Override // androidx.camera.core.impl.w
    public Config n() {
        return this.I;
    }
}
