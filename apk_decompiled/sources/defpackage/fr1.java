package defpackage;

import android.util.Pair;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.c0;
import androidx.camera.core.v;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
public class fr1 implements x01 {
    private final x01 a;
    private k72 b;

    fr1(x01 x01Var) {
        this.a = x01Var;
    }

    private v k(v vVar) {
        if (vVar == null) {
            return null;
        }
        vz2 vz2VarB = this.b == null ? vz2.b() : vz2.a(new Pair(this.b.i(), this.b.h().get(0)));
        this.b = null;
        return new c0(vVar, new Size(vVar.getWidth(), vVar.getHeight()), new ds(new fg3(vz2VarB, vVar.h0().c())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void l(x01.a aVar, x01 x01Var) {
        aVar.a(this);
    }

    @Override // defpackage.x01
    public Surface a() {
        return this.a.a();
    }

    @Override // defpackage.x01
    public v c() {
        return k(this.a.c());
    }

    @Override // defpackage.x01
    public void close() {
        this.a.close();
    }

    @Override // defpackage.x01
    public int d() {
        return this.a.d();
    }

    @Override // defpackage.x01
    public void e() {
        this.a.e();
    }

    @Override // defpackage.x01
    public void f(final x01.a aVar, Executor executor) {
        this.a.f(new x01.a() { // from class: er1
            @Override // x01.a
            public final void a(x01 x01Var) {
                this.a.l(aVar, x01Var);
            }
        }, executor);
    }

    @Override // defpackage.x01
    public int g() {
        return this.a.g();
    }

    @Override // defpackage.x01
    public int getHeight() {
        return this.a.getHeight();
    }

    @Override // defpackage.x01
    public int getWidth() {
        return this.a.getWidth();
    }

    @Override // defpackage.x01
    public v h() {
        return k(this.a.h());
    }

    void i(k72 k72Var) {
        b52.j(this.b == null, "Pending request should be null");
        this.b = k72Var;
    }

    void j() {
        this.b = null;
    }
}
