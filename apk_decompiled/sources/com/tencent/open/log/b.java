package com.tencent.open.log;

import android.text.TextUtils;
import com.baji.protocol.model.ProtocolConstants;
import com.tencent.open.utils.l;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: loaded from: classes3.dex */
public class b {
    private static SimpleDateFormat a = d.C0115d.a("yy.MM.dd.HH");
    private File g;
    private String b = "Tracer.File";
    private int c = Integer.MAX_VALUE;
    private int d = Integer.MAX_VALUE;
    private int e = 4096;
    private long f = ProtocolConstants.CONNECTION_TIMEOUT_MS;
    private int h = 10;
    private String i = ".log";
    private long j = Long.MAX_VALUE;

    public b(File file, int i, int i2, int i3, String str, long j, int i4, String str2, long j2) {
        a(file);
        b(i);
        a(i2);
        c(i3);
        a(str);
        b(j);
        d(i4);
        b(str2);
        c(j2);
    }

    private String c(String str) {
        return "com.tencent.mobileqq_connectSdk." + str + ".log";
    }

    private File[] d(long j) {
        File file;
        File fileB = b();
        String strC = c(a(j));
        try {
            fileB = new File(fileB, strC);
        } catch (Throwable th) {
            SLog.e(SLog.TAG, "getWorkFile,get old sdcard file exception:", th);
        }
        String strB = l.b();
        if (TextUtils.isEmpty(strB) && strB == null) {
            file = null;
        } else {
            try {
                File file2 = new File(strB, c.o);
                if (!file2.exists()) {
                    file2.mkdirs();
                }
                file = new File(file2, strC);
            } catch (Exception e) {
                SLog.e(SLog.TAG, "getWorkFile,get app specific file exception:", e);
                file = null;
            }
        }
        return new File[]{fileB, file};
    }

    public File[] a() {
        return d(System.currentTimeMillis());
    }

    public File b() {
        File fileE = e();
        if (fileE != null) {
            fileE.mkdirs();
        }
        return fileE;
    }

    public File e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public static String a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat("yy.MM.dd.HH").format(calendar.getTime());
    }

    public String c() {
        return this.b;
    }

    public void b(int i) {
        this.d = i;
    }

    public void c(int i) {
        this.e = i;
    }

    public void b(long j) {
        this.f = j;
    }

    public void c(long j) {
        this.j = j;
    }

    public void b(String str) {
        this.i = str;
    }

    public void a(String str) {
        this.b = str;
    }

    public void a(int i) {
        this.c = i;
    }

    public void a(File file) {
        this.g = file;
    }

    public int d() {
        return this.e;
    }

    public void d(int i) {
        this.h = i;
    }
}
