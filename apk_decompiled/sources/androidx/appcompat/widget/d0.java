package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
class d0 extends x {
    private final WeakReference b;

    public d0(Context context, Resources resources) {
        super(resources);
        this.b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawableA = a(i);
        Context context = (Context) this.b.get();
        if (drawableA != null && context != null) {
            w.g().w(context, i, drawableA);
        }
        return drawableA;
    }
}
