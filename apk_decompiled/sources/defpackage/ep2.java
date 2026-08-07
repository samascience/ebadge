package defpackage;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
public class ep2 {
    private Fragment a;
    private dp2 b;
    private boolean c;

    /* JADX WARN: Multi-variable type inference failed */
    public ep2(Fragment fragment) {
        this.a = fragment;
        if (!(fragment instanceof dp2)) {
            throw new IllegalArgumentException("Fragment请实现SimpleImmersionOwner接口");
        }
        this.b = (dp2) fragment;
    }

    private void e() {
        Fragment fragment = this.a;
        if (fragment != null && this.c && fragment.getUserVisibleHint() && this.b.b()) {
            this.b.a();
        }
    }

    public void a(Bundle bundle) {
        this.c = true;
        e();
    }

    public void b(Configuration configuration) {
        e();
    }

    public void c() {
        this.a = null;
        this.b = null;
    }

    public void d(boolean z) {
        Fragment fragment = this.a;
        if (fragment != null) {
            fragment.setUserVisibleHint(!z);
        }
    }

    public void f(boolean z) {
        e();
    }
}
