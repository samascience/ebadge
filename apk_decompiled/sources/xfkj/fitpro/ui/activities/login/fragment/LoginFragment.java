package xfkj.fitpro.ui.activities.login.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.a;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.b;
import com.google.android.gms.common.api.ApiException;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import com.tencent.mm.opensdk.utils.Log;
import defpackage.pv2;
import defpackage.qe2;
import defpackage.td1;
import defpackage.u03;
import xfkj.fitpro.base.NewBaseFragment;
import xfkj.fitpro.model.sever.body.SocialLoginBody;
import xfkj.fitpro.ui.activities.login.ForgetPsdActivity;
import xfkj.fitpro.ui.activities.login.LoginAndRegisterActivity;
import xfkj.fitpro.view.PasswordEditText;

/* JADX INFO: loaded from: classes4.dex */
public class LoginFragment extends NewBaseFragment {
    EditText j;
    PasswordEditText k;
    TextView l;
    Button m;
    ImageButton n;
    ImageButton o;
    ImageButton p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    ImageButton f406q;
    ImageButton r;
    private final int s = 1008;
    private b t;

    private boolean I(String str, String str2) {
        if (!qe2.a(str)) {
            ToastUtils.t(R.string.please_input_correct_email_addr);
            return false;
        }
        if (!pv2.f(str2)) {
            return true;
        }
        ToastUtils.t(R.string.please_input_pwd);
        return false;
    }

    private void L() {
        startActivityForResult(this.t.l(), 1008);
    }

    private void M(u03 u03Var) {
        try {
            GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) u03Var.d(ApiException.class);
            if (googleSignInAccount != null) {
                SocialLoginBody socialLoginBody = new SocialLoginBody();
                socialLoginBody.setUid(googleSignInAccount.J0());
                socialLoginBody.setSocialSource(Constants.VIA_SHARE_TYPE_INFO);
                socialLoginBody.setNickname(googleSignInAccount.F0());
                socialLoginBody.setSex(1);
                socialLoginBody.setType(1);
                socialLoginBody.setAvatar(googleSignInAccount.L0() == null ? null : googleSignInAccount.L0().toString());
                td1.m().z(getActivity());
                td1.m().n(socialLoginBody);
            }
        } catch (ApiException e) {
            Log.w(this.b, "signInResult:failed code=" + e.getStatusCode());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void N(View view) {
        R();
    }

    private void O() {
        String string = this.j.getText().toString();
        String string2 = this.k.getText().toString();
        if (I(string, string2)) {
            td1.m().y(string, string2, getActivity());
        }
    }

    public static NewBaseFragment P() {
        return new LoginFragment();
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void A() {
        this.l.setOnClickListener(new View.OnClickListener() { // from class: qd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.N(view);
            }
        });
        this.m.setOnClickListener(new View.OnClickListener() { // from class: rd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q(view);
            }
        });
        x(R.id.img_btn_login_google).setOnClickListener(new View.OnClickListener() { // from class: rd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q(view);
            }
        });
        this.o.setOnClickListener(new View.OnClickListener() { // from class: rd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q(view);
            }
        });
        this.n.setOnClickListener(new View.OnClickListener() { // from class: rd1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.Q(view);
            }
        });
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    protected void B(View view) {
        super.B(view);
        this.j = (EditText) view.findViewById(R.id.edt_email_addr);
        this.k = (PasswordEditText) view.findViewById(R.id.edt_pwd);
        this.l = (TextView) view.findViewById(R.id.tv_forget_pwd);
        this.m = (Button) view.findViewById(R.id.btn_login);
        this.n = (ImageButton) view.findViewById(R.id.img_btn_login_wechat);
        this.o = (ImageButton) view.findViewById(R.id.img_btn_login_qq);
        this.p = (ImageButton) view.findViewById(R.id.img_btn_login_sina);
        this.f406q = (ImageButton) view.findViewById(R.id.img_btn_login_fb);
        this.r = (ImageButton) view.findViewById(R.id.img_btn_login_tw);
    }

    public EditText J() {
        return this.j;
    }

    public PasswordEditText K() {
        return this.k;
    }

    public void Q(View view) {
        if (((LoginAndRegisterActivity) getActivity()).g0()) {
            switch (view.getId()) {
                case R.id.btn_login /* 2131296418 */:
                    O();
                    break;
                case R.id.img_btn_login_google /* 2131296742 */:
                    L();
                    break;
                case R.id.img_btn_login_qq /* 2131296743 */:
                    td1.m().A(getActivity());
                    break;
                case R.id.img_btn_login_wechat /* 2131296746 */:
                    td1.m().B(getActivity());
                    break;
            }
        }
    }

    public void R() {
        a.m(ForgetPsdActivity.class);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1008) {
            M(com.google.android.gms.auth.api.signin.a.b(intent));
        }
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public int y() {
        return R.layout.fragment_login;
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void z(Bundle bundle) {
        this.t = com.google.android.gms.auth.api.signin.a.a(this.c, new GoogleSignInOptions.a(GoogleSignInOptions.p).b().a());
    }
}
