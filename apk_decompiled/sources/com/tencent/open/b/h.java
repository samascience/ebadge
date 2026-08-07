package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.k;
import com.tencent.open.utils.l;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class h {
    protected static h a;
    protected HandlerThread e;
    protected Handler f;
    protected Random b = new Random();
    protected List<Serializable> d = Collections.synchronizedList(new ArrayList());
    protected List<Serializable> c = Collections.synchronizedList(new ArrayList());
    protected Executor g = k.b();
    protected Executor h = k.b();

    private h() {
        this.e = null;
        if (this.e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.e = handlerThread;
            handlerThread.start();
        }
        if (!this.e.isAlive() || this.e.getLooper() == null) {
            return;
        }
        this.f = new Handler(this.e.getLooper()) { // from class: com.tencent.open.b.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i = message.what;
                if (i == 1000) {
                    h.this.b();
                } else if (i == 1001) {
                    h.this.e();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized h a() {
        try {
            if (a == null) {
                a = new h();
            }
        } catch (Throwable th) {
            throw th;
        }
        return a;
    }

    protected void b() {
        if (l.b(com.tencent.open.utils.g.a())) {
            this.h.execute(new Runnable() { // from class: com.tencent.open.b.h.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Map<String, String> mapC = h.this.c();
                        if (mapC != null && !mapC.isEmpty()) {
                            int iA = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Common_HttpRetryCount");
                            if (iA == 0) {
                                iA = 3;
                            }
                            SLog.d("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + iA);
                            int i = 0;
                            do {
                                i++;
                                try {
                                    int iD = com.tencent.open.a.a.a().b("https://wspeed.qq.com/w.cgi", mapC).d();
                                    SLog.i("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + iD);
                                    if (iD != 200) {
                                        break;
                                    } else {
                                        g.a().b("report_cgi");
                                    }
                                } catch (SocketTimeoutException e) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e);
                                } catch (Exception e2) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e2);
                                }
                                h.this.c.clear();
                            } while (i < iA);
                            g.a().a("report_cgi", h.this.c);
                            h.this.c.clear();
                        }
                    } catch (Exception e3) {
                        SLog.e("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e3);
                    }
                }
            });
        }
    }

    protected Map<String, String> c() {
        if (this.c.size() == 0) {
            return null;
        }
        c cVar = (c) this.c.get(0);
        if (cVar == null) {
            SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = cVar.a.get("appid");
        List<Serializable> listA = g.a().a("report_cgi");
        if (listA != null) {
            this.c.addAll(listA);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.c.size());
        if (this.c.size() == 0) {
            return null;
        }
        HashMap map = new HashMap();
        try {
            map.put("appid", str);
            map.put("releaseversion", Constants.SDK_VERSION_REPORT);
            map.put("device", com.tencent.open.utils.f.a().a(com.tencent.open.utils.g.a()));
            map.put("qua", Constants.SDK_QUA);
            map.put("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i = 0; i < this.c.size(); i++) {
                c cVar2 = (c) this.c.get(i);
                map.put(i + "_1", cVar2.a.get("apn"));
                map.put(i + "_2", cVar2.a.get("frequency"));
                map.put(i + "_3", cVar2.a.get("commandid"));
                map.put(i + "_4", cVar2.a.get("resultCode"));
                map.put(i + "_5", cVar2.a.get("timeCost"));
                map.put(i + "_6", cVar2.a.get("reqSize"));
                map.put(i + "_7", cVar2.a.get("rspSize"));
                map.put(i + "_8", cVar2.a.get("detail"));
                map.put(i + "_9", cVar2.a.get("uin"));
                map.put(i + "_10", d.e(com.tencent.open.utils.g.a()) + "&" + cVar2.a.get("deviceInfo"));
            }
            SLog.v("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + map.toString());
            return map;
        } catch (Exception e) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e);
            return null;
        }
    }

    protected Map<String, String> d() {
        List<Serializable> listA = g.a().a("report_via");
        if (listA != null) {
            this.d.addAll(listA);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.d.size());
        if (this.d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.d) {
            JSONObject jSONObject = new JSONObject();
            c cVar = (c) serializable;
            for (String str : cVar.a.keySet()) {
                try {
                    String str2 = cVar.a.get(str);
                    if (str2 == null) {
                        str2 = Constants.STR_EMPTY;
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap map = new HashMap();
            map.put("data", jSONObject2.toString());
            return map;
        } catch (JSONException e2) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
            return null;
        }
    }

    protected void e() {
        if (l.b(com.tencent.open.utils.g.a())) {
            this.g.execute(new Runnable() { // from class: com.tencent.open.b.h.5
                @Override // java.lang.Runnable
                public void run() {
                    int i;
                    long j;
                    long jB;
                    long j2;
                    long j3;
                    long j4;
                    boolean z;
                    int i2;
                    try {
                        Map<String, String> mapD = h.this.d();
                        if (mapD == null) {
                            return;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, params: " + mapD.toString());
                        int iA = f.a();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        int i3 = 0;
                        int errorCodeFromException = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            try {
                                try {
                                    com.tencent.open.a.b bVarB = com.tencent.open.a.a.a().b("https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", mapD);
                                    SLog.i("openSDK_LOG.ReportManager", "-->reportVia: statusCode " + bVarB.d());
                                    JSONObject jSONObjectD = l.d(bVarB.a());
                                    long jC = (long) bVarB.c();
                                    i = i4;
                                    jB = bVarB.b();
                                    try {
                                        try {
                                            if (bVarB.d() != 200) {
                                                errorCodeFromException = bVarB.d();
                                                j2 = jElapsedRealtime;
                                                j3 = jB;
                                                j4 = jC;
                                                z = false;
                                            } else {
                                                try {
                                                    i2 = jSONObjectD.getInt("ret");
                                                } catch (JSONException unused) {
                                                    i2 = -4;
                                                }
                                                if (i2 == 0 || jB != 0) {
                                                    j2 = jElapsedRealtime;
                                                    j3 = jB;
                                                    j4 = jC;
                                                    z = true;
                                                } else {
                                                    j = jC;
                                                    i3 = i;
                                                    if (i3 >= iA) {
                                                        j2 = jElapsedRealtime;
                                                        j3 = jB;
                                                        j4 = j;
                                                        z = false;
                                                    }
                                                }
                                            }
                                        } catch (JSONException unused2) {
                                            j = 0;
                                            jB = 0;
                                            i3 = i;
                                            errorCodeFromException = -4;
                                        }
                                    } catch (SocketTimeoutException unused3) {
                                        j = 0;
                                        jElapsedRealtime = SystemClock.elapsedRealtime();
                                        errorCodeFromException = -8;
                                        jB = j;
                                    } catch (IOException e) {
                                        e = e;
                                        j = 0;
                                        errorCodeFromException = HttpUtils.getErrorCodeFromException(e);
                                        jB = j;
                                    }
                                } catch (Exception unused4) {
                                    j = 0;
                                    errorCodeFromException = -6;
                                    i3 = iA;
                                    jB = 0;
                                }
                            } catch (SocketTimeoutException unused5) {
                                i = i4;
                            } catch (IOException e2) {
                                e = e2;
                                i = i4;
                            } catch (JSONException unused6) {
                                i = i4;
                            }
                            h.this.a("mapp_apptrace_sdk", j2, j4, j3, errorCodeFromException, null, false);
                            if (z) {
                                g.a().b("report_via");
                            } else {
                                g.a().a("report_via", h.this.d);
                            }
                            h.this.d.clear();
                            SLog.i("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z + " resultCode: " + errorCodeFromException);
                            return;
                        }
                    } catch (Exception e3) {
                        SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e3);
                    }
                }
            });
        }
    }

    public void a(final Bundle bundle, String str, final boolean z) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z) {
            this.g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        String strK = l.k(d.b(com.tencent.open.utils.g.a()));
                        String strK2 = l.k(d.c(com.tencent.open.utils.g.a()));
                        String strK3 = l.k(d.a());
                        String strK4 = l.k(d.d(com.tencent.open.utils.g.a()));
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("imei", strK);
                        bundle2.putString("imsi", strK2);
                        bundle2.putString("android_id", strK4);
                        bundle2.putString("mac", strK3);
                        bundle2.putString(Constants.PARAM_PLATFORM, "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", Constants.STR_EMPTY);
                        bundle2.putString("network", a.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("language", d.b());
                        bundle2.putString("resolution", d.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.g.a()));
                        bundle2.putString(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().b(com.tencent.open.utils.g.a()));
                        bundle2.putString("timezone", TimeZone.getDefault().getID());
                        bundle2.putString(Constants.PARAM_SDK_VER, Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", l.d(com.tencent.open.utils.g.a(), Constants.PACKAGE_QZONE));
                        bundle2.putString(Constants.PARAM_QQ_VER, l.c(com.tencent.open.utils.g.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", l.e(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.g.b());
                        bundle2.putString(Constants.PARAM_APP_VER, l.d(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        Bundle bundle3 = bundle;
                        if (bundle3 != null) {
                            bundle2.putAll(bundle3);
                        }
                        h.this.d.add(new c(bundle2));
                        int size = h.this.d.size();
                        int iA = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (iA == 0) {
                            iA = 10000;
                        }
                        if (!h.this.a("report_via", size) && !z) {
                            if (h.this.f.hasMessages(1001)) {
                                return;
                            }
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 1001;
                            h.this.f.sendMessageDelayed(messageObtain, iA);
                            return;
                        }
                        h.this.e();
                        h.this.f.removeMessages(1001);
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    public void a(String str, long j, long j2, long j3, int i) {
        a(str, j, j2, j3, i, Constants.STR_EMPTY, false);
    }

    public void a(final String str, final long j, final long j2, final long j3, final int i, final String str2, final boolean z) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j + " | reqSize:" + j2 + " | rspSize: " + j3 + " | responseCode: " + i + " | detail: " + str2);
        if (a("report_cgi", Constants.STR_EMPTY + i) || z) {
            this.h.execute(new Runnable() { // from class: com.tencent.open.b.h.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long jElapsedRealtime = SystemClock.elapsedRealtime() - j;
                        Bundle bundle = new Bundle();
                        String strA = a.a(com.tencent.open.utils.g.a());
                        bundle.putString("apn", strA);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString("detail", str2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("network=");
                        sb.append(strA);
                        sb.append('&');
                        sb.append("sdcard=");
                        int i2 = 1;
                        sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                        sb.append('&');
                        sb.append("wifi=");
                        sb.append(a.e(com.tencent.open.utils.g.a()));
                        bundle.putString("deviceInfo", sb.toString());
                        int iA = 100 / h.this.a(i);
                        if (iA > 0) {
                            i2 = iA > 100 ? 100 : iA;
                        }
                        bundle.putString("frequency", i2 + Constants.STR_EMPTY);
                        bundle.putString("reqSize", j2 + Constants.STR_EMPTY);
                        bundle.putString("resultCode", i + Constants.STR_EMPTY);
                        bundle.putString("rspSize", j3 + Constants.STR_EMPTY);
                        bundle.putString("timeCost", jElapsedRealtime + Constants.STR_EMPTY);
                        bundle.putString("uin", Constants.DEFAULT_UIN);
                        h.this.c.add(new c(bundle));
                        int size = h.this.c.size();
                        int iA2 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (iA2 == 0) {
                            iA2 = 10000;
                        }
                        if (h.this.a("report_cgi", size) || z) {
                            h.this.b();
                            h.this.f.removeMessages(1000);
                        } else if (!h.this.f.hasMessages(1000)) {
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 1000;
                            h.this.f.sendMessageDelayed(messageObtain, iA2);
                        }
                    } catch (Exception e) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e);
                    }
                }
            });
        }
    }

    protected boolean a(String str, String str2) {
        int iA;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i = 100;
        if (str.equals("report_cgi")) {
            try {
                iA = a(Integer.parseInt(str2));
                if (this.b.nextInt(100) < iA) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                iA = f.a(str2);
                if (this.b.nextInt(100) < iA) {
                    i = iA;
                    z = true;
                }
            }
            SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
            return z;
        }
        i = iA;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i);
        return z;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x001c A[PHI: r0
      0x001c: PHI (r0v9 int) = (r0v6 int), (r0v12 int) binds: [B:11:0x0034, B:5:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    protected boolean a(String str, int i) {
        int iA;
        int i2 = 5;
        if (str.equals("report_cgi")) {
            iA = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportMaxcount");
            if (iA != 0) {
                i2 = iA;
            }
        } else if (str.equals("report_via")) {
            iA = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportBatchCount");
            if (iA != 0) {
                i2 = iA;
            }
        } else {
            i2 = 0;
        }
        SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i + " | maxcount: " + i2);
        return i >= i2;
    }

    protected int a(int i) {
        if (i == 0) {
            int iA = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (iA == 0) {
                return 10;
            }
            return iA;
        }
        int iA2 = com.tencent.open.utils.h.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (iA2 == 0) {
            return 100;
        }
        return iA2;
    }

    public void a(final String str, final Map<String, String> map) {
        if (l.b(com.tencent.open.utils.g.a())) {
            k.b(new Runnable() { // from class: com.tencent.open.b.h.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        int iA = f.a();
                        if (iA == 0) {
                            iA = 3;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + iA);
                        int i = 0;
                        do {
                            i++;
                            try {
                                try {
                                    SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + com.tencent.open.a.a.a().a(str, map).d());
                                    break;
                                } catch (SocketTimeoutException e) {
                                    SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e);
                                }
                            } catch (Exception e2) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e2);
                                break;
                            }
                        } while (i < iA);
                    } catch (Exception e3) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e3);
                    }
                }
            });
        }
    }
}
