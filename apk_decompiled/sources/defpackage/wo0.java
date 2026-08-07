package defpackage;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class wo0 {

    public static class b {
        private final Uri a;
        private final int b;
        private final int c;
        private final boolean d;
        private final int e;

        public b(Uri uri, int i, int i2, boolean z, int i3) {
            this.a = (Uri) b52.g(uri);
            this.b = i;
            this.c = i2;
            this.d = z;
            this.e = i3;
        }

        static b a(Uri uri, int i, int i2, boolean z, int i3) {
            return new b(uri, i, i2, z, i3);
        }

        public int b() {
            return this.e;
        }

        public int c() {
            return this.b;
        }

        public Uri d() {
            return this.a;
        }

        public int e() {
            return this.c;
        }

        public boolean f() {
            return this.d;
        }
    }

    public static class c {
        public abstract void a(int i);

        public abstract void b(Typeface typeface);
    }

    public static Typeface a(Context context, CancellationSignal cancellationSignal, b[] bVarArr) {
        return h73.b(context, cancellationSignal, bVarArr, 0);
    }

    public static a b(Context context, CancellationSignal cancellationSignal, po0 po0Var) {
        return oo0.e(context, g73.a(new Object[]{po0Var}), cancellationSignal);
    }

    public static Typeface c(Context context, List list, int i, boolean z, int i2, Handler handler, c cVar) {
        hq hqVar = new hq(cVar, gf2.b(handler));
        if (!z) {
            return to0.d(context, list, i, null, hqVar);
        }
        if (list.size() <= 1) {
            return to0.e(context, (po0) list.get(0), hqVar, i, i2);
        }
        throw new IllegalArgumentException("Fallbacks with blocking fetches are not supported for performance reasons");
    }

    public static class a {
        private final int a;
        private final List b;

        public a(int i, b[] bVarArr) {
            this.a = i;
            this.b = Collections.singletonList(bVarArr);
        }

        static a a(int i, List list) {
            return new a(i, list);
        }

        static a b(int i, b[] bVarArr) {
            return new a(i, bVarArr);
        }

        public b[] c() {
            return (b[]) this.b.get(0);
        }

        public List d() {
            return this.b;
        }

        public int e() {
            return this.a;
        }

        boolean f() {
            return this.b.size() > 1;
        }

        a(int i, List list) {
            this.a = i;
            this.b = list;
        }
    }
}
