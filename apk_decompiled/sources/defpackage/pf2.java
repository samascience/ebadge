package defpackage;

import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class pf2 {
    private final Set a = Collections.newSetFromMap(new WeakHashMap());
    private final List b = new ArrayList();
    private boolean c;

    public boolean a(ef2 ef2Var) {
        boolean z = true;
        if (ef2Var == null) {
            return true;
        }
        boolean zRemove = this.a.remove(ef2Var);
        if (!this.b.remove(ef2Var) && !zRemove) {
            z = false;
        }
        if (z) {
            ef2Var.clear();
        }
        return z;
    }

    public void b() {
        Iterator it = na3.i(this.a).iterator();
        while (it.hasNext()) {
            a((ef2) it.next());
        }
        this.b.clear();
    }

    public void c() {
        this.c = true;
        for (ef2 ef2Var : na3.i(this.a)) {
            if (ef2Var.isRunning() || ef2Var.j()) {
                ef2Var.clear();
                this.b.add(ef2Var);
            }
        }
    }

    public void d() {
        this.c = true;
        for (ef2 ef2Var : na3.i(this.a)) {
            if (ef2Var.isRunning()) {
                ef2Var.pause();
                this.b.add(ef2Var);
            }
        }
    }

    public void e() {
        for (ef2 ef2Var : na3.i(this.a)) {
            if (!ef2Var.j() && !ef2Var.i()) {
                ef2Var.clear();
                if (this.c) {
                    this.b.add(ef2Var);
                } else {
                    ef2Var.e();
                }
            }
        }
    }

    public void f() {
        this.c = false;
        for (ef2 ef2Var : na3.i(this.a)) {
            if (!ef2Var.j() && !ef2Var.isRunning()) {
                ef2Var.e();
            }
        }
        this.b.clear();
    }

    public void g(ef2 ef2Var) {
        this.a.add(ef2Var);
        if (!this.c) {
            ef2Var.e();
            return;
        }
        ef2Var.clear();
        if (Log.isLoggable("RequestTracker", 2)) {
            Log.v("RequestTracker", "Paused, delaying request");
        }
        this.b.add(ef2Var);
    }

    public String toString() {
        return super.toString() + "{numRequests=" + this.a.size() + ", isPaused=" + this.c + "}";
    }
}
