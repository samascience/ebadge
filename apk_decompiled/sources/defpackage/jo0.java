package defpackage;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class jo0 {
    private final AssetManager d;
    private final jm1 a = new jm1();
    private final Map b = new HashMap();
    private final Map c = new HashMap();
    private String e = ".ttf";

    public jo0(Drawable.Callback callback, io0 io0Var) {
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
        } else {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }

    private Typeface a(String str) {
        Typeface typeface = (Typeface) this.c.get(str);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.d, "fonts/" + str + this.e);
        this.c.put(str, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    private Typeface d(Typeface typeface, String str) {
        int i;
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        if (zContains && zContains2) {
            i = 3;
        } else if (zContains) {
            i = 2;
        } else {
            i = zContains2 ? 1 : 0;
        }
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }

    public Typeface b(String str, String str2) {
        this.a.b(str, str2);
        Typeface typeface = (Typeface) this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceD = d(a(str), str2);
        this.b.put(this.a, typefaceD);
        return typefaceD;
    }

    public void c(io0 io0Var) {
    }
}
