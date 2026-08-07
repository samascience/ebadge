package defpackage;

import android.app.Application;
import android.content.SharedPreferences;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class gj2 {
    private static final Map b = new HashMap();
    private SharedPreferences a;

    private gj2(String str, int i) {
        this.a = a().getSharedPreferences(str, i);
    }

    private static Application a() {
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Object objInvoke = cls.getMethod("getApplication", null).invoke(cls.getMethod("currentActivityThread", null).invoke(null, null), null);
            if (objInvoke != null) {
                return (Application) objInvoke;
            }
            throw new NullPointerException("u should init first");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (NoSuchMethodException e3) {
            e3.printStackTrace();
            throw new NullPointerException("u should init first");
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            throw new NullPointerException("u should init first");
        }
    }

    public static gj2 b(String str) {
        return c(str, 0);
    }

    public static gj2 c(String str, int i) {
        if (e(str)) {
            str = "spUtils";
        }
        Map map = b;
        gj2 gj2Var = (gj2) map.get(str);
        if (gj2Var == null) {
            synchronized (gj2.class) {
                try {
                    gj2Var = (gj2) map.get(str);
                    if (gj2Var == null) {
                        gj2Var = new gj2(str, i);
                        map.put(str, gj2Var);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return gj2Var;
    }

    public static gj2 d() {
        return b("PictureSpUtils");
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

    public void f(String str, String str2) {
        g(str, str2, false);
    }

    public void g(String str, String str2, boolean z) {
        if (z) {
            this.a.edit().putString(str, str2).commit();
        } else {
            this.a.edit().putString(str, str2).apply();
        }
    }
}
