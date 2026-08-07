package defpackage;

import android.content.Context;
import android.util.Log;
import com.baji.protocol.model.ProtocolConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class zm3 implements q91 {
    private static Object f = new Object();
    private static zm3 g;
    private int a = 0;
    private Context b = null;
    private long c = 0;
    private String d = null;
    public int e = 0;

    public static zm3 b() {
        zm3 zm3Var;
        synchronized (f) {
            try {
                if (g == null) {
                    g = new zm3();
                }
                zm3Var = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return zm3Var;
    }

    public static String d(Context context) {
        try {
            return p91.w(context).y(context);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String f(Context context) {
        try {
            return p91.w(context).x();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // defpackage.q91
    public void a(int i, String str) {
        String str2;
        this.a = i;
        if (i == 0) {
            str2 = "LocationAuthManager Authentication AUTHENTICATE_SUCC";
        } else {
            str2 = "LocationAuthManager Authentication Error errorcode = " + i + " , msg = " + str;
        }
        Log.i("baidu_location_service", str2);
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.has("token") && jSONObject.getString("token") != null) {
                    this.d = jSONObject.getString("token");
                }
                if (!jSONObject.has("ak_permission") || jSONObject.getInt("ak_permission") == 0) {
                    return;
                }
                this.e = jSONObject.getInt("ak_permission");
                Log.i("baidu_location_service", "LocationAuthManager ak_permission = " + this.e);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void c(Context context) {
        this.b = context;
        p91.w(context).m(false, "lbs_locsdk", null, this);
        this.c = System.currentTimeMillis();
    }

    public boolean e() {
        int i = this.a;
        boolean z = i == 0 || i == 602 || i == 601 || i == -10 || i == -11;
        if (this.b != null) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.c;
            if (!z ? jCurrentTimeMillis < 0 || jCurrentTimeMillis > ProtocolConstants.CONNECTION_TIMEOUT_MS : jCurrentTimeMillis > 86400000) {
                p91.w(this.b).m(false, "lbs_locsdk", null, this);
                this.c = System.currentTimeMillis();
            }
        }
        return z;
    }
}
