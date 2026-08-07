package org.slf4j.event;

import defpackage.ew2;
import defpackage.gw2;
import defpackage.nd1;
import java.util.Queue;
import org.slf4j.Marker;
import org.slf4j.helpers.LegacyAbstractLogger;

/* JADX INFO: loaded from: classes4.dex */
public class EventRecordingLogger extends LegacyAbstractLogger {
    static final boolean RECORD_ALL_EVENTS = true;
    private static final long serialVersionUID = -176083308134819629L;
    Queue<gw2> eventQueue;
    ew2 logger;
    String name;

    public EventRecordingLogger(ew2 ew2Var, Queue<gw2> queue) {
        this.logger = ew2Var;
        this.name = ew2Var.getName();
        this.eventQueue = queue;
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

    @Override // org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public String getName() {
        return this.name;
    }

    @Override // org.slf4j.helpers.AbstractLogger
    protected void handleNormalizedLoggingCall(Level level, Marker marker, String str, Object[] objArr, Throwable th) {
        gw2 gw2Var = new gw2();
        gw2Var.o(System.currentTimeMillis());
        gw2Var.i(level);
        gw2Var.j(this.logger);
        gw2Var.k(this.name);
        if (marker != null) {
            gw2Var.f(marker);
        }
        gw2Var.l(str);
        gw2Var.m(Thread.currentThread().getName());
        gw2Var.h(objArr);
        gw2Var.n(th);
        this.eventQueue.add(gw2Var);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isDebugEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ boolean isEnabledForLevel(Level level) {
        return super.isEnabledForLevel(level);
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isErrorEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isInfoEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isTraceEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public boolean isWarnEnabled() {
        return true;
    }

    @Override // org.slf4j.helpers.LegacyAbstractLogger, org.slf4j.helpers.AbstractLogger, defpackage.hd1
    public /* bridge */ /* synthetic */ nd1 makeLoggingEventBuilder(Level level) {
        return super.makeLoggingEventBuilder(level);
    }
}
