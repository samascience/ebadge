package defpackage;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
public class r11 {
    private Fragment a;
    private q11 b;
    private boolean c;
    private boolean d;
    private boolean e;

    /* JADX WARN: Multi-variable type inference failed */
    public r11(Fragment fragment) {
        this.a = fragment;
        if (!(fragment instanceof q11)) {
            throw new IllegalArgumentException("Fragment请实现ImmersionOwner接口");
        }
        this.b = (q11) fragment;
    }

    public void a(Bundle bundle) {
        this.c = true;
        Fragment fragment = this.a;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        if (this.b.b()) {
            this.b.a();
        }
        if (this.d) {
            return;
        }
        this.b.e();
        this.d = true;
    }

    public void b(Configuration configuration) {
        Fragment fragment = this.a;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        if (this.b.b()) {
            this.b.a();
        }
        this.b.i();
    }

    public void c(Bundle bundle) {
        Fragment fragment = this.a;
        if (fragment == null || !fragment.getUserVisibleHint() || this.e) {
            return;
        }
        this.b.k();
        this.e = true;
    }

    public void d() {
        this.a = null;
        this.b = null;
    }

    public void e(boolean z) {
        Fragment fragment = this.a;
        if (fragment != null) {
            fragment.setUserVisibleHint(!z);
        }
    }

    public void f() {
        if (this.a != null) {
            this.b.j();
        }
    }

    public void g() {
        Fragment fragment = this.a;
        if (fragment == null || !fragment.getUserVisibleHint()) {
            return;
        }
        this.b.i();
    }

    public void h(boolean z) {
        Fragment fragment = this.a;
        if (fragment != null) {
            if (!fragment.getUserVisibleHint()) {
                if (this.c) {
                    this.b.j();
                    return;
                }
                return;
            }
            if (!this.e) {
                this.b.k();
                this.e = true;
            }
            if (this.c && this.a.getUserVisibleHint()) {
                if (this.b.b()) {
                    this.b.a();
                }
                if (!this.d) {
                    this.b.e();
                    this.d = true;
                }
                this.b.i();
            }
        }
    }
}
