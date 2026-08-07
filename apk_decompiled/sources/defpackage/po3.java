package defpackage;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class po3 {
    private static final String e = d(new byte[]{81, 72, 116, 79, 75, 72, 69, 52, 76, 51, 103, 61}, new byte[]{82, 51, 104, 90, 83, 122, 65, 105, 101, 49, 107, 61});
    private static final String f = d(new byte[]{76, 67, 77, 53, 77, 70, 90, 73, 81, 107, 107, 61}, new byte[]{90, 105, 108, 121, 79, 68, 100, 81, 86, 121, 89, 61});
    private String a;
    private String b;
    private int c = 3;
    private int d;

    po3() {
    }

    static po3 a(xm3 xm3Var) {
        if (xm3Var == null) {
            throw new IllegalArgumentException("arg non-nullable is expected");
        }
        po3 po3Var = new po3();
        po3Var.f(xm3Var.a());
        po3Var.k(xm3Var.f());
        return po3Var;
    }

    static po3 b(Context context, String str) {
        return i(context, str);
    }

    private static String d(byte[]... bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte[] bArr2 : bArr) {
            sb.append(new String(yf.a(bArr2)));
        }
        return sb.toString();
    }

    static po3 h(Context context) {
        File fileO = o(context);
        if (fileO.exists()) {
            return n(gp3.b(fileO));
        }
        return null;
    }

    private static po3 i(Context context, String str) {
        po3 po3Var = new po3();
        int i = Build.VERSION.SDK_INT;
        po3Var.f(uo3.b(("com.baidu" + gp3.a(context)).getBytes(), true));
        po3Var.k(str);
        po3Var.e(i);
        return po3Var;
    }

    private String j() {
        try {
            JSONObject jSONObjectPut = new JSONObject().put(r("ZGV2aWNlaWQ="), this.a);
            String strR = r("ZmxhZw==");
            String str = this.b;
            if (str == null) {
                str = "0";
            }
            return jSONObjectPut.put(strR, str).put(r("dmVy"), this.c).put(r("c2Rr"), this.d).toString();
        } catch (JSONException e2) {
            gp3.c(e2);
            return null;
        }
    }

    static po3 l(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            String strOptString = jSONObject.optString(r("ZmxhZw=="), "0");
            String string = jSONObject.getString(r("ZGV2aWNlaWQ="));
            int iOptInt = jSONObject.optInt(r("c2Rr"), 0);
            if (!TextUtils.isEmpty(string)) {
                po3 po3Var = new po3();
                po3Var.f(string);
                po3Var.k(strOptString);
                po3Var.e(iOptInt);
                return po3Var;
            }
        } catch (JSONException e2) {
            gp3.c(e2);
        }
        return null;
    }

    private boolean m(Context context) {
        String strP = p(j());
        FileOutputStream fileOutputStreamOpenFileOutput = null;
        try {
            try {
                fileOutputStreamOpenFileOutput = context.openFileOutput("libcuid_v3.so", 0);
                fileOutputStreamOpenFileOutput.write(strP.getBytes());
                fileOutputStreamOpenFileOutput.flush();
                try {
                    fileOutputStreamOpenFileOutput.close();
                    return true;
                } catch (Exception e2) {
                    gp3.c(e2);
                    return true;
                }
            } catch (Throwable th) {
                if (fileOutputStreamOpenFileOutput != null) {
                    try {
                        fileOutputStreamOpenFileOutput.close();
                    } catch (Exception e3) {
                        gp3.c(e3);
                    }
                }
                throw th;
            }
        } catch (Exception e4) {
            gp3.c(e4);
            if (fileOutputStreamOpenFileOutput != null) {
                try {
                    fileOutputStreamOpenFileOutput.close();
                } catch (Exception e5) {
                    gp3.c(e5);
                }
            }
            return false;
        }
    }

    static po3 n(String str) {
        return l(q(str));
    }

    private static File o(Context context) {
        return new File(context.getFilesDir(), "libcuid_v3.so");
    }

    static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return yf.c(dn3.a(e, f, str.getBytes()), "utf-8");
        } catch (UnsupportedEncodingException | Exception e2) {
            gp3.c(e2);
            return Constants.STR_EMPTY;
        }
    }

    static String q(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new String(dn3.b(e, f, yf.a(str.getBytes())));
        } catch (Exception e2) {
            gp3.c(e2);
            return Constants.STR_EMPTY;
        }
    }

    static String r(String str) {
        return new String(yf.a(str.getBytes()));
    }

    public String c() {
        if (TextUtils.isEmpty(this.b)) {
            this.b = "0";
        }
        return this.a + "|" + this.b;
    }

    public void e(int i) {
        this.d = i;
    }

    public void f(String str) {
        this.a = str;
    }

    boolean g(Context context) {
        return m(context);
    }

    public void k(String str) {
        this.b = str;
    }
}
