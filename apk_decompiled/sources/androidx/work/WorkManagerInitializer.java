package androidx.work;

import android.content.Context;
import defpackage.fd1;
import defpackage.g21;
import defpackage.mk3;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class WorkManagerInitializer implements g21 {
    private static final String a = fd1.f("WrkMgrInitializer");

    @Override // defpackage.g21
    public List a() {
        return Collections.emptyList();
    }

    @Override // defpackage.g21
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public mk3 b(Context context) {
        fd1.c().a(a, "Initializing WorkManager with default configuration.", new Throwable[0]);
        mk3.d(context, new a.b().a());
        return mk3.c(context);
    }
}
