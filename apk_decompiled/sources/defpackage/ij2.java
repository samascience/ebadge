package defpackage;

import android.content.SharedPreferences;
import com.blankj.utilcode.util.o;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class ij2 {
    private static final Map b = new HashMap();
    private SharedPreferences a;

    private ij2(String str, int i) {
        this.a = o.a().getSharedPreferences(str, i);
    }

    public static ij2 b() {
        return d(Constants.STR_EMPTY, 0);
    }

    public static ij2 c(String str) {
        return d(str, 0);
    }

    public static ij2 d(String str, int i) {
        if (i(str)) {
            str = "spUtils";
        }
        Map map = b;
        ij2 ij2Var = (ij2) map.get(str);
        if (ij2Var == null) {
            synchronized (ij2.class) {
                try {
                    ij2Var = (ij2) map.get(str);
                    if (ij2Var == null) {
                        ij2Var = new ij2(str, i);
                        map.put(str, ij2Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return ij2Var;
    }

    private static boolean i(String str) {
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

    public boolean a(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public int e(String str, int i) {
        return this.a.getInt(str, i);
    }

    public long f(String str, long j) {
        return this.a.getLong(str, j);
    }

    public String g(String str) {
        return h(str, Constants.STR_EMPTY);
    }

    public String h(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public void j(String str, int i) {
        k(str, i, false);
    }

    public void k(String str, int i, boolean z) {
        if (z) {
            this.a.edit().putInt(str, i).commit();
        } else {
            this.a.edit().putInt(str, i).apply();
        }
    }

    public void l(String str, long j) {
        m(str, j, false);
    }

    public void m(String str, long j, boolean z) {
        if (z) {
            this.a.edit().putLong(str, j).commit();
        } else {
            this.a.edit().putLong(str, j).apply();
        }
    }

    public void n(String str, String str2) {
        o(str, str2, false);
    }

    public void o(String str, String str2, boolean z) {
        if (z) {
            this.a.edit().putString(str, str2).commit();
        } else {
            this.a.edit().putString(str, str2).apply();
        }
    }

    public void p(String str, boolean z) {
        q(str, z, false);
    }

    public void q(String str, boolean z, boolean z2) {
        if (z2) {
            this.a.edit().putBoolean(str, z).commit();
        } else {
            this.a.edit().putBoolean(str, z).apply();
        }
    }

    public void r(String str) {
        s(str, false);
    }

    public void s(String str, boolean z) {
        if (z) {
            this.a.edit().remove(str).commit();
        } else {
            this.a.edit().remove(str).apply();
        }
    }
}
