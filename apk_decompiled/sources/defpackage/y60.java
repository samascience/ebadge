package defpackage;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public abstract class y60 {
    private static final SimpleDateFormat a = new SimpleDateFormat("yyyyMMddHHmmssSSS");

    public static int a(long j) {
        try {
            return (int) Math.abs(e() - j);
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String b(long j) {
        Locale locale = Locale.getDefault();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return String.format(locale, "%02d:%02d", Long.valueOf(timeUnit.toMinutes(j)), Long.valueOf(timeUnit.toSeconds(j) - TimeUnit.MINUTES.toSeconds(timeUnit.toMinutes(j))));
    }

    public static String c() {
        return a.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static String d(String str) {
        return str + a.format(Long.valueOf(System.currentTimeMillis()));
    }

    public static long e() {
        String strE = db3.e(Long.valueOf(System.currentTimeMillis()));
        if (strE.length() > 10) {
            strE = strE.substring(0, 10);
        }
        return db3.c(strE);
    }
}
