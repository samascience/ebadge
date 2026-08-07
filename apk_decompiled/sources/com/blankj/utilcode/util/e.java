package com.blankj.utilcode.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: loaded from: classes.dex */
public abstract class e {
    private static final String a = System.getProperty("file.separator");
    private static final Thread.UncaughtExceptionHandler b = Thread.getDefaultUncaughtExceptionHandler();

    class a implements Thread.UncaughtExceptionHandler {
        final /* synthetic */ String a;

        a(String str, c cVar) {
            this.a = str;
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            String str = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
            q.T(this.a + str + ".txt", new b(str, th, null).toString(), true);
            if (e.b != null) {
                e.b.uncaughtException(thread, th);
            }
        }
    }

    public static final class b {
        private q.a a;
        private Throwable b;

        /* synthetic */ b(String str, Throwable th, a aVar) {
            this(str, th);
        }

        public String toString() {
            return this.a.toString() + q.o(this.b);
        }

        private b(String str, Throwable th) {
            this.b = th;
            q.a aVar = new q.a("Crash");
            this.a = aVar;
            aVar.a("Time Of Crash", str);
        }
    }

    public interface c {
    }

    private static Thread.UncaughtExceptionHandler b(String str, c cVar) {
        return new a(str, cVar);
    }

    public static void c(String str) {
        d(str, null);
    }

    public static void d(String str, c cVar) {
        if (!q.H(str)) {
            String str2 = a;
            if (!str.endsWith(str2)) {
                str = str + str2;
            }
        } else if (!q.G() || o.a().getExternalFilesDir(null) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(o.a().getFilesDir());
            String str3 = a;
            sb.append(str3);
            sb.append("crash");
            sb.append(str3);
            str = sb.toString();
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(o.a().getExternalFilesDir(null));
            String str4 = a;
            sb2.append(str4);
            sb2.append("crash");
            sb2.append(str4);
            str = sb2.toString();
        }
        Thread.setDefaultUncaughtExceptionHandler(b(str, cVar));
    }
}
