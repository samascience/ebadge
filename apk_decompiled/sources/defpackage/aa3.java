package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class aa3 implements rk1 {
    private static final Set b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));
    private final c a;

    public static final class a implements sk1, c {
        private final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // aa3.c
        public y50 a(Uri uri) {
            return new ua(this.a, uri);
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new aa3(this);
        }
    }

    public static class b implements sk1, c {
        private final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // aa3.c
        public y50 a(Uri uri) {
            return new gm0(this.a, uri);
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new aa3(this);
        }
    }

    public interface c {
        y50 a(Uri uri);
    }

    public static class d implements sk1, c {
        private final ContentResolver a;

        public d(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // aa3.c
        public y50 a(Uri uri) {
            return new bv2(this.a, uri);
        }

        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new aa3(this);
        }
    }

    public aa3(c cVar) {
        this.a = cVar;
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(Uri uri, int i, int i2, rx1 rx1Var) {
        return new rk1.a(new nt1(uri), this.a.a(uri));
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
