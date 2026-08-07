package defpackage;

import com.google.zxing.NotFoundException;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes3.dex */
public final class th {
    private final sh a;
    private wh b;

    public th(sh shVar) {
        if (shVar == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.a = shVar;
    }

    public wh a() {
        if (this.b == null) {
            this.b = this.a.b();
        }
        return this.b;
    }

    public uh b(int i, uh uhVar) {
        return this.a.c(i, uhVar);
    }

    public int c() {
        return this.a.d();
    }

    public int d() {
        return this.a.f();
    }

    public boolean e() {
        return this.a.e().e();
    }

    public th f() {
        return new th(this.a.a(this.a.e().f()));
    }

    public String toString() {
        try {
            return a().toString();
        } catch (NotFoundException unused) {
            return Constants.STR_EMPTY;
        }
    }
}
