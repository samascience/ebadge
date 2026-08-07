package defpackage;

import com.airbnb.lottie.model.layer.a;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class zn2 implements j30 {
    private final String a;
    private final List b;

    public zn2(String str, List list) {
        this.a = str;
        this.b = list;
    }

    @Override // defpackage.j30
    public s20 a(je1 je1Var, a aVar) {
        return new u20(je1Var, aVar, this);
    }

    public List b() {
        return this.b;
    }

    public String c() {
        return this.a;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.a + "' Shapes: " + Arrays.toString(this.b.toArray()) + '}';
    }
}
