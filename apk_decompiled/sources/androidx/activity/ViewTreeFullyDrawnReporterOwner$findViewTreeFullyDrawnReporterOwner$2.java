package androidx.activity;

import android.view.View;
import defpackage.ar0;
import defpackage.p31;
import defpackage.xq0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes.dex */
final class ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2 extends Lambda implements ar0 {
    public static final ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2 INSTANCE = new ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2();

    ViewTreeFullyDrawnReporterOwner$findViewTreeFullyDrawnReporterOwner$2() {
        super(1);
    }

    @Override // defpackage.ar0
    public final xq0 invoke(View view) {
        p31.f(view, "it");
        Object tag = view.getTag(R$id.report_drawn);
        if (tag instanceof xq0) {
            return (xq0) tag;
        }
        return null;
    }
}
