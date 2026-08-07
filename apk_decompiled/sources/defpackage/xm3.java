package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.util.JsonReader;
import com.tencent.connect.common.Constants;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/* JADX INFO: loaded from: classes.dex */
final class xm3 {
    private static final String e = new String(yf.a(new byte[]{77, 122, 65, 121, 77, 84, 73, 120, 77, 68, 73, 61})) + new String(yf.a(new byte[]{90, 71, 108, 106, 100, 87, 82, 112, 89, 87, 73, 61}));
    private String a;
    private String b;
    private int c = 0;
    private int d = 2;

    xm3() {
    }

    static boolean d(Context context) {
        File fileJ = j(context);
        if (fileJ.exists()) {
            return fileJ.delete();
        }
        return false;
    }

    static xm3 e(Context context) {
        return l(gp3.b(j(context)));
    }

    public static boolean h(int i) {
        return i >= 14;
    }

    static xm3 i(String str) throws Throwable {
        JsonReader jsonReader;
        JsonReader jsonReader2 = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            jsonReader = new JsonReader(new StringReader(str));
            try {
                jsonReader.beginObject();
                String strQ = q("ZGV2aWNlaWQ=");
                String strQ2 = q("dmVy");
                String strNextString = "0";
                String strNextString2 = Constants.STR_EMPTY;
                int iNextInt = 2;
                while (jsonReader.hasNext()) {
                    String strNextName = jsonReader.nextName();
                    if (strQ.equals(strNextName)) {
                        strNextString2 = jsonReader.nextString();
                    } else if (strQ2.equals(strNextName)) {
                        iNextInt = jsonReader.nextInt();
                    } else {
                        strNextString = jsonReader.nextString();
                    }
                }
                jsonReader.endObject();
                int length = 0;
                if (iNextInt == 2 && !TextUtils.isEmpty(strNextString)) {
                    length = strNextString.length();
                }
                try {
                    jsonReader.close();
                } catch (Exception e2) {
                    gp3.c(e2);
                }
                if (TextUtils.isEmpty(strNextString2)) {
                    return null;
                }
                xm3 xm3Var = new xm3();
                xm3Var.c(strNextString2);
                xm3Var.b(length);
                if (!xm3Var.m()) {
                    xm3Var.g(strNextString);
                }
                return xm3Var;
            } catch (IOException unused) {
                if (jsonReader != null) {
                    try {
                        jsonReader.close();
                    } catch (Exception e3) {
                        gp3.c(e3);
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                jsonReader2 = jsonReader;
                if (jsonReader2 != null) {
                    try {
                        jsonReader2.close();
                    } catch (Exception e4) {
                        gp3.c(e4);
                    }
                }
                throw th;
            }
        } catch (IOException unused2) {
            jsonReader = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static File j(Context context) {
        return new File(context.getFilesDir(), "libcuid.so");
    }

    static xm3 l(String str) {
        return i(p(str));
    }

    public static boolean o(String str) {
        return TextUtils.isEmpty(str);
    }

    private static String p(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String str2 = e;
            return new String(dn3.b(str2, str2, yf.a(str.getBytes())));
        } catch (Exception e2) {
            gp3.c(e2);
            return Constants.STR_EMPTY;
        }
    }

    private static String q(String str) {
        return new String(yf.a(str.getBytes()));
    }

    public String a() {
        return this.a;
    }

    public void b(int i) {
        this.c = i;
    }

    public void c(String str) {
        this.a = str;
    }

    public String f() {
        return this.b;
    }

    public void g(String str) {
        this.b = str;
    }

    boolean k() {
        String str;
        if (m()) {
            str = "O";
        } else {
            if (!n()) {
                return false;
            }
            str = "0";
        }
        this.b = str;
        return true;
    }

    public boolean m() {
        return h(this.c);
    }

    public boolean n() {
        return o(this.b);
    }
}
