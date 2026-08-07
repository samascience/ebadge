package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class i11 {
    private static final i11 b = new i11();
    private List a = new ArrayList();

    public static i11 c() {
        return b;
    }

    public void a() {
        this.a.clear();
    }

    public List b() {
        return this.a;
    }

    public void d(List list) {
        this.a = list;
    }
}
