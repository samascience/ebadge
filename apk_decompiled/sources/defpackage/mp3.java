package defpackage;

import android.content.Context;
import android.location.GnssNavigationMessage;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.OnNmeaMessageListener;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baji.protocol.model.ProtocolConstants;
import com.seeker.luckychart.animation.ChartCoordinateportAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Random;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes.dex */
public class mp3 {
    private static mp3 Y = null;
    private static Location Z = null;
    private static int a0 = -1;
    public static int b0 = 0;
    private static int c0 = 0;
    private static int d0 = 0;
    private static int e0 = 0;
    private static int f0 = 0;
    private static int g0 = 0;
    private static long h0 = 0;
    private static String i0 = null;
    private static double j0 = 100.0d;
    public static String k0 = "";
    public static String l0 = "";
    private static float m0 = -1.0f;
    private BDLocation Q;
    private String U;
    private Context a;
    private Location c;
    private GpsStatus f;
    private b g;
    private boolean h;
    private boolean j;
    private LocationManager b = null;
    private e d = null;
    private f e = null;
    private c i = null;
    private GpsStatus.NmeaListener k = null;
    private OnNmeaMessageListener l = null;
    private long m = 0;
    private boolean n = false;
    private boolean o = false;
    private String p = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f359q = false;
    private long r = 0;
    private double s = -1.0d;
    private double t = 0.0d;
    private double u = 0.0d;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private d y = null;
    private long z = 0;
    private long A = 0;
    private a B = null;
    private ArrayList C = new ArrayList();
    private ArrayList D = new ArrayList();
    private ArrayList E = new ArrayList();
    private ArrayList F = new ArrayList();
    private ArrayList G = new ArrayList();
    private ArrayList H = new ArrayList();
    private String I = null;
    private long J = 0;
    private ArrayList K = new ArrayList();
    private String L = null;
    private String M = null;
    private long N = 0;
    private long O = -1;
    private long P = -1;
    private boolean R = false;
    private boolean S = false;
    private long T = 0;
    private long V = 0;
    private StringBuilder W = new StringBuilder();
    public long X = 0;

    private class a extends GnssNavigationMessage.Callback {
        public int a;

        private a() {
            this.a = 0;
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onGnssNavigationMessageReceived(GnssNavigationMessage gnssNavigationMessage) {
            ar3 ar3VarB;
            long jCurrentTimeMillis;
            if (mp3.this.x != 0) {
                ar3VarB = ar3.b();
                jCurrentTimeMillis = mp3.this.x;
            } else {
                ar3VarB = ar3.b();
                jCurrentTimeMillis = System.currentTimeMillis() / 1000;
            }
            ar3VarB.c(gnssNavigationMessage, jCurrentTimeMillis);
        }

        @Override // android.location.GnssNavigationMessage.Callback
        public void onStatusChanged(int i) {
            this.a = i;
        }

        /* synthetic */ a(mp3 mp3Var, qp3 qp3Var) {
            this();
        }
    }

    private class b extends GnssStatus.Callback {
        private b() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onFirstFix(int i) {
        }

