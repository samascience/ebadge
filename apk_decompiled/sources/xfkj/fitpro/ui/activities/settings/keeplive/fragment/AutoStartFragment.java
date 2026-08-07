package xfkj.fitpro.ui.activities.settings.keeplive.fragment;

import android.os.Bundle;
import android.view.View;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.v81;
import xfkj.fitpro.base.NewBaseFragment;

/* JADX INFO: loaded from: classes4.dex */
public class AutoStartFragment extends NewBaseFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(View view) {
        K();
    }

    public static NewBaseFragment J() {
        return new AutoStartFragment();
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void A() {
        x(R.id.btn_click1).setOnClickListener(new View.OnClickListener() { // from class: rc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.I(view);
            }
        });
    }

    public void K() {
        v81.c(getActivity());
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public int y() {
        return R.layout.fragment_keep_live_auto_start;
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void z(Bundle bundle) {
    }
}
