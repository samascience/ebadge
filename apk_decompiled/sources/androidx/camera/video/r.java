package androidx.camera.video;

import android.content.Context;
import defpackage.b52;
import defpackage.fy1;
import defpackage.q20;
import defpackage.t30;
import defpackage.xz1;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public final class r {
    private final Context a;
    private final Recorder b;
    private final fy1 c;
    private q20 d;
    private Executor e;
    private boolean f = false;
    private boolean g = false;

    r(Context context, Recorder recorder, fy1 fy1Var) {
        this.a = t30.a(context);
        this.b = recorder;
        this.c = fy1Var;
    }

    Context a() {
        return this.a;
    }

    q20 b() {
        return this.d;
    }

    Executor c() {
        return this.e;
    }

    fy1 d() {
        return this.c;
    }

    Recorder e() {
        return this.b;
    }

    boolean f() {
        return this.f;
    }

    boolean g() {
        return this.g;
    }

    public k0 h(Executor executor, q20 q20Var) {
        b52.h(executor, "Listener Executor can't be null.");
        b52.h(q20Var, "Event listener can't be null");
        this.e = executor;
        this.d = q20Var;
        return this.b.C0(this);
    }

    public r i() {
        if (xz1.b(this.a, "android.permission.RECORD_AUDIO") == -1) {
            throw new SecurityException("Attempted to enable audio for recording but application does not have RECORD_AUDIO permission granted.");
        }
        b52.j(this.b.K(), "The Recorder this recording is associated to doesn't support audio.");
        this.f = true;
        return this;
    }
}
