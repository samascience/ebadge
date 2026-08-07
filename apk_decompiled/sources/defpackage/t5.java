package defpackage;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import kotlin.collections.u;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class t5 {
    public static final t5 a = new t5();
    private static final CopyOnWriteArraySet b = new CopyOnWriteArraySet();
    private static final Map c;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = zt1.class.getPackage();
        String name = r2 != null ? r2.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = zt1.class.getName();
        p31.e(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = hx0.class.getName();
        p31.e(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = b13.class.getName();
        p31.e(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        c = u.n(linkedHashMap);
    }

    private t5() {
    }

    private final void c(String str, String str2) {
        Level level;
        Logger logger = Logger.getLogger(str);
        if (b.add(logger)) {
            logger.setUseParentHandlers(false);
            if (Log.isLoggable(str2, 3)) {
                level = Level.FINE;
            } else {
                level = Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING;
            }
            logger.setLevel(level);
            logger.addHandler(u5.a);
        }
    }

    private final String d(String str) {
        String str2 = (String) c.get(str);
        return str2 == null ? i.S0(str, 23) : str2;
    }

    public final void a(String str, int i, String str2, Throwable th) {
        int iMin;
        p31.f(str, "loggerName");
        p31.f(str2, "message");
        String strD = d(str);
        if (Log.isLoggable(strD, i)) {
            if (th != null) {
                str2 = str2 + '\n' + Log.getStackTraceString(th);
            }
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                int iV = i.V(str2, '\n', i2, false, 4, null);
                if (iV == -1) {
                    iV = length;
                }
                while (true) {
                    iMin = Math.min(iV, i2 + 4000);
                    String strSubstring = str2.substring(i2, iMin);
                    p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    Log.println(i, strD, strSubstring);
                    if (iMin >= iV) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }

    public final void b() {
        for (Map.Entry entry : c.entrySet()) {
            c((String) entry.getKey(), (String) entry.getValue());
        }
    }
}
