package xfkj.fitpro.ui.activities.common;

import android.os.Handler;
import android.os.Message;
import com.blankj.utilcode.util.ToastUtils;
import com.blankj.utilcode.util.a;
import com.legend.smartwatch.app.base.acitivity.BaseActivity;
import com.legend.smartwatch.electronicbadge.android.R;
import defpackage.g82;
import defpackage.hg;
import defpackage.k00;
import defpackage.p4;
import defpackage.zm1;
import xfkj.fitpro.api.HttpHelper;
import xfkj.fitpro.db.DBHelper;
import xfkj.fitpro.db.DBModule;
import xfkj.fitpro.ui.activities.device.electronicBadgeDevice.DeviceHomeActivity;

/* JADX INFO: loaded from: classes4.dex */
public class WelcomeActivity extends BaseActivity<p4> {
    private Handler k;

    public WelcomeActivity() {
        super(R.layout.activity_welcome);
        this.k = new Handler(new Handler.Callback() { // from class: di3
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.a.c0(message);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b0() {
        hg.E(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean c0(Message message) {
        if (message.what != 1) {
            return false;
        }
        Z();
        d0();
        return false;
    }

    protected void Z() {
        if (DBHelper.isLogin()) {
            k00.j();
            HttpHelper.g().h();
            HttpHelper.g().J(zm1.f());
        }
        HttpHelper.g().o();
        HttpHelper.g().p();
    }

    protected void a0(int i) {
        new Thread(new Runnable() { // from class: ci3
            @Override // java.lang.Runnable
            public final void run() {
                this.a.b0();
            }
        }).start();
        if (!g82.a()) {
            ToastUtils.t(R.string.init_db_failed);
            return;
        }
        DBModule.getInstance().init(getApplication());
        if (DBModule.getInstance().getDaoSession() == null) {
            ToastUtils.t(R.string.init_db_failed);
        } else {
            this.k.removeMessages(1);
            this.k.sendEmptyMessageDelayed(1, Math.max(0, i));
        }
    }

    protected void d0() {
        a.m(DeviceHomeActivity.class);
        finish();
    }
}
