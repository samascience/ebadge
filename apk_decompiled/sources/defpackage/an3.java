package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.location.Jni;
import com.baidu.location.LocationClientOption;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class an3 {
    private static String y = "BDLocConfigManager";
    private SharedPreferences a;
    public boolean b;
    public int c;
    private long d;
    public double e;
    public int f;
    public int g;
    public double h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public double[] o;
    public int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f123q;
    public int r;
    private String s;
    private a t;
    private boolean u;
    private String v;
    private String w;
    private String x;

    class a extends np3 {
        String k = null;
        boolean l = false;

        public a() {
            this.d = new HashMap();
        }

        @Override // defpackage.np3
        public void a() {
            this.b = 2;
            String strE = Jni.e(this.k);
            this.k = null;
            this.d.put("qt", "conf");
            this.d.put("req", strE);
        }

        @Override // defpackage.np3
        public void d(boolean z) {
            if (z && this.c != null) {
                try {
                    new JSONObject(this.c);
                    if (an3.this.a != null) {
                        SharedPreferences.Editor editorEdit = an3.this.a.edit();
                        editorEdit.putString(an3.y + "_newConfig", Base64.encodeToString(fq3.p(this.c.getBytes()), 0));
                        editorEdit.commit();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            Map map = this.d;
            if (map != null) {
                map.clear();
            }
            this.l = false;
        }

        public void f(String str) {
            if (this.l) {
                return;
            }
            this.l = true;
            this.k = str;
            e(fp3.b);
        }
    }

    private static class b {
        public static final an3 a = new an3();
    }

    private an3() {
        this.a = null;
        this.b = false;
        this.c = 16;
        this.d = 300L;
        this.e = 0.75d;
        this.f = 0;
        this.g = 1;
        this.h = -0.10000000149011612d;
        this.i = 0;
        this.j = 1;
        this.k = 1;
        this.l = 10;
        this.m = 3;
        this.n = 40;
        this.p = 1;
        this.f123q = 0;
        this.r = 1;
        this.s = null;
        this.t = null;
        this.u = false;
        this.v = null;
        this.w = null;
        this.x = null;
    }

    public static an3 a() {
        return b.a;
    }

    private void e(LocationClientOption locationClientOption) throws Throwable {
        String str = "&ver=" + fq3.o + "&usr=" + i() + "&app=" + this.v + "&prod=" + locationClientOption.f + "&newwf=1";
        String strSubstring = Build.VERSION.RELEASE;
        if (strSubstring != null && strSubstring.length() > 6) {
            strSubstring = strSubstring.substring(0, 6);
        }
        String str2 = str + "&sv=" + strSubstring;
        String strW = fq3.w("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(strW)) {
            str2 = str2 + "&miui=" + strW;
        }
        String strG = fq3.G();
        if (!TextUtils.isEmpty(strG)) {
            str2 = str2 + "&mtk=" + strG;
        }
        String string = this.a.getString(y + "_loc", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                str2 = str2 + "&loc=" + new String(Base64.decode(string, 0), Constants.ENC_UTF_8);
            } catch (Exception unused) {
            }
        }
        if (this.t == null) {
            this.t = new a();
        }
        this.t.f(str2);
    }

    private void f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("is_check_Per") && jSONObject.getInt("is_check_Per") > 0) {
                this.b = true;
            }
            if (jSONObject.has("wfnum")) {
                this.c = jSONObject.getInt("wfnum");
            }
            if (jSONObject.has("freq")) {
                this.d = jSONObject.getLong("freq");
            }
            if (jSONObject.has("wfsm")) {
                this.e = jSONObject.getDouble("wfsm");
            }
            if (jSONObject.has("idmoc")) {
                this.f = jSONObject.getInt("idmoc");
            }
            if (jSONObject.has("gnmcrm")) {
                this.h = jSONObject.getDouble("gnmcrm");
            }
            if (jSONObject.has("gnmcon")) {
                this.i = jSONObject.getInt("gnmcon");
            }
            if (jSONObject.has("lpcs")) {
                this.g = jSONObject.getInt("lpcs");
            }
            if (jSONObject.has("iupl")) {
                this.j = jSONObject.getInt("iupl");
            }
            if (jSONObject.has("opetco")) {
                this.k = jSONObject.getInt("opetco");
            }
            if (jSONObject.has("ct")) {
                this.l = jSONObject.getInt("ct");
            }
            if (jSONObject.has("suci")) {
                this.m = jSONObject.getInt("suci");
            }
            if (jSONObject.has("smn")) {
                this.n = jSONObject.getInt("smn");
            }
            if (jSONObject.has("bcar")) {
                g(jSONObject);
            }
            if (jSONObject.has("ums")) {
                this.p = jSONObject.getInt("ums");
            }
            if (jSONObject.has("hpdts")) {
                this.f123q = jSONObject.getInt("hpdts");
            }
            if (jSONObject.has("oldts")) {
                this.r = jSONObject.getInt("oldts");
            }
            this.s = str;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String i() {
        StringBuilder sb = new StringBuilder();
        sb.append("v9.293|");
        sb.append(this.w);
        sb.append("|");
        String str = Build.MODEL;
        sb.append(str);
        sb.append("&cu=");
        sb.append(this.w);
        sb.append("&mb=");
        sb.append(str);
        return sb.toString();
    }

    public synchronized void c(double d, double d2, String str) {
        SharedPreferences sharedPreferences;
        try {
            if (this.x == null && str != null) {
                try {
                    if (str.equals("bd09") || str.equals("wgs84mc")) {
                        double[] dArrC = Jni.c(d2, d, "bd092gcj");
                        double d3 = dArrC[1];
                        double d4 = dArrC[0];
                        d = d3;
                        d2 = d4;
                    }
                    String str2 = String.format(Locale.US, "%.5f|%.5f", Double.valueOf(d2), Double.valueOf(d));
                    this.x = str2;
                    String strEncodeToString = Base64.encodeToString(str2.getBytes(Constants.ENC_UTF_8), 0);
                    if (strEncodeToString != null && (sharedPreferences = this.a) != null) {
                        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                        editorEdit.putString(y + "_loc", strEncodeToString);
                        editorEdit.commit();
                    }
                } catch (Exception unused) {
                    this.x = null;
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void d(Context context, LocationClientOption locationClientOption, String str) {
        try {
            if (!this.u && context != null) {
                this.u = true;
                if (locationClientOption == null) {
                    locationClientOption = new LocationClientOption();
                }
                this.v = context.getPackageName();
                try {
                    this.w = p91.w(context).v();
                } catch (Throwable unused) {
                    this.w = null;
                }
                if (this.a == null) {
                    this.a = context.getSharedPreferences(y + "BDLocConfig", 0);
                }
                SharedPreferences sharedPreferences = this.a;
                if (sharedPreferences != null) {
                    long j = sharedPreferences.getLong(y + "_lastCheckTime", 0L);
                    String string = this.a.getString(y + "_config", Constants.STR_EMPTY);
                    String string2 = this.a.getString(y + "_newConfig", Constants.STR_EMPTY);
                    if (!TextUtils.isEmpty(string2)) {
                        f(new String(fq3.u(Base64.decode(string2, 0))));
                    } else if (!TextUtils.isEmpty(string)) {
                        f(string);
                        SharedPreferences.Editor editorEdit = this.a.edit();
                        editorEdit.remove(y + "_config");
                        editorEdit.apply();
                    }
                    if (Math.abs((System.currentTimeMillis() / 1000) - j) > this.d) {
                        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
                        SharedPreferences.Editor editorEdit2 = this.a.edit();
                        editorEdit2.putLong(y + "_lastCheckTime", jCurrentTimeMillis);
                        editorEdit2.commit();
                        e(locationClientOption);
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void g(JSONObject jSONObject) {
        JSONArray jSONArray;
        if (jSONObject != null) {
            double[] dArr = this.o;
            if (dArr != null && dArr.length > 0) {
                this.o = null;
            }
            try {
                if (!jSONObject.has("bcar") || (jSONArray = jSONObject.getJSONArray("bcar")) == null || jSONArray.length() <= 0) {
                    return;
                }
                if (this.o == null) {
                    this.o = new double[jSONArray.length() * 4];
                }
                int i = 0;
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.o[i] = jSONArray.getJSONObject(i2).getDouble("x1");
                    this.o[i + 1] = jSONArray.getJSONObject(i2).getDouble("y1");
                    int i3 = i + 3;
                    this.o[i + 2] = jSONArray.getJSONObject(i2).getDouble("x2");
                    i += 4;
                    this.o[i3] = jSONArray.getJSONObject(i2).getDouble("y2");
                }
            } catch (Exception unused) {
            }
        }
    }
}
