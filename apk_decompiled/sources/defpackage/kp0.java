package defpackage;

import androidx.camera.core.impl.Timebase;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public abstract class kp0 implements zt {
    private final zt a;

    public kp0(zt ztVar) {
        this.a = ztVar;
    }

    @Override // defpackage.yt
    public int a() {
        return this.a.a();
    }

    @Override // defpackage.zt
    public Set b() {
        return this.a.b();
    }

    @Override // defpackage.zt
    public boolean c() {
        return this.a.c();
    }

    @Override // defpackage.zt
    public String d() {
        return this.a.d();
    }

    @Override // defpackage.zt
    public zt e() {
        return this.a.e();
    }

    @Override // defpackage.yt
    public int f() {
        return this.a.f();
    }

    @Override // defpackage.zt
    public void g(Executor executor, as asVar) {
        this.a.g(executor, asVar);
    }

    @Override // defpackage.zt
    public Timebase h() {
        return this.a.h();
    }

    @Override // defpackage.yt
    public String i() {
        return this.a.i();
    }

    @Override // defpackage.zt
    public List j(int i) {
        return this.a.j(i);
    }

    @Override // defpackage.yt
    public int k(int i) {
        return this.a.k(i);
    }

    @Override // defpackage.zt
    public dh0 l() {
        return this.a.l();
    }

    @Override // defpackage.zt
    public w92 m() {
        return this.a.m();
    }

    @Override // defpackage.zt
    public List n(int i) {
        return this.a.n(i);
    }

    @Override // defpackage.zt
    public void o(as asVar) {
        this.a.o(asVar);
    }
}
