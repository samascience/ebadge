package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.runtime.R$id;
import defpackage.ar0;
import defpackage.db1;
import defpackage.p31;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 extends Lambda implements ar0 {
    public static final ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2 INSTANCE = new ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2();

    ViewTreeLifecycleOwner$findViewTreeLifecycleOwner$2() {
        super(1);
    }

    @Override // defpackage.ar0
    public final db1 invoke(View view) {
        p31.f(view, "viewParent");
        Object tag = view.getTag(R$id.view_tree_lifecycle_owner);
        if (tag instanceof db1) {
            return (db1) tag;
        }
        return null;
    }
}
