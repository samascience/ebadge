package okhttp3.internal.cache;

import defpackage.ar0;
import defpackage.k83;
import defpackage.p31;
import defpackage.pa3;
import java.io.IOException;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes4.dex */
final class DiskLruCache$newJournalWriter$faultHidingSink$1 extends Lambda implements ar0 {
    final /* synthetic */ a this$0;

    DiskLruCache$newJournalWriter$faultHidingSink$1(a aVar) {
        super(1);
    }

    @Override // defpackage.ar0
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return k83.a;
    }

    public final void invoke(IOException iOException) {
        p31.f(iOException, "it");
        if (!pa3.h || Thread.holdsLock(null)) {
            a.n(null, true);
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + ((Object) null));
    }
}
