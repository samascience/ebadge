package defpackage;

import android.content.Context;
import android.net.Uri;

/* JADX INFO: loaded from: classes.dex */
public class ai1 implements rk1 {
    private final Context a;

    public static class a implements sk1 {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new ai1(this.a);
        }
    }

    public ai1(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(Uri uri, int i, int i2, rx1 rx1Var) {
        if (ci1.d(i, i2)) {
            return new rk1.a(new nt1(uri), y23.f(this.a, uri));
        }
        return null;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return ci1.a(uri);
    }
}
