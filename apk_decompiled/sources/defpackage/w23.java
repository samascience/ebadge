package defpackage;

import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class w23 {
    private final String a;
    private final w23 b;
    private final String c;
    private final w23[] d;
    private final jt2[] e;

    public w23(Throwable th) {
        this(th, Collections.newSetFromMap(new IdentityHashMap()));
    }

    public w23 a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public String c() {
        return this.a;
    }

    public jt2[] d() {
        return this.e;
    }

    public w23[] e() {
        return this.d;
    }

    public w23(Throwable th, Set set) {
        set.add(th);
        this.a = th.getMessage();
        if (th.getCause() == null || set.contains(th.getCause())) {
            this.b = null;
        } else {
            this.b = new w23(th.getCause(), set);
        }
        this.c = th.getClass().getName();
        Throwable[] suppressed = th.getSuppressed();
        LinkedList linkedList = new LinkedList();
        int length = suppressed.length;
        for (int i = 0; i < length; i++) {
            if (!set.contains(suppressed[i])) {
                linkedList.add(new w23(suppressed[i], set));
            }
        }
        this.d = (w23[]) linkedList.toArray(new w23[0]);
        StackTraceElement[] stackTrace = th.getStackTrace();
        this.e = new jt2[stackTrace.length];
        int length2 = stackTrace.length;
        for (int i2 = 0; i2 < length2; i2++) {
            this.e[i2] = new jt2(stackTrace[i2]);
        }
    }
}
