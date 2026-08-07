package com.airbnb.lottie.model.layer;

import com.tencent.connect.common.Constants;
import defpackage.fe1;
import defpackage.g6;
import defpackage.p6;
import defpackage.q6;
import defpackage.s6;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class Layer {
    private final List a;
    private final fe1 b;
    private final String c;
    private final long d;
    private final LayerType e;
    private final long f;
    private final String g;
    private final List h;
    private final s6 i;
    private final int j;
    private final int k;
    private final int l;
    private final float m;
    private final float n;
    private final int o;
    private final int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final p6 f209q;
    private final q6 r;
    private final g6 s;
    private final List t;
    private final MatteType u;

    public enum LayerType {
        PreComp,
        Solid,
        Image,
        Null,
        Shape,
        Text,
        Unknown
    }

    public enum MatteType {
        None,
        Add,
        Invert,
        Unknown
    }

    public Layer(List list, fe1 fe1Var, String str, long j, LayerType layerType, long j2, String str2, List list2, s6 s6Var, int i, int i2, int i3, float f, float f2, int i4, int i5, p6 p6Var, q6 q6Var, List list3, MatteType matteType, g6 g6Var) {
        this.a = list;
        this.b = fe1Var;
        this.c = str;
        this.d = j;
        this.e = layerType;
        this.f = j2;
        this.g = str2;
        this.h = list2;
        this.i = s6Var;
        this.j = i;
        this.k = i2;
        this.l = i3;
        this.m = f;
        this.n = f2;
        this.o = i4;
        this.p = i5;
        this.f209q = p6Var;
        this.r = q6Var;
        this.t = list3;
        this.u = matteType;
        this.s = g6Var;
    }

    fe1 a() {
        return this.b;
    }

    public long b() {
        return this.d;
    }

    List c() {
        return this.t;
    }

    public LayerType d() {
        return this.e;
    }

    List e() {
        return this.h;
    }

    MatteType f() {
        return this.u;
    }

    String g() {
        return this.c;
    }

    long h() {
        return this.f;
    }

    int i() {
        return this.p;
    }

    int j() {
        return this.o;
    }

    String k() {
        return this.g;
    }

    List l() {
        return this.a;
    }

    int m() {
        return this.l;
    }

    int n() {
        return this.k;
    }

    int o() {
        return this.j;
    }

    float p() {
        return this.n / this.b.e();
    }

    p6 q() {
        return this.f209q;
    }

    q6 r() {
        return this.r;
    }

    g6 s() {
        return this.s;
    }

    float t() {
        return this.m;
    }

    public String toString() {
        return v(Constants.STR_EMPTY);
    }

    s6 u() {
        return this.i;
    }

    public String v(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(g());
        sb.append("\n");
        Layer layerO = this.b.o(h());
        if (layerO != null) {
            sb.append("\t\tParents: ");
            sb.append(layerO.g());
            Layer layerO2 = this.b.o(layerO.h());
            while (layerO2 != null) {
                sb.append("->");
                sb.append(layerO2.g());
                layerO2 = this.b.o(layerO2.h());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!e().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(e().size());
            sb.append("\n");
        }
        if (o() != 0 && n() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(o()), Integer.valueOf(n()), Integer.valueOf(m())));
        }
        if (!this.a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (Object obj : this.a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(obj);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
