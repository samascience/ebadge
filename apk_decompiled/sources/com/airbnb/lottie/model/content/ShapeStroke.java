package com.airbnb.lottie.model.content;

import android.graphics.Paint;
import defpackage.f6;
import defpackage.g6;
import defpackage.i6;
import defpackage.j30;
import defpackage.je1;
import defpackage.s20;
import defpackage.wv2;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ShapeStroke implements j30 {
    private final String a;
    private final g6 b;
    private final List c;
    private final f6 d;
    private final i6 e;
    private final g6 f;
    private final LineCapType g;
    private final LineJoinType h;
    private final float i;

    public enum LineCapType {
        Butt,
        Round,
        Unknown;

        public Paint.Cap toPaintCap() {
            int i = a.a[ordinal()];
            if (i != 1) {
                return i != 2 ? Paint.Cap.SQUARE : Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    public enum LineJoinType {
        Miter,
        Round,
        Bevel;

        public Paint.Join toPaintJoin() {
            int i = a.b[ordinal()];
            if (i == 1) {
                return Paint.Join.BEVEL;
            }
            if (i == 2) {
                return Paint.Join.MITER;
            }
            if (i != 3) {
                return null;
            }
            return Paint.Join.ROUND;
        }
    }

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;
        static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[LineJoinType.values().length];
            b = iArr;
            try {
                iArr[LineJoinType.Bevel.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[LineJoinType.Miter.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[LineJoinType.Round.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[LineCapType.values().length];
            a = iArr2;
            try {
                iArr2[LineCapType.Butt.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[LineCapType.Round.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[LineCapType.Unknown.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public ShapeStroke(String str, g6 g6Var, List list, f6 f6Var, i6 i6Var, g6 g6Var2, LineCapType lineCapType, LineJoinType lineJoinType, float f) {
        this.a = str;
        this.b = g6Var;
        this.c = list;
        this.d = f6Var;
        this.e = i6Var;
        this.f = g6Var2;
        this.g = lineCapType;
        this.h = lineJoinType;
        this.i = f;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, com.airbnb.lottie.model.layer.a aVar) {
        return new wv2(je1Var, aVar, this);
    }

    public LineCapType b() {
        return this.g;
    }

    public f6 c() {
        return this.d;
    }

    public g6 d() {
        return this.b;
    }

    public LineJoinType e() {
        return this.h;
    }

    public List f() {
        return this.c;
    }

    public float g() {
        return this.i;
    }

    public String h() {
        return this.a;
    }

    public i6 i() {
        return this.e;
    }

    public g6 j() {
        return this.f;
    }
}
