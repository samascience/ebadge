package defpackage;

import android.content.SharedPreferences;
import com.legend.mywatch.sdk.mywatchsdklib.android.utils.i;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class fj2 {
    private static final Map b = new HashMap();
    private SharedPreferences a;

    private fj2(String str, int i) {
        this.a = i.a().getSharedPreferences(str, i);
    }

    public static fj2 a(String str) {
        return b(str, 0);
    }

    public static fj2 b(String str, int i) {
        if (e(str)) {
            str = "spUtils";
        }
        Map map = b;
        fj2 fj2Var = (fj2) map.get(str);
        if (fj2Var == null) {
            synchronized (fj2.class) {
                try {
                    fj2Var = (fj2) map.get(str);
                    if (fj2Var == null) {
                        fj2Var = new fj2(str, i);
                        map.put(str, fj2Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return fj2Var;
    }

    private static boolean e(String str) {
        if (str == null) {
            return true;
        }
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public String c(String str) {
        return d(str, Constants.STR_EMPTY);
    }

    public String d(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public void f(String str) {
        g(str, false);
    }

    public void g(String str, boolean z) {
        if (z) {
            this.a.edit().remove(str).commit();
        } else {
            this.a.edit().remove(str).apply();
        }
    }
}
