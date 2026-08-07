package defpackage;

import android.text.TextUtils;
import androidx.work.ExistingWorkPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class ik3 extends hk3 {
    private static final String j = fd1.f("WorkContinuationImpl");
    private final nk3 a;
    private final String b;
    private final ExistingWorkPolicy c;
    private final List d;
    private final List e;
    private final List f;
    private final List g;
    private boolean h;
    private tw1 i;

    public ik3(nk3 nk3Var, List list) {
        this(nk3Var, null, ExistingWorkPolicy.KEEP, list, null);
    }

    private static boolean i(ik3 ik3Var, Set set) {
        set.addAll(ik3Var.c());
        Set setL = l(ik3Var);
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (setL.contains((String) it.next())) {
                return true;
            }
        }
        List listE = ik3Var.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator it2 = listE.iterator();
            while (it2.hasNext()) {
                if (i((ik3) it2.next(), set)) {
                    return true;
                }
            }
        }
        set.removeAll(ik3Var.c());
        return false;
    }

    public static Set l(ik3 ik3Var) {
        HashSet hashSet = new HashSet();
        List listE = ik3Var.e();
        if (listE != null && !listE.isEmpty()) {
            Iterator it = listE.iterator();
            while (it.hasNext()) {
                hashSet.addAll(((ik3) it.next()).c());
            }
        }
        return hashSet;
    }

    public tw1 a() {
        if (this.h) {
            fd1.c().h(j, String.format("Already enqueued work ids (%s)", TextUtils.join(", ", this.e)), new Throwable[0]);
        } else {
            rh0 rh0Var = new rh0(this);
            this.a.o().b(rh0Var);
            this.i = rh0Var.d();
        }
        return this.i;
    }

    public ExistingWorkPolicy b() {
        return this.c;
    }

    public List c() {
        return this.e;
    }

    public String d() {
        return this.b;
    }

    public List e() {
        return this.g;
    }

    public List f() {
        return this.d;
    }

    public nk3 g() {
        return this.a;
    }

    public boolean h() {
        return i(this, new HashSet());
    }

    public boolean j() {
        return this.h;
    }

    public void k() {
        this.h = true;
    }

    public ik3(nk3 nk3Var, String str, ExistingWorkPolicy existingWorkPolicy, List list, List list2) {
        this.a = nk3Var;
        this.b = str;
        this.c = existingWorkPolicy;
        this.d = list;
        this.g = list2;
        this.e = new ArrayList(list.size());
        this.f = new ArrayList();
        if (list2 != null) {
            Iterator it = list2.iterator();
            while (it.hasNext()) {
                this.f.addAll(((ik3) it.next()).f);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            String strA = ((wk3) list.get(i)).a();
            this.e.add(strA);
            this.f.add(strA);
        }
    }
}
