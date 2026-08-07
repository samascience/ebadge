package kotlinx.coroutines.flow;

import defpackage.be0;

/* JADX INFO: loaded from: classes4.dex */
public final class SharingStartedKt {
    /* JADX INFO: renamed from: WhileSubscribed-5qebJ5I, reason: not valid java name */
    public static final SharingStarted m136WhileSubscribed5qebJ5I(SharingStarted.Companion companion, long j, long j2) {
        return new StartedWhileSubscribed(be0.j(j), be0.j(j2));
    }

    /* JADX INFO: renamed from: WhileSubscribed-5qebJ5I$default, reason: not valid java name */
    public static /* synthetic */ SharingStarted m137WhileSubscribed5qebJ5I$default(SharingStarted.Companion companion, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = be0.a.b();
        }
        if ((i & 2) != 0) {
            j2 = be0.a.a();
        }
        return m136WhileSubscribed5qebJ5I(companion, j, j2);
    }
}
