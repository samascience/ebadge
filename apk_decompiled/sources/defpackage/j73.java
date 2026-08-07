package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class j73 extends i73 {
    protected final Class g;
    protected final Constructor h;
    protected final Method i;
    protected final Method j;
    protected final Method k;
    protected final Method l;
    protected final Method m;

    public j73() {
        Class clsU;
        Constructor constructorV;
        Method methodR;
        Method methodS;
        Method methodW;
        Method methodQ;
        Method methodT;
        try {
            clsU = u();
            constructorV = v(clsU);
            methodR = r(clsU);
            methodS = s(clsU);
            methodW = w(clsU);
            methodQ = q(clsU);
            methodT = t(clsU);
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + e.getClass().getName(), e);
            clsU = null;
            constructorV = null;
            methodR = null;
            methodS = null;
            methodW = null;
            methodQ = null;
            methodT = null;
        }
        this.g = clsU;
        this.h = constructorV;
        this.i = methodR;
        this.j = methodS;
        this.k = methodW;
        this.l = methodQ;
        this.m = methodT;
    }

    private Object k() {
        try {
            return this.h.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    private void l(Object obj) {
        try {
            this.l.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    private boolean m(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean n(Object obj, ByteBuffer byteBuffer, int i, int i2, int i3) {
        try {
            return ((Boolean) this.j.invoke(obj, byteBuffer, Integer.valueOf(i), null, Integer.valueOf(i2), Integer.valueOf(i3))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean o(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    private boolean p() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    @Override // defpackage.i73, defpackage.m73
    public Typeface a(Context context, uo0.c cVar, Resources resources, int i) {
        if (!p()) {
            return super.a(context, cVar, resources, i);
        }
        Object objK = k();
        if (objK == null) {
            return null;
        }
        for (uo0.d dVar : cVar.a()) {
            if (!m(context, objK, dVar.a(), dVar.c(), dVar.e(), dVar.f() ? 1 : 0, FontVariationAxis.fromFontVariationSettings(dVar.d()))) {
                l(objK);
                return null;
            }
        }
        if (o(objK)) {
            return i(objK);
        }
        return null;
    }

    @Override // defpackage.m73
    public Typeface b(Context context, CancellationSignal cancellationSignal, wo0.b[] bVarArr, int i) {
        Typeface typefaceI;
        if (bVarArr.length < 1) {
            return null;
        }
        if (!p()) {
            wo0.b bVarG = g(bVarArr, i);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(bVarG.d(), "r", cancellationSignal);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(bVarG.e()).setItalic(bVarG.f()).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } catch (Throwable th) {
                    try {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } catch (IOException unused) {
                return null;
            }
        }
        Map mapF = n73.f(context, bVarArr, cancellationSignal);
        Object objK = k();
        if (objK == null) {
            return null;
        }
        boolean z = false;
        for (wo0.b bVar : bVarArr) {
            ByteBuffer byteBuffer = (ByteBuffer) mapF.get(bVar.d());
            if (byteBuffer != null) {
                if (!n(objK, byteBuffer, bVar.c(), bVar.e(), bVar.f() ? 1 : 0)) {
                    l(objK);
                    return null;
                }
                z = true;
            }
        }
        if (!z) {
            l(objK);
            return null;
        }
        if (o(objK) && (typefaceI = i(objK)) != null) {
            return Typeface.create(typefaceI, i);
        }
        return null;
    }

    @Override // defpackage.m73
    public /* bridge */ /* synthetic */ Typeface c(Context context, CancellationSignal cancellationSignal, List list, int i) {
        return super.c(context, cancellationSignal, list, i);
    }

    @Override // defpackage.m73
    public Typeface d(Context context, Resources resources, int i, String str, int i2) {
        if (!p()) {
            return super.d(context, resources, i, str, i2);
        }
        Object objK = k();
        if (objK == null) {
            return null;
        }
        if (!m(context, objK, str, 0, -1, -1, null)) {
            l(objK);
            return null;
        }
        if (o(objK)) {
            return i(objK);
        }
        return null;
    }

    protected Typeface i(Object obj) {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.g, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.m.invoke(null, objNewInstance, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return null;
        }
    }

    protected Method q(Class cls) {
        return cls.getMethod("abortCreation", null);
    }

    protected Method r(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    protected Method s(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    protected Method t(Class cls) throws NoSuchMethodException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }

    protected Class u() {
        return Class.forName("android.graphics.FontFamily");
    }

    protected Constructor v(Class cls) {
        return cls.getConstructor(null);
    }

    protected Method w(Class cls) {
        return cls.getMethod("freeze", null);
    }
}
