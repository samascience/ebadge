package defpackage;

import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes4.dex */
public interface hd1 {
    default nd1 atDebug() {
        return isDebugEnabled() ? makeLoggingEventBuilder(Level.DEBUG) : fn1.a();
    }

    default nd1 atError() {
        return isErrorEnabled() ? makeLoggingEventBuilder(Level.ERROR) : fn1.a();
    }

    default nd1 atInfo() {
        return isInfoEnabled() ? makeLoggingEventBuilder(Level.INFO) : fn1.a();
    }

    default nd1 atLevel(Level level) {
        return isEnabledForLevel(level) ? makeLoggingEventBuilder(level) : fn1.a();
    }

    default nd1 atTrace() {
        return isTraceEnabled() ? makeLoggingEventBuilder(Level.TRACE) : fn1.a();
    }

    default nd1 atWarn() {
        return isWarnEnabled() ? makeLoggingEventBuilder(Level.WARN) : fn1.a();
    }

    void debug(String str);

    void debug(String str, Object obj);

    void error(String str);

    void error(String str, Object obj);

    String getName();

    void info(String str);

    boolean isDebugEnabled();

    default boolean isEnabledForLevel(Level level) {
        int i = level.toInt();
        if (i == 0) {
            return isTraceEnabled();
        }
        if (i == 10) {
            return isDebugEnabled();
        }
        if (i == 20) {
            return isInfoEnabled();
        }
        if (i == 30) {
            return isWarnEnabled();
        }
        if (i == 40) {
            return isErrorEnabled();
        }
        throw new IllegalArgumentException("Level [" + level + "] not recognized.");
    }

    boolean isErrorEnabled();

    boolean isInfoEnabled();

    boolean isTraceEnabled();

    boolean isWarnEnabled();

    default nd1 makeLoggingEventBuilder(Level level) {
        return new f80(this, level);
    }

    void warn(String str);
}
