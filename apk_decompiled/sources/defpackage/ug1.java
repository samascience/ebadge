package defpackage;

import android.graphics.drawable.Drawable;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public abstract class ug1 {
    static m40 a(int i) {
        if (i != 0) {
            return i != 1 ? b() : new p50();
        }
        return new ii2();
    }

    static m40 b() {
        return new ii2();
    }

    static ef0 c() {
        return new ef0();
    }

    public static void d(View view, float f) {
        Drawable background = view.getBackground();
        if (background instanceof tg1) {
            ((tg1) background).a0(f);
        }
    }

    public static void e(View view) {
        Drawable background = view.getBackground();
        if (background instanceof tg1) {
            f(view, (tg1) background);
        }
    }

    public static void f(View view, tg1 tg1Var) {
        if (tg1Var.S()) {
            tg1Var.f0(nf3.m(view));
        }
    }
}
