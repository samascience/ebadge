package xfkj.fitpro.ui.activities.settings.keeplive.fragment;

import android.os.Bundle;
import android.view.View;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.v81;
import xfkj.fitpro.base.NewBaseFragment;

/* JADX INFO: loaded from: classes4.dex */
public class SaveBatteryFragment extends NewBaseFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(View view) {
        K();
    }

    public static NewBaseFragment J() {
        return new SaveBatteryFragment();
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void A() {
        x(R.id.btn_click1).setOnClickListener(new View.OnClickListener() { // from class: pj2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.I(view);
            }
        });
    }

    public void K() {
        if (v81.l(getActivity())) {
            ToastUtils.t(R.string.already_close_save_mode);
        } else {
            v81.t(getActivity());
        }
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public int y() {
        return R.layout.fragment_keep_live_save_battery;
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void z(Bundle bundle) {
    }
}
