package defpackage;

import android.app.Application;
import android.content.Context;
import androidx.multidex.a;

/* JADX INFO: loaded from: classes.dex */
public abstract class hl1 extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        a.k(this);
    }
}
