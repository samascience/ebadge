package androidx.lifecycle;

import android.view.View;
import defpackage.ar0;
import defpackage.p31;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 extends Lambda implements ar0 {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1();

    ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$1() {
        super(1);
    }

    @Override // defpackage.ar0
    public final View invoke(View view) {
        p31.f(view, "currentView");
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }
}
