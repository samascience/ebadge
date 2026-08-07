package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import defpackage.b52;
import defpackage.g3;
import defpackage.q30;
import defpackage.tp0;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class f extends tp0 {
    private final Activity a;
    private final Context b;
    private final Handler c;
    private final int d;
    final FragmentManager e;

    f(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }

    Activity e() {
        return this.a;
    }

    Context f() {
        return this.b;
    }

    public Handler g() {
        return this.c;
    }

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object i();

    public abstract LayoutInflater j();

    public void k(Fragment fragment, String[] strArr, int i) {
    }

    public abstract boolean l(String str);

    public void m(Fragment fragment, Intent intent, int i, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting activity with a requestCode requires a FragmentActivity host");
        }
        q30.k(this.b, intent, bundle);
    }

    public void n(Fragment fragment, IntentSender intentSender, int i, Intent intent, int i2, int i3, int i4, Bundle bundle) {
        if (i != -1) {
            throw new IllegalStateException("Starting intent sender with a requestCode requires a FragmentActivity host");
        }
        g3.x(this.a, intentSender, i, intent, i2, i3, i4, bundle);
    }

    public abstract void o();

    f(Activity activity, Context context, Handler handler, int i) {
        this.e = new i();
        this.a = activity;
        this.b = (Context) b52.h(context, "context == null");
        this.c = (Handler) b52.h(handler, "handler == null");
        this.d = i;
    }
}
