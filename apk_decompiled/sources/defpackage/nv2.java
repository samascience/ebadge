package defpackage;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class nv2 implements rk1 {
    private final rk1 a;

    public static final class a implements sk1 {
        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new nv2(zl1Var.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    public static class b implements sk1 {
        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new nv2(zl1Var.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    public static class c implements sk1 {
        @Override // defpackage.sk1
        public rk1 b(zl1 zl1Var) {
            return new nv2(zl1Var.d(Uri.class, InputStream.class));
        }
    }

    public nv2(rk1 rk1Var) {
        this.a = rk1Var;
    }

    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? f(str) : uri;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public rk1.a b(String str, int i, int i2, rx1 rx1Var) {
        Uri uriE = e(str);
        if (uriE == null || !this.a.a(uriE)) {
            return null;
        }
        return this.a.b(uriE, i, i2, rx1Var);
    }

    @Override // defpackage.rk1
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(String str) {
        return true;
    }
}
