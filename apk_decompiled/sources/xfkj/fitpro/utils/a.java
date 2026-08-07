package xfkj.fitpro.utils;

import android.os.Handler;
import defpackage.ar0;
import defpackage.or0;
import defpackage.p31;
import defpackage.x30;
import defpackage.y70;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes4.dex */
public abstract class a {
    public static final b a = new b(null);

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: xfkj.fitpro.utils.a$a, reason: collision with other inner class name */
    final class C0180a {
        private final int a;
        private final Handler b;
        private final Runnable c;
        private final or0 d;

        public C0180a(a aVar, int i, Handler handler, Runnable runnable, or0 or0Var) {
            p31.f(handler, "timeoutHandler");
            p31.f(runnable, "timeoutRunnable");
            this.a = i;
            this.b = handler;
            this.c = runnable;
            this.d = or0Var;
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        private b() {
        }
    }

    public interface c {
    }

    /* JADX INFO: Access modifiers changed from: private */
    static final class d {
        private final int a;
        private final byte[] b;
        private final Handler c;
        private final Runnable d;
        private int e;
        private final int f;
        private final long g;
        private final or0 h;

        public d(int i, byte[] bArr, Handler handler, Runnable runnable, int i2, int i3, long j, or0 or0Var) {
            p31.f(bArr, "data");
            p31.f(handler, "timeoutHandler");
            p31.f(runnable, "timeoutRunnable");
            this.a = i;
            this.b = bArr;
            this.c = handler;
            this.d = runnable;
            this.e = i2;
            this.f = i3;
            this.g = j;
            this.h = or0Var;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d)) {
                return false;
            }
            d dVar = (d) obj;
            return this.a == dVar.a && p31.a(this.b, dVar.b) && p31.a(this.c, dVar.c) && p31.a(this.d, dVar.d) && this.e == dVar.e && this.f == dVar.f && this.g == dVar.g && p31.a(this.h, dVar.h);
        }

        public int hashCode() {
            int iHashCode = ((((((((((((Integer.hashCode(this.a) * 31) + Arrays.hashCode(this.b)) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + Integer.hashCode(this.e)) * 31) + Integer.hashCode(this.f)) * 31) + Long.hashCode(this.g)) * 31;
            or0 or0Var = this.h;
            return iHashCode + (or0Var == null ? 0 : or0Var.hashCode());
        }

        public String toString() {
            return "PendingRequest(requestId=" + this.a + ", data=" + Arrays.toString(this.b) + ", timeoutHandler=" + this.c + ", timeoutRunnable=" + this.d + ", retryCount=" + this.e + ", maxRetries=" + this.f + ", retryDelayMs=" + this.g + ", callback=" + this.h + ")";
        }
    }

    public static final /* synthetic */ ConcurrentHashMap a(a aVar) {
        throw null;
    }

    public static final /* synthetic */ CoroutineScope b(a aVar) {
        throw null;
    }

    public static final /* synthetic */ ConcurrentHashMap c(a aVar) {
        throw null;
    }

    public static final /* synthetic */ Object d(a aVar, int i, int i2, long j, or0 or0Var, String str, ar0 ar0Var, x30 x30Var) {
        throw null;
    }

    public static final /* synthetic */ void e(a aVar, String str) {
        throw null;
    }

    public static final /* synthetic */ void f(a aVar, String str) {
        throw null;
    }

    public static final /* synthetic */ void g(a aVar, String str) {
        throw null;
    }

    public static final /* synthetic */ void h(a aVar, Class cls, c cVar) {
        throw null;
    }

    public static final /* synthetic */ void i(a aVar, Class cls) {
        throw null;
    }
}
