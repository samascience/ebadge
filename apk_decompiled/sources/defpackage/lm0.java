package defpackage;

import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.j;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes4.dex */
public final class lm0 {
    private final boolean a;
    private final boolean b;
    private final hz1 c;
    private final Long d;
    private final Long e;
    private final Long f;
    private final Long g;
    private final Map h;

    public lm0(boolean z, boolean z2, hz1 hz1Var, Long l, Long l2, Long l3, Long l4, Map map) {
        p31.f(map, "extras");
        this.a = z;
        this.b = z2;
        this.c = hz1Var;
        this.d = l;
        this.e = l2;
        this.f = l3;
        this.g = l4;
        this.h = u.n(map);
    }

    public final Long a() {
        return this.f;
    }

    public final Long b() {
        return this.d;
    }

    public final hz1 c() {
        return this.c;
    }

    public final boolean d() {
        return this.b;
    }

    public final boolean e() {
        return this.a;
    }

    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.a) {
            arrayList.add("isRegularFile");
        }
        if (this.b) {
            arrayList.add("isDirectory");
        }
        if (this.d != null) {
            arrayList.add("byteCount=" + this.d);
        }
        if (this.e != null) {
            arrayList.add("createdAt=" + this.e);
        }
        if (this.f != null) {
            arrayList.add("lastModifiedAt=" + this.f);
        }
        if (this.g != null) {
            arrayList.add("lastAccessedAt=" + this.g);
        }
        if (!this.h.isEmpty()) {
            arrayList.add("extras=" + this.h);
        }
        return j.N(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }

    public /* synthetic */ lm0(boolean z, boolean z2, hz1 hz1Var, Long l, Long l2, Long l3, Long l4, Map map, int i, y70 y70Var) {
        this((i & 1) != 0 ? false : z, (i & 2) == 0 ? z2 : false, (i & 4) != 0 ? null : hz1Var, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : l3, (i & 64) == 0 ? l4 : null, (i & 128) != 0 ? u.f() : map);
    }
}
