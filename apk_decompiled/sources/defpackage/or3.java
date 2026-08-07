package defpackage;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.b;

/* JADX INFO: loaded from: classes.dex */
public final class or3 extends hr3 {
    private final b c;

    public or3(b bVar) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.c = bVar;
    }

    @Override // com.google.android.gms.common.api.c
    public final com.google.android.gms.common.api.internal.b j(com.google.android.gms.common.api.internal.b bVar) {
        return this.c.b(bVar);
    }

    @Override // com.google.android.gms.common.api.c
    public final Context l() {
        return this.c.e();
    }

    @Override // com.google.android.gms.common.api.c
    public final Looper m() {
        return this.c.g();
    }
}
