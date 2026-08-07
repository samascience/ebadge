package defpackage;

import android.util.Log;
import com.clj.fastble.BleManager;
import com.clj.fastble.callback.BleGattCallback;
import com.clj.fastble.data.BleDevice;

/* JADX INFO: loaded from: classes.dex */
public class sm1 {
    private static sm1 g;
    private BleDevice c;
    private String d;
    b f;
    private final String a = sm1.class.getSimpleName();
    a e = new a(this, null);
    private final BleManager b = BleManager.getInstance();

    private class a extends BleGattCallback {
        private a() {
        }

        /* synthetic */ a(sm1 sm1Var, rm1 rm1Var) {
            this();
        }
    }

    public interface b {
    }

    public static sm1 d() {
        if (g == null) {
            g = new sm1();
        }
        return g;
    }

    public void a(String str) {
        Log.i(this.a, "connect mac:" + str);
        this.d = str;
        this.b.connect(str, this.e);
    }

    public void b(String str, b bVar) {
        Log.i(this.a, "connect mac:" + str);
        this.f = bVar;
        a(str);
    }

    public void c() {
        this.b.disconnect(this.c);
        this.c = null;
        Log.i(this.a, "强制断开蓝牙设备!");
    }

    public void e() {
        this.f = null;
    }
}
