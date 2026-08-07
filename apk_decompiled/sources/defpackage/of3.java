package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
abstract class of3 {
    private static final sf3 a;
    static final Property b;
    static final Property c;

    class a extends Property {
        a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(View view) {
            return Float.valueOf(of3.b(view));
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Float f) {
            of3.e(view, f.floatValue());
        }
    }

    class b extends Property {
        b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Rect get(View view) {
            return view.getClipBounds();
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, Rect rect) {
            view.setClipBounds(rect);
        }
    }

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            a = new bg3();
        } else {
            a = new ag3();
        }
        b = new a(Float.class, "translationAlpha");
        c = new b(Rect.class, "clipBounds");
    }

    static void a(View view) {
        a.a(view);
    }

    static float b(View view) {
        return a.b(view);
    }

    static void c(View view) {
        a.c(view);
    }

    static void d(View view, int i, int i2, int i3, int i4) {
        a.d(view, i, i2, i3, i4);
    }

    static void e(View view, float f) {
        a.e(view, f);
    }

    static void f(View view, int i) {
        a.f(view, i);
    }

    static void g(View view, Matrix matrix) {
        a.g(view, matrix);
    }

    static void h(View view, Matrix matrix) {
        a.h(view, matrix);
    }
}
