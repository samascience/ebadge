package defpackage;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;

/* JADX INFO: loaded from: classes.dex */
public class z71 extends h71 {
    protected final z71 c;
    protected ae0 d;
    protected z71 e;
    protected String f;
    protected Object g;
    protected boolean h;

    protected z71(int i, z71 z71Var, ae0 ae0Var) {
        this.a = i;
        this.c = z71Var;
        this.d = ae0Var;
        this.b = -1;
    }

    private final void n(ae0 ae0Var, String str) throws JsonGenerationException {
        if (ae0Var.c(str)) {
            Object objB = ae0Var.b();
            throw new JsonGenerationException("Duplicate field '" + str + "'", objB instanceof JsonGenerator ? (JsonGenerator) objB : null);
        }
    }

    public static z71 t(ae0 ae0Var) {
        return new z71(0, null, ae0Var);
    }

    public int A() {
        int i = this.a;
        if (i == 2) {
            if (!this.h) {
                return 5;
            }
            this.h = false;
            this.b++;
            return 2;
        }
        if (i == 1) {
            int i2 = this.b;
            this.b = i2 + 1;
            return i2 < 0 ? 0 : 1;
        }
        int i3 = this.b + 1;
        this.b = i3;
        return i3 == 0 ? 0 : 3;
    }

    @Override // defpackage.h71
    public final String b() {
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

    public z71 o() {
        this.g = null;
        return this.c;
    }

    public z71 p() {
        z71 z71Var = this.e;
        if (z71Var != null) {
            return z71Var.w(1);
        }
        ae0 ae0Var = this.d;
        z71 z71Var2 = new z71(1, this, ae0Var == null ? null : ae0Var.a());
        this.e = z71Var2;
        return z71Var2;
    }

    public z71 q(Object obj) {
        z71 z71Var = this.e;
        if (z71Var != null) {
            return z71Var.x(1, obj);
        }
        ae0 ae0Var = this.d;
        z71 z71Var2 = new z71(1, this, ae0Var == null ? null : ae0Var.a(), obj);
        this.e = z71Var2;
        return z71Var2;
    }

    public z71 r() {
        z71 z71Var = this.e;
        if (z71Var != null) {
            return z71Var.w(2);
        }
        ae0 ae0Var = this.d;
        z71 z71Var2 = new z71(2, this, ae0Var == null ? null : ae0Var.a());
        this.e = z71Var2;
        return z71Var2;
    }

    public z71 s(Object obj) {
        z71 z71Var = this.e;
        if (z71Var != null) {
            return z71Var.x(2, obj);
        }
        ae0 ae0Var = this.d;
        z71 z71Var2 = new z71(2, this, ae0Var == null ? null : ae0Var.a(), obj);
        this.e = z71Var2;
        return z71Var2;
    }

    public ae0 u() {
        return this.d;
    }

    @Override // defpackage.h71
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public final z71 e() {
        return this.c;
    }

    public z71 w(int i) {
        this.a = i;
        this.b = -1;
        this.f = null;
        this.h = false;
        this.g = null;
        ae0 ae0Var = this.d;
        if (ae0Var != null) {
            ae0Var.d();
        }
        return this;
    }

    public z71 x(int i, Object obj) {
        this.a = i;
        this.b = -1;
        this.f = null;
        this.h = false;
        this.g = obj;
        ae0 ae0Var = this.d;
        if (ae0Var != null) {
            ae0Var.d();
        }
        return this;
    }

    public z71 y(ae0 ae0Var) {
        this.d = ae0Var;
        return this;
    }

    public int z(String str) throws JsonGenerationException {
        if (this.a != 2 || this.h) {
            return 4;
        }
        this.h = true;
        this.f = str;
        ae0 ae0Var = this.d;
        if (ae0Var != null) {
            n(ae0Var, str);
        }
        return this.b < 0 ? 0 : 1;
    }

    protected z71(int i, z71 z71Var, ae0 ae0Var, Object obj) {
        this.a = i;
        this.c = z71Var;
        this.d = ae0Var;
        this.b = -1;
        this.g = obj;
    }
}
