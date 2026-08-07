package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class l {
    private final MotionLayout a;
    private HashSet c;
    ArrayList e;
    private ArrayList b = new ArrayList();
    private String d = "ViewTransitionController";
    ArrayList f = new ArrayList();

    class a implements androidx.constraintlayout.widget.c.a {
        final /* synthetic */ k a;
        final /* synthetic */ int b;
        final /* synthetic */ boolean c;
        final /* synthetic */ int d;

        a(k kVar, int i, boolean z, int i2) {
            this.a = kVar;
            this.b = i;
            this.c = z;
            this.d = i2;
        }
    }

    public l(MotionLayout motionLayout) {
        this.a = motionLayout;
    }

    private void f(k kVar, boolean z) {
        ConstraintLayout.getSharedValues().a(kVar.h(), new a(kVar, kVar.h(), z, kVar.g()));
    }

    public void a(k kVar) {
        this.b.add(kVar);
        this.c = null;
        if (kVar.i() == 4) {
            f(kVar, true);
        } else if (kVar.i() == 5) {
            f(kVar, false);
        }
    }

    void b(k.b bVar) {
        if (this.e == null) {
            this.e = new ArrayList();
        }
        this.e.add(bVar);
    }

    void c() {
        ArrayList arrayList = this.e;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((k.b) it.next()).a();
        }
        this.e.removeAll(this.f);
        this.f.clear();
        if (this.e.isEmpty()) {
            this.e = null;
        }
    }

    boolean d(int i, g gVar) {
        for (k kVar : this.b) {
            if (kVar.e() == i) {
                kVar.f.a(gVar);
                return true;
            }
        }
        return false;
    }

    void e() {
        this.a.invalidate();
    }

    void g(k.b bVar) {
        this.f.add(bVar);
    }

    void h(MotionEvent motionEvent) {
        int currentState = this.a.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.c == null) {
            this.c = new HashSet();
            for (k kVar : this.b) {
                int childCount = this.a.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    View childAt = this.a.getChildAt(i);
                    if (kVar.k(childAt)) {
                        childAt.getId();
                        this.c.add(childAt);
                    }
                }
            }
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList arrayList = this.e;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it = this.e.iterator();
            while (it.hasNext()) {
                ((k.b) it.next()).d(action, x, y);
            }
        }
        if (action == 0 || action == 1) {
            androidx.constraintlayout.widget.b bVarL0 = this.a.l0(currentState);
            for (k kVar2 : this.b) {
                if (kVar2.m(action)) {
                    for (View view : this.c) {
                        if (kVar2.k(view)) {
                            view.getHitRect(rect);
                            if (rect.contains((int) x, (int) y)) {
                                kVar2.c(this, this.a, currentState, bVarL0, view);
                            }
                        }
                    }
                }
            }
        }
    }
}
