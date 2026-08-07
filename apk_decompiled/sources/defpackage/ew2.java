package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Queue;
import org.slf4j.event.EventRecordingLogger;
import org.slf4j.event.Level;
import org.slf4j.helpers.NOPLogger;

/* JADX INFO: loaded from: classes4.dex */
public class ew2 implements hd1 {
    private final String a;
    private volatile hd1 b;
    private Boolean c;
    private Method d;
    private EventRecordingLogger e;
    private final Queue f;
    public final boolean g;

    public ew2(String str, Queue queue, boolean z) {
        this.a = str;
        this.f = queue;
        this.g = z;
    }

    private hd1 b() {
        if (this.e == null) {
            this.e = new EventRecordingLogger(this, this.f);
        }
        return this.e;
    }

    public hd1 a() {
        if (this.b != null) {
            return this.b;
        }
        return this.g ? NOPLogger.NOP_LOGGER : b();
    }

    public boolean c() {
        Boolean bool = this.c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            this.d = this.b.getClass().getMethod("log", md1.class);
            this.c = Boolean.TRUE;
        } catch (NoSuchMethodException unused) {
            this.c = Boolean.FALSE;
        }
        return this.c.booleanValue();
    }

    public boolean d() {
        return this.b instanceof NOPLogger;
    }

    @Override // defpackage.hd1
    public void debug(String str) {
        a().debug(str);
    }

    public boolean e() {
        return this.b == null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.a.equals(((ew2) obj).a);
    }

    @Override // defpackage.hd1
    public void error(String str) {
        a().error(str);
    }

    public void f(md1 md1Var) {
        if (c()) {
            try {
                this.d.invoke(this.b, md1Var);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException unused) {
            }
        }
    }

    public void g(hd1 hd1Var) {
        this.b = hd1Var;
    }

    @Override // defpackage.hd1
    public String getName() {
        return this.a;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // defpackage.hd1
    public void info(String str) {
        a().info(str);
    }

    @Override // defpackage.hd1
    public boolean isDebugEnabled() {
        return a().isDebugEnabled();
    }

    @Override // defpackage.hd1
    public boolean isEnabledForLevel(Level level) {
        return a().isEnabledForLevel(level);
    }

    @Override // defpackage.hd1
    public boolean isErrorEnabled() {
        return a().isErrorEnabled();
    }

    @Override // defpackage.hd1
    public boolean isInfoEnabled() {
        return a().isInfoEnabled();
    }

    @Override // defpackage.hd1
    public boolean isTraceEnabled() {
        return a().isTraceEnabled();
    }

    @Override // defpackage.hd1
    public boolean isWarnEnabled() {
        return a().isWarnEnabled();
    }

    @Override // defpackage.hd1
    public nd1 makeLoggingEventBuilder(Level level) {
        return a().makeLoggingEventBuilder(level);
    }

    @Override // defpackage.hd1
    public void warn(String str) {
        a().warn(str);
    }

    @Override // defpackage.hd1
    public void debug(String str, Object obj) {
        a().debug(str, obj);
    }

    @Override // defpackage.hd1
    public void error(String str, Object obj) {
        a().error(str, obj);
    }
}
