package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.telephony.CellLocation;
import android.telephony.TelephonyManager;
import android.telephony.TelephonyManager$CellInfoCallback;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import com.baidu.location.BDLocation;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.baji.protocol.model.ProtocolConstants;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class dp3 {
    private static char[] x = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_.".toCharArray();
    private Context a;
    private TelephonyManager b;
    private WifiManager d;
    private String f;
    private String g;
    private LocationClientOption h;
    private b i;
    private String k;
    private String l;
    String m;
    String n;
    private boolean o;
    private f s;
    private boolean u;
    private bn3 c = new bn3();
    private e e = null;
    private String j = null;
    c p = new c();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f325q = false;
    private final Object r = new Object();
    private boolean t = true;
    private long v = 0;
    private boolean w = false;

    private class a extends TelephonyManager$CellInfoCallback {
        private a() {
        }

        public void onCellInfo(List list) {
            if (list == null) {
                return;
            }
            dp3 dp3Var = dp3.this;
            dp3Var.t = !dp3Var.t;
            if (dp3.this.t || dp3.this.h.g == 4) {
                synchronized (dp3.this.r) {
                    dp3.this.r.notifyAll();
                }
            }
        }

        /* synthetic */ a(dp3 dp3Var, ip3 ip3Var) {
            this();
        }
    }

    public interface b {
        void a(BDLocation bDLocation);
    }

    class c extends np3 {
        LocationManager l;
        a m;
        String k = null;
        boolean n = false;

        private class a implements LocationListener {
            private a() {
            }

            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                c.this.i();
                c.this.n = true;
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

            /* synthetic */ a(c cVar, ip3 ip3Var) {
                this();
            }
        }

        c() {
            this.d = new HashMap();
        }

        private void h() {
            try {
                this.l = (LocationManager) dp3.this.a.getSystemService("location");
                a aVar = new a(this, null);
                this.m = aVar;
                LocationManager locationManager = this.l;
                if (locationManager != null) {
                    try {
                        locationManager.requestLocationUpdates("network", 1000L, 0.0f, aVar, Looper.getMainLooper());
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void i() {
            LocationManager locationManager;
            a aVar = this.m;
            if (aVar == null || (locationManager = this.l) == null) {
                return;
            }
            try {
                locationManager.removeUpdates(aVar);
            } catch (Exception unused) {
            }
        }

        @Override // defpackage.np3
        public void a() {
            if (dp3.this.k != null && dp3.this.l != null) {
                this.k += String.format(Locale.CHINA, "&ki=%s&sn=%s", dp3.this.k, dp3.this.l);
            }
            String str = this.k + "&enc=2";
            this.k = str;
            String strG = Jni.g(str);
            this.k = null;
            this.d.put("bloc", strG);
            this.d.put("trtm", String.format(Locale.CHINA, "%d", Long.valueOf(System.currentTimeMillis())));
        }

        /* JADX WARN: Code duplicated, block: B:22:0x004e A[Catch: Exception -> 0x0031, TryCatch #2 {Exception -> 0x0031, blocks: (B:6:0x000c, B:20:0x0046, B:22:0x004e, B:23:0x0099, B:19:0x003e, B:13:0x002d, B:17:0x0033, B:8:0x0014, B:10:0x001f), top: B:35:0x000c, inners: #0, #1 }] */
        /* JADX WARN: Code duplicated, block: B:23:0x0099 A[Catch: Exception -> 0x0031, TRY_LEAVE, TryCatch #2 {Exception -> 0x0031, blocks: (B:6:0x000c, B:20:0x0046, B:22:0x004e, B:23:0x0099, B:19:0x003e, B:13:0x002d, B:17:0x0033, B:8:0x0014, B:10:0x001f), top: B:35:0x000c, inners: #0, #1 }] */
        /* JADX WARN: Code duplicated, block: B:31:0x0033 A[EXC_TOP_SPLITTER, PHI: r6
          0x0033: PHI (r6v7 java.lang.String) = (r6v3 java.lang.String), (r6v3 java.lang.String), (r6v3 java.lang.String), (r6v6 java.lang.String) binds: [B:7:0x0012, B:13:0x002d, B:9:0x001d, B:10:0x001f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0008, code lost:
        
            r6 = r5.c;
         */
        /* JADX WARN: Instruction removed from duplicated block: B:22:0x004e, please report this as an issue */
        @Override // defpackage.np3
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void d(boolean r6) {
            /*
                r5 = this;
                java.lang.String r0 = ";"
                java.lang.String r1 = "enc"
                r2 = 63
                if (r6 == 0) goto Lac
                java.lang.String r6 = r5.c
                if (r6 == 0) goto Lac
                java.lang.String r3 = "\"enc\""
                boolean r3 = r6.contains(r3)     // Catch: java.lang.Exception -> L31
                if (r3 == 0) goto L33
                org.json.JSONObject r3 = new org.json.JSONObject     // Catch: java.lang.Exception -> L2c
                r3.<init>(r6)     // Catch: java.lang.Exception -> L2c
                boolean r4 = r3.has(r1)     // Catch: java.lang.Exception -> L2c
                if (r4 == 0) goto L33
                java.lang.String r1 = r3.getString(r1)     // Catch: java.lang.Exception -> L2c
                mq3 r3 = defpackage.mq3.b()     // Catch: java.lang.Exception -> L2c
                java.lang.String r6 = r3.c(r1)     // Catch: java.lang.Exception -> L2c
                goto L33
            L2c:
                r1 = move-exception
                r1.printStackTrace()     // Catch: java.lang.Exception -> L31
                goto L33
            L31:
                r6 = move-exception
                goto La3
            L33:
                com.baidu.location.BDLocation r1 = new com.baidu.location.BDLocation     // Catch: java.lang.Exception -> L3e
                r1.<init>(r6)     // Catch: java.lang.Exception -> L3e
                dp3 r3 = defpackage.dp3.this     // Catch: java.lang.Exception -> L3e
                defpackage.dp3.h(r3, r6)     // Catch: java.lang.Exception -> L3e
                goto L46
            L3e:
                com.baidu.location.BDLocation r1 = new com.baidu.location.BDLocation     // Catch: java.lang.Exception -> L31
                r1.<init>()     // Catch: java.lang.Exception -> L31
                r1.O(r2)     // Catch: java.lang.Exception -> L31
            L46:
                int r6 = r1.g()     // Catch: java.lang.Exception -> L31
                r3 = 161(0xa1, float:2.26E-43)
                if (r6 != r3) goto L99
                dp3 r6 = defpackage.dp3.this     // Catch: java.lang.Exception -> L31
                com.baidu.location.LocationClientOption r6 = defpackage.dp3.q(r6)     // Catch: java.lang.Exception -> L31
                java.lang.String r6 = r6.a     // Catch: java.lang.Exception -> L31
                r1.x(r6)     // Catch: java.lang.Exception -> L31
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L31
                r6.<init>()     // Catch: java.lang.Exception -> L31
                dp3 r3 = defpackage.dp3.this     // Catch: java.lang.Exception -> L31
                java.lang.String r3 = r3.m     // Catch: java.lang.Exception -> L31
                r6.append(r3)     // Catch: java.lang.Exception -> L31
                r6.append(r0)     // Catch: java.lang.Exception -> L31
                dp3 r3 = defpackage.dp3.this     // Catch: java.lang.Exception -> L31
                java.lang.String r3 = r3.n     // Catch: java.lang.Exception -> L31
                r6.append(r3)     // Catch: java.lang.Exception -> L31
                r6.append(r0)     // Catch: java.lang.Exception -> L31
                java.lang.String r0 = r1.o()     // Catch: java.lang.Exception -> L31
                r6.append(r0)     // Catch: java.lang.Exception -> L31
                java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L31
                java.lang.String r6 = com.baidu.location.Jni.d(r6)     // Catch: java.lang.Exception -> L31
                r1.R(r6)     // Catch: java.lang.Exception -> L31
                r6 = 0
                r0 = 0
                r1.d0(r0, r0, r6)     // Catch: java.lang.Exception -> L31
                dp3 r6 = defpackage.dp3.this     // Catch: java.lang.Exception -> L31
                r0 = 1
                defpackage.dp3.k(r6, r0)     // Catch: java.lang.Exception -> L31
                dp3 r6 = defpackage.dp3.this     // Catch: java.lang.Exception -> L31
                dp3$b r6 = defpackage.dp3.s(r6)     // Catch: java.lang.Exception -> L31
                r6.a(r1)     // Catch: java.lang.Exception -> L31
                goto Lb1
            L99:
                dp3 r6 = defpackage.dp3.this     // Catch: java.lang.Exception -> L31
                int r0 = r1.g()     // Catch: java.lang.Exception -> L31
                defpackage.dp3.g(r6, r0)     // Catch: java.lang.Exception -> L31
                goto Lb1
            La3:
                dp3 r0 = defpackage.dp3.this
                defpackage.dp3.g(r0, r2)
                r6.printStackTrace()
                goto Lb1
            Lac:
                dp3 r6 = defpackage.dp3.this
                defpackage.dp3.g(r6, r2)
            Lb1:
                java.util.Map r6 = r5.d
                if (r6 == 0) goto Lb8
                r6.clear()
            Lb8:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dp3.c.d(boolean):void");
        }

        public void g(String str) {
            this.k = str;
            e(fp3.a);
            if (dp3.this.f325q) {
                h();
                Timer timer = new Timer();
                timer.schedule(new lp3(this, timer), ProtocolConstants.CONNECTION_TIMEOUT_MS);
                SharedPreferences.Editor editorEdit = dp3.this.a.getSharedPreferences("cuidRelate", 0).edit();
                editorEdit.putLong("reqtime", System.currentTimeMillis());
                editorEdit.apply();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    class d {
        public String a;
        public int b;

        d(String str, int i) {
            this.a = str;
            this.b = i;
        }
    }

    public static class e {
        public List a;
        private long b;
        public String c = null;
        private String d = null;
        private int e = 16;

        public e(List list) {
            this.b = 0L;
            this.a = list;
            this.b = System.currentTimeMillis();
            try {
                c();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
            jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        private void c() {
            /*
                r7 = this;
                int r0 = r7.a()
                r1 = 1
                if (r0 >= r1) goto L8
                return
            L8:
                java.util.List r0 = r7.a
                int r0 = r0.size()
                int r0 = r0 - r1
                r2 = r1
            L10:
                if (r0 < r1) goto L5e
                if (r2 == 0) goto L5e
                r2 = 0
                r3 = r2
            L16:
                if (r2 >= r0) goto L5a
                java.util.List r4 = r7.a
                java.lang.Object r4 = r4.get(r2)
                if (r4 == 0) goto L57
                java.util.List r4 = r7.a
                int r5 = r2 + 1
                java.lang.Object r4 = r4.get(r5)
                if (r4 == 0) goto L57
                java.util.List r4 = r7.a
                java.lang.Object r4 = r4.get(r2)
                android.net.wifi.ScanResult r4 = (android.net.wifi.ScanResult) r4
                int r4 = r4.level
                java.util.List r6 = r7.a
                java.lang.Object r6 = r6.get(r5)
                android.net.wifi.ScanResult r6 = (android.net.wifi.ScanResult) r6
                int r6 = r6.level
                if (r4 >= r6) goto L57
                java.util.List r3 = r7.a
                java.lang.Object r3 = r3.get(r5)
                android.net.wifi.ScanResult r3 = (android.net.wifi.ScanResult) r3
                java.util.List r4 = r7.a
                java.lang.Object r6 = r4.get(r2)
                r4.set(r5, r6)
                java.util.List r4 = r7.a
                r4.set(r2, r3)
                r3 = r1
            L57:
                int r2 = r2 + 1
                goto L16
            L5a:
                int r0 = r0 + (-1)
                r2 = r3
                goto L10
            L5e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: dp3.e.c():void");
        }

        public int a() {
            List list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String b(int i, String str, boolean z, int i2) {
            long jElapsedRealtimeNanos;
            boolean z2;
            StringBuffer stringBuffer;
            int size;
            boolean z3;
            long j;
            int i3;
            int i4;
            int i5;
            int i6;
            String str2;
            int i7;
            boolean z4;
            long j2;
            if (a() < 1) {
                return null;
            }
            this.e = i2;
            ArrayList<Long> arrayList = new ArrayList();
            try {
                jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
                while (true) {
                    if (i3 >= size) {
                        str2 = ";%d;";
                        i7 = i5;
                        break;
                    }
                    if (this.a.get(i3) == null || ((ScanResult) this.a.get(i3)).level == 0) {
                        jElapsedRealtimeNanos = jElapsedRealtimeNanos;
                    } else {
                        i4++;
                        if (z3) {
                            stringBuffer.append("&wf=");
                            z3 = false;
                        } else {
                            stringBuffer.append("|");
                        }
                        String strReplace = ((ScanResult) this.a.get(i3)).BSSID.replace(":", Constants.STR_EMPTY);
                        stringBuffer.append(strReplace);
                        if (str != 0 && strReplace.equals(str)) {
                            i6 = i4;
                        }
                        int i8 = ((ScanResult) this.a.get(i3)).level;
                        if (i8 < 0) {
                            i8 = -i8;
                        }
                        stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i8)));
                        i7 = i5 + 1;
                        if (z2) {
                            try {
                                str2 = ";%d;";
                                try {
                                    j2 = (jElapsedRealtimeNanos - ((ScanResult) this.a.get(i3)).timestamp) / 1000000;
                                } catch (Throwable unused) {
                                    j2 = 0;
                                }
                            } catch (Throwable unused2) {
                                str2 = ";%d;";
                            }
                            arrayList.add(Long.valueOf(j2));
                            if (j2 > j) {
                                j = j2;
                            }
                        } else {
                            str2 = ";%d;";
                            jElapsedRealtimeNanos = jElapsedRealtimeNanos;
                        }
                        if (i7 > i) {
                            break;
                        }
                        i5 = i7;
                    }
                    i3++;
                    jElapsedRealtimeNanos = jElapsedRealtimeNanos;
                }
            } catch (Error unused3) {
                jElapsedRealtimeNanos = 0;
            }
            z2 = jElapsedRealtimeNanos > 0;
            stringBuffer = new StringBuffer(512);
            size = this.a.size();
            z3 = true;
            j = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            int i9 = i6;
            if (z) {
                return stringBuffer.toString();
            }
            if (i9 > 0) {
                stringBuffer.append("&wf_n=");
                stringBuffer.append(i9);
            }
            if (i7 > i) {
                z4 = true;
                if (this.e > i + 1) {
                    int i10 = i7;
                    while (i10 < size) {
                        if (i10 == i7) {
                            stringBuffer.append("&wf2=");
                        } else {
                            stringBuffer.append("|");
                        }
                        stringBuffer.append(((ScanResult) this.a.get(i10)).BSSID.replace(":", Constants.STR_EMPTY));
                        int i11 = ((ScanResult) this.a.get(i10)).level;
                        if (i11 < 0) {
                            i11 = -i11;
                        }
                        String str3 = str2;
                        stringBuffer.append(String.format(Locale.CHINA, str3, Integer.valueOf(i11)));
                        if (i10 >= this.e) {
                            break;
                        }
                        i10++;
                        str2 = str3;
                    }
                }
            } else {
                z4 = true;
            }
            if (z3) {
                return null;
            }
            if (j > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                StringBuffer stringBuffer2 = new StringBuffer(128);
                stringBuffer2.append("&wf_ut=");
                Long l = (Long) arrayList.get(0);
                for (Long l2 : arrayList) {
                    if (z4) {
                        stringBuffer2.append(l2.longValue());
                        z4 = false;
                    } else {
                        long jLongValue = l2.longValue() - l.longValue();
                        if (jLongValue != 0) {
                            stringBuffer2.append(Constants.STR_EMPTY + jLongValue);
                        }
                    }
                    stringBuffer2.append("|");
                }
                stringBuffer.append(stringBuffer2.toString());
            }
            return stringBuffer.toString();
        }
    }

    private class f extends BroadcastReceiver {
        private f() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null || intent == null) {
                return;
            }
            String action = intent.getAction();
            dp3 dp3Var = dp3.this;
            dp3Var.t = !dp3Var.t;
            if (!(action.equals("android.net.wifi.SCAN_RESULTS") && dp3.this.t) && Build.VERSION.SDK_INT >= 29 && dp3.this.u) {
                return;
            }
            synchronized (dp3.this.r) {
                dp3.this.r.notifyAll();
            }
        }

        /* synthetic */ f(dp3 dp3Var, ip3 ip3Var) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public dp3(Context context, LocationClientOption locationClientOption, b bVar, String str) {
        StringBuilder sb;
        String str2 = null;
        Object[] objArr = 0;
        this.a = null;
        this.b = null;
        this.d = null;
        this.f = null;
        this.g = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = false;
        this.s = null;
        this.u = false;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        try {
            fq3.J = applicationContext.getPackageName();
        } catch (Exception unused) {
        }
        this.o = true;
        this.h = new LocationClientOption(locationClientOption);
        this.i = bVar;
        this.m = this.a.getPackageName();
        this.n = null;
        try {
            this.b = (TelephonyManager) this.a.getSystemService("phone");
            this.d = (WifiManager) this.a.getApplicationContext().getSystemService("wifi");
        } catch (Exception unused2) {
        }
        LocationClientOption locationClientOption2 = this.h;
        if (locationClientOption2.D == LocationClientOption.FirstLocType.ACCURACY_IN_FIRST_LOC) {
            if (locationClientOption2.g != 4) {
                f fVar = new f(this, objArr == true ? 1 : 0);
                this.s = fVar;
                try {
                    this.a.registerReceiver(fVar, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
                } catch (Exception unused3) {
                }
            }
            if (Build.VERSION.SDK_INT >= 30) {
                this.u = fq3.t("android.telephony.TelephonyManager$CellInfoCallback");
            }
        }
        this.g = "&" + this.m + "&" + ((String) null);
        try {
            this.n = p91.w(this.a).v();
        } catch (Throwable unused4) {
            this.n = null;
            this.b = null;
            this.d = null;
        }
        if (this.n != null) {
            fq3.l = Constants.STR_EMPTY + this.n;
            sb = new StringBuilder();
            sb.append("&prod=");
            sb.append(this.h.f);
            sb.append(":");
            sb.append(this.m);
            sb.append("|&cu=");
            str2 = this.n;
        } else {
            sb = new StringBuilder();
            sb.append("&prod=");
            sb.append(this.h.f);
            sb.append(":");
            sb.append(this.m);
            sb.append("|&im=");
        }
        sb.append(str2);
        sb.append("&coor=");
        sb.append(locationClientOption.g());
        this.f = sb.toString();
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append("&fw=");
        stringBuffer.append("9.293");
        stringBuffer.append("&sdk=");
        stringBuffer.append("9.293");
        stringBuffer.append("&lt=1");
        stringBuffer.append("&mb=");
        stringBuffer.append(Build.MODEL);
        stringBuffer.append("&resid=");
        stringBuffer.append(Constants.VIA_REPORT_TYPE_SET_AVATAR);
        locationClientOption.d();
        if (locationClientOption.d() != null && locationClientOption.d().equals("all")) {
            this.f += "&addr=allj2";
            if (locationClientOption.t) {
                stringBuffer.append("&adtp=n2");
            }
        }
        if (locationClientOption.o || locationClientOption.p) {
            this.f += "&sema=";
            if (locationClientOption.o) {
                this.f += "aptag|";
            }
            if (locationClientOption.p) {
                this.f += "aptagd2|";
            }
            this.k = zm3.d(this.a);
            this.l = zm3.f(this.a);
        }
        stringBuffer.append("&first=1");
        stringBuffer.append("&os=A");
        stringBuffer.append(Build.VERSION.SDK);
        this.f += stringBuffer.toString();
    }

    private List A() {
        try {
            WifiManager wifiManager = this.d;
            if (wifiManager != null) {
                return wifiManager.getConfiguredNetworks();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static bn3 a(CellLocation cellLocation, TelephonyManager telephonyManager, bn3 bn3Var) {
        if (cellLocation == null || telephonyManager == null) {
            return null;
        }
        bn3 bn3Var2 = new bn3();
        bn3Var2.l = 1;
        String networkOperator = telephonyManager.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() > 0) {
            try {
                if (networkOperator.length() >= 3) {
                    int iIntValue = Integer.valueOf(networkOperator.substring(0, 3)).intValue();
                    if (iIntValue < 0) {
                        iIntValue = bn3Var.c;
                    }
                    bn3Var2.c = iIntValue;
                }
                String strSubstring = networkOperator.substring(3);
                if (strSubstring != null) {
                    char[] charArray = strSubstring.toCharArray();
                    int i = 0;
                    while (i < charArray.length && Character.isDigit(charArray[i])) {
                        i++;
                    }
                    int iIntValue2 = Integer.valueOf(strSubstring.substring(0, i)).intValue();
                    if (iIntValue2 < 0) {
                        iIntValue2 = bn3Var.d;
                    }
                    bn3Var2.d = iIntValue2;
                }
            } catch (Exception unused) {
            }
        }
        if (cellLocation instanceof GsmCellLocation) {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            bn3Var2.a = gsmCellLocation.getLac();
            bn3Var2.b = gsmCellLocation.getCid();
            bn3Var2.i = 'g';
        } else if (cellLocation instanceof CdmaCellLocation) {
            bn3Var2.i = 'c';
            try {
                if (Class.forName("android.telephony.cdma.CdmaCellLocation").isInstance(cellLocation)) {
                    try {
                        int systemId = ((CdmaCellLocation) cellLocation).getSystemId();
                        if (systemId < 0) {
                            systemId = -1;
                        }
                        bn3Var2.d = systemId;
                        bn3Var2.b = ((CdmaCellLocation) cellLocation).getBaseStationId();
                        bn3Var2.a = ((CdmaCellLocation) cellLocation).getNetworkId();
                        int baseStationLatitude = ((CdmaCellLocation) cellLocation).getBaseStationLatitude();
                        if (baseStationLatitude < Integer.MAX_VALUE) {
                            bn3Var2.e = baseStationLatitude;
                        }
                        int baseStationLongitude = ((CdmaCellLocation) cellLocation).getBaseStationLongitude();
                        if (baseStationLongitude < Integer.MAX_VALUE) {
                            bn3Var2.f = baseStationLongitude;
                        }
                    } catch (Exception unused2) {
                    }
                }
            } catch (Exception unused3) {
                return null;
            }
        }
        if (bn3Var2.c()) {
            return bn3Var2;
        }
        return null;
    }

    private Object b(Object obj, String str) {
        return obj.getClass().getField(str).get(obj);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:45:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:46:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bf A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:49:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c6  */
    /* JADX WARN: Instruction removed from duplicated block: B:46:0x00ae, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:51:0x00c6, please report this as an issue */
    private String c(int i) {
        String strI;
        String strB;
        bn3 bn3Var;
        try {
            try {
                bn3 bn3VarD = so3.d(this.c, this.b, true);
                try {
                    if (bn3VarD == null || !bn3VarD.c()) {
                        if (Build.VERSION.SDK_INT <= 28) {
                            bn3VarD = a(this.b.getCellLocation(), this.b, this.c);
                            this.c = bn3VarD;
                        }
                        this.e = null;
                        if (j(this.d) || this.h.g == 4) {
                            strB = null;
                        } else {
                            e eVar = new e(this.d.getScanResults());
                            this.e = eVar;
                            strB = eVar.b(i, m(this.d), this.f325q, an3.a().c);
                            try {
                                LocationClientOption locationClientOption = this.h;
                                if (locationClientOption != null && locationClientOption.h()) {
                                    this.d.startScan();
                                }
                            } catch (Exception unused) {
                            }
                        }
                        if (strI != null && strB == null) {
                            this.j = null;
                            return null;
                        }
                        if (strB != null) {
                            if (strI == null) {
                                strI = strB;
                            } else {
                                strI = strI + strB;
                            }
                        }
                        if (strI == null) {
                            return null;
                        }
                        this.j = strI;
                        if (this.f != null) {
                            this.j += this.f;
                        }
                        y();
                        return strI + this.f;
                    }
                    this.c = bn3VarD;
                    if (!TextUtils.isEmpty(strI) && (bn3Var = this.c) != null && bn3Var.m != null) {
                        strI = strI + this.c.m;
                    }
                } catch (Throwable unused2) {
                }
                bn3 bn3Var2 = this.c;
                strI = (bn3Var2 == null || !bn3Var2.c()) ? null : this.c.i();
            } catch (Throwable unused3) {
                strI = null;
            }
            this.e = null;
            if (j(this.d)) {
                strB = null;
            } else {
                strB = null;
            }
        } catch (Exception unused4) {
        }
        if (strI != null) {
        }
        if (strB != null) {
            if (strI == null) {
                strI = strB;
            } else {
                strI = strI + strB;
            }
        }
        if (strI == null) {
            return null;
        }
        this.j = strI;
        if (this.f != null) {
            this.j += this.f;
        }
        y();
        return strI + this.f;
    }

    private String e(List list) {
        ArrayList<d> arrayList;
        int iIntValue;
        int i = 0;
        if (list == null || list.size() <= 0) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                WifiConfiguration wifiConfiguration = (WifiConfiguration) it.next();
                String str = wifiConfiguration.SSID;
                try {
                    iIntValue = ((Integer) b(wifiConfiguration, "numAssociation")).intValue();
                } catch (Throwable unused) {
                    iIntValue = 0;
                }
                if (iIntValue > 0 && !TextUtils.isEmpty(str)) {
                    arrayList.add(new d(str, iIntValue));
                }
            }
        }
        if (arrayList == null || arrayList.isEmpty()) {
            return null;
        }
        if (arrayList.size() > 1) {
            Collections.sort(arrayList, new ip3(this));
        }
        StringBuffer stringBuffer = new StringBuffer(200);
        for (d dVar : arrayList) {
            stringBuffer.append(dVar.a);
            stringBuffer.append(",");
            stringBuffer.append(dVar.b);
            stringBuffer.append("|");
            i++;
            if (i == 4) {
                break;
            }
        }
        if (arrayList.size() >= 5) {
            stringBuffer.append(((d) arrayList.get(4)).a);
            stringBuffer.append(",");
            stringBuffer.append(((d) arrayList.get(4)).b);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(String str) {
        String[] strArrSplit;
        try {
            JSONObject jSONObject = new JSONObject(str).getJSONObject("content");
            String string = jSONObject.has("ideocfre") ? jSONObject.getString("ideocfre") : null;
            if (TextUtils.isEmpty(string) || !string.contains("|") || (strArrSplit = string.split("\\|")) == null || strArrSplit.length < 2) {
                return;
            }
            int i = Integer.parseInt(strArrSplit[0]);
            long j = Long.parseLong(strArrSplit[1]);
            SharedPreferences.Editor editorEdit = this.a.getSharedPreferences("cuidRelate", 0).edit();
            editorEdit.putInt("cuidoc", i);
            editorEdit.putLong("cuidfreq", j);
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean j(WifiManager wifiManager) {
        try {
            return wifiManager.isWifiEnabled() || wifiManager.isScanAlwaysAvailable();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String m(WifiManager wifiManager) {
        if (wifiManager == null) {
            return null;
        }
        try {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (connectionInfo == null) {
                return null;
            }
            String bssid = connectionInfo.getBSSID();
            String strReplace = bssid != null ? bssid.replace(":", Constants.STR_EMPTY) : null;
            if (strReplace == null || strReplace.length() == 12) {
                return new String(strReplace);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i) {
        if (this.h.h()) {
            BDLocation bDLocation = new BDLocation();
            bDLocation.O(i);
            bDLocation.R(Jni.d(this.m + ";" + this.n + ";" + new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM_SS, Locale.US).format(new Date(System.currentTimeMillis()))));
            b bVar = this.i;
            if (bVar != null) {
                bVar.a(bDLocation);
            }
        }
    }

    private boolean x() {
        if (an3.a().f == 0) {
            return false;
        }
        SharedPreferences sharedPreferences = this.a.getApplicationContext().getSharedPreferences("cuidRelate", 0);
        if (!sharedPreferences.contains("isInstalled")) {
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            if (!fq3.s(this.a, "com.baidu.map.location")) {
                editorEdit.putInt("isInstalled", 0);
                return false;
            }
            editorEdit.putInt("isInstalled", 1);
            editorEdit.apply();
        } else if (sharedPreferences.getInt("isInstalled", -1) == 0) {
            return false;
        }
        return sharedPreferences.getInt("cuidoc", 1) != 0 && (System.currentTimeMillis() - sharedPreferences.getLong("reqtime", 0L)) / 1000 >= sharedPreferences.getLong("cuidfreq", 60L) && fq3.q(this.a) >= 2 && j(this.d) && this.e.a() > 3;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0061  */
    private void y() {
        String strK;
        if (!x()) {
            this.f325q = false;
            return;
        }
        this.f325q = true;
        if (this.e.a() >= 10) {
            String strB = this.e.b(9, m(this.d), this.f325q, an3.a().c);
            if (TextUtils.isEmpty(strB)) {
                strK = null;
            } else {
                strK = fq3.k(strB.getBytes(), false);
            }
        } else {
            e eVar = this.e;
            String strB2 = eVar.b(eVar.a(), m(this.d), this.f325q, an3.a().c);
            if (TextUtils.isEmpty(strB2)) {
                strK = null;
            } else {
                strK = fq3.k(strB2.getBytes(), false);
            }
        }
        String strE = e(A());
        String strK2 = TextUtils.isEmpty(strE) ? null : fq3.k(strE.getBytes(), false);
        if (TextUtils.isEmpty(strK)) {
            this.f325q = false;
        } else {
            this.j += "&swf5=" + strK;
            this.f325q = true;
        }
        if (TextUtils.isEmpty(strK2)) {
            return;
        }
        this.j += "&hwf5=" + strK2;
        this.f325q = true;
    }

    public void f() {
        l();
    }

    public String l() {
        try {
            return c(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public void r() {
        String str = this.j;
        if (str == null) {
            o(62);
        } else if (this.o) {
            this.p.g(str);
        }
    }

    public void t() {
        if ((this.d.isWifiEnabled() || this.d.isScanAlwaysAvailable()) && this.h.g != 4) {
            this.d.startScan();
        }
        if (fq3.c(this.a, "android.permission.ACCESS_FINE_LOCATION") == 1 && Build.VERSION.SDK_INT >= 29 && this.u) {
            this.b.requestCellInfoUpdate(this.a.getMainExecutor(), new a(this, null));
        }
        synchronized (this.r) {
            try {
                this.r.wait(3000L);
            } catch (InterruptedException unused) {
            }
        }
    }

    public void u() {
        try {
            f fVar = this.s;
            if (fVar != null) {
                this.a.unregisterReceiver(fVar);
            }
        } catch (Exception unused) {
        }
    }
}
