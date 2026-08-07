package defpackage;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public final class rv0 {
    private wi0 a = wi0.g;
    private LongSerializationPolicy b = LongSerializationPolicy.DEFAULT;
    private ul0 c = FieldNamingPolicy.IDENTITY;
    private final Map d = new HashMap();
    private final List e = new ArrayList();
    private final List f = new ArrayList();
    private boolean g = false;
    private String h = qv0.z;
    private int i = 2;
    private int j = 2;
    private boolean k = false;
    private boolean l = false;
    private boolean m = true;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f380q = true;
    private n33 r = qv0.B;
    private n33 s = qv0.C;
    private final LinkedList t = new LinkedList();

    private void b(String str, int i, int i2, List list) {
        f63 f63VarB;
        f63 f63VarB2;
        boolean z = gt2.a;
        f63 f63VarA = null;
        if (str != null && !str.trim().isEmpty()) {
            f63VarB = z70.b.b.b(str);
            if (z) {
                f63VarA = gt2.c.b(str);
                f63VarB2 = gt2.b.b(str);
            } else {
                f63VarB2 = null;
            }
        } else {
            if (i == 2 || i2 == 2) {
                return;
            }
            f63 f63VarA2 = z70.b.b.a(i, i2);
            if (z) {
                f63VarA = gt2.c.a(i, i2);
                f63 f63VarA3 = gt2.b.a(i, i2);
                f63VarB = f63VarA2;
                f63VarB2 = f63VarA3;
            } else {
                f63VarB = f63VarA2;
                f63VarB2 = null;
            }
        }
        list.add(f63VarB);
        if (z) {
            list.add(f63VarA);
            list.add(f63VarB2);
        }
    }

    public rv0 a(xi0 xi0Var) {
        Objects.requireNonNull(xi0Var);
        this.a = this.a.m(xi0Var, true, false);
        return this;
    }

    public qv0 c() {
        ArrayList arrayList = new ArrayList(this.e.size() + this.f.size() + 3);
        arrayList.addAll(this.e);
        Collections.reverse(arrayList);
        ArrayList arrayList2 = new ArrayList(this.f);
        Collections.reverse(arrayList2);
        arrayList.addAll(arrayList2);
        b(this.h, this.i, this.j, arrayList);
        return new qv0(this.a, this.c, new HashMap(this.d), this.g, this.k, this.o, this.m, this.n, this.p, this.l, this.f380q, this.b, this.h, this.i, this.j, new ArrayList(this.e), new ArrayList(this.f), arrayList, this.r, this.s, new ArrayList(this.t));
    }

    public rv0 d() {
        this.m = false;
        return this;
    }

    public rv0 e(Type type, Object obj) {
        Objects.requireNonNull(type);
        a.a((obj instanceof t51) || (obj instanceof e63));
        if (obj instanceof t51) {
            this.e.add(a63.h(TypeToken.get(type), obj));
        }
        if (obj instanceof e63) {
            this.e.add(h63.a(TypeToken.get(type), (e63) obj));
        }
        return this;
    }

    public rv0 f() {
        this.g = true;
        return this;
    }

    public rv0 g(String str) {
        this.h = str;
        return this;
    }

    public rv0 h() {
        this.p = true;
        return this;
    }

    public rv0 i(n33 n33Var) {
        Objects.requireNonNull(n33Var);
        this.r = n33Var;
        return this;
    }

    public rv0 j() {
        this.n = true;
        return this;
    }
}
