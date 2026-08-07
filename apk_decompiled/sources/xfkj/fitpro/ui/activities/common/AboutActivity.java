package xfkj.fitpro.ui.activities.common;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.blankj.utilcode.util.ImageUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.a;
import com.blankj.utilcode.util.c;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.lo2;
import defpackage.qm2;
import defpackage.w2;
import defpackage.zi2;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.DeviceHardInfoModel;
import xfkj.fitpro.ui.activities.common.AboutActivity;
import xfkj.fitpro.ui.activities.common.debug.DebugFunctionActivity;

/* JADX INFO: loaded from: classes4.dex */
public class AboutActivity extends BaseActivity<w2> {
    LinearLayout k;
    TextView l;
    TextView m;
    TextView n;

    public AboutActivity() {
        super(R.layout.activity_about);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean e0(View view) {
        if (!zi2.i()) {
            ToastUtils.t(R.string.unconnected);
            return false;
        }
        zi2.o(qm2.D(AttrAndFunCode.SYS_INFO_ATTR_HIGH_AND_BASS), "测试指令");
        ToastUtils.u("sendding test cmd");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f0(View view) {
        UserProtocolActivity.Z(this, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g0(View view) {
        UserProtocolActivity.Z(this, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean h0(View view) {
        a.m(DebugFunctionActivity.class);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i0(View view) {
        l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(View view) {
        m0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        n0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public int H() {
        return R.color.white;
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        super.N(bundle);
        this.k = (LinearLayout) findViewById(R.id.ll_about);
        this.l = (TextView) findViewById(R.id.tv_version);
        this.m = (TextView) findViewById(R.id.tv_link_user_protocol);
        this.n = (TextView) findViewById(R.id.tv_link_privacy_policy);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        setTitle(R.string.about);
        this.l.setText("V " + c.i());
        TextView textView = (TextView) findViewById(R.id.tv_icp);
        if (textView == null || O()) {
            return;
        }
        textView.setText(getString(R.string.icp_s, getString(R.string.icp)));
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        this.l.setOnLongClickListener(new View.OnLongClickListener() { // from class: o0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return AboutActivity.e0(view);
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.f0(view);
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: q0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.g0(view);
            }
        });
        View viewFindViewById = findViewById(R.id.btn_share);
        if (viewFindViewById != null) {
            viewFindViewById.setOnLongClickListener(new View.OnLongClickListener() { // from class: r0
                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    return AboutActivity.h0(view);
                }
            });
        }
        findViewById(R.id.tv_link_open_sourece_protcol).setOnClickListener(new View.OnClickListener() { // from class: s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.i0(view);
            }
        });
        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() { // from class: t0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.j0(view);
            }
        });
        findViewById(R.id.img_qrcode).setOnClickListener(new View.OnClickListener() { // from class: u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.k0(view);
            }
        });
    }

    public void l0() {
        a.m(UserProtocolActivity.class);
    }

    public void m0() {
        lo2.a(ImageUtils.g(this.k));
    }

    public void n0() {
        DeviceHardInfoModel deviceHardInfo = DBHelper.getDeviceHardInfo();
        if (deviceHardInfo != null) {
            ToastUtils.s(deviceHardInfo.toString());
        } else if (!zi2.i()) {
            ToastUtils.t(R.string.unconnected);
        } else {
            zi2.o(qm2.D(AttrAndFunCode.SYS_INFO_ATTR_FIXED_LEN_DATA_FUN), "获取硬件信息");
            ToastUtils.u("获取失败请重试!");
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
