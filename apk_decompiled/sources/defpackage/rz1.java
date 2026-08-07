package defpackage;

import android.os.Environment;
import com.blankj.utilcode.util.c;
import com.blankj.utilcode.util.o;
import com.jieli.jl_rcsp.constant.WatchConstant;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public abstract class rz1 {
    public static final String a = "Android/data/" + c.f();

    public static String a() {
        return g("apk");
    }

    public static String b() {
        return g("cache");
    }

    public static String c() {
        File cacheDir = o.a().getCacheDir();
        if (cacheDir == null) {
            return o.a().getDatabasePath(g82.a).getAbsolutePath();
        }
        return cacheDir.getAbsolutePath() + WatchConstant.FAT_FS_ROOT;
    }

    public static String d() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "/FitPro/camera";
    }

    public static String e() {
        return g("crash");
    }

    public static String f() {
        return g("db");
    }

    public static String g(String str) {
        StringBuilder sb = new StringBuilder();
        if (n()) {
            sb.append(i());
        } else {
            sb.append(c());
        }
        sb.append(str);
        sb.append(File.separator);
        return sb.toString();
    }

    public static String h() {
        return g("download");
    }

    public static String i() {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory().getAbsolutePath());
        String str = File.separator;
        sb.append(str);
        sb.append(a);
        sb.append(str);
        return sb.toString();
    }

    public static String j() {
        return g("log");
    }

    public static String k() {
        return g("OTA");
    }

    public static String l() {
        return g("other");
    }

    public static String m() {
        return g("patch");
    }

    public static boolean n() {
        return "mounted".equals(Environment.getExternalStorageState());
    }
}
