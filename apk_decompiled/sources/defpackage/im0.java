package defpackage;

import android.os.Environment;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class im0 {
    private String a;
    private String b;

    public im0(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public static String b() {
        File file = new File(c() + "/Download");
        if (!file.exists()) {
            file.mkdir();
        }
        return c() + "/Download";
    }

    public static String c() {
        return Environment.getExternalStorageState().equals("mounted") ? Environment.getExternalStorageDirectory().toString() : Environment.getDownloadCacheDirectory().toString();
    }

    public String a() {
        return this.b;
    }
}
