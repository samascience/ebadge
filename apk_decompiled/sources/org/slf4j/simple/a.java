package org.slf4j.simple;

import defpackage.qa3;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Properties;
import kotlinx.coroutines.DebugKt;
import org.slf4j.simple.a;

/* JADX INFO: loaded from: classes4.dex */
public class a {
    static int n = 20;
    private static final String o = null;
    private static String p;
    int a = n;
    boolean b = false;
    DateFormat c = null;
    boolean d = true;
    boolean e = false;
    boolean f = true;
    boolean g = false;
    boolean h = false;
    private String i = "System.err";
    OutputChoice j = null;
    private boolean k = false;
    String l = "WARN";
    private final Properties m = new Properties();

    private static OutputChoice b(String str, boolean z) {
        if ("System.err".equalsIgnoreCase(str)) {
            return z ? new OutputChoice(OutputChoice.OutputChoiceType.CACHED_SYS_ERR) : new OutputChoice(OutputChoice.OutputChoiceType.SYS_ERR);
        }
        if ("System.out".equalsIgnoreCase(str)) {
            return z ? new OutputChoice(OutputChoice.OutputChoiceType.CACHED_SYS_OUT) : new OutputChoice(OutputChoice.OutputChoiceType.SYS_OUT);
        }
        try {
            return new OutputChoice(new PrintStream(new FileOutputStream(str)));
        } catch (FileNotFoundException e) {
            qa3.d("Could not open [" + str + "]. Defaulting to System.err", e);
            return new OutputChoice(OutputChoice.OutputChoiceType.SYS_ERR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ InputStream g() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader != null ? contextClassLoader.getResourceAsStream("simplelogger.properties") : ClassLoader.getSystemResourceAsStream("simplelogger.properties");
    }

    private void h() {
        InputStream inputStream = (InputStream) AccessController.doPrivileged(new PrivilegedAction() { // from class: fp2
            @Override // java.security.PrivilegedAction
            public final Object run() {
                return a.g();
            }
        });
        if (inputStream != null) {
            try {
                this.m.load(inputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                try {
                    inputStream.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
            try {
                inputStream.close();
            } catch (IOException unused3) {
            }
        }
    }

    static int i(String str) {
        if ("trace".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("debug".equalsIgnoreCase(str)) {
            return 10;
        }
        if ("info".equalsIgnoreCase(str)) {
            return 20;
        }
        if ("warn".equalsIgnoreCase(str)) {
            return 30;
        }
        if ("error".equalsIgnoreCase(str)) {
            return 40;
        }
        return DebugKt.DEBUG_PROPERTY_VALUE_OFF.equalsIgnoreCase(str) ? 50 : 20;
    }

    boolean c(String str, boolean z) {
        String strD = d(str);
        return strD == null ? z : "true".equalsIgnoreCase(strD);
    }

    String d(String str) {
        String property;
        try {
            property = System.getProperty(str);
        } catch (SecurityException unused) {
            property = null;
        }
        return property == null ? this.m.getProperty(str) : property;
    }

    String e(String str, String str2) {
        String strD = d(str);
        return strD == null ? str2 : strD;
    }

    void f() {
        h();
        String strE = e(SimpleLogger.DEFAULT_LOG_LEVEL_KEY, null);
        if (strE != null) {
            this.a = i(strE);
        }
        this.f = c(SimpleLogger.SHOW_LOG_NAME_KEY, true);
        this.g = c(SimpleLogger.SHOW_SHORT_LOG_NAME_KEY, false);
        this.b = c(SimpleLogger.SHOW_DATE_TIME_KEY, false);
        this.d = c(SimpleLogger.SHOW_THREAD_NAME_KEY, true);
        this.e = c(SimpleLogger.SHOW_THREAD_ID_KEY, false);
        p = e(SimpleLogger.DATE_TIME_FORMAT_KEY, o);
        this.h = c(SimpleLogger.LEVEL_IN_BRACKETS_KEY, false);
        this.l = e(SimpleLogger.WARN_LEVEL_STRING_KEY, "WARN");
        this.i = e(SimpleLogger.LOG_FILE_KEY, this.i);
        boolean zC = c(SimpleLogger.CACHE_OUTPUT_STREAM_STRING_KEY, false);
        this.k = zC;
        this.j = b(this.i, zC);
        if (p != null) {
            try {
                this.c = new SimpleDateFormat(p);
            } catch (IllegalArgumentException e) {
                qa3.d("Bad date format in simplelogger.properties; will output relative time", e);
            }
        }
    }
}
