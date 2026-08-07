package defpackage;

import android.graphics.Rect;
import android.util.Log;
import com.airbnb.lottie.model.layer.Layer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class fe1 {
    private final vz1 a = new vz1();
    private final HashSet b = new HashSet();
    private Map c;
    private Map d;
    private Map e;
    private ns2 f;
    private zd1 g;
    private List h;
    private Rect i;
    private float j;
    private float k;
    private float l;

    public void a(String str) {
        Log.w("LOTTIE", str);
        this.b.add(str);
    }

    public Rect b() {
        return this.i;
    }

    public ns2 c() {
        return this.f;
    }

    public float d() {
        return (long) ((e() / this.l) * 1000.0f);
    }

    public float e() {
        return this.k - this.j;
    }

    public float f() {
        return this.k;
    }

    public Map g() {
        return this.e;
    }

    public float h() {
        return this.l;
    }

    public Map i() {
        return this.d;
    }

    public List j() {
        return this.h;
    }

    public vz1 k() {
        return this.a;
    }

    public List l(String str) {
        return (List) this.c.get(str);
    }

    public float m() {
        return this.j;
    }

    public void n(Rect rect, float f, float f2, float f3, List list, zd1 zd1Var, Map map, Map map2, ns2 ns2Var, Map map3) {
        this.i = rect;
        this.j = f;
        this.k = f2;
        this.l = f3;
        this.h = list;
        this.g = zd1Var;
        this.c = map;
        this.d = map2;
        this.f = ns2Var;
        this.e = map3;
    }

    public Layer o(long j) {
        return (Layer) this.g.c(j);
    }

    public void p(boolean z) {
        this.a.b(z);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            sb.append(((Layer) it.next()).v("\t"));
        }
        return sb.toString();
    }
}
