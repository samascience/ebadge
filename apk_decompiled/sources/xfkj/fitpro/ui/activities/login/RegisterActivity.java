package xfkj.fitpro.ui.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.kx0;
import defpackage.ob0;
import defpackage.pv2;
import defpackage.qe2;
import defpackage.y3;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.model.sever.reponse.BaseResponse;

/* JADX INFO: loaded from: classes4.dex */
public class RegisterActivity extends BaseActivity<y3> {
    EditText k;
    EditText l;
    EditText m;

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
            Intent intent = new Intent();
            intent.putExtra("email", RegisterActivity.this.k.getText().toString());
            RegisterActivity.this.setResult(17, intent);
            RegisterActivity.this.finish();
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
            ob0.d(((BaseActivity) RegisterActivity.this).f, R.string.registering);
        }
    }

    private static boolean Z(String str, String str2, String str3) {
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
    public /* synthetic */ void a0(View view) {
        b0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        this.k = (EditText) findViewById(R.id.edt_email_addr);
        this.l = (EditText) findViewById(R.id.edt_pwd);
        this.m = (EditText) findViewById(R.id.edt_pwd_agin);
    }

    public void b0() {
        String string = this.k.getText().toString();
        String string2 = this.l.getText().toString();
        if (Z(string, string2, this.m.getText().toString())) {
            HttpHelper.g().G(string, string2, new a());
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        setTitle(Constants.STR_EMPTY);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() { // from class: re2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a0(view);
            }
        });
    }
}
