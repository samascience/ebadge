package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import androidx.appcompat.resources.R$drawable;
import defpackage.af1;
import defpackage.ap2;
import defpackage.dd0;
import defpackage.gb3;
import defpackage.ns2;
import defpackage.q30;
import defpackage.zd1;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes.dex */
public final class w {
    private static w i;
    private WeakHashMap a;
    private ap2 b;
    private ns2 c;
    private final WeakHashMap d = new WeakHashMap(0);
    private TypedValue e;
    private boolean f;
    private c g;
    private static final PorterDuff.Mode h = PorterDuff.Mode.SRC_IN;
    private static final a j = new a(6);

    private static class a extends af1 {
        public a(int i) {
            super(i);
        }

        private static int h(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        PorterDuffColorFilter i(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) c(Integer.valueOf(h(i, mode)));
        }

        PorterDuffColorFilter j(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) d(Integer.valueOf(h(i, mode)), porterDuffColorFilter);
        }
    }

    private interface b {
        Drawable a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    public interface c {
        boolean a(Context context, int i, Drawable drawable);

        PorterDuff.Mode b(int i);

        Drawable c(w wVar, Context context, int i);

        ColorStateList d(Context context, int i);

        boolean e(Context context, int i, Drawable drawable);
    }

    private synchronized boolean a(Context context, long j2, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            zd1 zd1Var = (zd1) this.d.get(context);
            if (zd1Var == null) {
                zd1Var = new zd1();
                this.d.put(context, zd1Var);
            }
            zd1Var.f(j2, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    private void b(Context context, int i2, ColorStateList colorStateList) {
        if (this.a == null) {
            this.a = new WeakHashMap();
        }
        ns2 ns2Var = (ns2) this.a.get(context);
        if (ns2Var == null) {
            ns2Var = new ns2();
            this.a.put(context, ns2Var);
        }
        ns2Var.a(i2, colorStateList);
    }

    private void c(Context context) {
        if (this.f) {
            return;
        }
        this.f = true;
        Drawable drawableI = i(context, R$drawable.abc_vector_test);
        if (drawableI == null || !p(drawableI)) {
            this.f = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }

    private static long d(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    private Drawable e(Context context, int i2) {
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        context.getResources().getValue(i2, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        c cVar = this.g;
        Drawable drawableC = cVar == null ? null : cVar.c(this, context, i2);
        if (drawableC != null) {
            drawableC.setChangingConfigurations(typedValue.changingConfigurations);
            a(context, jD, drawableC);
        }
        return drawableC;
    }

    private static PorterDuffColorFilter f(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return k(colorStateList.getColorForState(iArr, 0), mode);
    }

    public static synchronized w g() {
        try {
            if (i == null) {
                w wVar = new w();
                i = wVar;
                o(wVar);
            }
        } catch (Throwable th) {
            throw th;
        }
        return i;
    }

    private synchronized Drawable h(Context context, long j2) {
        zd1 zd1Var = (zd1) this.d.get(context);
        if (zd1Var == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) zd1Var.c(j2);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            zd1Var.g(j2);
        }
        return null;
    }

    public static synchronized PorterDuffColorFilter k(int i2, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterI;
        a aVar = j;
        porterDuffColorFilterI = aVar.i(i2, mode);
        if (porterDuffColorFilterI == null) {
            porterDuffColorFilterI = new PorterDuffColorFilter(i2, mode);
            aVar.j(i2, mode, porterDuffColorFilterI);
        }
        return porterDuffColorFilterI;
    }

    private ColorStateList m(Context context, int i2) {
        ns2 ns2Var;
        WeakHashMap weakHashMap = this.a;
        if (weakHashMap == null || (ns2Var = (ns2) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) ns2Var.d(i2);
    }

    private static void o(w wVar) {
    }

    private static boolean p(Drawable drawable) {
        return (drawable instanceof gb3) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    private Drawable q(Context context, int i2) {
        int next;
        ap2 ap2Var = this.b;
        if (ap2Var == null || ap2Var.isEmpty()) {
            return null;
        }
        ns2 ns2Var = this.c;
        if (ns2Var != null) {
            String str = (String) ns2Var.d(i2);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.b.get(str) == null)) {
                return null;
            }
        } else {
            this.c = new ns2();
        }
        if (this.e == null) {
            this.e = new TypedValue();
        }
        TypedValue typedValue = this.e;
        Resources resources = context.getResources();
        resources.getValue(i2, typedValue, true);
        long jD = d(typedValue);
        Drawable drawableH = h(context, jD);
        if (drawableH != null) {
            return drawableH;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i2);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.c.a(i2, name);
                b bVar = (b) this.b.get(name);
                if (bVar != null) {
                    drawableH = bVar.a(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableH != null) {
                    drawableH.setChangingConfigurations(typedValue.changingConfigurations);
                    a(context, jD, drawableH);
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (drawableH == null) {
            this.c.a(i2, "appcompat_skip_skip");
        }
        return drawableH;
    }

    private Drawable u(Context context, int i2, boolean z, Drawable drawable) {
        ColorStateList colorStateListL = l(context, i2);
        if (colorStateListL != null) {
            Drawable drawableR = dd0.r(drawable.mutate());
            dd0.o(drawableR, colorStateListL);
            PorterDuff.Mode modeN = n(i2);
            if (modeN == null) {
                return drawableR;
            }
            dd0.p(drawableR, modeN);
            return drawableR;
        }
        c cVar = this.g;
        if ((cVar == null || !cVar.e(context, i2, drawable)) && !w(context, i2, drawable) && z) {
            return null;
        }
        return drawable;
    }

    static void v(Drawable drawable, c0 c0Var, int[] iArr) {
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = c0Var.d;
        if (z || c0Var.c) {
            drawable.setColorFilter(f(z ? c0Var.a : null, c0Var.c ? c0Var.b : h, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    public synchronized Drawable i(Context context, int i2) {
        return j(context, i2, false);
    }

    synchronized Drawable j(Context context, int i2, boolean z) {
        Drawable drawableQ;
        try {
            c(context);
            drawableQ = q(context, i2);
            if (drawableQ == null) {
                drawableQ = e(context, i2);
            }
            if (drawableQ == null) {
                drawableQ = q30.e(context, i2);
            }
            if (drawableQ != null) {
                drawableQ = u(context, i2, z, drawableQ);
            }
            if (drawableQ != null) {
                s.b(drawableQ);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableQ;
    }

    synchronized ColorStateList l(Context context, int i2) {
        ColorStateList colorStateListM;
        colorStateListM = m(context, i2);
        if (colorStateListM == null) {
            c cVar = this.g;
            colorStateListM = cVar == null ? null : cVar.d(context, i2);
            if (colorStateListM != null) {
                b(context, i2, colorStateListM);
            }
        }
        return colorStateListM;
    }

    PorterDuff.Mode n(int i2) {
        c cVar = this.g;
        if (cVar == null) {
            return null;
        }
        return cVar.b(i2);
    }

    public synchronized void r(Context context) {
        zd1 zd1Var = (zd1) this.d.get(context);
        if (zd1Var != null) {
            zd1Var.a();
        }
    }

    synchronized Drawable s(Context context, g0 g0Var, int i2) {
        try {
            Drawable drawableQ = q(context, i2);
            if (drawableQ == null) {
                drawableQ = g0Var.a(i2);
            }
            if (drawableQ == null) {
                return null;
            }
            return u(context, i2, false, drawableQ);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void t(c cVar) {
        this.g = cVar;
    }

    boolean w(Context context, int i2, Drawable drawable) {
        c cVar = this.g;
        return cVar != null && cVar.a(context, i2, drawable);
    }
}