        @Override // android.location.GnssStatus.Callback
        public void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            ArrayList arrayList;
            if (mp3.this.b == null) {
                return;
            }
            mp3.this.A = System.currentTimeMillis();
            int satelliteCount = gnssStatus.getSatelliteCount();
            mp3.this.E.clear();
            mp3.this.F.clear();
            mp3.this.G.clear();
            mp3.this.H.clear();
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < satelliteCount; i4++) {
                i3++;
                ArrayList arrayList2 = new ArrayList();
                int constellationType = gnssStatus.getConstellationType(i4);
                arrayList2.add(Float.valueOf(gnssStatus.getAzimuthDegrees(i4)));
                arrayList2.add(Float.valueOf(gnssStatus.getElevationDegrees(i4)));
                arrayList2.add(Float.valueOf(gnssStatus.getCn0DbHz(i4)));
                if (gnssStatus.usedInFix(i4)) {
                    i++;
                    arrayList2.add(Float.valueOf(1.0f));
                    if (constellationType == 1) {
                        i2++;
                    }
                } else {
                    arrayList2.add(Float.valueOf(0.0f));
                }
                arrayList2.add(Float.valueOf(gnssStatus.getSvid(i4)));
                if (constellationType == 1) {
                    arrayList2.add(Float.valueOf(1.0f));
                    arrayList = mp3.this.E;
                } else if (constellationType == 5) {
                    arrayList2.add(Float.valueOf(2.0f));
                    arrayList = mp3.this.F;
                } else if (constellationType == 3) {
                    arrayList2.add(Float.valueOf(3.0f));
                    arrayList = mp3.this.G;
                } else {
                    if (constellationType == 6) {
                        arrayList2.add(Float.valueOf(4.0f));
                        arrayList = mp3.this.H;
                    }
                }
                arrayList.add(arrayList2);
            }
            ArrayList arrayList3 = new ArrayList();
            arrayList3.addAll(mp3.this.E);
            arrayList3.addAll(mp3.this.F);
            arrayList3.addAll(mp3.this.G);
            arrayList3.addAll(mp3.this.H);
            mp3.this.D(arrayList3);
            mp3 mp3Var = mp3.this;
            mp3Var.C = mp3Var.l(true, false, false, false, true, -1.0f);
            mp3 mp3Var2 = mp3.this;
            mp3.k0 = mp3Var2.h(mp3Var2.C);
            mp3 mp3Var3 = mp3.this;
            mp3Var3.D = mp3Var3.l(true, true, true, true, true, -1.0f);
            mp3 mp3Var4 = mp3.this;
            mp3.l0 = mp3Var4.h(mp3Var4.D);
            mp3.b0 = i;
            int unused = mp3.c0 = i2;
            int unused2 = mp3.g0 = i3;
            long unused3 = mp3.h0 = System.currentTimeMillis();
            mp3 mp3Var5 = mp3.this;
            int unused4 = mp3.d0 = mp3Var5.k(mp3Var5.G, true, -1.0f).size();
            mp3 mp3Var6 = mp3.this;
            int unused5 = mp3.e0 = mp3Var6.k(mp3Var6.H, true, -1.0f).size();
            mp3 mp3Var7 = mp3.this;
            int unused6 = mp3.f0 = mp3Var7.k(mp3Var7.F, true, -1.0f).size();
        }

        @Override // android.location.GnssStatus.Callback
        public void onStarted() {
        }

        @Override // android.location.GnssStatus.Callback
        public void onStopped() {
            mp3.this.Y(null);
            mp3.this.E(false);
            mp3.b0 = 0;
            int unused = mp3.c0 = 0;
            int unused2 = mp3.d0 = 0;
            int unused3 = mp3.e0 = 0;
            int unused4 = mp3.f0 = 0;
            int unused5 = mp3.a0 = -1;
            Location unused6 = mp3.Z = null;
        }

