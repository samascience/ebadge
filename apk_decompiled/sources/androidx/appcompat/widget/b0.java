package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class b0 extends ContextWrapper {
    private static final Object c = new Object();
    private static ArrayList d;
    private final Resources a;
    private final Resources.Theme b;

    private b0(Context context) {
        super(context);
        if (!g0.d()) {
            this.a = new d0(this, context.getResources());
            this.b = null;
            return;
        }
        g0 g0Var = new g0(this, context.getResources());
        this.a = g0Var;
        Resources.Theme themeNewTheme = g0Var.newTheme();
        this.b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        if ((context instanceof b0) || (context.getResources() instanceof d0) || (context.getResources() instanceof g0)) {
            return false;
        }
        return g0.d();
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (c) {
            try {
                ArrayList arrayList = d;
                if (arrayList == null) {
                    d = new ArrayList();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference weakReference = (WeakReference) d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            d.remove(size);
                        }
                    }
                    for (int size2 = d.size() - 1; size2 >= 0; size2--) {
                        WeakReference weakReference2 = (WeakReference) d.get(size2);
                        b0 b0Var = weakReference2 != null ? (b0) weakReference2.get() : null;
                        if (b0Var != null && b0Var.getBaseContext() == context) {
                            return b0Var;
                        }
                    }
                }
                b0 b0Var2 = new b0(context);
                d.add(new WeakReference(b0Var2));
                return b0Var2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        Resources.Theme theme = this.b;
        if (theme == null) {
            super.setTheme(i);
        } else {
            theme.applyStyle(i, true);
        }
    }
}
