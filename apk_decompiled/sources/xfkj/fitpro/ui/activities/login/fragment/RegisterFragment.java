package xfkj.fitpro.ui.activities.login.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.kx0;
import defpackage.ob0;
import defpackage.pv2;
import defpackage.qe2;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.base.NewBaseFragment;
import xfkj.fitpro.model.sever.reponse.BaseResponse;
import xfkj.fitpro.ui.activities.login.LoginAndRegisterActivity;
import xfkj.fitpro.view.PasswordEditText;

/* JADX INFO: loaded from: classes4.dex */
public class RegisterFragment extends NewBaseFragment {
    EditText j;
    PasswordEditText k;
    PasswordEditText l;
    Button m;

    class a implements Observer {
        a() {
        }

        @Override // io.reactivex.Observer
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(BaseResponse baseResponse) {
            if (!baseResponse.isSuccess()) {
                kx0.a(baseResponse.getError());
                return;
            }
            ToastUtils.t(R.string.register_success);
            LoginAndRegisterActivity loginAndRegisterActivity = (LoginAndRegisterActivity) ((NewBaseFragment) RegisterFragment.this).c;
            loginAndRegisterActivity.h0(0);
            loginAndRegisterActivity.e0(RegisterFragment.this.j.getText().toString());
            loginAndRegisterActivity.a0();
            RegisterFragment.this.j.setText(Constants.STR_EMPTY);
            RegisterFragment.this.k.setText(Constants.STR_EMPTY);
            RegisterFragment.this.l.setText(Constants.STR_EMPTY);
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ob0.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ToastUtils.t(R.string.network_error);
            ob0.b();
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            ob0.d(((NewBaseFragment) RegisterFragment.this).c, R.string.registering);
        }
    }

    private static boolean K(String str, String str2, String str3) {
        if (!qe2.a(str)) {
            ToastUtils.t(R.string.please_input_correct_email_addr);
            return false;
        }
        if (pv2.f(str2)) {
            ToastUtils.t(R.string.please_input_pwd);
            return false;
        }
        if (str2.length() < 6) {
            ToastUtils.t(R.string.please_passwd_short);
            return false;
        }
        if (pv2.f(str3)) {
            ToastUtils.t(R.string.please_input_pwd_agin);
            return false;
        }
        if (pv2.a(str2, str3)) {
            return true;
        }
        ToastUtils.t(R.string.input_passwd_diff);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L(View view) {
        N();
    }

    public static NewBaseFragment M() {
        return new RegisterFragment();
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void A() {
        this.m.setOnClickListener(new View.OnClickListener() { // from class: se2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.L(view);
            }
        });
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    protected void B(View view) {
        super.B(view);
        this.j = (EditText) view.findViewById(R.id.edt_email_addr);
        this.k = (PasswordEditText) view.findViewById(R.id.edt_pwd);
        this.l = (PasswordEditText) view.findViewById(R.id.edt_pwd_agin);
        this.m = (Button) view.findViewById(R.id.btn_register);
    }

    public void N() {
        if (((LoginAndRegisterActivity) getActivity()).g0()) {
            String string = this.j.getText().toString();
            String string2 = this.k.getText().toString();
            if (K(string, string2, this.l.getText().toString())) {
                HttpHelper.g().G(string, string2, new a());
            }
        }
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public int y() {
        return R.layout.fragment_register;
    }

    @Override // xfkj.fitpro.base.NewBaseFragment
    public void z(Bundle bundle) {
    }
}
