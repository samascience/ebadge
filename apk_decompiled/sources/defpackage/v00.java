package defpackage;

import kotlin.coroutines.d;

/* JADX INFO: loaded from: classes4.dex */
public final class v00 implements x30 {
    public static final v00 a = new v00();

    private v00() {
    }

    @Override // defpackage.x30
    public d getContext() {
        throw new IllegalStateException("This continuation is already complete");
    }

    @Override // defpackage.x30
    public void resumeWith(Object obj) {
        throw new IllegalStateException("This continuation is already complete");
    }

    public String toString() {
        return "This continuation is already complete";
    }
}
