package defpackage;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes4.dex */
public class gw2 implements md1 {
    Level a;
    List b;
    String c;
    ew2 d;
    String e;
    String f;
    Object[] g;
    long h;
    Throwable i;

    @Override // defpackage.md1
    public String a() {
        return this.f;
    }

    @Override // defpackage.md1
    public Object[] b() {
        return this.g;
    }

    @Override // defpackage.md1
    public Level c() {
        return this.a;
    }

    @Override // defpackage.md1
    public List d() {
        return this.b;
    }

    @Override // defpackage.md1
    public Throwable e() {
        return this.i;
    }

    public void f(Marker marker) {
        if (marker == null) {
            return;
        }
        if (this.b == null) {
            this.b = new ArrayList(2);
        }
        this.b.add(marker);
    }

    public ew2 g() {
        return this.d;
    }

    public void h(Object[] objArr) {
        this.g = objArr;
    }

    public void i(Level level) {
        this.a = level;
    }

    public void j(ew2 ew2Var) {
        this.d = ew2Var;
    }

    public void k(String str) {
        this.c = str;
    }

    public void l(String str) {
        this.f = str;
    }

    public void m(String str) {
        this.e = str;
    }

    public void n(Throwable th) {
        this.i = th;
    }

    public void o(long j) {
        this.h = j;
    }
}
