package defpackage;

import android.bluetooth.BluetoothDevice;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import java.util.List;
import yqy.yichip.yc_lib_ota_3_gen.wristband_1121E._3GenEBandOtaService;

/* JADX INFO: loaded from: classes4.dex */
public class hm3 {
    private static volatile hm3 f;
    private Context a;
    private pm3 c;
    private boolean d;
    private _3GenEBandOtaService b = null;
    private ServiceConnection e = new a();

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            _3GenEBandOtaService.f fVar = (_3GenEBandOtaService.f) iBinder;
            Log.d("_3GenEBandOtaManager", "onServiceConnected()-->" + fVar.a().getClass().getName());
            hm3.this.b = fVar.a();
            hm3 hm3Var = hm3.this;
            hm3Var.d = hm3Var.b != null;
            if (hm3.this.c != null) {
                if (hm3.this.b == null) {
                    hm3.this.c.a(hm3.this.d);
                } else {
                    hm3.this.c.a(hm3.this.d);
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("_3GenEBandOtaManager", "onServiceDisconnected()-->" + componentName.getClassName());
        }
    }

    private hm3(Context context) {
        Log.d("_3GenEBandOtaManager", "_3GenEBandOtaManager()-->");
        this.a = context;
        this.d = false;
    }

    public static synchronized hm3 g(Context context) {
        try {
            if (f == null) {
                synchronized (hm3.class) {
                    try {
                        if (f == null) {
                            f = new hm3(context);
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return f;
    }

    public List f() {
        _3GenEBandOtaService _3genebandotaservice = this.b;
        if (_3genebandotaservice == null) {
            return null;
        }
        return _3genebandotaservice.L0();
    }

    public boolean h(boolean z) {
        _3GenEBandOtaService _3genebandotaservice = this.b;
        if (_3genebandotaservice == null) {
            return false;
        }
        _3genebandotaservice.N0(z);
        return true;
    }

    public void i(pm3 pm3Var) {
        this.c = pm3Var;
        if (this.d) {
            pm3Var.a(true);
        } else {
            this.a.bindService(new Intent(this.a, (Class<?>) _3GenEBandOtaService.class), this.e, 1);
        }
    }

    public boolean j() {
        _3GenEBandOtaService _3genebandotaservice = this.b;
        if (_3genebandotaservice == null) {
            return false;
        }
        _3genebandotaservice.P0();
        return true;
    }

    public boolean k(rm3 rm3Var) {
        if (this.b == null) {
            return false;
        }
        Log.d("_3GenEBandOtaManager", "setA3GenOtaServiceActivityListener()-->");
        this.b.W0(rm3Var);
        return true;
    }

    public boolean l(String str, int i, BluetoothDevice bluetoothDevice) {
        _3GenEBandOtaService _3genebandotaservice = this.b;
        if (_3genebandotaservice == null) {
            return false;
        }
        _3genebandotaservice.Y0(str, i, bluetoothDevice);
        return true;
    }

    public boolean m() {
        _3GenEBandOtaService _3genebandotaservice = this.b;
        if (_3genebandotaservice == null) {
            return false;
        }
        _3genebandotaservice.Z0();
        return true;
    }
}
