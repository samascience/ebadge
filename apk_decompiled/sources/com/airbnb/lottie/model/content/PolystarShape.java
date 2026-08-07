package com.airbnb.lottie.model.content;

import defpackage.d42;
import defpackage.g6;
import defpackage.j30;
import defpackage.je1;
import defpackage.s20;
import defpackage.u6;

/* JADX INFO: loaded from: classes.dex */
public class PolystarShape implements j30 {
    private final String a;
    private final Type b;
    private final g6 c;
    private final u6 d;
    private final g6 e;
    private final g6 f;
    private final g6 g;
    private final g6 h;
    private final g6 i;

    public enum Type {
        Star(1),
        Polygon(2);

        private final int value;

        Type(int i) {
            this.value = i;
        }

        public static Type forValue(int i) {
            for (Type type : values()) {
                if (type.value == i) {
                    return type;
                }
            }
            return null;
        }
    }

    public PolystarShape(String str, Type type, g6 g6Var, u6 u6Var, g6 g6Var2, g6 g6Var3, g6 g6Var4, g6 g6Var5, g6 g6Var6) {
        this.a = str;
        this.b = type;
        this.c = g6Var;
        this.d = u6Var;
        this.e = g6Var2;
        this.f = g6Var3;
        this.g = g6Var4;
        this.h = g6Var5;
        this.i = g6Var6;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, com.airbnb.lottie.model.layer.a aVar) {
        return new d42(je1Var, aVar, this);
    }

    public g6 b() {
        return this.f;
    }

    public g6 c() {
        return this.h;
    }

    public String d() {
        return this.a;
    }

    public g6 e() {
        return this.g;
    }

    public g6 f() {
        return this.i;
    }

    public g6 g() {
        return this.c;
    }

    public u6 h() {
        return this.d;
    }

    public g6 i() {
        return this.e;
    }

    public Type j() {
        return this.b;
    }
}
