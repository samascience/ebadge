package defpackage;

import android.location.Location;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.baidu.location.Jni;
import com.baidu.location.f;
import java.util.HashMap;
import java.util.Locale;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public abstract class iq3 {
    public static String l;
    public eq3 a = null;
    public bn3 b = null;
    private boolean c = true;
    private boolean d = true;
    private boolean e = false;
    private long f = 0;
    final Handler g = new a();
    private String h = null;
    private String i = null;
    private boolean j = false;
    private long k = 0;

    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (f.e) {
                int i = message.what;
                if (i == 21) {
                    iq3.this.d(message);
                } else if (i == 62 || i == 63) {
                    iq3.this.c();
                }
            }
        }
    }

    class b extends np3 {
        String k = null;
        String l = null;
        long m = 0;
        long n = 0;

        public b() {
            this.d = new HashMap();
        }

        @Override // defpackage.np3
        public void a() {
            if ((fq3.f || fq3.h) && iq3.this.h != null && iq3.this.i != null) {
                this.l += String.format(Locale.CHINA, "&ki=%s&sn=%s", iq3.this.h, iq3.this.i);
            }
            if (mq3.b().d()) {
                this.l += "&enc=2";
            }
            String strG = Jni.g(this.l);
            this.l = null;
            if (this.k == null) {
                this.k = zq3.l();
            }
            this.d.put("bloc", strG);
            String str = this.k;
            if (str != null) {
                this.d.put("up", str);
            }
            this.d.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
        
            r10 = r9.c;
         */
        @Override // defpackage.np3
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void d(boolean r10) {
            /*
                Method dump skipped, instruction units count: 232
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: iq3.b.d(boolean):void");
        }

        public void f(String str, long j) {
            this.l = str;
            this.n = System.currentTimeMillis();
            this.m = j;
            ExecutorService executorServiceB = xq3.a().b();
            if (fq3.r()) {
                c(executorServiceB, false, null);
            } else if (executorServiceB != null) {
                b(executorServiceB, fp3.a);
            } else {
                e(fp3.a);
            }
        }
    }

    public String a(String str) {
        eq3 eq3Var;
        String strT;
        if (this.h == null) {
            this.h = zm3.d(f.b());
        }
        if (this.i == null) {
            this.i = zm3.f(f.b());
        }
        bn3 bn3Var = this.b;
        if (bn3Var == null || !bn3Var.a()) {
            this.b = so3.h().v();
        }
        eq3 eq3Var2 = this.a;
        if (eq3Var2 == null || !eq3Var2.s()) {
            this.a = jq3.c().w();
        }
        Location locationE0 = mp3.f().m0() ? mp3.f().e0() : null;
        bn3 bn3Var2 = this.b;
        if ((bn3Var2 == null || bn3Var2.e() || this.b.d()) && (((eq3Var = this.a) == null || eq3Var.a() == 0) && locationE0 == null)) {
            return null;
        }
        String strE = e();
        if (dq3.c().l() == -2) {
            strE = strE + "&imo=1";
        }
        int iQ = fq3.q(f.b());
        if (iQ >= 0) {
            strE = strE + "&lmd=" + iQ;
            if (Build.VERSION.SDK_INT >= 28 && !this.j) {
                this.j = true;
                try {
                    if (f.b().getPackageManager().hasSystemFeature("android.hardware.wifi.rtt")) {
                        strE = strE + "&rtt=1";
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
        eq3 eq3Var3 = this.a;
        if ((eq3Var3 == null || eq3Var3.a() == 0) && (strT = jq3.c().t()) != null) {
            strE = strT + strE;
        }
        String str2 = strE;
        if (!this.d) {
            return fq3.g(this.b, this.a, locationE0, str2, 0);
        }
        this.d = false;
        return fq3.h(this.b, this.a, locationE0, str2, 0, true);
    }

    public abstract void c();

    public abstract void d(Message message);

    public String e() {
        String strL = ro3.b().l();
        String str = jq3.c().q() ? "&cn=32" : String.format(Locale.CHINA, "&cn=%d", Integer.valueOf(so3.h().u()));
        if (System.currentTimeMillis() - this.k > 60000) {
            this.k = System.currentTimeMillis();
            String strV = fq3.v();
            if (!TextUtils.isEmpty(strV)) {
                str = str + "&qcip6c=" + strV;
            }
        }
        if (this.c) {
            this.c = false;
        } else if (!this.e) {
            String strR = zq3.r();
            if (strR != null) {
                str = str + strR;
            }
            this.e = true;
        }
        return str + strL;
    }
}
