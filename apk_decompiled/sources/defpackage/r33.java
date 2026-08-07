package defpackage;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.io.ContentReference;

/* JADX INFO: loaded from: classes.dex */
public class r33 extends h71 {
    protected final h71 c;
    protected final JsonLocation d;
    protected String e;
    protected Object f;

    protected r33(h71 h71Var, ContentReference contentReference) {
        super(h71Var);
        this.c = h71Var.e();
        this.e = h71Var.b();
        this.f = h71Var.c();
        if (h71Var instanceof z61) {
            this.d = ((z61) h71Var).x(contentReference);
        } else {
            this.d = JsonLocation.NA;
        }
    }

    public static r33 p(h71 h71Var) {
        return h71Var == null ? new r33() : new r33(h71Var, ContentReference.unknown());
    }

    @Override // defpackage.h71
    public String b() {
        return this.e;
    }

    @Override // defpackage.h71
    public Object c() {
        return this.f;
    }

    @Override // defpackage.h71
    public h71 e() {
        return this.c;
    }

    @Override // defpackage.h71
    public boolean g() {
        return this.e != null;
    }

    @Override // defpackage.h71
    public void l(Object obj) {
        this.f = obj;
    }

    public r33 n() {
        this.b++;
        return new r33(this, 1, -1);
    }

    public r33 o() {
        this.b++;
        return new r33(this, 2, -1);
    }

    public r33 q() {
        h71 h71Var = this.c;
        if (h71Var instanceof r33) {
            return (r33) h71Var;
        }
        return h71Var == null ? new r33() : new r33(h71Var, this.d);
    }

    public void r(String str) {
        this.e = str;
    }

    public void s() {
        this.b++;
    }

    protected r33(h71 h71Var, JsonLocation jsonLocation) {
        super(h71Var);
        this.c = h71Var.e();
        this.e = h71Var.b();
        this.f = h71Var.c();
        this.d = jsonLocation;
    }

    protected r33() {
        super(0, -1);
        this.c = null;
        this.d = JsonLocation.NA;
    }

    protected r33(r33 r33Var, int i, int i2) {
        super(i, i2);
        this.c = r33Var;
        this.d = r33Var.d;
    }
}
