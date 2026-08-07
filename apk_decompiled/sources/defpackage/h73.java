package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.Handler;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class h73 {
    private static final m73 a;
    private static final af1 b;

    public static class a extends wo0.c {
        private bh2.e a;

        public a(bh2.e eVar) {
            this.a = eVar;
        }

        @Override // wo0.c
        public void a(int i) {
            bh2.e eVar = this.a;
            if (eVar != null) {
                eVar.f(i);
            }
        }

        @Override // wo0.c
        public void b(Typeface typeface) {
            bh2.e eVar = this.a;
            if (eVar != null) {
                eVar.g(typeface);
            }
        }
    }

    static {
        l43.a("TypefaceCompat static init");
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            a = new l73();
        } else if (i >= 28) {
            a = new k73();
        } else {
            a = new j73();
        }
        b = new af1(16);
        l43.b();
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    public static Typeface b(Context context, CancellationSignal cancellationSignal, wo0.b[] bVarArr, int i) {
        l43.a("TypefaceCompat.createFromFontInfo");
        try {
            return a.b(context, cancellationSignal, bVarArr, i);
        } finally {
            l43.b();
        }
    }

    public static Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i) {
        l43.a("TypefaceCompat.createFromFontInfoWithFallback");
        try {
            return a.c(context, cancellationSignal, list, i);
        } finally {
            l43.b();
        }
    }

    public static Typeface d(Context context, uo0.b bVar, Resources resources, int i, String str, int i2, int i3, bh2.e eVar, Handler handler, boolean z) {
        Typeface typefaceA;
        if (bVar instanceof uo0.e) {
            uo0.e eVar2 = (uo0.e) bVar;
            Typeface typefaceH = h(eVar2.d());
            if (typefaceH != null) {
                if (eVar != null) {
                    eVar.d(typefaceH, handler);
                }
                return typefaceH;
            }
            typefaceA = wo0.c(context, eVar2.a() != null ? g73.a(new Object[]{eVar2.c(), eVar2.a()}) : g73.a(new Object[]{eVar2.c()}), i3, !z ? eVar != null : eVar2.b() != 0, z ? eVar2.e() : -1, bh2.e.e(handler), new a(eVar));
        } else {
            typefaceA = a.a(context, (uo0.c) bVar, resources, i3);
            if (eVar != null) {
                if (typefaceA != null) {
                    eVar.d(typefaceA, handler);
                } else {
                    eVar.c(-3, handler);
                }
            }
        }
        if (typefaceA != null) {
            b.d(f(resources, i, str, i2, i3), typefaceA);
        }
        return typefaceA;
    }

    public static Typeface e(Context context, Resources resources, int i, String str, int i2, int i3) {
        Typeface typefaceD = a.d(context, resources, i, str, i3);
        if (typefaceD != null) {
            b.d(f(resources, i, str, i2, i3), typefaceD);
        }
        return typefaceD;
    }

    private static String f(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    public static Typeface g(Resources resources, int i, String str, int i2, int i3) {
        return (Typeface) b.c(f(resources, i, str, i2, i3));
    }

    private static Typeface h(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
