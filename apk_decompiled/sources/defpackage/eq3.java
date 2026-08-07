package defpackage;

import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public class eq3 {
    public List a;
    private long b;
    private long c;
    private boolean d = false;
    private boolean e;

    public eq3(List list, long j) {
        this.c = 0L;
        this.b = j;
        this.a = list;
        this.c = System.currentTimeMillis();
        try {
            w();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("wpa|wep", 2).matcher(str).find();
    }

    private String i(String str) {
        if (str != null) {
            return (str.contains("&") || str.contains(";")) ? str.replace("&", "_").replace(";", "_") : str;
        }
        return str;
    }

    private int v() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /*  JADX ERROR: JadxOverflowException in pass: LoopRegionVisitor
        jadx.core.utils.exceptions.JadxOverflowException: LoopRegionVisitor.assignOnlyInLoop endless recursion
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    private void w() {
        /*
            r7 = this;
            int r0 = r7.v()
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
        throw new UnsupportedOperationException("Method not decompiled: defpackage.eq3.w():void");
    }

    public int a() {
        List list = this.a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String b(int i) {
        return c(i, false, false);
    }

    public String c(int i, boolean z, boolean z2) {
        String strReplace;
        String strU;
        int rssi;
        long jElapsedRealtimeNanos;
        boolean z3;
        String str;
        int i2;
        boolean z4;
        long j;
        boolean z5;
        if (a() < 1) {
            return null;
        }
        try {
            try {
                Random random = new Random();
                StringBuffer stringBuffer = new StringBuffer(512);
                ArrayList<Long> arrayList = new ArrayList();
                WifiInfo wifiInfoS = jq3.c().s();
                if (wifiInfoS == null || wifiInfoS.getBSSID() == null) {
                    strReplace = null;
                    strU = null;
                    rssi = -1;
                } else {
                    strReplace = wifiInfoS.getBSSID().replace(":", Constants.STR_EMPTY);
                    rssi = wifiInfoS.getRssi();
                    strU = jq3.c().u();
                    if (rssi < 0) {
                        rssi = -rssi;
                    }
                }
                try {
                    jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
                } catch (Error unused) {
                    jElapsedRealtimeNanos = 0;
                }
                boolean z6 = jElapsedRealtimeNanos > 0;
                if (z6) {
                    z6 = z6 && z;
                }
                try {
                    try {
                        int size = this.a.size();
                        if (size <= i) {
                            z3 = false;
                        } else if (i < fq3.L) {
                            size = i;
                            z3 = true;
                        } else {
                            size = i;
                            z3 = false;
                        }
                        boolean z7 = true;
                        int i3 = 0;
                        int i4 = 0;
                        char c = 0;
                        StringBuffer stringBuffer2 = null;
                        long j2 = 0;
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            str = strU;
                            if (i4 >= size) {
                                break;
                            }
                            int i7 = i3 + 1;
                            if (this.a.get(i4) == null || ((ScanResult) this.a.get(i4)).level == 0) {
                                i2 = size;
                                z4 = z3;
                            } else {
                                if (z6) {
                                    try {
                                        i2 = size;
                                        z4 = z3;
                                        try {
                                            j = (jElapsedRealtimeNanos - ((ScanResult) this.a.get(i4)).timestamp) / 1000000;
                                        } catch (Exception unused2) {
                                            j = 0;
                                        }
                                    } catch (Exception unused3) {
                                        i2 = size;
                                        z4 = z3;
                                    }
                                    arrayList.add(Long.valueOf(j));
                                    if (j > j2) {
                                        j2 = j;
                                    }
                                } else {
                                    i2 = size;
                                    z4 = z3;
                                }
                                try {
                                    if (((ScanResult) this.a.get(i4)).is80211mcResponder()) {
                                        StringBuffer stringBuffer3 = stringBuffer2 == null ? new StringBuffer() : stringBuffer2;
                                        try {
                                            stringBuffer3.append(i4);
                                            stringBuffer3.append("|");
                                            stringBuffer2 = stringBuffer3;
                                        } catch (Throwable th) {
                                            th = th;
                                            stringBuffer2 = stringBuffer3;
                                            th.printStackTrace();
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                                if (z7) {
                                    stringBuffer.append("&wf=");
                                    z7 = false;
                                } else {
                                    stringBuffer.append("|");
                                }
                                String str2 = ((ScanResult) this.a.get(i4)).BSSID;
                                if (str2 != null) {
                                    String strReplace2 = str2.replace(":", Constants.STR_EMPTY);
                                    stringBuffer.append(strReplace2);
                                    int i8 = ((ScanResult) this.a.get(i4)).level;
                                    if (i8 < 0) {
                                        i8 = -i8;
                                    }
                                    stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i8)));
                                    i5++;
                                    if (strReplace == null || !strReplace.equals(strReplace2)) {
                                        z5 = false;
                                    } else {
                                        this.e = e(((ScanResult) this.a.get(i4)).capabilities);
                                        i6 = i5;
                                        z5 = true;
                                    }
                                    if (z5) {
                                        stringBuffer.append(i(((ScanResult) this.a.get(i4)).SSID));
                                    } else if (c == 0) {
                                        try {
                                            if (random.nextInt(10) == 2 && ((ScanResult) this.a.get(i4)).SSID != null && ((ScanResult) this.a.get(i4)).SSID.length() < 30) {
                                                stringBuffer.append(i(((ScanResult) this.a.get(i4)).SSID));
                                                c = 1;
                                            }
                                        } catch (Exception unused4) {
                                        }
                                    } else if (c == 1 && random.nextInt(20) == 1 && ((ScanResult) this.a.get(i4)).SSID != null && ((ScanResult) this.a.get(i4)).SSID.length() < 30) {
                                        stringBuffer.append(i(((ScanResult) this.a.get(i4)).SSID));
                                        c = 2;
                                    }
                                }
                            }
                            i4++;
                            size = i2;
                            z3 = z4;
                            strU = str;
                            i3 = i7;
                        }
                        int i9 = size;
                        if (z3) {
                            boolean z8 = true;
                            for (int i10 = i9; i10 < this.a.size(); i10++) {
                                i3++;
                                if (this.a.get(i10) != null && ((ScanResult) this.a.get(i10)).level != 0) {
                                    if (z8) {
                                        stringBuffer.append("&wf2=");
                                        z8 = false;
                                    } else {
                                        stringBuffer.append("|");
                                    }
                                    String str3 = ((ScanResult) this.a.get(i10)).BSSID;
                                    if (str3 != null) {
                                        stringBuffer.append(str3.replace(":", Constants.STR_EMPTY));
                                        int i11 = ((ScanResult) this.a.get(i10)).level;
                                        if (i11 < 0) {
                                            i11 = -i11;
                                        }
                                        stringBuffer.append(String.format(Locale.CHINA, ";%d;", Integer.valueOf(i11)));
                                    }
                                    if (i3 >= fq3.L) {
                                        break;
                                    }
                                }
                            }
                        }
                        if (z7) {
                            return null;
                        }
                        StringBuilder sb = new StringBuilder();
                        sb.append("&wf_n=");
                        int i12 = i6;
                        sb.append(i12);
                        stringBuffer.append(sb.toString());
                        if (stringBuffer2 != null) {
                            stringBuffer.append("&wf_mc=");
                            stringBuffer.append(stringBuffer2.toString());
                        }
                        if (strReplace != null && rssi != -1) {
                            stringBuffer.append("&wf_rs=" + rssi);
                        }
                        if (j2 > 10 && arrayList.size() > 0 && ((Long) arrayList.get(0)).longValue() > 0) {
                            StringBuffer stringBuffer4 = new StringBuffer(128);
                            stringBuffer4.append("&wf_ut=");
                            Long l = (Long) arrayList.get(0);
                            boolean z9 = true;
                            for (Long l2 : arrayList) {
                                if (z9) {
                                    stringBuffer4.append(l2.longValue());
                                    z9 = false;
                                } else {
                                    long jLongValue = l2.longValue() - l.longValue();
                                    if (jLongValue != 0) {
                                        stringBuffer4.append(Constants.STR_EMPTY + jLongValue);
                                    }
                                }
                                stringBuffer4.append("|");
                            }
                            stringBuffer.append(stringBuffer4.toString());
                        }
                        stringBuffer.append("&wf_st=");
                        stringBuffer.append(this.b);
                        stringBuffer.append("&wf_et=");
                        stringBuffer.append(this.c);
                        stringBuffer.append("&wf_vt=");
                        stringBuffer.append(jq3.m);
                        if (i12 > 0) {
                            this.d = true;
                            stringBuffer.append("&wf_en=");
                            stringBuffer.append(this.e ? 1 : 0);
                        }
                        if (str != null) {
                            stringBuffer.append("&wf_gw=");
                            stringBuffer.append(str);
                        }
                        return stringBuffer.toString();
                    } catch (Error unused5) {
                        return null;
                    }
                } catch (Exception unused6) {
                    return null;
                }
            } catch (Error unused7) {
                return null;
            }
        } catch (Exception unused8) {
            return null;
        }
    }

    public boolean d(long j) {
        long jElapsedRealtimeNanos;
        List list;
        long j2;
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z = jElapsedRealtimeNanos > 0;
        if (!z || (list = this.a) == null || list.size() == 0) {
            return false;
        }
        int size = this.a.size();
        if (size > 16) {
            size = 16;
        }
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < size; i++) {
            if (this.a.get(i) != null && ((ScanResult) this.a.get(i)).level != 0 && z) {
                try {
                    j2 = (jElapsedRealtimeNanos - ((ScanResult) this.a.get(i)).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j2 = 0;
                }
                j3 += j2;
                if (j2 > j4) {
                    j4 = j2;
                }
            }
        }
        return j4 * 1000 > j || (j3 / ((long) size)) * 1000 > j;
    }

    public boolean f(eq3 eq3Var) {
        List list = this.a;
        if (list == null || eq3Var == null || eq3Var.a == null) {
            return false;
        }
        int size = (list.size() < eq3Var.a.size() ? this.a : eq3Var.a).size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i) != null) {
                String str = ((ScanResult) this.a.get(i)).BSSID;
                String str2 = ((ScanResult) eq3Var.a.get(i)).BSSID;
                if (!TextUtils.isEmpty(str) && !str.equals(str2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public String g() {
        try {
            return c(fq3.t, true, true);
        } catch (Exception unused) {
            return null;
        }
    }

    public String h(int i) {
        if (i == 0) {
            return null;
        }
        int i2 = 1;
        if (a() < 1) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer(256);
        int size = this.a.size();
        int i3 = fq3.t;
        if (size > i3) {
            size = i3;
        }
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            if (this.a.get(i5) != null) {
                if ((i2 & i) != 0 && ((ScanResult) this.a.get(i5)).BSSID != null) {
                    stringBuffer.append(i4 == 0 ? "&ssid=" : "|");
                    stringBuffer.append(((ScanResult) this.a.get(i5)).BSSID.replace(":", Constants.STR_EMPTY));
                    stringBuffer.append(";");
                    stringBuffer.append(i(((ScanResult) this.a.get(i5)).SSID));
                    i4++;
                }
                i2 <<= 1;
            }
        }
        return stringBuffer.toString();
    }

    public boolean j(eq3 eq3Var) {
        List list = this.a;
        if (list == null || eq3Var == null || eq3Var.a == null) {
            return false;
        }
        int size = (list.size() < eq3Var.a.size() ? this.a : eq3Var.a).size();
        for (int i = 0; i < size; i++) {
            if (this.a.get(i) != null) {
                String str = ((ScanResult) this.a.get(i)).BSSID;
                int i2 = ((ScanResult) this.a.get(i)).level;
                String str2 = ((ScanResult) eq3Var.a.get(i)).BSSID;
                int i3 = ((ScanResult) eq3Var.a.get(i)).level;
                if ((!TextUtils.isEmpty(str) && !str.equals(str2)) || i2 != i3) {
                    return false;
                }
            }
        }
        return true;
    }

    public String k() {
        try {
            return c(fq3.t, true, false);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean l(eq3 eq3Var) {
        return jq3.d(eq3Var, this);
    }

    public String m() {
        try {
            return b(15);
        } catch (Exception unused) {
            return null;
        }
    }

    public boolean n() {
        return d(fq3.D);
    }

    public long o() {
        long jElapsedRealtimeNanos;
        long j;
        List list = this.a;
        if (list == null || list.size() == 0) {
            return 0L;
        }
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z = jElapsedRealtimeNanos > 0;
        if (!z) {
            return 0L;
        }
        int size = this.a.size();
        if (size > 16) {
            size = 16;
        }
        long j2 = 2147483647L;
        for (int i = 0; i < size; i++) {
            if (this.a.get(i) != null && ((ScanResult) this.a.get(i)).level != 0 && z) {
                try {
                    j = (jElapsedRealtimeNanos - ((ScanResult) this.a.get(i)).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j = 0;
                }
                if (j < j2) {
                    j2 = j;
                }
            }
        }
        if (!z) {
            j2 = 0;
        }
        if (j2 < 0) {
            return 0L;
        }
        return j2;
    }

    public long p() {
        long jElapsedRealtimeNanos;
        long j;
        List list = this.a;
        if (list == null || list.size() == 0) {
            return 0L;
        }
        try {
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        } catch (Error | Exception unused) {
            jElapsedRealtimeNanos = 0;
        }
        boolean z = jElapsedRealtimeNanos > 0;
        if (!z) {
            return 0L;
        }
        int size = this.a.size();
        if (size > 16) {
            size = 16;
        }
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < size; i++) {
            if (this.a.get(i) != null && ((ScanResult) this.a.get(i)).level != 0 && z) {
                try {
                    j = (jElapsedRealtimeNanos - ((ScanResult) this.a.get(i)).timestamp) / 1000000;
                } catch (Error | Exception unused2) {
                    j = 0;
                }
                j4 += j;
                j2++;
                if (j > j3) {
                    j3 = j;
                }
            }
        }
        return j2 > 1 ? (j4 - j3) / (j2 - 1) : j3;
    }

    public int q() {
        int i;
        for (int i2 = 0; i2 < a(); i2++) {
            if (this.a.get(i2) != null && (i = -((ScanResult) this.a.get(i2)).level) > 0) {
                return i;
            }
        }
        return 0;
    }

    public boolean r() {
        return this.d;
    }

    public boolean s() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean t() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.c < 5000;
    }

    public boolean u() {
        return System.currentTimeMillis() - this.c > 0 && System.currentTimeMillis() - this.b < 5000;
    }
}
