package xfkj.fitpro.ui.activities.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import defpackage.kx0;
import defpackage.ob0;
import defpackage.qe2;
import defpackage.t40;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.model.sever.reponse.BaseResponse;
import xfkj.fitpro.model.sever.reponse.QueryDataReponse;
import xfkj.fitpro.view.XEditText;

/* JADX INFO: loaded from: classes4.dex */
public class ForgetPsdActivity extends BaseActivity {
    XEditText k;
    Button l;
    TextView m;
    private boolean n;
    private t40 o;

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
            ForgetPsdActivity.this.l.setEnabled(false);
            ForgetPsdActivity.this.m.setVisibility(0);
            ForgetPsdActivity.this.l.setAlpha(0.8f);
            ForgetPsdActivity forgetPsdActivity = ForgetPsdActivity.this;
            forgetPsdActivity.k.setTextColor(forgetPsdActivity.getResources().getColor(R.color.gray));
            ForgetPsdActivity.this.o.e();
            if (DBHelper.isLogin()) {
                HttpHelper.g().A();
            }
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            ob0.b();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            ob0.b();
            ToastUtils.t(R.string.reset_pwd_failed);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            ob0.f(((BaseActivity) ForgetPsdActivity.this).f, ForgetPsdActivity.this.getString(R.string.resetting_pwd));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a0(View view) {
        b0();
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void N(Bundle bundle) {
        this.k = (XEditText) findViewById(R.id.edt_email_addr);
        this.l = (Button) findViewById(R.id.btn_send_pwd);
        this.m = (TextView) findViewById(R.id.tv_already_send_psd);
    }

    public void b0() {
        String strTrim = this.k.getText().toString().trim();
        if (qe2.a(strTrim)) {
            HttpHelper.g().H(strTrim, new a());
        } else {
            ToastUtils.t(R.string.please_input_correct_email_addr);
        }
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initData(Bundle bundle) {
        setTitle(Constants.STR_EMPTY);
        QueryDataReponse userInfo = DBHelper.getUserInfo();
        String stringExtra = getIntent().getStringExtra("acount");
        if (userInfo != null) {
            this.k.setText(userInfo.getEmail());
            this.k.setEnabled(false);
            this.k.setDisableClear(true);
            this.n = true;
        } else if (stringExtra != null && qe2.a(stringExtra)) {
            this.k.setText(stringExtra);
            this.k.setSelection(stringExtra.length());
            this.n = false;
        }
        t40 t40VarB = t40.b();
        this.o = t40VarB;
        t40VarB.d(10050L);
        this.o.c(1000L);
    }

    @Override // com.legend.smartwatch.app.base.acitivity.BaseActivity
    public void initListener() {
        this.l.setOnClickListener(new View.OnClickListener() { // from class: fp0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.a.a0(view);
            }
        });
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        if (!this.n || DBHelper.isLogin()) {
            super.onBackPressed();
        } else {
            com.blankj.utilcode.util.a.a();
            com.blankj.utilcode.util.a.m(LoginAndRegisterActivity.class);
        }
    }
}
