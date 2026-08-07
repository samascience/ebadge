package xfkj.fitpro.ui.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.blankj.utilcode.util.ToastUtils;
import com.google.android.material.tabs.TabLayout;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.umeng.socialize.UMShareAPI;
import defpackage.k00;
import defpackage.n3;
import defpackage.nz;
import defpackage.og;
import defpackage.xf;
import defpackage.zm1;
import java.util.ArrayList;
import xfkj.fitpro.ui.activities.common.UserProtocolActivity;
import xfkj.fitpro.ui.activities.login.fragment.LoginFragment;
import xfkj.fitpro.ui.activities.login.fragment.RegisterFragment;

/* JADX INFO: loaded from: classes4.dex */
public class LoginAndRegisterActivity extends BaseActivity<n3> {
    TabLayout k;
    ViewPager l;
    TextView m;
    CheckBox n;
    private og o;

    class a extends ClickableSpan {
        a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            UserProtocolActivity.Z(((BaseActivity) LoginAndRegisterActivity.this).f, false);
        }
    }

    class b extends ClickableSpan {
        b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            UserProtocolActivity.Z(((BaseActivity) LoginAndRegisterActivity.this).f, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c0(View view) {
        d0();
    }

    private void f0() {
        String str = "《" + getString(R.string.user_protocol) + "》";
        String str2 = "《" + getString(R.string.private_protocol) + "》";
        SpannableString spannableString = new SpannableString(getString(R.string.private_procity_user_protocol, str, str2));
        int iIndexOf = spannableString.toString().indexOf(str);
        spannableString.setSpan(new a(), iIndexOf, str.length() + iIndexOf, 17);
        int iIndexOf2 = spannableString.toString().indexOf(str2);
        spannableString.setSpan(new b(), iIndexOf2, str2.length() + iIndexOf2, 17);
        this.m.setText(spannableString);
        this.m.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        this.k = (TabLayout) findViewById(R.id.tabLayout);
        this.l = (ViewPager) findViewById(R.id.viewPager);
        this.m = (TextView) findViewById(R.id.tv_user_private_procity);
        this.n = (CheckBox) findViewById(R.id.cx_protocol);
    }

    public void a0() {
        ((LoginFragment) this.o.t(0)).K().requestFocus();
    }

    public boolean b0() {
        return this.n.isChecked();
    }

    public void d0() {
        zm1.h0(true);
        com.blankj.utilcode.util.a.a();
    }

    public void e0(String str) {
        ((LoginFragment) this.o.t(0)).J().setText(str);
    }

    public boolean g0() {
        if (b0()) {
            return true;
        }
        ToastUtils.r(R.string.pls_read_private_protocol_then_login);
        return false;
    }

    public void h0(int i) {
        this.l.N(i, false);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        getWindow().getDecorView().setSystemUiVisibility(8192);
        xf.f(this, nz.a(R.color.bg_color));
        ArrayList arrayList = new ArrayList();
        arrayList.add(LoginFragment.P());
        arrayList.add(RegisterFragment.M());
        og ogVar = new og(getSupportFragmentManager(), arrayList);
        this.o = ogVar;
        this.l.setAdapter(ogVar);
        this.l.setAdapter(this.o);
        String[] strArr = {getString(R.string.login), getString(R.string.register)};
        TabLayout tabLayout = this.k;
        tabLayout.h(tabLayout.D().r(strArr[0]));
        TabLayout tabLayout2 = this.k;
        tabLayout2.h(tabLayout2.D().r(strArr[1]));
        this.k.setupWithViewPager(this.l);
        this.k.A(0).r(strArr[0]);
        this.k.A(1).r(strArr[1]);
        this.k.setTabIndicatorFullWidth(false);
        f0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        findViewById(R.id.tv_skip).setOnClickListener(new View.OnClickListener() { // from class: pd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.c0(view);
            }
        });
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        UMShareAPI uMShareAPI;
        super.onActivityResult(i, i2, intent);
        if (k00.e() || (uMShareAPI = UMShareAPI.get(this)) == null) {
            return;
        }
        uMShareAPI.onActivityResult(i, i2, intent);
    }
}
