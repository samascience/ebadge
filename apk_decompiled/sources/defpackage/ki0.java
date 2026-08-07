package defpackage;

import com.tencent.open.SocialConstants;

/* JADX INFO: loaded from: classes4.dex */
public final class ki0 {
    public static final ki0 a = new ki0();

    private ki0() {
    }

    public static final hi0.a b(final zt1 zt1Var) {
        p31.f(zt1Var, "client");
        return new hi0.a() { // from class: ji0
            @Override // hi0.a
            public final hi0 a(df2 df2Var, ii0 ii0Var) {
                return ki0.c(zt1Var, df2Var, ii0Var);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final hi0 c(zt1 zt1Var, df2 df2Var, ii0 ii0Var) {
        p31.f(zt1Var, "$client");
        p31.f(df2Var, SocialConstants.TYPE_REQUEST);
        p31.f(ii0Var, "listener");
        if (df2Var.d("Accept") == null) {
            df2Var = df2Var.h().a("Accept", "text/event-stream").b();
        }
        id2 id2Var = new id2(df2Var, ii0Var);
        id2Var.c(zt1Var);
        return id2Var;
    }
}
