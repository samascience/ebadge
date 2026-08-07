package androidx.savedstate;

import android.view.View;
import defpackage.ar0;
import defpackage.p31;
import defpackage.zj2;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 extends Lambda implements ar0 {
    public static final ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2 INSTANCE = new ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2();

    ViewTreeSavedStateRegistryOwner$findViewTreeSavedStateRegistryOwner$2() {
        super(1);
    }

    @Override // defpackage.ar0
    public final zj2 invoke(View view) {
        p31.f(view, "view");
        Object tag = view.getTag(R$id.view_tree_saved_state_registry_owner);
        if (tag instanceof zj2) {
            return (zj2) tag;
        }
        return null;
    }
}
