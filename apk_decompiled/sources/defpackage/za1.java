package defpackage;

import android.app.Activity;
import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: loaded from: classes.dex */
public interface za1 {
    void c(String str, LifecycleCallback lifecycleCallback);

    LifecycleCallback f(String str, Class cls);

    Activity g();

    void startActivityForResult(Intent intent, int i);
}
