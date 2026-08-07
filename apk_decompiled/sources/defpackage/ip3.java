package defpackage;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
class ip3 implements Comparator {
    final /* synthetic */ dp3 a;

    ip3(dp3 dp3Var) {
        this.a = dp3Var;
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(dp3.d dVar, dp3.d dVar2) {
        int i = dVar.b;
        int i2 = dVar2.b;
        if (i > i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }
}
