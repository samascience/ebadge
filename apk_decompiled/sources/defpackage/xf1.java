package defpackage;

import com.airbnb.lottie.model.content.Mask;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class xf1 {
    private final List a;
    private final List b;
    private final List c;

    public xf1(List list) {
        this.c = list;
        this.a = new ArrayList(list.size());
        this.b = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            this.a.add(((Mask) list.get(i)).b().a());
            this.b.add(((Mask) list.get(i)).c().a());
        }
    }

    public List a() {
        return this.a;
    }

    public List b() {
        return this.c;
    }

    public List c() {
        return this.b;
    }
}
