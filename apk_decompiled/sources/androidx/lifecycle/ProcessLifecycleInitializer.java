package androidx.lifecycle;

import android.content.Context;
import defpackage.db1;
import defpackage.g21;
import defpackage.p31;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements g21 {
    @Override // defpackage.g21
    public List a() {
        return kotlin.collections.j.j();
    }

    @Override // defpackage.g21
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public db1 b(Context context) {
        p31.f(context, "context");
        androidx.startup.a aVarE = androidx.startup.a.e(context);
        p31.e(aVarE, "getInstance(context)");
        if (!aVarE.g(ProcessLifecycleInitializer.class)) {
            throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
        }
        e.a(context);
        k.b bVar = k.i;
        bVar.b(context);
        return bVar.a();
    }
}
