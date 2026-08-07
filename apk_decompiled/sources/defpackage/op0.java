package defpackage;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public class op0 extends h33 {
    private h33 f;

    public op0(h33 h33Var) {
        p31.f(h33Var, "delegate");
        this.f = h33Var;
    }

    @Override // defpackage.h33
    public h33 a() {
        return this.f.a();
    }

    @Override // defpackage.h33
    public h33 b() {
        return this.f.b();
    }

    @Override // defpackage.h33
    public long c() {
        return this.f.c();
    }

    @Override // defpackage.h33
    public h33 d(long j) {
        return this.f.d(j);
    }

    @Override // defpackage.h33
    public boolean e() {
        return this.f.e();
    }

    @Override // defpackage.h33
    public void f() throws InterruptedIOException {
        this.f.f();
    }

    @Override // defpackage.h33
    public h33 g(long j, TimeUnit timeUnit) {
        p31.f(timeUnit, "unit");
        return this.f.g(j, timeUnit);
    }

    @Override // defpackage.h33
    public long h() {
        return this.f.h();
    }

    public final h33 i() {
        return this.f;
    }

    public final op0 j(h33 h33Var) {
        p31.f(h33Var, "delegate");
        this.f = h33Var;
        return this;
    }
}
