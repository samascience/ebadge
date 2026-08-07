package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class p91 {
    private static Context e;
    private static oq3 f;
    private static int g;
    private static p91 i;
    private vo3 a = null;
    private hp3 b = null;
    private boolean c = false;
    private final Handler d = new zp3(this, Looper.getMainLooper());
    private static Hashtable h = new Hashtable();
    private static String j = Constants.STR_EMPTY;
    private static String k = Constants.STR_EMPTY;
    private static String l = Constants.STR_EMPTY;
    private static String[] m = null;
    private static boolean n = false;

    private p91(Context context) {
        e = context;
        oq3 oq3Var = f;
        if (oq3Var != null && !oq3Var.isAlive()) {
            f = null;
        }
        ym3.c("BaiduApiAuth SDK Version:1.0.25");
        s();
    }

    private int a(String str) {
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            i2 = jSONObject.getInt("status");
            if (jSONObject.has("current") && i2 == 0) {
                long j2 = jSONObject.getLong("current");
                long jCurrentTimeMillis = System.currentTimeMillis();
                if ((jCurrentTimeMillis - j2) / 3600000.0d >= 24.0d) {
                    i2 = 601;
                } else if (this.c) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    if (!simpleDateFormat.format(Long.valueOf(jCurrentTimeMillis)).equals(simpleDateFormat.format(Long.valueOf(j2)))) {
                        i2 = 601;
                    }
                    return i2;
                }
            }
            if (jSONObject.has("current") && i2 == 602) {
                if ((System.currentTimeMillis() - jSONObject.getLong("current")) / 1000 > 180.0d) {
                    return 601;
                }
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return i2;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x006e  */
    /* JADX WARN: Code duplicated, block: B:35:0x0073  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0080  */
    /* JADX WARN: Code duplicated, block: B:8:0x0035 A[PHI: r0 r6
      0x0035: PHI (r0v6 java.lang.String) = (r0v0 java.lang.String), (r0v0 java.lang.String), (r0v12 java.lang.String) binds: [B:36:0x0076, B:42:0x0083, B:7:0x002f] A[DONT_GENERATE, DONT_INLINE]
      0x0035: PHI (r6v10 java.io.FileInputStream) = (r6v8 java.io.FileInputStream), (r6v9 java.io.FileInputStream), (r6v13 java.io.FileInputStream) binds: [B:36:0x0076, B:42:0x0083, B:7:0x002f] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Multi-variable type inference failed */
    private String b(int i2) throws Throwable {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        FileInputStream fileInputStream;
        String line = null;
        try {
            fileInputStream = new FileInputStream(new File("/proc/" + i2 + "/cmdline"));
            try {
                inputStreamReader = new InputStreamReader(fileInputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    try {
                        line = bufferedReader.readLine();
                        bufferedReader.close();
                        inputStreamReader.close();
                    } catch (FileNotFoundException unused) {
                        if (bufferedReader != 0) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                        }
                        return line;
                    } catch (IOException unused2) {
                        if (bufferedReader != 0) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                        }
                        return line;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != 0) {
                            bufferedReader.close();
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused3) {
                    bufferedReader = 0;
                } catch (IOException unused4) {
                    bufferedReader = 0;
                } catch (Throwable th3) {
                    bufferedReader = 0;
                    th = th3;
                }
            } catch (FileNotFoundException unused5) {
                inputStreamReader = null;
                bufferedReader = inputStreamReader;
                if (bufferedReader != 0) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return line;
            } catch (IOException unused6) {
                inputStreamReader = null;
                bufferedReader = inputStreamReader;
                if (bufferedReader != 0) {
                    bufferedReader.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                return line;
            } catch (Throwable th4) {
                bufferedReader = 0;
                th = th4;
                inputStreamReader = null;
            }
        } catch (FileNotFoundException unused7) {
            fileInputStream = null;
            inputStreamReader = null;
        } catch (IOException unused8) {
            fileInputStream = null;
            inputStreamReader = null;
        } catch (Throwable th5) {
            inputStreamReader = null;
            bufferedReader = 0;
            th = th5;
            fileInputStream = null;
        }
        fileInputStream.close();
        return line;
    }

    private String c(Context context) throws Throwable {
        String strB;
        try {
            strB = b(Process.myPid());
        } catch (IOException unused) {
            strB = null;
        }
        return strB != null ? strB : e.getPackageName();
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0052 A[Catch: NameNotFoundException -> 0x0046, TRY_LEAVE, TryCatch #0 {NameNotFoundException -> 0x0046, blocks: (B:14:0x003f, B:18:0x0048, B:20:0x0052), top: B:27:0x003f }] */
    private String d(Context context, String str) {
        q91 q91Var;
        String str2 = Constants.STR_EMPTY;
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        try {
            Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (bundle != null) {
                String string = bundle.getString("com.baidu.lbsapi.API_KEY");
                if (string != null) {
                    try {
                        if (string.equals(Constants.STR_EMPTY)) {
                            q91Var = (q91) h.get(str);
                            if (q91Var != null) {
                                q91Var.a(101, ai0.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                            }
                        }
                        str2 = string;
                    } catch (PackageManager.NameNotFoundException unused) {
                        str2 = string;
                        q91 q91Var2 = (q91) h.get(str);
                        if (q91Var2 != null) {
                            q91Var2.a(101, ai0.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                        }
                    }
                } else {
                    q91Var = (q91) h.get(str);
                    if (q91Var != null) {
                        q91Var.a(101, ai0.a(101, "无法在AndroidManifest.xml中获取com.baidu.android.lbs.API_KEY的值"));
                    }
                    str2 = string;
                }
                return str2;
            }
            q91 q91Var3 = (q91) h.get(str);
            if (q91Var3 != null) {
                q91Var3.a(101, ai0.a(101, "AndroidManifest.xml的application中没有meta-data标签"));
            }
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void i(String str, String str2) {
        oq3 oq3Var;
        if (str == null) {
            try {
                str = u();
            } catch (Throwable th) {
                throw th;
            }
        }
        Message messageObtainMessage = this.d.obtainMessage();
        int i2 = -1;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.has("status")) {
                jSONObject.put("status", -1);
            }
            if (!jSONObject.has("current")) {
                jSONObject.put("current", System.currentTimeMillis());
            }
            q(jSONObject.toString());
            if (jSONObject.has("current")) {
                jSONObject.remove("current");
            }
            i2 = jSONObject.getInt("status");
            messageObtainMessage.what = i2;
            messageObtainMessage.obj = jSONObject.toString();
            Bundle bundle = new Bundle();
            bundle.putString("listenerKey", str2);
            messageObtainMessage.setData(bundle);
            this.d.sendMessage(messageObtainMessage);
        } catch (JSONException e2) {
            e2.printStackTrace();
            messageObtainMessage.what = i2;
            messageObtainMessage.obj = new JSONObject();
            Bundle bundle2 = new Bundle();
            bundle2.putString("listenerKey", str2);
            messageObtainMessage.setData(bundle2);
            this.d.sendMessage(messageObtainMessage);
        }
        oq3 oq3Var2 = f;
        if (oq3Var2 != null) {
            oq3Var2.c();
        }
        g--;
        ym3.b("httpRequest called mAuthCounter-- = " + g);
        if (g == 0 && (oq3Var = f) != null) {
            oq3Var.a();
            f = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(boolean z, String str, Hashtable hashtable, String str2) {
        String strA;
        StringBuilder sb;
        int i2;
        String strD = d(e, str2);
        if (strD == null || strD.equals(Constants.STR_EMPTY)) {
            return;
        }
        HashMap map = new HashMap();
        map.put(SocialConstants.PARAM_URL, "https://api.map.baidu.com/sdkcs/verify");
        ym3.b("url:https://api.map.baidu.com/sdkcs/verify");
        map.put("output", "json");
        map.put("ak", strD);
        ym3.b("ak:" + strD);
        map.put("mcode", !TextUtils.isEmpty(l) ? l : qo3.b(e));
        map.put(Constants.FROM, "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry entry : hashtable.entrySet()) {
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    map.put(str3, str4);
                }
            }
        }
        String strV = v();
        ym3.b("cuid:" + strV);
        if (TextUtils.isEmpty(strV)) {
            map.put("cuid", Constants.STR_EMPTY);
        } else {
            map.put("cuid", strV);
        }
        map.put("pcn", e.getPackageName());
        map.put("version", "1.0.25");
        map.put("macaddr", Constants.STR_EMPTY);
        try {
            strA = qo3.a();
        } catch (Exception unused) {
            strA = Constants.STR_EMPTY;
        }
        if (TextUtils.isEmpty(strA)) {
            map.put("language", Constants.STR_EMPTY);
        } else {
            map.put("language", strA);
        }
        if (z) {
            if (z) {
                sb = new StringBuilder();
                i2 = 1;
            } else {
                sb = new StringBuilder();
                i2 = 0;
            }
            sb.append(i2);
            sb.append(Constants.STR_EMPTY);
            map.put("force", sb.toString());
        }
        if (str == null) {
            map.put("from_service", Constants.STR_EMPTY);
        } else {
            map.put("from_service", str);
        }
        String strT = t();
        if (!TextUtils.isEmpty(strT)) {
            map.put("extend", strT);
        }
        vo3 vo3Var = new vo3(e);
        this.a = vo3Var;
        vo3Var.e(map, new gq3(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(boolean z, String str, Hashtable hashtable, String[] strArr, String str2) {
        String strA;
        StringBuilder sb;
        int i2;
        String strD = d(e, str2);
        if (strD == null || strD.equals(Constants.STR_EMPTY)) {
            return;
        }
        HashMap map = new HashMap();
        map.put(SocialConstants.PARAM_URL, "https://api.map.baidu.com/sdkcs/verify");
        map.put("output", "json");
        map.put("ak", strD);
        map.put(Constants.FROM, "lbs_yunsdk");
        if (hashtable != null && hashtable.size() > 0) {
            for (Map.Entry entry : hashtable.entrySet()) {
                String str3 = (String) entry.getKey();
                String str4 = (String) entry.getValue();
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    map.put(str3, str4);
                }
            }
        }
        String strV = v();
        ym3.b("sendAuthRequests : cuid: " + strV);
        if (TextUtils.isEmpty(strV)) {
            map.put("cuid", Constants.STR_EMPTY);
        } else {
            map.put("cuid", strV);
        }
        map.put("pcn", e.getPackageName());
        map.put("version", "1.0.25");
        map.put("macaddr", Constants.STR_EMPTY);
        try {
            strA = qo3.a();
        } catch (Exception unused) {
            strA = Constants.STR_EMPTY;
        }
        if (TextUtils.isEmpty(strA)) {
            map.put("language", Constants.STR_EMPTY);
        } else {
            map.put("language", strA);
        }
        if (z) {
            if (z) {
                sb = new StringBuilder();
                i2 = 1;
            } else {
                sb = new StringBuilder();
                i2 = 0;
            }
            sb.append(i2);
            sb.append(Constants.STR_EMPTY);
            map.put("force", sb.toString());
        }
        if (str == null) {
            map.put("from_service", Constants.STR_EMPTY);
        } else {
            map.put("from_service", str);
        }
        String strT = t();
        if (!TextUtils.isEmpty(strT)) {
            map.put("extend", strT);
        }
        hp3 hp3Var = new hp3(e);
        this.b = hp3Var;
        hp3Var.e(map, strArr, new kq3(this, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean n(String str) {
        String string;
        String strD = d(e, str);
        try {
            JSONObject jSONObject = new JSONObject(u());
            if (!jSONObject.has("ak")) {
                return true;
            }
            string = jSONObject.getString("ak");
        } catch (JSONException e2) {
            e2.printStackTrace();
            string = Constants.STR_EMPTY;
        }
        return (strD == null || string == null || strD.equals(string)) ? false : true;
    }

    private void q(String str) {
        e.getSharedPreferences("authStatus_" + c(e), 0).edit().putString("status", str).commit();
    }

    private void s() {
        synchronized (p91.class) {
            if (f == null) {
                oq3 oq3Var = new oq3("auth");
                f = oq3Var;
                oq3Var.start();
                while (f.a == null) {
                    try {
                        ym3.b("wait for create auth thread.");
                        Thread.sleep(3L);
                    } catch (InterruptedException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    private String t() {
        try {
            JSONObject jSONObject = new JSONObject(u());
            return !jSONObject.has("extend") ? Constants.STR_EMPTY : jSONObject.getString("extend");
        } catch (JSONException unused) {
            return Constants.STR_EMPTY;
        }
    }

    private String u() {
        return e.getSharedPreferences("authStatus_" + c(e), 0).getString("status", "{\"status\":601}");
    }

    public static p91 w(Context context) {
        if (i == null) {
            synchronized (p91.class) {
                try {
                    if (i == null) {
                        i = new p91(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        } else if (context != null) {
            e = context;
        } else if (ym3.a) {
            ym3.d("input context is null");
            new RuntimeException("here").printStackTrace();
        }
        return i;
    }

    public int m(boolean z, String str, Hashtable hashtable, q91 q91Var) {
        synchronized (p91.class) {
            boolean z2 = false;
            if (hashtable != null) {
                try {
                    String str2 = (String) hashtable.get("zero_auth");
                    if (str2 != null && Integer.valueOf(str2).intValue() == 1) {
                        z2 = true;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            this.c = z2;
            String str3 = System.currentTimeMillis() + Constants.STR_EMPTY;
            if (q91Var != null) {
                h.put(str3, q91Var);
            }
            String strD = d(e, str3);
            if (strD != null && !strD.equals(Constants.STR_EMPTY)) {
                g++;
                ym3.b(" mAuthCounter  ++ = " + g);
                String strU = u();
                ym3.b("getAuthMessage from cache:" + strU);
                int iA = a(strU);
                if (iA == 601) {
                    try {
                        q(new JSONObject().put("status", 602).toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
                s();
                oq3 oq3Var = f;
                if (oq3Var != null && oq3Var.a != null) {
                    ym3.b("mThreadLooper.mHandler = " + f.a);
                    f.a.post(new cq3(this, iA, z, str3, str, hashtable));
                    return iA;
                }
                return -1;
            }
            return 101;
        }
    }

    public String v() {
        Context context = e;
        String string = Constants.STR_EMPTY;
        if (context == null) {
            return Constants.STR_EMPTY;
        }
        try {
            ym3.b("mIsPrivacyMode " + n);
            if (n) {
                string = zo3.b(e);
                ym3.b("getCUID: " + string);
            } else {
                SharedPreferences sharedPreferences = e.getSharedPreferences("Map_Privacy", 0);
                if (sharedPreferences.contains("cuid")) {
                    string = sharedPreferences.getString("cuid", Constants.STR_EMPTY);
                } else {
                    string = pq3.b(UUID.randomUUID().toString().getBytes(), true) + "|MAPSDK001";
                    SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                    editorEdit.putString("cuid", string);
                    editorEdit.apply();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return string;
    }

    public String x() {
        if (e == null) {
            return Constants.STR_EMPTY;
        }
        return !TextUtils.isEmpty(l) ? l : qo3.b(e);
    }

    public String y(Context context) {
        if (!TextUtils.isEmpty(j)) {
            return j;
        }
        return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.getString("com.baidu.lbsapi.API_KEY");
    }

    public void z(boolean z) {
        Context context = e;
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("Map_Privacy", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (z) {
            editorEdit.putBoolean("privacyMode", z);
            editorEdit.apply();
        } else {
            z = sharedPreferences.getBoolean("privacyMode", false);
        }
        n = z;
    }
}
