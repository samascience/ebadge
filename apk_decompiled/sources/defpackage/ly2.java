package defpackage;

import com.yanzhenjie.recyclerview.swipe.SwipeMenuLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class ly2 {
    private SwipeMenuLayout a;
    private int b;
    private int c = 0;
    private List d = new ArrayList(2);

    public ly2(SwipeMenuLayout swipeMenuLayout, int i) {
        this.a = swipeMenuLayout;
        this.b = i;
    }

    public void a(ny2 ny2Var) {
        this.d.add(ny2Var);
    }

    public List b() {
        return this.d;
    }

    public int c() {
        return this.c;
    }
}
