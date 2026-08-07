package androidx.activity;

import android.view.View;
import defpackage.ar0;
import defpackage.p31;
import defpackage.qu1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 extends Lambda implements ar0 {
    public static final ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 INSTANCE = new ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2();

    ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2() {
        super(1);
    }

    @Override // defpackage.ar0
    public final qu1 invoke(View view) {
        p31.f(view, "it");
        Object tag = view.getTag(R$id.view_tree_on_back_pressed_dispatcher_owner);
        if (tag instanceof qu1) {
            return (qu1) tag;
        }
        return null;
    }
}
