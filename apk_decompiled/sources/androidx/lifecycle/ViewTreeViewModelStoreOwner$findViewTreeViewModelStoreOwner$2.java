package androidx.lifecycle;

import android.view.View;
import androidx.lifecycle.viewmodel.R$id;
import defpackage.ar0;
import defpackage.ne3;
import defpackage.p31;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 extends Lambda implements ar0 {
    public static final ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2 INSTANCE = new ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2();

    ViewTreeViewModelStoreOwner$findViewTreeViewModelStoreOwner$2() {
        super(1);
    }

    @Override // defpackage.ar0
    public final ne3 invoke(View view) {
        p31.f(view, "view");
        Object tag = view.getTag(R$id.view_tree_view_model_store_owner);
        if (tag instanceof ne3) {
            return (ne3) tag;
        }
        return null;
    }
}
