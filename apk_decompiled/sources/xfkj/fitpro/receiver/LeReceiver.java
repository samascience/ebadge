package xfkj.fitpro.receiver;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import defpackage.zm1;
import java.io.Serializable;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class LeReceiver extends BroadcastReceiver {
    private Context a;
    private Handler b;
    private IntentFilter c;
    private Intent d = null;

    public LeReceiver(Context context, Handler handler) {
        this.a = context;
        this.b = handler;
        IntentFilter intentFilter = new IntentFilter();
        this.c = intentFilter;
        intentFilter.addAction("find");
        this.c.addAction("state");
        this.c.addAction("charac_write");
        this.c.addAction("charac_read");
        this.c.addAction("charac_changed");
        this.c.addAction("descriptor");
        this.c.addAction("find_phone");
    }

    public Intent a() {
        return (Build.VERSION.SDK_INT < 34 || this.a.getApplicationInfo().targetSdkVersion < 34) ? this.a.registerReceiver(this, this.c) : this.a.registerReceiver(this, this.c, 2);
    }

    public void b() {
        this.a.unregisterReceiver(this);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            Message message = new Message();
            Map map = (Map) intent.getExtras().getSerializable("Datas");
            String action = intent.getAction();
            if (action.equals(map.get("action").toString())) {
                if (action.equals("find")) {
                    ((BluetoothDevice) map.get("device")).getAddress();
                    zm1.f();
                }
                Bundle bundle = new Bundle();
                bundle.putSerializable("Datas", (Serializable) map);
                Integer num = (Integer) map.get("what");
                message.setData(bundle);
                message.what = num.intValue();
                this.b.sendMessage(message);
            }
        } catch (Exception unused) {
        }
    }
}
