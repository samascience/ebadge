package defpackage;

import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class ul3 {
    private final hz1 a;
    private final boolean b;
    private final String c;
    private final long d;
    private final long e;
    private final long f;
    private final int g;
    private final Long h;
    private final long i;
    private final List j;

    public ul3(hz1 hz1Var, boolean z, String str, long j, long j2, long j3, int i, Long l, long j4) {
        p31.f(hz1Var, "canonicalPath");
        p31.f(str, "comment");
        this.a = hz1Var;
        this.b = z;
        this.c = str;
        this.d = j;
        this.e = j2;
        this.f = j3;
        this.g = i;
        this.h = l;
        this.i = j4;
        this.j = new ArrayList();
    }

    public final hz1 a() {
        return this.a;
    }

    public final List b() {
        return this.j;
    }

    public final Long c() {
        return this.h;
    }

    public final long d() {
        return this.i;
    }

    public final long e() {
        return this.f;
    }

    public final boolean f() {
        return this.b;
    }

    public /* synthetic */ ul3(hz1 hz1Var, boolean z, String str, long j, long j2, long j3, int i, Long l, long j4, int i2, y70 y70Var) {
        this(hz1Var, (i2 & 2) != 0 ? false : z, (i2 & 4) != 0 ? Constants.STR_EMPTY : str, (i2 & 8) != 0 ? -1L : j, (i2 & 16) != 0 ? -1L : j2, (i2 & 32) != 0 ? -1L : j3, (i2 & 64) != 0 ? -1 : i, (i2 & 128) != 0 ? null : l, (i2 & 256) == 0 ? j4 : -1L);
    }
}
