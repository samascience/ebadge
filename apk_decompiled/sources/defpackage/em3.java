package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import yqy.yichip.yc_lib_ota_3_gen.wristband._3GenBandOtaService;

/* JADX INFO: loaded from: classes4.dex */
public class em3 {
    private static volatile em3 f;
    private Context a;
    private pm3 c;
    private boolean d;
    private _3GenBandOtaService b = null;
    private ServiceConnection e = new a();

    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder instanceof _3GenBandOtaService.f) {
                _3GenBandOtaService.f fVar = (_3GenBandOtaService.f) iBinder;
                Log.d("_3GenBandOtaManager", "onServiceConnected()-->" + fVar.a().getClass().getName());
                em3.this.b = fVar.a();
                em3 em3Var = em3.this;
                em3Var.d = em3Var.b != null;
                if (em3.this.c != null) {
                    if (em3.this.b == null) {
                        em3.this.c.a(em3.this.d);
                    } else {
                        em3.this.c.a(em3.this.d);
                    }
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d("_3GenBandOtaManager", "onServiceDisconnected()-->" + componentName.getClassName());
        }
    }

    private em3(Context context) {
        Log.d("_3GenBandOtaManager", "_3GenOtaManager()-->");
        this.a = context;
        this.d = false;
    }

    public static synchronized em3 g(Context context) {
        try {
            if (f == null) {
                synchronized (em3.class) {
                    try {
                        if (f == null) {
                            f = new em3(context);
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

    public void f() {
        Log.d("_3GenBandOtaManager", "destroyManager()---> = " + this.d);
        if (this.d) {
            this.a.unbindService(this.e);
            this.e = null;
            this.d = false;
        }
    }
}
