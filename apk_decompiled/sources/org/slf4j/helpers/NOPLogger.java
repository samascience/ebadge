package org.slf4j.helpers;

import defpackage.hd1;
import defpackage.nd1;
import org.slf4j.Marker;
import org.slf4j.event.Level;

/* JADX INFO: loaded from: classes4.dex */
public class NOPLogger extends NamedLoggerBase implements hd1 {
    public static final NOPLogger NOP_LOGGER = new NOPLogger();
    private static final long serialVersionUID = -517220405410904473L;

    protected NOPLogger() {
    }

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
    public final void debug(String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final void error(String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public String getName() {
        return "NOP";
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final void info(String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final boolean isDebugEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level level) {
        return super.isEnabledForLevel(level);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final boolean isErrorEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final boolean isInfoEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final boolean isTraceEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final boolean isWarnEnabled() {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 makeLoggingEventBuilder(Level level) {
        return super.makeLoggingEventBuilder(level);
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final void warn(String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final void debug(String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase, defpackage.hd1
    public final void error(String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final boolean isDebugEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final boolean isErrorEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public boolean isInfoEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final boolean isTraceEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final boolean isWarnEnabled(Marker marker) {
        return false;
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker marker, String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker marker, String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker marker, String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker marker, String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker marker, String str) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker marker, String str, Object obj) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker marker, String str, Object obj, Object obj2) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker marker, String str, Throwable th) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void debug(Marker marker, String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void error(Marker marker, String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void info(Marker marker, String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void trace(Marker marker, String str, Object... objArr) {
    }

    @Override // org.slf4j.helpers.NamedLoggerBase
    public final void warn(Marker marker, String str, Object... objArr) {
    }
}
