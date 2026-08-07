package defpackage;

import android.content.Intent;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baidu.location.PoiRegion;
import com.baidu.location.b;
import com.baidu.location.f;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ro3 {
    private static ro3 l = null;
    public static long m = 0;
    public static int n = -1;
    private ArrayList a;
    private boolean b = false;
    public boolean c = false;
    boolean d = false;
    private BDLocation e = null;
    private BDLocation f = null;
    private Object g = new Object();
    int h = 0;
    private BDLocation i = null;
    private boolean j = false;
    private boolean k = false;

    private class a {
        public String a;
        public Messenger b;
        public LocationClientOption c = new LocationClientOption();
        public int d = 0;

        public a(Message message) {
            this.a = null;
            this.b = null;
            this.b = message.replyTo;
            this.a = message.getData().getString("packName");
            this.c.f = message.getData().getString("prodName");
            to3.a().e(this.c.f, this.a);
            this.c.a = message.getData().getString("coorType");
            this.c.b = message.getData().getString("addrType");
            this.c.j = message.getData().getBoolean("enableSimulateGps", false);
            fq3.k = fq3.k || this.c.j;
            if (!fq3.d.equals("all")) {
                fq3.d = this.c.b;
            }
            this.c.c = message.getData().getBoolean("openGPS");
            this.c.d = message.getData().getInt("scanSpan");
            this.c.e = message.getData().getInt("timeOut");
            this.c.g = message.getData().getInt("priority");
            this.c.h = message.getData().getBoolean("location_change_notify");
            this.c.n = message.getData().getBoolean("needDirect", false);
            this.c.s = message.getData().getBoolean("isneedaltitude", false);
            this.c.t = message.getData().getBoolean("isneednewrgc", false);
            fq3.g = fq3.g || this.c.t;
            fq3.f = fq3.f || message.getData().getBoolean("isneedaptag", false);
            fq3.h = fq3.h || message.getData().getBoolean("isneedaptagd", false);
            fq3.v = message.getData().getFloat("autoNotifyLocSensitivity", 0.5f);
            int i = message.getData().getInt("wfnum", fq3.L);
            float f = message.getData().getFloat("wfsm", fq3.M);
            int i2 = message.getData().getInt("gnmcon", fq3.O);
            double d = message.getData().getDouble("gnmcrm", fq3.N);
            int i3 = message.getData().getInt("iupl", 1);
            fq3.S = message.getData().getInt("ct", 10);
            fq3.T = message.getData().getInt("suci", 3);
            fq3.V = message.getData().getDoubleArray("cgs");
            fq3.W = message.getData().getInt("ums", 1);
            fq3.U = message.getData().getInt("smn", 40);
            if (i3 <= 0) {
                fq3.R = 0;
            } else if (fq3.R == -1) {
                fq3.R = 1;
            }
            if (message.getData().getInt("opetco", 1) == 0) {
                fq3.X = 0;
            }
            if (message.getData().getInt("lpcs", fq3.Y) == 0) {
                fq3.Y = 0;
            }
            if (i2 == 1) {
                fq3.O = 1;
            }
            if (d > fq3.N) {
                fq3.N = d;
            }
            fq3.K = fq3.K || message.getData().getBoolean("ischeckper", false);
            boolean z = message.getData().getBoolean("isEnableBeidouMode", false);
            if (Build.VERSION.SDK_INT >= 28) {
                fq3.a0 = fq3.a0 || z;
            }
            if (i > fq3.L) {
                fq3.L = i;
            }
            if (f > fq3.M) {
                fq3.M = f;
            }
            int i4 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
            if (i4 < fq3.D) {
                fq3.D = i4;
            }
            int i5 = message.getData().getInt("autoNotifyMaxInterval", 0);
            if (i5 >= fq3.z) {
                fq3.z = i5;
            }
            int i6 = message.getData().getInt("autoNotifyMinDistance", 0);
            if (i6 >= fq3.B) {
                fq3.B = i6;
            }
            int i7 = message.getData().getInt("autoNotifyMinTimeInterval", 0);
            if (i7 >= fq3.A) {
                fq3.A = i7;
            }
            LocationClientOption locationClientOption = this.c;
            if (locationClientOption.n || locationClientOption.s) {
                tq3.a().b(this.c.n);
                tq3.a().c();
            }
            ro3.this.d = ro3.this.d || this.c.s;
            if (message.getData().getInt("hpdts", fq3.P) == 1) {
                fq3.P = 1;
            } else {
                fq3.P = 0;
            }
            if (message.getData().getInt("oldts", fq3.Q) == 1) {
                fq3.Q = 1;
            } else {
                fq3.Q = 0;
            }
        }

        private double a(boolean z, BDLocation bDLocation, BDLocation bDLocation2) {
            double d;
            double dF;
            double dI;
            double dF2;
            double dI2;
            double dA;
            double[] dArrC;
            double[] dArrC2;
            if (z) {
                if (!TextUtils.equals(bDLocation2.c(), bDLocation.c())) {
                    if (TextUtils.equals("wgs84", bDLocation.c())) {
                        dArrC = new double[]{bDLocation.i(), bDLocation.f()};
                    } else {
                        if (TextUtils.equals("bd09", bDLocation.c())) {
                            dArrC2 = Jni.c(bDLocation.i(), bDLocation.f(), "bd092gcj");
                        } else {
                            dArrC2 = TextUtils.equals("bd09ll", bDLocation.c()) ? Jni.c(bDLocation.i(), bDLocation.f(), "bd09ll2gcj") : new double[]{bDLocation.i(), bDLocation.f()};
                        }
                        dArrC = Jni.c(dArrC2[0], dArrC2[1], "gcj2wgs");
                    }
                    bDLocation.N(dArrC[1]);
                    d = dArrC[0];
                    bDLocation.T(d);
                    bDLocation.i0(fq3.f());
                    bDLocation.x("wgs84");
                } else if (TextUtils.equals("bd09", bDLocation2.c())) {
                    double[] dArrC3 = Jni.c(bDLocation2.i(), bDLocation2.f(), "bd092gcj");
                    double[] dArrC4 = Jni.c(bDLocation.i(), bDLocation.f(), "bd092gcj");
                    dF = dArrC3[1];
                    dI = dArrC3[0];
                    dF2 = dArrC4[1];
                    dI2 = dArrC4[0];
                    dA = fq3.a(dF, dI, dF2, dI2);
                }
                dA = fq3.a(bDLocation2.f(), bDLocation2.i(), bDLocation.f(), bDLocation.i());
            } else if (TextUtils.equals(bDLocation2.c(), bDLocation.c())) {
                dF = bDLocation2.f();
                dI = bDLocation2.i();
                dF2 = bDLocation.f();
                dI2 = bDLocation.i();
                dA = fq3.a(dF, dI, dF2, dI2);
            } else {
                double[] dArrC5 = Jni.c(bDLocation.i(), bDLocation.f(), "gcj2wgs");
                bDLocation.N(dArrC5[1]);
                d = dArrC5[0];
                bDLocation.T(d);
                bDLocation.i0(fq3.f());
                bDLocation.x("wgs84");
                dA = fq3.a(bDLocation2.f(), bDLocation2.i(), bDLocation.f(), bDLocation.i());
            }
            bDLocation2.B(dA);
            if (bDLocation != null) {
                bDLocation2.c0(bDLocation);
            }
            return dA;
        }

        private int b(double d) {
            if (d >= 0.0d && d <= 10.0d) {
                return 0;
            }
            if (d <= 10.0d || d > 100.0d) {
                return (d <= 100.0d || d > 200.0d) ? 3 : 2;
            }
            return 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i) {
            Message messageObtain = Message.obtain((Handler) null, i);
            try {
                Messenger messenger = this.b;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(int i, Bundle bundle) {
            Message messageObtain = Message.obtain((Handler) null, i);
            messageObtain.setData(bundle);
            try {
                Messenger messenger = this.b;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
                e.printStackTrace();
            }
        }

        private void g(int i, String str, BDLocation bDLocation) {
            Bundle bundle = new Bundle();
            bundle.putParcelable(str, bDLocation);
            bundle.setClassLoader(BDLocation.class.getClassLoader());
            Message messageObtain = Message.obtain((Handler) null, i);
            messageObtain.setData(bundle);
            try {
                Messenger messenger = this.b;
                if (messenger != null) {
                    messenger.send(messageObtain);
                }
                this.d = 0;
            } catch (Exception e) {
                if (e instanceof DeadObjectException) {
                    this.d++;
                }
            }
        }

        private BDLocation l() {
            BDLocation bDLocationH0 = mp3.f().h0();
            if (bDLocationH0 == null) {
                return null;
            }
            double[] dArrC = Jni.c(bDLocationH0.i(), bDLocationH0.f(), "gps2gcj");
            double[] dArrC2 = Jni.c(dArrC[0], dArrC[1], this.c.a);
            BDLocation bDLocation = new BDLocation();
            bDLocation.T(dArrC2[0]);
            bDLocation.N(dArrC2[1]);
            bDLocation.i0(fq3.f());
            bDLocation.O(61);
            bDLocation.x(this.c.a);
            return bDLocation;
        }

        private BDLocation m() {
            BDLocation bDLocationH0 = mp3.f().h0();
            if (bDLocationH0 == null) {
                return null;
            }
            double[] dArrC = Jni.c(bDLocationH0.i(), bDLocationH0.f(), "gps2gcj");
            BDLocation bDLocation = new BDLocation();
            bDLocation.T(dArrC[0]);
            bDLocation.N(dArrC[1]);
            bDLocation.i0(fq3.f());
            bDLocation.O(61);
            bDLocation.x("gcj02");
            return bDLocation;
        }

        public int c(int i, boolean z, BDLocation bDLocation) {
            double dA;
            if (i == 100) {
                if (z) {
                    BDLocation bDLocationL = l();
                    if (bDLocationL == null) {
                        return 3;
                    }
                    a(true, bDLocationL, bDLocation);
                    return 3;
                }
                BDLocation bDLocationM = m();
                if (bDLocationM == null) {
                    return 3;
                }
                a(false, bDLocationM, bDLocation);
                return 3;
            }
            if (i == 200 || i == 300) {
                return 1;
            }
            if (i != 400) {
                return i == 500 ? 1 : 0;
            }
            if (z) {
                BDLocation bDLocationL2 = l();
                if (bDLocationL2 == null) {
                    return -1;
                }
                dA = a(true, bDLocationL2, bDLocation);
            } else {
                BDLocation bDLocationM2 = m();
                if (bDLocationM2 == null) {
                    return -1;
                }
                dA = a(false, bDLocationM2, bDLocation);
            }
            return b(dA);
        }

        public void d() {
            if (this.c.h) {
                e(fq3.b ? 54 : 55);
            }
        }

        public void j(BDLocation bDLocation) {
            k(bDLocation, 21);
        }

        public void k(BDLocation bDLocation, int i) {
            int iC;
            String str;
            BDLocation bDLocation2 = new BDLocation(bDLocation);
            if (i == 21) {
                g(27, "locStr", bDLocation2);
            }
            String str2 = this.c.a;
            if (str2 != null && !str2.equals("gcj02")) {
                double dI = bDLocation2.i();
                double dF = bDLocation2.f();
                if (dI != Double.MIN_VALUE && dF != Double.MIN_VALUE) {
                    if ((bDLocation2.c() != null && bDLocation2.c().equals("gcj02")) || bDLocation2.c() == null) {
                        double[] dArrC = Jni.c(dI, dF, this.c.a);
                        bDLocation2.T(dArrC[0]);
                        bDLocation2.N(dArrC[1]);
                        str = this.c.a;
                    } else if (bDLocation2.c() != null && bDLocation2.c().equals("wgs84") && !this.c.a.equals("bd09ll")) {
                        double[] dArrC2 = Jni.c(dI, dF, "wgs842mc");
                        bDLocation2.T(dArrC2[0]);
                        bDLocation2.N(dArrC2[1]);
                        str = "wgs84mc";
                    }
                    bDLocation2.x(str);
                }
                if (!fq3.k && bDLocation2.j() > 0) {
                    iC = c(bDLocation2.j(), true, bDLocation2);
                    bDLocation2.U(iC);
                }
            } else if (!fq3.k && bDLocation2.j() > 0) {
                iC = c(bDLocation2.j(), false, bDLocation2);
                bDLocation2.U(iC);
            }
            g(i, "locStr", bDLocation2);
        }
    }

    private ro3() {
        this.a = null;
        this.a = new ArrayList();
    }

    private a a(Messenger messenger) {
        ArrayList<a> arrayList = this.a;
        if (arrayList == null) {
            return null;
        }
        try {
            for (a aVar : arrayList) {
                if (aVar.b.equals(messenger)) {
                    return aVar;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ro3 b() {
        if (l == null) {
            l = new ro3();
        }
        return l;
    }

    private void e(a aVar) {
        if (aVar == null) {
            return;
        }
        synchronized (this.g) {
            try {
                if (a(aVar.b) != null) {
                    aVar.e(14);
                } else {
                    this.a.add(aVar);
                    aVar.e(13);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private void g(String str) {
        Intent intent = new Intent("com.baidu.location.flp.log");
        intent.setPackage("com.baidu.baidulocationdemo");
        intent.putExtra("data", str);
        intent.putExtra("pack", to3.f);
        intent.putExtra("tag", "state");
        f.b().sendBroadcast(intent);
    }

    private void s() {
        t();
        p();
        u();
    }

    private void t() {
        boolean z;
        boolean z2 = false;
        try {
            Iterator it = this.a.iterator();
            z = false;
            while (it.hasNext()) {
                try {
                    LocationClientOption locationClientOption = ((a) it.next()).c;
                    if (locationClientOption.c) {
                        z2 = true;
                    }
                    if (locationClientOption.h) {
                        z = true;
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                }
            }
        } catch (Exception e2) {
            e = e2;
            z = false;
        }
        fq3.a = z;
        if (this.b != z2) {
            this.b = z2;
            mp3.f().v(this.b);
        }
    }

    private void u() {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                fq3.e = Math.min(fq3.e, ((a) it.next()).c.g);
            }
            if (f.e) {
                return;
            }
            fq3.e = 4;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void c(Bundle bundle, int i) {
        synchronized (this.g) {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                try {
                    a aVar = (a) it.next();
                    aVar.f(i, bundle);
                    if (aVar.d > 4) {
                        it.remove();
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public void d(Message message) {
        if (message == null || message.replyTo == null) {
            return;
        }
        m = System.currentTimeMillis();
        this.c = true;
        jq3.c().h();
        e(new a(message));
        s();
        if (this.j) {
            g("start");
            this.h = 0;
        }
    }

    public void f(BDLocation bDLocation) {
        k(bDLocation);
    }

    public void h(boolean z) {
        this.c = z;
        n = z ? 1 : 0;
    }

    public void i() {
        synchronized (this.g) {
            try {
                ArrayList arrayList = this.a;
                if (arrayList != null) {
                    arrayList.clear();
                }
            } catch (Throwable unused) {
            }
        }
        this.e = null;
        s();
    }

    public void j(Message message) {
        synchronized (this.g) {
            try {
                a aVarA = a(message.replyTo);
                if (aVarA != null) {
                    this.a.remove(aVarA);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        tq3.a().d();
        s();
        if (this.j) {
            g("stop");
            this.h = 0;
        }
    }

    public void k(BDLocation bDLocation) {
        BDLocation bDLocation2;
        if (bDLocation == null || bDLocation.g() != 161 || zm3.b().e()) {
            synchronized (this.g) {
                Iterator it = this.a.iterator();
                while (it.hasNext()) {
                    try {
                        a aVar = (a) it.next();
                        aVar.j(bDLocation);
                        if (aVar.d > 4) {
                            it.remove();
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        } else {
            if (this.f == null) {
                BDLocation bDLocation3 = new BDLocation();
                this.f = bDLocation3;
                bDLocation3.O(505);
            }
            synchronized (this.g) {
                Iterator it2 = this.a.iterator();
                while (it2.hasNext()) {
                    try {
                        a aVar2 = (a) it2.next();
                        aVar2.j(this.f);
                        if (aVar2.d > 4) {
                            it2.remove();
                        }
                    } catch (Exception unused2) {
                    }
                }
            }
        }
        boolean z = qq3.c0;
        if (z) {
            qq3.c0 = false;
        }
        if (fq3.z >= 10000) {
            if (bDLocation.g() == 61 || bDLocation.g() == 161 || bDLocation.g() == 66) {
                BDLocation bDLocation4 = this.e;
                if (bDLocation4 != null) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(bDLocation4.f(), this.e.i(), bDLocation.f(), bDLocation.i(), fArr);
                    if (fArr[0] <= fq3.B && !z) {
                        return;
                    }
                    this.e = null;
                    bDLocation2 = new BDLocation(bDLocation);
                } else {
                    bDLocation2 = new BDLocation(bDLocation);
                }
                this.e = bDLocation2;
            }
        }
    }

    public String l() {
        StringBuilder sb;
        StringBuffer stringBuffer = new StringBuffer(256);
        if (this.a.isEmpty()) {
            return "&prod=" + to3.g + ":" + to3.f;
        }
        String string = stringBuffer.toString();
        try {
            a aVar = (a) this.a.get(0);
            String str = aVar.c.f;
            if (str != null) {
                stringBuffer.append(str);
            }
            if (aVar.a != null) {
                stringBuffer.append(":");
                stringBuffer.append(aVar.a);
                stringBuffer.append("|");
            }
            if (string == null || string.equals(Constants.STR_EMPTY)) {
                sb = new StringBuilder();
                sb.append("&prod=");
                sb.append(to3.g);
                sb.append(":");
                string = to3.f;
            } else {
                sb = new StringBuilder();
                sb.append("&prod=");
            }
            sb.append(string);
            return sb.toString();
        } catch (Exception unused) {
            return "&prod=" + to3.g + ":" + to3.f;
        }
    }

    public void m(BDLocation bDLocation) {
        b bVarG = qq3.s().g(bDLocation);
        String strB = qq3.s().B();
        List listD = qq3.s().D();
        PoiRegion poiRegionF = qq3.s().F();
        if (bVarG != null) {
            bDLocation.t(bVarG);
        }
        if (strB != null) {
            bDLocation.Q(strB);
        }
        if (listD != null) {
            bDLocation.Y(listD);
        }
        if (poiRegionF != null) {
            bDLocation.Z(poiRegionF);
        }
        f(bDLocation);
        qq3.s().u(bDLocation);
    }

    public boolean n(Message message) {
        a aVarA = a(message.replyTo);
        boolean z = false;
        if (aVarA == null) {
            return false;
        }
        LocationClientOption locationClientOption = aVarA.c;
        int i = locationClientOption.d;
        locationClientOption.d = message.getData().getInt("scanSpan", aVarA.c.d);
        if (aVarA.c.d < 1000) {
            tq3.a().d();
            this.c = false;
        } else {
            this.c = true;
        }
        LocationClientOption locationClientOption2 = aVarA.c;
        if (locationClientOption2.d > 999 && i < 1000) {
            if (locationClientOption2.n || locationClientOption2.s) {
                tq3.a().b(aVarA.c.n);
                tq3.a().c();
            }
            this.d = this.d || aVarA.c.s;
            z = true;
        }
        aVarA.c.c = message.getData().getBoolean("openGPS", aVarA.c.c);
        String string = message.getData().getString("coorType");
        LocationClientOption locationClientOption3 = aVarA.c;
        if (string == null || string.equals(Constants.STR_EMPTY)) {
            string = aVarA.c.a;
        }
        locationClientOption3.a = string;
        String string2 = message.getData().getString("addrType");
        LocationClientOption locationClientOption4 = aVarA.c;
        if (string2 == null || string2.equals(Constants.STR_EMPTY)) {
            string2 = aVarA.c.b;
        }
        locationClientOption4.b = string2;
        if (!fq3.d.equals(aVarA.c.b)) {
            qq3.s().J();
        }
        aVarA.c.e = message.getData().getInt("timeOut", aVarA.c.e);
        aVarA.c.h = message.getData().getBoolean("location_change_notify", aVarA.c.h);
        aVarA.c.g = message.getData().getInt("priority", aVarA.c.g);
        fq3.e = aVarA.c.g;
        int i2 = message.getData().getInt("wifitimeout", Integer.MAX_VALUE);
        if (i2 < fq3.D) {
            fq3.D = i2;
        }
        s();
        return z;
    }

    public int o(Message message) {
        Messenger messenger;
        a aVarA;
        if (message == null || (messenger = message.replyTo) == null || (aVarA = a(messenger)) == null || aVarA.c == null) {
            return 1;
        }
        return fq3.e;
    }

    public void p() {
        try {
            Iterator it = this.a.iterator();
            while (it.hasNext()) {
                ((a) it.next()).d();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void q(BDLocation bDLocation) {
        m(bDLocation);
    }

    public int r(Message message) {
        Messenger messenger;
        a aVarA;
        LocationClientOption locationClientOption;
        if (message == null || (messenger = message.replyTo) == null || (aVarA = a(messenger)) == null || (locationClientOption = aVarA.c) == null) {
            return 1000;
        }
        return locationClientOption.d;
    }
}
