package defpackage;

import android.graphics.Path;
import com.airbnb.lottie.model.layer.a;

/* JADX INFO: loaded from: classes.dex */
public class xn2 implements j30 {
    private final boolean a;
    private final Path.FillType b;
    private final String c;
    private final f6 d;
    private final i6 e;

    public xn2(String str, boolean z, Path.FillType fillType, f6 f6Var, i6 i6Var) {
        this.c = str;
        this.a = z;
        this.b = fillType;
        this.d = f6Var;
        this.e = i6Var;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, a aVar) {
        return new in0(je1Var, aVar, this);
    }

    public f6 b() {
        return this.d;
    }

    public Path.FillType c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public i6 e() {
        return this.e;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.a + '}';
    }
}
