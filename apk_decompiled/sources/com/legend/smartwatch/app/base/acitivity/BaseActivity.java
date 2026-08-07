package com.legend.smartwatch.app.base.acitivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.e;
import com.gyf.immersionbar.h;
import com.legend.smartwatch.electronicbadge.android.R;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import defpackage.di0;
import defpackage.e43;
import defpackage.k00;
import defpackage.ng;
import defpackage.o10;
import defpackage.ob0;
import defpackage.p31;
import defpackage.q2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: loaded from: classes3.dex */
public abstract class BaseActivity<VB extends ViewDataBinding> extends AppCompatActivity {
    private final int a;
    private ProgressDialog c;
    protected Handler e;
    protected AppCompatActivity f;
    protected ViewDataBinding g;
    private final List h;
    private final Map i;
    private boolean j;
    private String b = getClass().getSimpleName();
    private boolean d = true;

    public static final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            p31.f(message, SocialConstants.PARAM_SEND_MSG);
            super.handleMessage(message);
            BaseActivity.this.handleMsg(message);
            if (BaseActivity.this.h.contains(Integer.valueOf(message.what))) {
                BaseActivity.this.h.remove(Integer.valueOf(message.what));
            }
        }
    }

    public BaseActivity(int i) {
        this.a = i;
        Looper looperMyLooper = Looper.myLooper();
        p31.c(looperMyLooper);
        this.e = new a(looperMyLooper);
        this.h = new ArrayList();
        this.i = new LinkedHashMap();
    }

    private final boolean P() {
        return this.d;
    }

    public int H() {
        return R.color.theme_color_light;
    }

    protected final ViewDataBinding I() {
        ViewDataBinding viewDataBinding = this.g;
        if (viewDataBinding != null) {
            return viewDataBinding;
        }
        p31.t("mBinding");
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final AppCompatActivity J() {
        AppCompatActivity appCompatActivity = this.f;
        if (appCompatActivity != null) {
            return appCompatActivity;
        }
        p31.t("mContext");
        return null;
    }

    protected final String K() {
        return this.b;
    }

    protected final void L() {
        ob0.b();
    }

    protected final void M() {
        h.p0(this).j0(true).l(true).c(H()).Q(true).G();
    }

    public void N(Bundle bundle) {
    }

    public final boolean O() {
        return k00.e();
    }

    protected final boolean Q() {
        try {
            return (isDestroyed() || isFinishing() || this.g == null) ? false : true;
        } catch (Exception e) {
            Log.w(this.b, "Error checking if ready for UI updates: " + e.getMessage());
            return false;
        }
    }

    protected void R(boolean z, String str, int i) {
    }

    protected final void S(ViewDataBinding viewDataBinding) {
        p31.f(viewDataBinding, "<set-?>");
        this.g = viewDataBinding;
    }

    protected final void T(AppCompatActivity appCompatActivity) {
        p31.f(appCompatActivity, "<set-?>");
        this.f = appCompatActivity;
    }

    protected final void U(int i, View.OnClickListener onClickListener) {
        ImageView imageView = (ImageView) I().getRoot().findViewById(R.id.img_right);
        if (imageView != null) {
            imageView.setVisibility(0);
            imageView.setImageResource(i);
            imageView.setOnClickListener(onClickListener);
        }
    }

    protected final void V(String str) {
        p31.f(str, "message");
        ob0.f(this, str);
    }

    protected final void W() {
        this.i.clear();
    }

    protected void handleMsg(Message message) {
    }

    public final void hideProgress() {
        ProgressDialog progressDialog = this.c;
        if (progressDialog != null) {
            p31.c(progressDialog);
            progressDialog.dismiss();
        }
    }

    public void initData(Bundle bundle) {
    }

    public void initListener() {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        T(this);
        S(e.g(this, this.a));
        I().A(this);
        setTitle(Constants.STR_EMPTY);
        N(bundle);
        initData(bundle);
        initListener();
        if (P()) {
            M();
        }
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        ob0.b();
        stopAllTimeOut();
        W();
    }

    public final void onMessageEvent(Object obj) {
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvents(ng ngVar) {
        if (ngVar instanceof q2) {
            e43.a(this.i.get(Integer.valueOf(((q2) ngVar).a())));
        } else if (ngVar instanceof o10) {
            o10 o10Var = (o10) ngVar;
            boolean zIsConnected = o10Var.isConnected();
            String macAddress = o10Var.getMacAddress();
            int iA = o10Var.a();
            if (this.j != zIsConnected) {
                this.j = zIsConnected;
                R(zIsConnected, macAddress, iA);
            }
        }
        onMessageEvent(ngVar);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        di0.b(this);
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
        di0.c(this);
        hideProgress();
        L();
        this.c = null;
    }

    protected final void stopAllTimeOut() {
        if (this.h.isEmpty()) {
            return;
        }
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            stopTimeOut(((Number) it.next()).intValue());
        }
    }

    protected final void stopTimeOut(int i) {
        this.h.remove(Integer.valueOf(i));
        this.e.removeMessages(i);
    }
}
