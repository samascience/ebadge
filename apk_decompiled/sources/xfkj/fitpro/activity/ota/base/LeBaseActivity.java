package xfkj.fitpro.activity.ota.base;

import android.os.Message;
import com.blankj.utilcode.util.ToastUtils;
import defpackage.pb0;
import defpackage.q2;
import defpackage.wd3;
import defpackage.zi2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import xfkj.fitpro.activity.ota.R;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LeBaseActivity<T extends wd3> extends NewBaseActivity<T> {
    private List<Integer> mLeAckCallbackList = new ArrayList();

    @Override // xfkj.fitpro.activity.ota.base.NewBaseActivity
    protected void handleMsg(Message message) {
        super.handleMsg(message);
        int i = message.what;
        if (this.mLeAckCallbackList.contains(Integer.valueOf(i))) {
            Map map = (Map) message.getData().getSerializable("Datas");
            onAckCallback(i, map.get("is_ok") != null && map.get("is_ok").equals("1"));
        }
    }

    protected boolean isConnected() {
        return zi2.i();
    }

    protected boolean isConnectedWithTips() {
        boolean zIsConnected = isConnected();
        if (!zIsConnected) {
            ToastUtils.t(R.string.unconnected);
        }
        return zIsConnected;
    }

    protected void onAckCallback(int i, boolean z) {
    }

    @Override // xfkj.fitpro.activity.ota.base.NewBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        this.mLeAckCallbackList.clear();
    }

    @Override // xfkj.fitpro.activity.ota.base.NewBaseActivity
    public void onMessageEvent(Object obj) {
        super.onMessageEvent(obj);
        if (obj instanceof q2) {
            q2 q2Var = (q2) obj;
            if (this.mLeAckCallbackList.contains(Integer.valueOf(q2Var.a()))) {
                onAckCallback(q2Var.a(), q2Var.c());
            }
        }
    }

    protected void registerAckCallback(int i) {
        if (this.mLeAckCallbackList.indexOf(Integer.valueOf(i)) == -1) {
            this.mLeAckCallbackList.add(Integer.valueOf(i));
        }
    }

    protected void unRegisterAckCallback(int i) {
        if (this.mLeAckCallbackList.contains(Integer.valueOf(i))) {
            this.mLeAckCallbackList.remove(i);
        }
    }

    protected boolean writeDataToBle(byte[] bArr, String str) {
        if (!isConnected()) {
            return false;
        }
        zi2.o(bArr, str);
        return true;
    }

    protected boolean writeDataToBleShowDialog(byte[] bArr) {
        return writeDataToBleShowDialog(bArr, getString(R.string.setting));
    }

    protected boolean writeDataToBleWarn(byte[] bArr, String str) {
        if (writeDataToBle(bArr, str)) {
            return true;
        }
        ToastUtils.t(R.string.unconnected);
        return false;
    }

    protected boolean writeDataToBleShowDialog(byte[] bArr, String str) {
        if (!writeDataToBleWarn(bArr, str)) {
            return false;
        }
        pb0.c(this.mContext, str);
        return true;
    }

    protected void registerAckCallback(int... iArr) {
        for (int i : iArr) {
            registerAckCallback(i);
        }
    }
}
