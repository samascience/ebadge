package xfkj.fitpro.ui.activities.settings.keeplive.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.bs1;
import defpackage.g02;
import xfkj.fitpro.base.NewBaseFragment;
import xfkj.fitpro.ui.activities.settings.keeplive.fragment.NotifiPermFragment;

/* JADX INFO: loaded from: classes4.dex */
public class NotifiPermFragment extends NewBaseFragment {
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(View view) {
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void K(DialogInterface dialogInterface, int i) {
        PermissionUtils.y("android.permission.POST_NOTIFICATIONS").z();
    }

    public static NewBaseFragment L() {
        return new NotifiPermFragment();
    }

    private boolean N() {
        if (!g02.h() || PermissionUtils.t("android.permission.POST_NOTIFICATIONS")) {
            return true;
        }
        g02.n(null, new DialogInterface.OnClickListener() { // from class: tr1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                NotifiPermFragment.K(dialogInterface, i);
            }
        }, getString(R.string.noti_perm), getString(R.string.notifiy_permission));
        return false;
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void A() {
        x(R.id.btn_click1).setOnClickListener(new View.OnClickListener() { // from class: sr1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.J(view);
            }
        });
    }

    public void M() {
        if (N()) {
            if (bs1.a(getActivity())) {
                ToastUtils.t(R.string.app_notifi_opened);
            } else {
                bs1.b(getActivity());
            }
        }
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public int y() {
        return R.layout.fragment_keep_live_notifi_permi;
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void z(Bundle bundle) {
    }
}
