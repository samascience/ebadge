package com.airbnb.lottie.model.content;

import defpackage.g6;
import defpackage.gv0;
import defpackage.h6;
import defpackage.i6;
import defpackage.j30;
import defpackage.je1;
import defpackage.l6;
import defpackage.s20;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class a implements j30 {
    private final String a;
    private final GradientType b;
    private final h6 c;
    private final i6 d;
    private final l6 e;
    private final l6 f;
    private final g6 g;
    private final ShapeStroke.LineCapType h;
    private final ShapeStroke.LineJoinType i;
    private final float j;
    private final List k;
    private final g6 l;

    public a(String str, GradientType gradientType, h6 h6Var, i6 i6Var, l6 l6Var, l6 l6Var2, g6 g6Var, ShapeStroke.LineCapType lineCapType, ShapeStroke.LineJoinType lineJoinType, float f, List list, g6 g6Var2) {
        this.a = str;
        this.b = gradientType;
        this.c = h6Var;
        this.d = i6Var;
        this.e = l6Var;
        this.f = l6Var2;
        this.g = g6Var;
        this.h = lineCapType;
        this.i = lineJoinType;
        this.j = f;
        this.k = list;
        this.l = g6Var2;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, com.airbnb.lottie.model.layer.a aVar) {
        return new gv0(je1Var, aVar, this);
    }

    public ShapeStroke.LineCapType b() {
        return this.h;
    }

    public g6 c() {
        return this.l;
    }

    public l6 d() {
        return this.f;
    }

    public h6 e() {
        return this.c;
    }

    public GradientType f() {
        return this.b;
    }

    public ShapeStroke.LineJoinType g() {
        return this.i;
    }

    public List h() {
        return this.k;
    }

    public float i() {
        return this.j;
    }

    public String j() {
        return this.a;
    }

    public i6 k() {
        return this.d;
    }

    public l6 l() {
        return this.e;
    }

    public g6 m() {
        return this.g;
    }
}
