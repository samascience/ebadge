package androidx.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import defpackage.p31;
import defpackage.zf0;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e a = new e();
    private static final AtomicBoolean b = new AtomicBoolean(false);

    public static final class a extends zf0 {
        @Override // defpackage.zf0, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            p31.f(activity, "activity");
            ReportFragment.b.c(activity);
        }
    }

    private e() {
    }

    public static final void a(Context context) {
        p31.f(context, "context");
        if (b.getAndSet(true)) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        p31.d(applicationContext, "null cannot be cast to non-null type android.app.Application");
        ((Application) applicationContext).registerActivityLifecycleCallbacks(new a());
    }
}
