package androidx.lifecycle;

import com.tencent.open.SocialConstants;
import defpackage.db1;
import defpackage.p31;
import defpackage.wj1;

/* JADX INFO: loaded from: classes.dex */
public final class CompositeGeneratedAdaptersObserver implements f {
    private final b[] a;

    public CompositeGeneratedAdaptersObserver(b[] bVarArr) {
        p31.f(bVarArr, "generatedAdapters");
        this.a = bVarArr;
    }

    @Override // androidx.lifecycle.f
    public void c(db1 db1Var, Lifecycle.Event event) {
        p31.f(db1Var, SocialConstants.PARAM_SOURCE);
        p31.f(event, "event");
        new wj1();
        b[] bVarArr = this.a;
        if (bVarArr.length > 0) {
            b bVar = bVarArr[0];
            throw null;
        }
        if (bVarArr.length <= 0) {
            return;
        }
        b bVar2 = bVarArr[0];
        throw null;
    }
}
