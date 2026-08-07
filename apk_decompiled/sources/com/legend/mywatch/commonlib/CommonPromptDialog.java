package com.legend.mywatch.commonlib;

import android.os.Bundle;
import android.view.View;
import com.blankj.utilcode.util.d;
import defpackage.ml2;
import defpackage.pv2;
import defpackage.zp0;

/* JADX INFO: loaded from: classes3.dex */
public class CommonPromptDialog extends CommonBaseDialogFragment<zp0> {
    private String v = pv2.d(R$string.tips_txt);
    private String w;
    private String x;
    private String y;
    private a z;

    public interface a {
        void a();
    }

    public CommonPromptDialog(String str) {
        this.w = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(View view) {
        y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void T(View view) {
        a aVar = this.z;
        if (aVar != null) {
            aVar.a();
        } else {
            y();
        }
    }

    @Override // com.legend.mywatch.commonlib.CommonBaseDialogFragment
    protected CommonBaseDialogFragment.a N() {
        return ml2.d() ? new CommonBaseDialogFragment.a().j(ml2.c() - d.c(40.0f)).i(17).h(true) : new CommonBaseDialogFragment.a().j(ml2.b() - d.c(40.0f)).i(17).h(true);
    }

    @Override // com.legend.mywatch.commonlib.CommonBaseDialogFragment
    public void O(Bundle bundle, View view) {
        ((zp0) this.r).d.setText(this.v);
        ((zp0) this.r).b.setText(this.w);
        ((zp0) this.r).e.setOnClickListener(new View.OnClickListener() { // from class: e00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.S(view2);
            }
        });
        ((zp0) this.r).f.setOnClickListener(new View.OnClickListener() { // from class: g00
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                this.a.T(view2);
            }
        });
        if (!pv2.h(this.x)) {
            ((zp0) this.r).e.setText(this.x);
        }
        if (pv2.h(this.y)) {
            return;
        }
        ((zp0) this.r).f.setText(this.y);
    }

    public void U(a aVar) {
        this.z = aVar;
    }
}
