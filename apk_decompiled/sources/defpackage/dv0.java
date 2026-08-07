package defpackage;

import android.graphics.Path;
import com.airbnb.lottie.model.content.GradientType;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: loaded from: classes.dex */
public class dv0 implements j30 {
    private final GradientType a;
    private final Path.FillType b;
    private final h6 c;
    private final i6 d;
    private final l6 e;
    private final l6 f;
    private final String g;
    private final g6 h;
    private final g6 i;

    public dv0(String str, GradientType gradientType, Path.FillType fillType, h6 h6Var, i6 i6Var, l6 l6Var, l6 l6Var2, g6 g6Var, g6 g6Var2) {
        this.a = gradientType;
        this.b = fillType;
        this.c = h6Var;
        this.d = i6Var;
        this.e = l6Var;
        this.f = l6Var2;
        this.g = str;
        this.h = g6Var;
        this.i = g6Var2;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, a aVar) {
        return new ev0(je1Var, aVar, this);
    }

    public l6 b() {
        return this.f;
    }

    public Path.FillType c() {
        return this.b;
    }

    public h6 d() {
        return this.c;
    }

    public GradientType e() {
        return this.a;
    }

    public String f() {
        return this.g;
    }

    public i6 g() {
        return this.d;
    }

    public l6 h() {
        return this.e;
    }
}
