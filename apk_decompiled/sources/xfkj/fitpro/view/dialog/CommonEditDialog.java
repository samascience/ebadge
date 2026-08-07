package xfkj.fitpro.view.dialog;

import android.os.Bundle;
import android.view.View;
import com.blankj.utilcode.util.d;
import defpackage.ml2;
import defpackage.pv2;
import defpackage.qu0;
import defpackage.wp0;
import xfkj.fitpro.view.dialog.CommonEditDialog;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonEditDialog extends BindingBaseDialogFragment<wp0> {
    private String F;
    private String w;
    private String x;
    private String y;
    private String z;

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(CommonEditDialog commonEditDialog, View view) {
        commonEditDialog.getClass();
        commonEditDialog.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(CommonEditDialog commonEditDialog, View view) {
        commonEditDialog.getClass();
        commonEditDialog.y();
    }

    @Override // xfkj.fitpro.view.dialog.BindingBaseDialogFragment
    protected BindingBaseDialogFragment.a N() {
        return ml2.d() ? new BindingBaseDialogFragment.a().m(ml2.c() - d.c(40.0f)).k(17).a(true) : new BindingBaseDialogFragment.a().m(ml2.b() - d.c(40.0f)).k(17).a(true);
    }

    @Override // xfkj.fitpro.view.dialog.BindingBaseDialogFragment
    public void O(Bundle bundle, View view) {
        ((wp0) Q()).G.setText(this.w);
        if (!pv2.h(this.z)) {
            ((wp0) Q()).F.setVisibility(0);
            qu0.c(this.v, this.z, ((wp0) Q()).F);
        }
        ((wp0) Q()).H.setOnClickListener(new View.OnClickListener() { // from class: a00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CommonEditDialog.U(this.a, view2);
            }
        });
        ((wp0) Q()).I.setOnClickListener(new View.OnClickListener() { // from class: b00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CommonEditDialog.V(this.a, view2);
            }
        });
        if (!pv2.h(this.x)) {
            ((wp0) Q()).H.setText(this.x);
        }
        if (!pv2.h(this.y)) {
            ((wp0) Q()).I.setText(this.y);
        }
        if (pv2.h(this.F)) {
            return;
        }
        ((wp0) Q()).z.setHint(this.F);
    }
}
