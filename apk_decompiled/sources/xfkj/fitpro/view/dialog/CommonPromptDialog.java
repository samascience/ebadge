package xfkj.fitpro.view.dialog;

import android.os.Bundle;
import android.view.View;
import com.blankj.utilcode.util.d;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.ml2;
import defpackage.pv2;
import defpackage.qu0;
import defpackage.yp0;
import xfkj.fitpro.view.dialog.CommonPromptDialog;

/* JADX INFO: loaded from: classes4.dex */
public final class CommonPromptDialog extends BindingBaseDialogFragment<yp0> {
    private String F;
    private boolean G;
    private String w;
    private String x;
    private String y;
    private String z;

    public CommonPromptDialog() {
        super(R.layout.fragment_dialog_common_prompt);
        this.w = Constants.STR_EMPTY;
        this.x = Constants.STR_EMPTY;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(CommonPromptDialog commonPromptDialog, View view) {
        commonPromptDialog.getClass();
        commonPromptDialog.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V(CommonPromptDialog commonPromptDialog, View view) {
        commonPromptDialog.getClass();
        commonPromptDialog.y();
    }

    @Override // xfkj.fitpro.view.dialog.BindingBaseDialogFragment
    protected BindingBaseDialogFragment.a N() {
        return ml2.d() ? new BindingBaseDialogFragment.a().m(ml2.c() - d.c(40.0f)).k(17).a(true) : new BindingBaseDialogFragment.a().m(ml2.b() - d.c(40.0f)).k(17).a(true);
    }

    @Override // xfkj.fitpro.view.dialog.BindingBaseDialogFragment
    public void O(Bundle bundle, View view) {
        ((yp0) Q()).G.setText(this.w);
        ((yp0) Q()).z.setText(this.x);
        if (!pv2.h(this.F)) {
            ((yp0) Q()).F.setVisibility(0);
            qu0.d(this.v, this.F, ((yp0) Q()).F, this.G);
        }
        ((yp0) Q()).H.setOnClickListener(new View.OnClickListener() { // from class: d00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CommonPromptDialog.U(this.a, view2);
            }
        });
        ((yp0) Q()).I.setOnClickListener(new View.OnClickListener() { // from class: f00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CommonPromptDialog.V(this.a, view2);
            }
        });
        if (!pv2.h(this.y)) {
            ((yp0) Q()).H.setText(this.y);
        }
        if (pv2.h(this.z)) {
            return;
        }
        ((yp0) Q()).I.setText(this.z);
    }
}
