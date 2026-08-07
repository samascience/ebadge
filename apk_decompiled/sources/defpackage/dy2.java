package defpackage;

import android.util.Size;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class dy2 {
    dy2() {
    }

    public static dy2 a(Size size, Map map, Size size2, Map map2, Size size3, Map map3, Map map4) {
        return new rd(size, map, size2, map2, size3, map3, map4);
    }

    public abstract Size b();

    public Size c(int i) {
        return (Size) d().get(Integer.valueOf(i));
    }

    public abstract Map d();

    public abstract Size e();

    public abstract Size f();

    public Size g(int i) {
        return (Size) h().get(Integer.valueOf(i));
    }

    public abstract Map h();

    public Size i(int i) {
        return (Size) j().get(Integer.valueOf(i));
    }

    public abstract Map j();

    public Size k(int i) {
        return (Size) l().get(Integer.valueOf(i));
    }

    public abstract Map l();
}
