package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.io.File;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
abstract class m73 {
    private ConcurrentHashMap a = new ConcurrentHashMap();

    class a implements b {
        a() {
        }

        @Override // m73.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public int a(wo0.b bVar) {
            return bVar.e();
        }

        @Override // m73.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean b(wo0.b bVar) {
            return bVar.f();
        }
    }

    private interface b {
        int a(Object obj);

        boolean b(Object obj);
    }

    m73() {
    }

    private static Object e(Object[] objArr, int i, b bVar) {
        return f(objArr, (i & 1) == 0 ? 400 : 700, (i & 2) != 0, bVar);
    }

    private static Object f(Object[] objArr, int i, boolean z, b bVar) {
        Object obj = null;
        int i2 = Integer.MAX_VALUE;
        for (Object obj2 : objArr) {
            int iAbs = (Math.abs(bVar.a(obj2) - i) * 2) + (bVar.b(obj2) == z ? 0 : 1);
            if (obj == null || i2 > iAbs) {
                obj = obj2;
                i2 = iAbs;
            }
        }
        return obj;
    }

    public abstract Typeface a(Context context, uo0.c cVar, Resources resources, int i);

    public abstract Typeface b(Context context, CancellationSignal cancellationSignal, wo0.b[] bVarArr, int i);

    public Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        File fileD = n73.d(context);
        if (fileD == null) {
            return null;
        }
        try {
            if (n73.b(fileD, resources, i)) {
                return Typeface.createFromFile(fileD.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileD.delete();
        }
    }

    protected wo0.b g(wo0.b[] bVarArr, int i) {
        return (wo0.b) e(bVarArr, i, new a());
    }
}
