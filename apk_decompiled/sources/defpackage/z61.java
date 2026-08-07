package defpackage;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.ContentReference;

/* JADX INFO: loaded from: classes.dex */
public final class z61 extends h71 {
    protected final z61 c;
    protected ae0 d;
    protected z61 e;
    protected String f;
    protected Object g;
    protected int h;
    protected int i;

    public z61(z61 z61Var, ae0 ae0Var, int i, int i2, int i3) {
        this.c = z61Var;
        this.d = ae0Var;
        this.a = i;
        this.h = i2;
        this.i = i3;
        this.b = -1;
    }

    private void n(ae0 ae0Var, String str) throws JsonParseException {
        if (ae0Var.c(str)) {
            Object objB = ae0Var.b();
            throw new JsonParseException(objB instanceof JsonParser ? (JsonParser) objB : null, "Duplicate field '" + str + "'");
        }
    }

    public static z61 r(ae0 ae0Var) {
        return new z61(null, ae0Var, 0, 1, 0);
    }

    @Override // defpackage.h71
    public String b() {
        return this.f;
    }

    @Override // defpackage.h71
    public Object c() {
        return this.g;
    }

    @Override // defpackage.h71
    public boolean g() {
        return this.f != null;
    }

    @Override // defpackage.h71
    public void l(Object obj) {
        this.g = obj;
    }

    public z61 o() {
        this.g = null;
        return this.c;
    }

    public z61 p(int i, int i2) {
        z61 z61Var = this.e;
        if (z61Var == null) {
            ae0 ae0Var = this.d;
            z61Var = new z61(this, ae0Var == null ? null : ae0Var.a(), 1, i, i2);
            this.e = z61Var;
        } else {
            z61Var.v(1, i, i2);
        }
        return z61Var;
    }

    public z61 q(int i, int i2) {
        z61 z61Var = this.e;
        if (z61Var != null) {
            z61Var.v(2, i, i2);
            return z61Var;
        }
        ae0 ae0Var = this.d;
        z61 z61Var2 = new z61(this, ae0Var == null ? null : ae0Var.a(), 2, i, i2);
        this.e = z61Var2;
        return z61Var2;
    }

    public boolean s() {
        int i = this.b + 1;
        this.b = i;
        return this.a != 0 && i > 0;
    }

    public ae0 t() {
        return this.d;
    }

    @Override // defpackage.h71
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public z61 e() {
        return this.c;
    }

    public void v(int i, int i2, int i3) {
        this.a = i;
        this.b = -1;
        this.h = i2;
        this.i = i3;
        this.f = null;
        this.g = null;
        ae0 ae0Var = this.d;
        if (ae0Var != null) {
            ae0Var.d();
        }
    }

    public void w(String str) throws JsonParseException {
        this.f = str;
        ae0 ae0Var = this.d;
        if (ae0Var != null) {
            n(ae0Var, str);
        }
    }

    public JsonLocation x(ContentReference contentReference) {
        return new JsonLocation(contentReference, -1L, this.h, this.i);
    }

    public z61 y(ae0 ae0Var) {
        this.d = ae0Var;
        return this;
    }
}
