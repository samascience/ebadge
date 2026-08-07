package defpackage;

import java.io.InputStream;
import java.net.URL;

/* JADX INFO: loaded from: classes.dex */
public class ca3 implements rk1 {
    private final rk1 a;

    public static class a implements sk1 {
        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new ca3(zl1Var.d(su0.class, InputStream.class));
        }
    }

    public ca3(rk1 rk1Var) {
        this.a = rk1Var;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(URL url, int i, int i2, rx1 rx1Var) {
        return this.a.b(new su0(url), i, i2, rx1Var);
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(URL url) {
        return true;
    }
}
