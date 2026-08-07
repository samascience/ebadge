package org.slf4j.simple;

import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.fj1;
import defpackage.md1;
import defpackage.nd1;
import defpackage.nr1;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Marker;
import org.slf4j.event.Level;
import org.slf4j.helpers.LegacyAbstractLogger;

/* JADX INFO: loaded from: classes4.dex */
public class SimpleLogger extends LegacyAbstractLogger {
    public static final String CACHE_OUTPUT_STREAM_STRING_KEY = "org.slf4j.simpleLogger.cacheOutputStream";
    public static final String DATE_TIME_FORMAT_KEY = "org.slf4j.simpleLogger.dateTimeFormat";
    public static final String DEFAULT_LOG_LEVEL_KEY = "org.slf4j.simpleLogger.defaultLogLevel";
    public static final String LEVEL_IN_BRACKETS_KEY = "org.slf4j.simpleLogger.levelInBrackets";
    public static final String LOG_FILE_KEY = "org.slf4j.simpleLogger.logFile";
    public static final String LOG_KEY_PREFIX = "org.slf4j.simpleLogger.log.";
    protected static final int LOG_LEVEL_DEBUG = 10;
    protected static final int LOG_LEVEL_ERROR = 40;
    protected static final int LOG_LEVEL_INFO = 20;
    protected static final int LOG_LEVEL_OFF = 50;
    protected static final int LOG_LEVEL_TRACE = 0;
    protected static final int LOG_LEVEL_WARN = 30;
    public static final String SHOW_DATE_TIME_KEY = "org.slf4j.simpleLogger.showDateTime";
    public static final String SHOW_LOG_NAME_KEY = "org.slf4j.simpleLogger.showLogName";
    public static final String SHOW_SHORT_LOG_NAME_KEY = "org.slf4j.simpleLogger.showShortLogName";
    public static final String SHOW_THREAD_ID_KEY = "org.slf4j.simpleLogger.showThreadId";
    public static final String SHOW_THREAD_NAME_KEY = "org.slf4j.simpleLogger.showThreadName";
    public static final String SYSTEM_PREFIX = "org.slf4j.simpleLogger.";
    static final String TID_PREFIX = "tid=";
    public static final String WARN_LEVEL_STRING_KEY = "org.slf4j.simpleLogger.warnLevelString";
    private static final long serialVersionUID = -632788891211436180L;
    protected int currentLogLevel;
    private transient String shortLogName = null;
    private static final long START_TIME = System.currentTimeMillis();
    static char SP = ' ';
    private static boolean INITIALIZED = false;
    static final a CONFIG_PARAMS = new a();

    SimpleLogger(String str) {
        this.currentLogLevel = 20;
        this.name = str;
        String strRecursivelyComputeLevelString = recursivelyComputeLevelString();
        if (strRecursivelyComputeLevelString != null) {
            this.currentLogLevel = a.i(strRecursivelyComputeLevelString);
        } else {
            this.currentLogLevel = CONFIG_PARAMS.a;
        }
    }

    private String computeShortName() {
        String str = this.name;
        return str.substring(str.lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR) + 1);
    }

    private String getFormattedDate() {
        String str;
        Date date = new Date();
        a aVar = CONFIG_PARAMS;
        synchronized (aVar.c) {
            str = aVar.c.format(date);
        }
        return str;
    }

    static void init() {
        CONFIG_PARAMS.f();
    }

    private void innerHandleNormalizedLoggingCall(Level level, List<Marker> list, String str, Object[] objArr, Throwable th) {
        StringBuilder sb = new StringBuilder(32);
        a aVar = CONFIG_PARAMS;
        if (aVar.b) {
            if (aVar.c != null) {
                sb.append(getFormattedDate());
                sb.append(SP);
            } else {
                sb.append(System.currentTimeMillis() - START_TIME);
                sb.append(SP);
            }
        }
        if (aVar.d) {
            sb.append('[');
            sb.append(Thread.currentThread().getName());
            sb.append("] ");
        }
        if (aVar.e) {
            sb.append(TID_PREFIX);
            sb.append(Thread.currentThread().getId());
            sb.append(SP);
        }
        if (aVar.h) {
            sb.append('[');
        }
        sb.append(level.name());
        if (aVar.h) {
            sb.append(']');
        }
        sb.append(SP);
        if (aVar.g) {
            if (this.shortLogName == null) {
                this.shortLogName = computeShortName();
            }
            sb.append(String.valueOf(this.shortLogName));
            sb.append(" - ");
        } else if (aVar.f) {
            sb.append(String.valueOf(this.name));
            sb.append(" - ");
        }
        if (list != null) {
            sb.append(SP);
            Iterator<Marker> it = list.iterator();
            while (it.hasNext()) {
                sb.append(it.next().getName());
                sb.append(SP);
            }
        }
        sb.append(fj1.b(str, objArr));
        write(sb, th);
    }

    static void lazyInit() {
        if (INITIALIZED) {
            return;
        }
        INITIALIZED = true;
        init();
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atDebug() {
        return super.atDebug();
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atError() {
        return super.atError();
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atInfo() {
        return super.atInfo();
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atLevel(Level level) {
        return super.atLevel(level);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atTrace() {
        return super.atTrace();
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atWarn() {
        return super.atWarn();
    }

    @Override // org.slf4j.helpers.AbstractLogger
    protected String getFullyQualifiedCallerName() {
        return null;
    }

    @Override // org.slf4j.helpers.AbstractLogger
    protected void handleNormalizedLoggingCall(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        ArrayList arrayList;
        if (marker != null) {
            arrayList = new ArrayList();
            arrayList.add(marker);
        } else {
            arrayList = null;
        }
        innerHandleNormalizedLoggingCall(level, arrayList, str, objArr, th);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isDebugEnabled() {
        return isLevelEnabled(10);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level level) {
        return super.isEnabledForLevel(level);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isErrorEnabled() {
        return isLevelEnabled(40);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isInfoEnabled() {
        return isLevelEnabled(20);
    }

    protected boolean isLevelEnabled(int i) {
        return i >= this.currentLogLevel;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isTraceEnabled() {
        return isLevelEnabled(0);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isWarnEnabled() {
        return isLevelEnabled(30);
    }

    public void log(md1 md1Var) {
        if (isLevelEnabled(md1Var.c().toInt())) {
            nr1 nr1VarD = nr1.d(md1Var);
            innerHandleNormalizedLoggingCall(md1Var.c(), md1Var.d(), nr1VarD.b(), nr1VarD.a(), md1Var.e());
        }
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 makeLoggingEventBuilder(Level level) {
        return super.makeLoggingEventBuilder(level);
    }

    String recursivelyComputeLevelString() {
        String strSubstring = this.name;
        int length = strSubstring.length();
        String strE = null;
        while (strE == null && length > -1) {
            strSubstring = strSubstring.substring(0, length);
            strE = CONFIG_PARAMS.e(LOG_KEY_PREFIX + strSubstring, null);
            length = String.valueOf(strSubstring).lastIndexOf(FileUtils.FILE_EXTENSION_SEPARATOR);
        }
        return strE;
    }

    void write(StringBuilder sb, Throwable th) {
        a aVar = CONFIG_PARAMS;
        PrintStream printStreamA = aVar.j.a();
        synchronized (aVar) {
            printStreamA.println(sb.toString());
            writeThrowable(th, printStreamA);
            printStreamA.flush();
        }
    }

    protected void writeThrowable(Throwable th, PrintStream printStream) {
        if (th != null) {
            th.printStackTrace(printStream);
        }
    }
}
