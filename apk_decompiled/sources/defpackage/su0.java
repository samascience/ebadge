package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class su0 implements w81 {
    private final hw0 b;
    private final URL c;
    private final String d;
    private String e;
    private URL f;
    private volatile byte[] g;
    private int h;

    public su0(URL url) {
        this(url, hw0.b);
    }

    private byte[] b() {
        if (this.g == null) {
            this.g = a().getBytes(w81.a);
        }
        return this.g;
    }

    private String d() {
        if (TextUtils.isEmpty(this.e)) {
            String string = this.d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) z42.d(this.c)).toString();
            }
            this.e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.e;
    }

    private URL e() {
        if (this.f == null) {
            this.f = new URL(d());
        }
        return this.f;
    }

    public String a() {
        String str = this.d;
        return str != null ? str : ((URL) z42.d(this.c)).toString();
    }

    public Map c() {
        return this.b.getHeaders();
    }

    @Override // defpackage.w81
    public boolean equals(Object obj) {
        if (!(obj instanceof su0)) {
            return false;
        }
        su0 su0Var = (su0) obj;
        return a().equals(su0Var.a()) && this.b.equals(su0Var.b);
    }

    public URL f() {
        return e();
    }

    @Override // defpackage.w81
    public int hashCode() {
        if (this.h == 0) {
            int iHashCode = a().hashCode();
            this.h = iHashCode;
            this.h = (iHashCode * 31) + this.b.hashCode();
        }
        return this.h;
    }

    public String toString() {
        return a();
    }

    @Override // defpackage.w81
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(b());
    }

    public su0(String str) {
        this(str, hw0.b);
    }

    public su0(URL url, hw0 hw0Var) {
        this.c = (URL) z42.d(url);
        this.d = null;
        this.b = (hw0) z42.d(hw0Var);
    }

    public su0(String str, hw0 hw0Var) {
        this.c = null;
        this.d = z42.b(str);
        this.b = (hw0) z42.d(hw0Var);
    }
}