        /* synthetic */ b(mp3 mp3Var, qp3 qp3Var) {
            this();
        }
    }

    private class c implements GpsStatus.Listener {
        private long a;

        private c() {
            this.a = 0L;
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            ArrayList arrayList;
            if (mp3.this.b == null) {
                return;
            }
            int i2 = 0;
            if (i == 2) {
                mp3.this.Y(null);
                mp3.this.E(false);
                mp3.b0 = 0;
                int unused = mp3.c0 = 0;
                int unused2 = mp3.d0 = 0;
                int unused3 = mp3.e0 = 0;
                int unused4 = mp3.f0 = 0;
                return;
            }
            if (i == 4 && mp3.this.o) {
                try {
                    if (mp3.this.f == null) {
                        mp3 mp3Var = mp3.this;
                        mp3Var.f = mp3Var.b.getGpsStatus(null);
                    } else {
                        mp3.this.b.getGpsStatus(mp3.this.f);
                    }
                    mp3.this.A = System.currentTimeMillis();
                    mp3.this.E.clear();
                    mp3.this.F.clear();
                    mp3.this.G.clear();
                    mp3.this.H.clear();
                    int i3 = 0;
                    for (GpsSatellite gpsSatellite : mp3.this.f.getSatellites()) {
                        ArrayList arrayList2 = new ArrayList();
                        int prn = gpsSatellite.getPrn();
                        arrayList2.add(Float.valueOf(gpsSatellite.getAzimuth()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getElevation()));
                        arrayList2.add(Float.valueOf(gpsSatellite.getSnr()));
                        if (gpsSatellite.usedInFix()) {
                            i2++;
                            arrayList2.add(Float.valueOf(1.0f));
                            if (prn >= 1 && prn <= 32) {
                                i3++;
                            }
                        } else {
                            arrayList2.add(Float.valueOf(0.0f));
                        }
                        arrayList2.add(Float.valueOf(prn));
                        if (prn >= 1 && prn <= 32) {
                            arrayList2.add(Float.valueOf(1.0f));
                            arrayList = mp3.this.E;
                        } else if (prn >= 201 && prn <= 235) {
                            arrayList2.add(Float.valueOf(2.0f));
                            arrayList = mp3.this.F;
                        } else if (prn >= 65 && prn <= 96) {
                            arrayList2.add(Float.valueOf(3.0f));
                            arrayList = mp3.this.G;
                        } else if (prn >= 301 && prn <= 336) {
                            arrayList2.add(Float.valueOf(4.0f));
                            arrayList = mp3.this.H;
                        }
                        arrayList.add(arrayList2);
                    }
                    ArrayList arrayList3 = new ArrayList();
                    arrayList3.addAll(mp3.this.E);
                    arrayList3.addAll(mp3.this.F);
                    arrayList3.addAll(mp3.this.G);
                    arrayList3.addAll(mp3.this.H);
                    mp3.this.D(arrayList3);
                    mp3 mp3Var2 = mp3.this;
                    mp3Var2.C = mp3Var2.l(true, false, false, false, true, -1.0f);
                    mp3 mp3Var3 = mp3.this;
                    mp3.k0 = mp3Var3.h(mp3Var3.C);
                    mp3 mp3Var4 = mp3.this;
                    mp3Var4.D = mp3Var4.l(true, true, true, true, true, -1.0f);
                    mp3 mp3Var5 = mp3.this;
                    mp3.l0 = mp3Var5.h(mp3Var5.D);
                    if (i3 > 0) {
                        int unused5 = mp3.c0 = i3;
                    }
                    if (i2 > 0 || System.currentTimeMillis() - this.a > 100) {
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        this.a = jCurrentTimeMillis;
                        mp3.b0 = i2;
                    }
                    long unused6 = mp3.h0 = System.currentTimeMillis();
                } catch (Exception unused7) {
                }
            }
        }

        /* synthetic */ c(mp3 mp3Var, qp3 qp3Var) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    static class d extends Handler {
        WeakReference a;
        mp3 b;

        d(mp3 mp3Var) {
            this.a = new WeakReference(mp3Var);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Location location;
            String str;
            if (com.baidu.location.f.e) {
                mp3 mp3Var = (mp3) this.a.get();
                this.b = mp3Var;
                if (mp3Var == null) {
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    mp3Var.g0((Location) message.obj);
                    return;
                }
                if (i == 3) {
                    location = (Location) message.obj;
                    str = "&og=1";
                } else {
                    if (i != 4) {
                        if (i != 5) {
                            return;
                        }
                        mp3Var.s((String) message.obj);
                        return;
                    }
                    location = (Location) message.obj;
                    str = "&og=2";
                }
                mp3Var.u(str, location);
            }
        }
    }

    private class e implements LocationListener {
        private e() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!(location == null && fq3.e == 4) && !fq3.n(location) && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d) {
                mp3.this.x = location.getTime() / 1000;
                mp3.this.O = System.currentTimeMillis();
                if (mp3.this.w != 0) {
                    mp3.this.v = System.currentTimeMillis() - mp3.this.w;
                }
                mp3.this.w = System.currentTimeMillis();
                int i = mp3.b0;
                if (i == 0) {
                    try {
                        i = location.getExtras().getInt("satellites");
                    } catch (Exception unused) {
                    }
                }
                if (i == 0 || qq3.s().I()) {
                    System.currentTimeMillis();
                    long unused2 = mp3.this.A;
                }
                mp3.this.E(true);
                mp3.this.Y(location);
                mp3.this.n = false;
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            mp3.this.Y(null);
            mp3.this.E(false);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            if (i == 0) {
                mp3.this.Y(null);
            } else if (i != 1) {
                if (i != 2) {
                    return;
                }
                mp3.this.n = false;
                return;
            } else {
                mp3.this.m = System.currentTimeMillis();
                mp3.this.n = true;
            }
            mp3.this.E(false);
        }

        /* synthetic */ e(mp3 mp3Var, qp3 qp3Var) {
            this();
        }
    }

    private class f implements LocationListener {
        private long a;

        private f() {
            this.a = 0L;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (!(mp3.this.o && fq3.e == 4) && location != null && TextUtils.equals(location.getProvider(), "gps") && System.currentTimeMillis() - this.a >= ProtocolConstants.CONNECTION_TIMEOUT_MS && Math.abs(location.getLatitude()) <= 360.0d && Math.abs(location.getLongitude()) <= 360.0d && zq3.j(location, false)) {
                this.a = System.currentTimeMillis();
                if (mp3.this.y != null) {
                    mp3.this.X = System.currentTimeMillis();
                    mp3.this.y.sendMessage(mp3.this.y.obtainMessage(4, location));
                }
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        /* synthetic */ f(mp3 mp3Var, qp3 qp3Var) {
            this();
        }
    }

    private mp3() {
        this.h = false;
        this.j = false;
        this.U = null;
        try {
            Class.forName("android.location.GnssStatus");
            this.h = true;
        } catch (ClassNotFoundException unused) {
            this.h = false;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            try {
                this.U = Build.MANUFACTURER;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.j = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(ArrayList arrayList) {
        String string;
        if (arrayList == null || arrayList.size() <= 0) {
            string = null;
        } else {
            StringBuilder sb = new StringBuilder(100);
            sb.append(yo3.g(this.E));
            sb.append("|");
            sb.append(yo3.f(this.E));
            sb.append("|");
            sb.append(yo3.a(this.E));
            sb.append("|");
            sb.append(yo3.h(this.E));
            sb.append("|");
            sb.append(yo3.b(this.E));
            sb.append("|");
            sb.append(yo3.c(this.E));
            sb.append("|");
            sb.append(yo3.e(this.E));
            sb.append("|");
            sb.append(yo3.d(this.E));
            string = sb.toString();
        }
        this.I = string;
        this.J = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z) {
        this.f359q = z;
        m0 = -1.0f;
    }

    private boolean H(String str) {
        int i;
        if (str.indexOf(Marker.ANY_MARKER) != -1 && str.indexOf("$") != -1 && str.indexOf("$") <= str.indexOf(Marker.ANY_MARKER) && str.length() >= str.indexOf(Marker.ANY_MARKER)) {
            byte[] bytes = str.substring(0, str.indexOf(Marker.ANY_MARKER)).getBytes();
            int i2 = bytes[1];
            for (int i3 = 2; i3 < bytes.length; i3++) {
                i2 ^= bytes[i3];
            }
            String str2 = String.format("%02x", Integer.valueOf(i2));
            int iIndexOf = str.indexOf(Marker.ANY_MARKER);
            if (iIndexOf != -1 && str.length() >= (i = iIndexOf + 3) && str2.equalsIgnoreCase(str.substring(iIndexOf + 1, i))) {
                return true;
            }
        }
        return false;
    }

    public static String L(Location location) {
        String strG = g(location);
        if (strG == null) {
            return strG;
        }
        return strG + i0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(Location location) {
        if (this.y == null || System.currentTimeMillis() - this.V <= 3000) {
            return;
        }
        this.y.sendMessage(this.y.obtainMessage(1, location));
    }

    private int a0(Location location) {
        if (location == null) {
            return 0;
        }
        try {
            if (location.isFromMockProvider()) {
                return 100;
            }
            if (Math.abs(this.O - this.P) >= 3000) {
                this.P = -1L;
                this.S = false;
                this.R = false;
                this.Q = null;
            } else if (this.Q == null) {
                if (!this.R) {
                    return 200;
                }
                if (this.S) {
                    return ChartCoordinateportAnimator.FAST_ANIMATION_DURATION;
                }
            } else if (!this.S && this.R) {
                return 400;
            }
            if (this.O > 0 && this.P == -1) {
                return 500;
            }
        } catch (Error | Exception unused) {
        }
        return 0;
    }

    public static synchronized mp3 f() {
        try {
            if (Y == null) {
                Y = new mp3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return Y;
    }

    public static String g(Location location) {
        StringBuilder sb;
        if (location == null) {
            return null;
        }
        float speed = (float) (((double) location.getSpeed()) * 3.6d);
        if (!location.hasSpeed()) {
            speed = -1.0f;
        }
        int accuracy = (int) (location.hasAccuracy() ? location.getAccuracy() : -1.0f);
        double altitude = location.hasAltitude() ? location.getAltitude() : 555.0d;
        float bearing = location.hasBearing() ? location.getBearing() : -1.0f;
        String str = m0 < -0.01f ? String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_snr=%.1f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(b0), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(b0), Integer.valueOf(c0), Integer.valueOf(d0), Integer.valueOf(e0), Integer.valueOf(f0), Double.valueOf(j0)) : String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_r=%d&ll_n=%d&ll_h=%.2f&ll_t=%d&ll_sn=%d|%d|%d|%d|%d&ll_snr=%.1f&ll_bp=%.2f", Double.valueOf(location.getLongitude()), Double.valueOf(location.getLatitude()), Float.valueOf(speed), Float.valueOf(bearing), Integer.valueOf(accuracy), Integer.valueOf(b0), Double.valueOf(altitude), Long.valueOf(location.getTime() / 1000), Integer.valueOf(b0), Integer.valueOf(c0), Integer.valueOf(d0), Integer.valueOf(e0), Integer.valueOf(f0), Double.valueOf(j0), Float.valueOf(m0));
        try {
            if (a0 != 2 || Z == null) {
                sb = new StringBuilder();
                sb.append(str);
                sb.append("&ll_fake=");
                sb.append(a0);
            } else {
                sb = new StringBuilder();
                sb.append(str);
                sb.append(String.format(Locale.CHINA, "&ll_fake=%d|%.5f|%.5f|%d", Integer.valueOf(a0), Double.valueOf(Z.getLongitude()), Double.valueOf(Z.getLatitude()), Long.valueOf(Z.getTime() / 1000)));
            }
            return sb.toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g0(Location location) {
        if (location == null) {
            this.c = null;
            return;
        }
        if (b0 == 0) {
            try {
                location.getExtras().getInt("satellites");
            } catch (Exception unused) {
            }
        }
        if (this.j && fq3.m(location.getSpeed(), 0.0f) && !fq3.l(this.t, 0.0d) && System.currentTimeMillis() - this.u < 2000.0d) {
            location.setSpeed((float) this.t);
        }
        Location location2 = new Location(location);
        this.r = System.currentTimeMillis();
        this.c = location;
        int i = b0;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.c.setTime(jCurrentTimeMillis);
        float speed = (float) (((double) this.c.getSpeed()) * 3.6d);
        if (!this.c.hasSpeed()) {
            speed = -1.0f;
        }
        if (i == 0) {
            try {
                i = this.c.getExtras().getInt("satellites");
            } catch (Exception unused2) {
            }
        }
        this.p = String.format(Locale.CHINA, "&ll=%.5f|%.5f&s=%.1f&d=%.1f&ll_n=%d&ll_t=%d", Double.valueOf(this.c.getLongitude()), Double.valueOf(this.c.getLatitude()), Float.valueOf(speed), Float.valueOf(this.c.getBearing()), Integer.valueOf(i), Long.valueOf(jCurrentTimeMillis));
        if (this.c != null) {
            BDLocation bDLocation = new BDLocation(d0());
            bDLocation.E(location.getExtras());
            Location location3 = this.c;
            if (location3 != null && "bd_beidou".equals(location3.getProvider())) {
                bDLocation.F("bd_beidou");
            }
            m(bDLocation);
            if (b0 > 2 && zq3.j(this.c, true) && "gps".equals(this.c.getProvider())) {
                boolean zM = jq3.c().m();
                uq3.c(new bn3(so3.h().v()));
                uq3.b(System.currentTimeMillis());
                uq3.d(new Location(this.c));
                uq3.e(ro3.b().l());
                if (!zM) {
                    ar3.b().e();
                }
            }
        }
        if ("gps".equals(location2.getProvider())) {
            ar3.b().d(location2, b0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String h(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        if (arrayList.size() == 0) {
            return sb.toString();
        }
        Iterator it = arrayList.iterator();
        boolean z = true;
        while (it.hasNext()) {
            ArrayList arrayList2 = (ArrayList) it.next();
            if (arrayList2.size() == 6) {
                if (z) {
                    z = false;
                } else {
                    sb.append("|");
                }
                sb.append(String.format("%.1f;", arrayList2.get(0)));
                sb.append(String.format("%.1f;", arrayList2.get(1)));
                sb.append(String.format("%.1f;", arrayList2.get(2)));
                sb.append(String.format("%.0f;", arrayList2.get(3)));
                sb.append(String.format("%.0f", arrayList2.get(4)));
                sb.append(String.format("%.0f", arrayList2.get(5)));
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList k(ArrayList arrayList, boolean z, float f2) {
        ArrayList arrayList2 = new ArrayList();
        if (arrayList.size() <= 40 && arrayList.size() != 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ArrayList arrayList3 = (ArrayList) it.next();
                if (arrayList3.size() == 6) {
                    float fFloatValue = ((Float) arrayList3.get(3)).floatValue();
                    float fFloatValue2 = ((Float) arrayList3.get(2)).floatValue();
                    if (!z || fFloatValue >= 1.0f) {
                        if (f2 <= 0.0f || fFloatValue2 >= f2) {
                            arrayList2.add(arrayList3);
                        }
                    }
                }
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ArrayList l(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, float f2) {
        ArrayList arrayList = new ArrayList();
        if (z) {
            arrayList.addAll(k(this.E, z5, f2));
        }
        if (z2) {
            arrayList.addAll(k(this.F, z5, f2));
        }
        if (z3) {
            arrayList.addAll(k(this.G, z5, f2));
        }
        if (z4) {
            arrayList.addAll(k(this.H, z5, f2));
        }
        return arrayList;
    }

    public static String p0() {
        long jCurrentTimeMillis = System.currentTimeMillis() - h0;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= 3000) {
            return null;
        }
        return String.format(Locale.US, "&gsvn=%d&gsfn=%d", Integer.valueOf(g0), Integer.valueOf(b0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(String str) {
        if (TextUtils.isEmpty(str) || !H(str)) {
            return;
        }
        if (str.startsWith("$GPGGA,")) {
            t(str, 2, 4, 6);
        } else if (str.startsWith("$GPRMC,")) {
            t(str, 3, 5, 2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00de  */
    /* JADX WARN: Code duplicated, block: B:46:0x00eb  */
    private void t(String str, int i, int i2, int i3) {
        if (TextUtils.isEmpty(str) || !H(str)) {
            return;
        }
        String[] strArrSplit = str.split(",");
        if (str.startsWith("$GPGGA,")) {
            if (strArrSplit.length < 7) {
                return;
            }
        } else if (str.startsWith("$GPRMC,") && strArrSplit.length < 6) {
            return;
        }
        if (TextUtils.isEmpty(strArrSplit[i].trim()) || strArrSplit[i].trim().length() <= 2) {
            this.Q = null;
        } else {
            try {
                double dDoubleValue = Double.valueOf(strArrSplit[i].substring(0, 2)).doubleValue() + (Double.valueOf(strArrSplit[i].substring(2)).doubleValue() / 60.0d);
                if (this.Q == null) {
                    this.Q = new BDLocation();
                }
                this.Q.N(dDoubleValue);
            } catch (NumberFormatException unused) {
                this.S = true;
            }
        }
        if (this.Q == null || TextUtils.isEmpty(strArrSplit[i2].trim()) || strArrSplit[i2].trim().length() <= 3) {
            this.Q = null;
        } else {
            try {
                this.Q.T(Double.valueOf(strArrSplit[i2].substring(0, 3)).doubleValue() + (Double.valueOf(strArrSplit[i2].substring(3)).doubleValue() / 60.0d));
            } catch (NumberFormatException unused2) {
                this.S = true;
            }
        }
        if (!TextUtils.isEmpty(strArrSplit[i3].trim())) {
            if (i3 == 2) {
                if (TextUtils.equals(strArrSplit[i3], "V")) {
                    this.R = false;
                } else if (TextUtils.equals(strArrSplit[i3], "A")) {
                    this.R = true;
                }
            } else if (i3 == 6) {
                if (TextUtils.equals(strArrSplit[i3], "0")) {
                    this.R = false;
                } else {
                    this.R = true;
                }
            }
        }
        if (this.Q != null) {
            this.S = false;
        }
        this.P = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str, Location location) {
        if (location == null) {
            return;
        }
        String str2 = str + ro3.b().l();
        boolean zM = jq3.c().m();
        uq3.c(new bn3(so3.h().v()));
        uq3.b(System.currentTimeMillis());
        uq3.d(new Location(location));
        uq3.e(str2);
        if (zM) {
            return;
        }
        zq3.e(uq3.g(), null, uq3.h(), str2);
    }

    public static boolean w(Location location, Location location2, boolean z) {
        if (location == location2) {
            return false;
        }
        if (location == null || location2 == null) {
            return true;
        }
        float speed = location2.getSpeed();
        if (z && ((fq3.n == 3 || !kp3.b().c(location2.getLongitude(), location2.getLatitude())) && speed < 5.0f)) {
            return true;
        }
        float fDistanceTo = location2.distanceTo(location);
        if (speed > fq3.f334q) {
            return fDistanceTo > fq3.s;
        }
        if (speed > fq3.p) {
            return fDistanceTo > fq3.r;
        }
        return fDistanceTo > 5.0f;
    }

    public static String z(Location location) {
        String strG = g(location);
        if (strG == null) {
            return strG;
        }
        return strG + "&g_tp=0";
    }

    public synchronized void B() {
        if (com.baidu.location.f.e) {
            Context contextB = com.baidu.location.f.b();
            this.a = contextB;
            try {
                this.b = (LocationManager) contextB.getSystemService("location");
            } catch (Exception unused) {
            }
            this.y = new d(this);
        }
    }

    public void N() {
        Log.d("baidu_location_service", "start gps...");
        if (this.o) {
            return;
        }
        qp3 qp3Var = null;
        try {
            if (!this.h) {
                c cVar = new c(this, qp3Var);
                this.i = cVar;
                this.b.addGpsStatusListener(cVar);
            } else if (fq3.c(this.a, "android.permission.ACCESS_FINE_LOCATION") == 1) {
                b bVar = new b(this, qp3Var);
                this.g = bVar;
                this.b.registerGnssStatusCallback(bVar);
            }
            f fVar = new f(this, qp3Var);
            this.e = fVar;
            this.b.requestLocationUpdates("passive", 9000L, 0.0f, fVar);
        } catch (Exception unused) {
        }
        try {
            this.d = new e(this, qp3Var);
            try {
                this.b.sendExtraCommand("gps", "force_xtra_injection", new Bundle());
            } catch (Exception unused2) {
            }
            this.b.requestLocationUpdates("gps", 1000L, 0.0f, this.d);
            if (this.h && this.B == null && fq3.O == 1 && new Random().nextDouble() < fq3.N) {
                this.B = new a(this, qp3Var);
            }
            a aVar = this.B;
            if (aVar != null) {
                this.b.registerGnssNavigationMessageCallback(aVar);
            }
            this.z = System.currentTimeMillis();
            if (!fq3.k && fq3.Y == 1) {
                qp3 qp3Var2 = new qp3(this);
                this.l = qp3Var2;
                this.b.addNmeaListener(qp3Var2);
            }
            this.o = true;
        } catch (Exception unused3) {
        }
    }

    public void T() {
        b bVar;
        if (this.o) {
            LocationManager locationManager = this.b;
            if (locationManager != null) {
                try {
                    c cVar = this.i;
                    if (cVar != null) {
                        locationManager.removeGpsStatusListener(cVar);
                        this.i = null;
                    }
                    if (this.h && (bVar = this.g) != null) {
                        this.b.unregisterGnssStatusCallback(bVar);
                        this.g = null;
                    }
                    f fVar = this.e;
                    if (fVar != null) {
                        this.b.removeUpdates(fVar);
                        this.e = null;
                    }
                } catch (Exception unused) {
                }
                try {
                    e eVar = this.d;
                    if (eVar != null) {
                        this.b.removeUpdates(eVar);
                    }
                    OnNmeaMessageListener onNmeaMessageListener = this.l;
                    if (onNmeaMessageListener != null) {
                        this.b.removeNmeaListener(onNmeaMessageListener);
                    }
                    if (this.k != null) {
                        Class.forName("android.location.LocationManager").getMethod("removeNmeaListener", GpsStatus.NmeaListener.class).invoke(this.b, this.k);
                    }
                    a aVar = this.B;
                    if (aVar != null) {
                        this.b.unregisterGnssNavigationMessageCallback(aVar);
                    }
                    o0();
                } catch (Exception unused2) {
                }
            }
            fq3.c = 0;
            fq3.n = 0;
            this.d = null;
            this.o = false;
            E(false);
        }
    }

    public synchronized void X() {
        T();
        if (this.b == null) {
            return;
        }
        try {
            d dVar = this.y;
            if (dVar != null) {
                dVar.removeCallbacksAndMessages(null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.b = null;
    }

    public String d0() {
        boolean z;
        StringBuilder sb;
        String str;
        if (this.c == null) {
            return null;
        }
        String str2 = "{\"result\":{\"time\":\"" + fq3.f() + "\",\"error\":\"61\"},\"content\":{\"point\":{\"x\":\"%f\",\"y\":\"%f\"},\"radius\":\"%d\",\"d\":\"%f\",\"s\":\"%f\",\"n\":\"%d\"";
        int accuracy = (int) (this.c.hasAccuracy() ? this.c.getAccuracy() : 10.0f);
        float speed = (float) (((double) this.c.getSpeed()) * 3.6d);
        if (!this.c.hasSpeed()) {
            speed = -1.0f;
        }
        double[] dArrC = new double[2];
        if (kp3.b().c(this.c.getLongitude(), this.c.getLatitude())) {
            dArrC = Jni.c(this.c.getLongitude(), this.c.getLatitude(), "gps2gcj");
            if (dArrC[0] <= 0.0d && dArrC[1] <= 0.0d) {
                dArrC[0] = this.c.getLongitude();
                dArrC[1] = this.c.getLatitude();
            }
            z = true;
        } else {
            dArrC[0] = this.c.getLongitude();
            double latitude = this.c.getLatitude();
            dArrC[1] = latitude;
            if (dArrC[0] <= 0.0d && latitude <= 0.0d) {
                dArrC[0] = this.c.getLongitude();
                dArrC[1] = this.c.getLatitude();
            }
            z = false;
        }
        Locale locale = Locale.CHINA;
        String str3 = String.format(locale, str2, Double.valueOf(dArrC[0]), Double.valueOf(dArrC[1]), Integer.valueOf(accuracy), Float.valueOf(this.c.getBearing()), Float.valueOf(speed), Integer.valueOf(b0));
        if (!z) {
            str3 = str3 + ",\"in_cn\":\"0\"";
        }
        if (!fq3.k) {
            str3 = str3 + String.format(locale, ",\"is_mock\":%d", Integer.valueOf(a0(this.c)));
        }
        if (this.c.hasAltitude()) {
            sb = new StringBuilder();
            sb.append(str3);
            str = String.format(locale, ",\"h\":%.2f}}", Double.valueOf(this.c.getAltitude()));
        } else {
            sb = new StringBuilder();
            sb.append(str3);
            str = "}}";
        }
        sb.append(str);
        return sb.toString();
    }

    public Location e0() {
        if (this.c != null && Math.abs(System.currentTimeMillis() - this.c.getTime()) <= 60000) {
            return this.c;
        }
        return null;
    }

    public BDLocation h0() {
        if (this.Q != null && Math.abs(System.currentTimeMillis() - this.P) <= 3000) {
            return this.Q;
        }
        return null;
    }

    public boolean k0() {
        try {
            System.currentTimeMillis();
            if (b0 == 0) {
                try {
                    this.c.getExtras().getInt("satellites");
                } catch (Exception unused) {
                }
            }
            Location location = this.c;
            return (location == null || location.getLatitude() == 0.0d || this.c.getLongitude() == 0.0d) ? false : true;
        } catch (Exception unused2) {
            Location location2 = this.c;
            return (location2 == null || location2.getLatitude() == 0.0d || this.c.getLongitude() == 0.0d) ? false : true;
        }
    }

    public void m(BDLocation bDLocation) {
        if (fq3.k || a0(this.c) <= 0) {
            ro3.b().q(bDLocation);
        } else {
            ro3.b().m(bDLocation);
        }
    }

    public boolean m0() {
        if (!k0() || System.currentTimeMillis() - this.r > ProtocolConstants.CONNECTION_TIMEOUT_MS) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.n || jCurrentTimeMillis - this.m >= 3000) {
            return this.f359q;
        }
        return true;
    }

    public void o0() {
    }

    public synchronized String s0() {
        String str;
        str = "-2";
        try {
            if (Math.abs(System.currentTimeMillis() - this.J) < 3000) {
                String str2 = this.I;
                str = str2 == null ? "0" : str2;
            } else {
                str = "-1";
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return "&gnsf=" + str;
    }

    public void v(boolean z) {
        if (z) {
            N();
        } else {
            T();
        }
    }
}
