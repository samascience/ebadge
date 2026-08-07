package defpackage;

import android.os.Handler;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class wu {
    public static wu a(Executor executor, Handler handler) {
        return new xc(executor, handler);
    }

    public abstract Executor b();

    public abstract Handler c();
}
