package org.slf4j.helpers;

import defpackage.hd1;
import defpackage.nd1;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes4.dex */
public abstract class MarkerIgnoringBase extends NamedLoggerBase implements hd1 {
    private static final long serialVersionUID = 9044267456635152283L;

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atDebug() {
        return super.atDebug();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atError() {
        return super.atError();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atInfo() {
        return super.atInfo();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atLevel(Level level) {
        return super.atLevel(level);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atTrace() {
        return super.atTrace();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 atWarn() {
        return super.atWarn();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ void debug(String str);

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ void debug(String str, Object obj);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void debug(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void debug(String str, Throwable th);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void debug(String str, Object... objArr);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker marker, String str) {
        debug(str);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ void error(String str);

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ void error(String str, Object obj);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void error(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void error(String str, Throwable th);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void error(String str, Object... objArr);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker marker, String str) {
        error(str);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ String getName() {
        return super.getName();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ void info(String str);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void info(String str, Object obj);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void info(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void info(String str, Throwable th);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void info(String str, Object... objArr);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker marker, String str) {
        info(str);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ boolean isDebugEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isDebugEnabled(Marker marker) {
        return isDebugEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level level) {
        return super.isEnabledForLevel(level);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ boolean isErrorEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isErrorEnabled(Marker marker) {
        return isErrorEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ boolean isInfoEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isInfoEnabled(Marker marker) {
        return isInfoEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ boolean isTraceEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isTraceEnabled(Marker marker) {
        return isTraceEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ boolean isWarnEnabled();

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isWarnEnabled(Marker marker) {
        return isWarnEnabled();
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 makeLoggingEventBuilder(Level level) {
        return super.makeLoggingEventBuilder(level);
    }

    public String toString() {
        return getClass().getName() + "(" + getName() + ")";
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void trace(String str);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void trace(String str, Object obj);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void trace(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void trace(String str, Throwable th);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void trace(String str, Object... objArr);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker marker, String str) {
        trace(str);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public abstract /* synthetic */ void warn(String str);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void warn(String str, Object obj);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void warn(String str, Object obj, Object obj2);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void warn(String str, Throwable th);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public abstract /* synthetic */ void warn(String str, Object... objArr);

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker marker, String str) {
        warn(str);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker marker, String str, Object obj) {
        debug(str, obj);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker marker, String str, Object obj) {
        error(str, obj);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker marker, String str, Object obj) {
        info(str, obj);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker marker, String str, Object obj) {
        trace(str, obj);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker marker, String str, Object obj) {
        warn(str, obj);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker marker, String str, Object obj, Object obj2) {
        debug(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker marker, String str, Object obj, Object obj2) {
        error(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker marker, String str, Object obj, Object obj2) {
        info(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker marker, String str, Object obj, Object obj2) {
        trace(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker marker, String str, Object obj, Object obj2) {
        warn(str, obj, obj2);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker marker, String str, Object... objArr) {
        debug(str, objArr);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker marker, String str, Object... objArr) {
        error(str, objArr);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker marker, String str, Object... objArr) {
        info(str, objArr);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker marker, String str, Object... objArr) {
        trace(str, objArr);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker marker, String str, Object... objArr) {
        warn(str, objArr);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void debug(Marker marker, String str, Throwable th) {
        debug(str, th);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void error(Marker marker, String str, Throwable th) {
        error(str, th);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void info(Marker marker, String str, Throwable th) {
        info(str, th);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void trace(Marker marker, String str, Throwable th) {
        trace(str, th);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public void warn(Marker marker, String str, Throwable th) {
        warn(str, th);
    }
}
