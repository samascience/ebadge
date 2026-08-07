package defpackage;

import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.PoiRegion;
import com.baidu.location.b;
import com.baidu.location.f;
import com.tencent.connect.common.Constants;
import java.util.List;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class qq3 extends iq3 {
    private static qq3 a0 = null;
    public static String b0 = "0";
    public static boolean c0 = false;
    private long B;
    private double F;
    private double G;
    public iq3.b n;
    private boolean m = true;
    private String o = null;
    private BDLocation p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private BDLocation f378q = null;
    private eq3 r = null;
    private bn3 s = null;
    private eq3 t = null;
    private bn3 u = null;
    private boolean v = true;
    private volatile boolean w = false;
    private boolean x = false;
    private long y = 0;
    private long z = 0;
    private b A = null;
    private String C = null;
    private List D = null;
    private PoiRegion E = null;
    private boolean H = false;
    private long I = 0;
    private long J = 0;
    private boolean K = false;
    private boolean L = false;
    private boolean M = true;
    public final Handler N = new iq3.a();
    private boolean O = false;
    private boolean P = false;
    private a Q = null;
    private boolean R = false;
    private int S = 0;
    private long T = 0;
    private boolean U = false;
    private String V = null;
    private boolean W = false;
    private boolean X = false;
    private boolean Y = false;
    private boolean Z = true;

    private class a implements Runnable {
        private a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (qq3.this.R) {
                qq3.this.R = false;
            }
            if (qq3.this.x) {
                qq3.this.x = false;
                qq3.this.G(null);
            }
        }

        /* synthetic */ a(qq3 qq3Var, rq3 rq3Var) {
            this();
        }
    }

    private qq3() {
        this.n = null;
        this.n = new iq3.b();
    }

    private void A(BDLocation bDLocation) {
        this.Y = bDLocation != null && bDLocation.s();
    }

    private void C(Message message) {
        a aVar;
        if (!jq3.c().n()) {
            G(message);
            return;
        }
        this.x = true;
        if (this.Q == null) {
            this.Q = new a(this, null);
        }
        if (this.R && (aVar = this.Q) != null) {
            this.N.removeCallbacks(aVar);
        }
        this.N.postDelayed(this.Q, 3500L);
        this.R = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(Message message) {
        this.S = 0;
        if (!this.v) {
            C(message);
            this.J = SystemClock.uptimeMillis();
            return;
        }
        this.S = 1;
        this.J = SystemClock.uptimeMillis();
        if (jq3.c().r()) {
            C(message);
        } else {
            G(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:36:0x00a0  */
    public void G(Message message) {
        long jCurrentTimeMillis;
        long jCurrentTimeMillis2 = System.currentTimeMillis() - this.y;
        if (!this.w || jCurrentTimeMillis2 > 12000) {
            if (System.currentTimeMillis() - this.y > 0 && System.currentTimeMillis() - this.y < 1000) {
                if (this.p != null) {
                    ro3.b().f(this.p);
                }
                L();
                return;
            }
            this.w = true;
            this.m = i(this.s);
            if (!j(this.r) && !this.m && this.p != null && !this.H) {
                if (this.f378q != null && System.currentTimeMillis() - this.z > 30000) {
                    this.p = this.f378q;
                    this.f378q = null;
                }
                if (tq3.a().e()) {
                    this.p.A(tq3.a().f());
                }
                if (this.p.g() == 62) {
                    jCurrentTimeMillis = System.currentTimeMillis() - this.T;
                    if (jCurrentTimeMillis <= 0) {
                        jCurrentTimeMillis = 0;
                    }
                } else {
                    jCurrentTimeMillis = 0;
                }
                if (this.p.g() == 61 || this.p.g() == 161 || (this.p.g() == 62 && jCurrentTimeMillis < 15000)) {
                    ro3.b().f(this.p);
                    L();
                    return;
                }
            }
            this.y = System.currentTimeMillis();
            String strA = a(null);
            this.P = false;
            if (strA == null) {
                this.P = true;
                this.T = System.currentTimeMillis();
                String[] strArrK = new String[2];
                try {
                    strArrK = K();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                long jCurrentTimeMillis3 = System.currentTimeMillis();
                if (jCurrentTimeMillis3 - this.I > 60000) {
                    this.I = jCurrentTimeMillis3;
                }
                String strT = jq3.c().t();
                if (strT != null) {
                    strA = strT + e() + strArrK[0];
                } else {
                    strA = Constants.STR_EMPTY + e() + strArrK[0];
                }
                bn3 bn3Var = this.b;
                if (bn3Var != null && bn3Var.i() != null) {
                    strA = this.b.i() + strA;
                }
                String strB = to3.a().b(true);
                if (strB != null) {
                    strA = strA + strB;
                }
            }
            if (this.o != null) {
                strA = strA + this.o;
                this.o = null;
            }
            eq3 eq3Var = this.a;
            this.n.f(strA, eq3Var != null ? eq3Var.o() : 0L);
            this.s = this.b;
            this.r = this.a;
            if (this.v) {
                this.v = false;
                if (jq3.c().q() && message != null) {
                    ro3.b().r(message);
                }
            }
            int i = this.S;
            if (i > 0) {
                if (i == 2) {
                    jq3.c().n();
                }
                this.S = 0;
            }
        }
    }

    private String[] K() {
        boolean z;
        String[] strArr = {Constants.STR_EMPTY, "Location failed beacuse we can not get any loc information!"};
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("&apl=");
        int iB = fq3.b(f.b());
        if (iB == 1) {
            strArr[1] = "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!";
        }
        stringBuffer.append(iB);
        String strZ = fq3.z(f.b());
        if (strZ.contains("0|0|")) {
            strArr[1] = "Location failed beacuse we can not get any loc information without any location permission!";
        }
        stringBuffer.append(strZ);
        stringBuffer.append("&loc=");
        int iQ = fq3.q(f.b());
        if (iQ == 0) {
            strArr[1] = "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!";
            z = true;
        } else {
            z = false;
        }
        stringBuffer.append(iQ);
        stringBuffer.append("&lmd=");
        int iQ2 = fq3.q(f.b());
        if (iQ2 >= 0) {
            stringBuffer.append(iQ2);
        }
        String strW = so3.h().w();
        String strO = jq3.c().o();
        stringBuffer.append(strO);
        stringBuffer.append(strW);
        stringBuffer.append(fq3.B(f.b()));
        if (iB == 1) {
            wo3.a().b(62, 7, "Location failed beacuse we can not get any loc information in airplane mode, you can turn it off and try again!!");
        } else if (strZ.contains("0|0|")) {
            wo3.a().b(62, 4, "Location failed beacuse we can not get any loc information without any location permission!");
        } else if (z) {
            wo3.a().b(62, 5, "Location failed beacuse we can not get any loc information with the phone loc mode is off, you can turn it on and try again!");
        } else if (strW == null || strO == null || !strW.equals("&sim=1") || strO.equals("&wifio=1")) {
            wo3.a().b(62, 9, "Location failed beacuse we can not get any loc information!");
        } else {
            wo3.a().b(62, 6, "Location failed beacuse we can not get any loc information , you can insert a sim card or open wifi and try again!");
        }
        strArr[0] = stringBuffer.toString();
        return strArr;
    }

    private void L() {
        this.w = false;
        this.L = false;
        this.M = false;
        this.H = false;
        M();
        if (this.Z) {
            this.Z = false;
        }
    }

    private void M() {
        if (this.p == null || !jq3.c().q()) {
            return;
        }
        ar3.b().g();
    }

    private boolean i(bn3 bn3Var) {
        bn3 bn3VarV = so3.h().v();
        this.b = bn3VarV;
        if (bn3VarV == bn3Var) {
            return false;
        }
        if (bn3VarV == null || bn3Var == null) {
            return true;
        }
        return !bn3Var.b(bn3VarV);
    }

    private boolean j(eq3 eq3Var) {
        eq3 eq3VarW = jq3.c().w();
        this.a = eq3VarW;
        if (eq3Var == eq3VarW) {
            return false;
        }
        if (eq3VarW == null || eq3Var == null) {
            return true;
        }
        return !eq3Var.l(eq3VarW);
    }

    private void o(String str) {
        this.X = str != null && "subway".equals(str.toLowerCase());
    }

    public static synchronized qq3 s() {
        try {
            if (a0 == null) {
                a0 = new qq3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return a0;
    }

    private void t(Message message) {
        if (!fq3.x(f.b())) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.O(62);
            ro3.b().f(bDLocation);
            return;
        }
        if (fq3.r()) {
            Log.d("baidu_location_service", "isInforbiddenTime on request location ...");
        }
        if (message.getData().getBoolean("isWaitingLocTag", false)) {
            c0 = true;
        }
        int iO = ro3.b().o(message);
        if (iO == 1) {
            w(message);
            return;
        }
        if (iO == 2) {
            if (mp3.f().m0()) {
                z(message);
            }
        } else {
            if (iO != 3 && iO != 4) {
                throw new IllegalArgumentException(String.format("this type %d is illegal", Integer.valueOf(iO)));
            }
            E(message);
        }
    }

    private void w(Message message) {
        if (mp3.f().m0()) {
            z(message);
            tq3.a().d();
        } else {
            E(message);
            tq3.a().c();
        }
    }

    private void x(BDLocation bDLocation) {
        if (fq3.k || bDLocation.j() <= 0) {
            ro3.b().f(bDLocation);
        } else {
            ro3.b().m(bDLocation);
        }
    }

    private void z(Message message) {
        BDLocation bDLocation = new BDLocation(mp3.f().d0());
        Location locationE0 = mp3.f().e0();
        if (locationE0 != null && "bd_beidou".equals(locationE0.getProvider())) {
            bDLocation.F("bd_beidou");
        }
        if (locationE0 != null) {
            bDLocation.E(locationE0.getExtras());
        }
        if (fq3.d.equals("all") || fq3.f || fq3.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.G, this.F, bDLocation.f(), bDLocation.i(), fArr);
            if (fArr[0] < 100.0f) {
                b bVar = this.A;
                if (bVar != null) {
                    bDLocation.t(bVar);
                }
                String str = this.C;
                if (str != null) {
                    bDLocation.Q(str);
                }
                List list = this.D;
                if (list != null) {
                    bDLocation.Y(list);
                }
                PoiRegion poiRegion = this.E;
                if (poiRegion != null) {
                    bDLocation.Z(poiRegion);
                }
            } else {
                this.H = true;
                E(null);
            }
        }
        this.p = bDLocation;
        this.f378q = null;
        x(bDLocation);
    }

    public String B() {
        return this.C;
    }

    public List D() {
        return this.D;
    }

    public PoiRegion F() {
        return this.E;
    }

    public void H() {
        if (this.x) {
            G(null);
            this.x = false;
        }
    }

    public boolean I() {
        return this.Y;
    }

    public void J() {
        this.p = null;
    }

    @Override // defpackage.iq3
    public void c() {
        if (mp3.f().m0()) {
            BDLocation bDLocation = new BDLocation(mp3.f().d0());
            Location locationE0 = mp3.f().e0();
            if (locationE0 != null && "bd_beidou".equals(locationE0.getProvider())) {
                bDLocation.F("bd_beidou");
            }
            if (locationE0 != null) {
                bDLocation.E(locationE0.getExtras());
            }
            if (fq3.d.equals("all") || fq3.f || fq3.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.G, this.F, bDLocation.f(), bDLocation.i(), fArr);
                if (fArr[0] < 100.0f) {
                    b bVar = this.A;
                    if (bVar != null) {
                        bDLocation.t(bVar);
                    }
                    String str = this.C;
                    if (str != null) {
                        bDLocation.Q(str);
                    }
                    List list = this.D;
                    if (list != null) {
                        bDLocation.Y(list);
                    }
                    PoiRegion poiRegion = this.E;
                    if (poiRegion != null) {
                        bDLocation.Z(poiRegion);
                    }
                }
            }
            ro3.b().f(bDLocation);
        } else {
            if (this.L) {
                L();
                return;
            }
            if (this.m || this.p == null) {
                BDLocation bDLocation2 = new BDLocation();
                bDLocation2.O(63);
                this.p = null;
                ro3.b().f(bDLocation2);
            } else {
                ro3.b().f(this.p);
            }
            this.f378q = null;
        }
        L();
    }

    @Override // defpackage.iq3
    public void d(Message message) {
        BDLocation bDLocation = (BDLocation) message.obj;
        if (bDLocation != null && bDLocation.g() == 161) {
            o(bDLocation.p());
            A(bDLocation);
        }
        if (bDLocation != null && bDLocation.g() == 167 && this.P) {
            bDLocation.O(62);
        }
        n(bDLocation);
    }

    public b g(BDLocation bDLocation) {
        if (fq3.d.equals("all") || fq3.f || fq3.h) {
            float[] fArr = new float[2];
            Location.distanceBetween(this.G, this.F, bDLocation.f(), bDLocation.i(), fArr);
            if (fArr[0] < 100.0d) {
                b bVar = this.A;
                if (bVar != null) {
                    return bVar;
                }
            } else {
                this.C = null;
                this.D = null;
                this.E = null;
                this.H = true;
                this.N.post(new rq3(this));
            }
        }
        return null;
    }

    public void m(Message message) {
        if (this.O) {
            t(message);
        }
    }

    public void n(BDLocation bDLocation) {
        String strO;
        eq3 eq3Var;
        BDLocation bDLocation2;
        String str;
        new BDLocation(bDLocation);
        if (bDLocation.r()) {
            b bVarB = bDLocation.b();
            this.A = bVarB;
            if (bVarB != null && (str = bVarB.e) != null) {
                b0 = str;
                this.B = System.currentTimeMillis();
            }
            this.F = bDLocation.i();
            this.G = bDLocation.f();
        }
        if (bDLocation.h() != null) {
            this.C = bDLocation.h();
            this.F = bDLocation.i();
            this.G = bDLocation.f();
        }
        if (bDLocation.l() != null) {
            this.D = bDLocation.l();
            this.F = bDLocation.i();
            this.G = bDLocation.f();
        }
        if (bDLocation.m() != null) {
            this.E = bDLocation.m();
            this.F = bDLocation.i();
            this.G = bDLocation.f();
        }
        boolean z = false;
        if (mp3.f().m0()) {
            BDLocation bDLocation3 = new BDLocation(mp3.f().d0());
            Location locationE0 = mp3.f().e0();
            if (locationE0 != null && "bd_beidou".equals(locationE0.getProvider())) {
                bDLocation3.F("bd_beidou");
            }
            if (locationE0 != null) {
                bDLocation3.E(locationE0.getExtras());
            }
            if (fq3.d.equals("all") || fq3.f || fq3.h) {
                float[] fArr = new float[2];
                Location.distanceBetween(this.G, this.F, bDLocation3.f(), bDLocation3.i(), fArr);
                if (fArr[0] < 100.0f) {
                    b bVar = this.A;
                    if (bVar != null) {
                        bDLocation3.t(bVar);
                    }
                    String str2 = this.C;
                    if (str2 != null) {
                        bDLocation3.Q(str2);
                    }
                    List list = this.D;
                    if (list != null) {
                        bDLocation3.Y(list);
                    }
                    PoiRegion poiRegion = this.E;
                    if (poiRegion != null) {
                        bDLocation3.Z(poiRegion);
                    }
                }
            }
            x(bDLocation3);
            L();
            return;
        }
        if (this.L) {
            float[] fArr2 = new float[2];
            BDLocation bDLocation4 = this.p;
            if (bDLocation4 != null) {
                Location.distanceBetween(bDLocation4.f(), this.p.i(), bDLocation.f(), bDLocation.i(), fArr2);
            }
            if (fArr2[0] > 10.0f) {
                this.p = bDLocation;
                if (!this.M) {
                    this.M = false;
                    ro3.b().f(bDLocation);
                }
            } else if (bDLocation.q() > -1) {
                this.p = bDLocation;
                ro3.b().f(bDLocation);
            }
            L();
            return;
        }
        if (bDLocation.g() == 167) {
            wo3.a().b(Opcodes.GOTO, 8, "NetWork location failed because baidu location service can not caculate the location!");
        } else if (bDLocation.g() == 161) {
            int iQ = fq3.q(f.b());
            if (iQ == 0 || iQ == 2) {
                wo3.a().b(161, 1, "NetWork location successful, open gps will be better!");
            } else if (bDLocation.n() >= 100.0f && bDLocation.k() != null && bDLocation.k().equals("cl") && (strO = jq3.c().o()) != null && !strO.equals("&wifio=1")) {
                wo3.a().b(161, 2, "NetWork location successful, open wifi will be better!");
            }
        }
        this.f378q = null;
        if (bDLocation.g() == 161 && "cl".equals(bDLocation.k()) && (bDLocation2 = this.p) != null && bDLocation2.g() == 161 && "wf".equals(this.p.k()) && System.currentTimeMillis() - this.z < 30000) {
            this.f378q = bDLocation;
            z = true;
        }
        ro3 ro3VarB = ro3.b();
        if (z) {
            ro3VarB.f(this.p);
        } else {
            ro3VarB.f(bDLocation);
            this.z = System.currentTimeMillis();
        }
        if (!fq3.o(bDLocation)) {
            this.p = null;
        } else if (!z) {
            this.p = bDLocation;
        }
        int iE = fq3.e(iq3.l, "ssid\":\"", "\"");
        if (iE == Integer.MIN_VALUE || (eq3Var = this.r) == null) {
            this.o = null;
        } else {
            this.o = eq3Var.h(iE);
        }
        jq3.c().q();
        L();
    }

    public void u(BDLocation bDLocation) {
        this.p = new BDLocation(bDLocation);
    }

    public void v() {
        this.v = true;
        this.w = false;
        this.O = true;
    }

    public void y() {
        this.w = false;
        this.x = false;
        this.L = false;
        this.M = true;
        J();
        this.O = false;
    }
}
