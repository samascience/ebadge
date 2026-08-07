package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import com.baidu.location.f;
import com.baji.protocol.model.ProtocolConstants;
import com.tencent.connect.common.Constants;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class jq3 {
    private static jq3 l;
    public static long m;
    private WifiManager a = null;
    private a b = null;
    private eq3 c = null;
    private long d = 0;
    private long e = 0;
    private boolean f = false;
    private ConnectivityManager g = null;
    private Handler h = new Handler();
    private boolean i = false;
    private long j = 0;
    private long k = 0;

    /* JADX INFO: Access modifiers changed from: private */
    class a extends BroadcastReceiver {
        private long a;
        private boolean b;

        private a() {
            this.a = 0L;
            this.b = false;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (context == null) {
                return;
            }
            String action = intent.getAction();
            if (action.equals("android.net.wifi.SCAN_RESULTS")) {
                jq3.m = System.currentTimeMillis() / 1000;
                jq3.this.h.post(new nq3(this, intent.getBooleanExtra("resultsUpdated", true)));
            } else if (action.equals("android.net.wifi.STATE_CHANGE") && ((NetworkInfo) intent.getParcelableExtra("networkInfo")).getState().equals(NetworkInfo.State.CONNECTED) && System.currentTimeMillis() - this.a >= 5000) {
                this.a = System.currentTimeMillis();
                if (this.b) {
                    return;
                }
                this.b = true;
            }
        }
    }

    private jq3() {
    }

    private String a(long j) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(String.valueOf((int) (j & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 8) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 16) & 255)));
        stringBuffer.append('.');
        stringBuffer.append(String.valueOf((int) ((j >> 24) & 255)));
        return stringBuffer.toString();
    }

    public static synchronized jq3 c() {
        try {
            if (l == null) {
                l = new jq3();
            }
        } catch (Throwable th) {
            throw th;
        }
        return l;
    }

    public static boolean d(eq3 eq3Var, eq3 eq3Var2) {
        boolean zE = e(eq3Var, eq3Var2, fq3.M);
        long jCurrentTimeMillis = System.currentTimeMillis() - ro3.m;
        if (jCurrentTimeMillis <= 0 || jCurrentTimeMillis >= 30000 || !zE || eq3Var2.p() - eq3Var.p() <= 30) {
            return zE;
        }
        return false;
    }

    public static boolean e(eq3 eq3Var, eq3 eq3Var2, float f) {
        if (eq3Var != null && eq3Var2 != null) {
            List list = eq3Var.a;
            List list2 = eq3Var2.a;
            if (list == list2) {
                return true;
            }
            if (list != null && list2 != null) {
                int size = list.size();
                int size2 = list2.size();
                if (size == 0 && size2 == 0) {
                    return true;
                }
                if (size != 0 && size2 != 0) {
                    int i = 0;
                    for (int i2 = 0; i2 < size; i2++) {
                        String str = list.get(i2) != null ? ((ScanResult) list.get(i2)).BSSID : null;
                        if (str != null) {
                            for (int i3 = 0; i3 < size2; i3++) {
                                String str2 = list2.get(i3) != null ? ((ScanResult) list2.get(i3)).BSSID : null;
                                if (str2 != null && str.equals(str2)) {
                                    i++;
                                    break;
                                }
                            }
                        }
                    }
                    if (i >= size * f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y() {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return;
        }
        try {
            eq3 eq3VarB = b(wifiManager, System.currentTimeMillis());
            if (eq3VarB.a != null) {
                eq3 eq3Var = this.c;
                if (eq3Var == null || !eq3VarB.f(eq3Var)) {
                    this.c = eq3VarB;
                }
            }
        } catch (Exception unused) {
        }
    }

    public eq3 b(WifiManager wifiManager, long j) {
        eq3 eq3Var = new eq3(null, 0L);
        return (wifiManager == null || fq3.e == 4) ? eq3Var : new eq3(wifiManager.getScanResults(), j);
    }

    public void h() {
        this.j = 0L;
    }

    public synchronized void k() {
        if (this.f) {
            return;
        }
        if (f.e) {
            this.a = (WifiManager) f.b().getApplicationContext().getSystemService("wifi");
            this.b = new a();
            try {
                f.b().registerReceiver(this.b, new IntentFilter("android.net.wifi.SCAN_RESULTS"));
            } catch (Exception unused) {
            }
            this.f = true;
        }
    }

    public synchronized void l() {
        if (this.f) {
            try {
                f.b().unregisterReceiver(this.b);
                m = 0L;
            } catch (Exception unused) {
            }
            this.b = null;
            this.a = null;
            this.f = false;
        }
    }

    public boolean m() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.e;
        if (jCurrentTimeMillis - j > 0 && jCurrentTimeMillis - j <= 5000) {
            return false;
        }
        this.e = jCurrentTimeMillis;
        h();
        return n();
    }

    public boolean n() {
        if (this.a == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.d;
        if (jCurrentTimeMillis - j > 0) {
            long j2 = jCurrentTimeMillis - j;
            long j3 = this.j;
            if (j2 <= j3 + 5000 || jCurrentTimeMillis - (m * 1000) <= j3 + 5000) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 28 && jCurrentTimeMillis - j < 25000) {
                return false;
            }
            if (q() && jCurrentTimeMillis - this.d <= this.j + ProtocolConstants.CONNECTION_TIMEOUT_MS) {
                return false;
            }
        }
        return p();
    }

    public String o() {
        WifiManager wifiManager = this.a;
        if (wifiManager == null) {
            return Constants.STR_EMPTY;
        }
        try {
            return (wifiManager.isWifiEnabled() || this.a.isScanAlwaysAvailable()) ? "&wifio=1" : Constants.STR_EMPTY;
        } catch (Exception | NoSuchMethodError unused) {
            return Constants.STR_EMPTY;
        }
    }

    public boolean p() {
        long jCurrentTimeMillis = System.currentTimeMillis() - this.k;
        if (jCurrentTimeMillis >= 0 && jCurrentTimeMillis <= 2000) {
            return false;
        }
        this.k = System.currentTimeMillis();
        try {
            if ((this.a.isWifiEnabled() || this.a.isScanAlwaysAvailable()) && fq3.e != 4) {
                this.a.startScan();
                this.d = System.currentTimeMillis();
                return true;
            }
        } catch (Exception | NoSuchMethodError unused) {
        }
        return false;
    }

    public boolean q() {
        try {
            if (this.g == null) {
                this.g = (ConnectivityManager) f.b().getSystemService("connectivity");
            }
            ConnectivityManager connectivityManager = this.g;
            if (connectivityManager != null) {
                return connectivityManager.getNetworkInfo(1).isConnected();
            }
            return false;
        } catch (Error | Exception unused) {
            return false;
        }
    }

    public boolean r() {
        eq3 eq3VarV;
        try {
            return (this.a.isWifiEnabled() || this.a.isScanAlwaysAvailable()) && !q() && (eq3VarV = v()) != null && eq3VarV.n();
        } catch (Exception | NoSuchMethodError unused) {
            return false;
        }
    }

    public WifiInfo s() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null && fq3.e != 4) {
            try {
                WifiInfo connectionInfo = wifiManager.getConnectionInfo();
                if (connectionInfo != null && connectionInfo.getBSSID() != null && connectionInfo.getRssi() > -100) {
                    String bssid = connectionInfo.getBSSID();
                    if (bssid != null) {
                        String strReplace = bssid.replace(":", Constants.STR_EMPTY);
                        if ("000000000000".equals(strReplace) || Constants.STR_EMPTY.equals(strReplace) || strReplace.equals("020000000000")) {
                            return null;
                        }
                    }
                    return connectionInfo;
                }
            } catch (Error | Exception unused) {
            }
        }
        return null;
    }

    public String t() {
        StringBuffer stringBuffer = new StringBuffer();
        WifiInfo wifiInfoS = c().s();
        if (wifiInfoS != null && wifiInfoS.getBSSID() != null) {
            String strReplace = wifiInfoS.getBSSID().replace(":", Constants.STR_EMPTY);
            int rssi = wifiInfoS.getRssi();
            String strU = c().u();
            if (rssi < 0) {
                rssi = -rssi;
            }
            if (strReplace != null && rssi < 100 && !strReplace.equals("020000000000")) {
                stringBuffer.append("&wf=");
                stringBuffer.append(strReplace);
                stringBuffer.append(";");
                stringBuffer.append(Constants.STR_EMPTY + rssi + ";");
                String ssid = wifiInfoS.getSSID();
                if (ssid != null && (ssid.contains("&") || ssid.contains(";"))) {
                    ssid = ssid.replace("&", "_");
                }
                stringBuffer.append(ssid);
                stringBuffer.append("&wf_n=1");
                if (strU != null) {
                    stringBuffer.append("&wf_gw=");
                    stringBuffer.append(strU);
                }
                return stringBuffer.toString();
            }
        }
        return null;
    }

    public String u() {
        DhcpInfo dhcpInfo;
        WifiManager wifiManager = this.a;
        if (wifiManager == null || (dhcpInfo = wifiManager.getDhcpInfo()) == null) {
            return null;
        }
        return a(dhcpInfo.gateway);
    }

    public eq3 v() {
        eq3 eq3Var = this.c;
        return (eq3Var == null || !eq3Var.s()) ? x() : this.c;
    }

    public eq3 w() {
        eq3 eq3Var = this.c;
        return (eq3Var == null || !eq3Var.t()) ? x() : this.c;
    }

    public eq3 x() {
        WifiManager wifiManager = this.a;
        if (wifiManager != null) {
            try {
                return b(wifiManager, this.d);
            } catch (Exception unused) {
            }
        }
        return b(null, 0L);
    }
}
