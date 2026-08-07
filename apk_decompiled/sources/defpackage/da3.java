package defpackage;

import android.net.Uri;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class da3 implements rk1 {
    private static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    private final rk1 a;

    public static class a implements sk1 {
        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new da3(zl1Var.d(su0.class, InputStream.class));
        }
    }

    public da3(rk1 rk1Var) {
        this.a = rk1Var;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(Uri uri, int i, int i2, rx1 rx1Var) {
        return this.a.b(new su0(uri.toString()), i, i2, rx1Var);
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
