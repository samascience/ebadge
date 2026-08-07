package com.airbnb.lottie.model.content;

import defpackage.b63;
import defpackage.g6;
import defpackage.j30;
import defpackage.je1;
import defpackage.s20;

/* JADX INFO: loaded from: classes.dex */
public class ShapeTrimPath implements j30 {
    private final String a;
    private final Type b;
    private final g6 c;
    private final g6 d;
    private final g6 e;

    public enum Type {
        Simultaneously,
        Individually;

        public static Type forId(int i) {
            if (i == 1) {
                return Simultaneously;
            }
            if (i == 2) {
                return Individually;
            }
            throw new IllegalArgumentException("Unknown trim path type " + i);
        }
    }

    public ShapeTrimPath(String str, Type type, g6 g6Var, g6 g6Var2, g6 g6Var3) {
        this.a = str;
        this.b = type;
        this.c = g6Var;
        this.d = g6Var2;
        this.e = g6Var3;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, com.airbnb.lottie.model.layer.a aVar) {
        return new b63(aVar, this);
    }

    public g6 b() {
        return this.d;
    }

    public String c() {
        return this.a;
    }

    public g6 d() {
        return this.e;
    }

    public g6 e() {
        return this.c;
    }

    public Type f() {
        return this.b;
    }

    public String toString() {
        return "Trim Path: {start: " + this.c + ", end: " + this.d + ", offset: " + this.e + "}";
    }
}
