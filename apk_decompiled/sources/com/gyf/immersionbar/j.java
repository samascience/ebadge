package com.gyf.immersionbar;

import android.app.Activity;
import android.content.res.Configuration;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes3.dex */
class j implements Runnable {
    private h a;
    private c b;
    private int c;

    j(Object obj) {
        if (obj instanceof Activity) {
            if (this.a == null) {
                this.a = new h((Activity) obj);
                return;
            }
            return;
        }
        if (obj instanceof Fragment) {
            if (this.a == null) {
                if (obj instanceof DialogFragment) {
                    this.a = new h((DialogFragment) obj);
                    return;
                } else {
                    this.a = new h((Fragment) obj);
                    return;
                }
            }
            return;
        }
        if ((obj instanceof android.app.Fragment) && this.a == null) {
            if (obj instanceof android.app.DialogFragment) {
                this.a = new h((android.app.DialogFragment) obj);
            } else {
                this.a = new h((android.app.Fragment) obj);
            }
        }
    }

    private void a(Configuration configuration) {
        h hVar = this.a;
        if (hVar == null || !hVar.K()) {
            return;
        }
        this.a.u().getClass();
    }

    public h b() {
        return this.a;
    }

    void c(Configuration configuration) {
        a(configuration);
    }

    void d(Configuration configuration) {
        h hVar = this.a;
        if (hVar != null) {
            hVar.S(configuration);
            a(configuration);
        }
    }

    void e() {
        h hVar = this.a;
        if (hVar != null) {
            hVar.T();
            this.a = null;
        }
    }

    void f() {
        h hVar = this.a;
        if (hVar != null) {
            hVar.U();
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        h hVar = this.a;
        if (hVar == null || hVar.s() == null) {
            return;
        }
        Activity activityS = this.a.s();
        a aVar = new a(activityS);
        this.b.g(aVar.j());
        this.b.b(aVar.l());
        this.b.c(aVar.d());
        this.b.d(aVar.g());
        this.b.a(aVar.a());
        boolean zHasNotchScreen = NotchUtils.hasNotchScreen(activityS);
        this.b.f(zHasNotchScreen);
        if (zHasNotchScreen && this.c == 0) {
            int notchHeight = NotchUtils.getNotchHeight(activityS);
            this.c = notchHeight;
            this.b.e(notchHeight);
        }
        throw null;
    }
}
