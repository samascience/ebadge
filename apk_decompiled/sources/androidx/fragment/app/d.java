package androidx.fragment.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import defpackage.b52;

/* JADX INFO: loaded from: classes.dex */
public class d {
    private final f a;

    private d(f fVar) {
        this.a = fVar;
    }

    public static d b(f fVar) {
        return new d((f) b52.h(fVar, "callbacks == null"));
    }

    public void a(Fragment fragment) {
        f fVar = this.a;
        fVar.e.n(fVar, fVar, fragment);
    }

    public void c() {
        this.a.e.y();
    }

    public boolean d(MenuItem menuItem) {
        return this.a.e.B(menuItem);
    }

    public void e() {
        this.a.e.C();
    }

    public void f() {
        this.a.e.E();
    }

    public void g() {
        this.a.e.N();
    }

    public void h() {
        this.a.e.R();
    }

    public void i() {
        this.a.e.S();
    }

    public void j() {
        this.a.e.U();
    }

    public boolean k() {
        return this.a.e.b0(true);
    }

    public FragmentManager l() {
        return this.a.e;
    }

    public void m() {
        this.a.e.Z0();
    }

    public View n(View view, String str, Context context, AttributeSet attributeSet) {
        return this.a.e.w0().onCreateView(view, str, context, attributeSet);
    }
}
