package androidx.constraintlayout.core.widgets.analyzer;

import defpackage.j90;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
class k {
    public static int h;
    WidgetRun c;
    WidgetRun d;
    int f;
    int g;
    public int a = 0;
    public boolean b = false;
    ArrayList e = new ArrayList();

    public k(WidgetRun widgetRun, int i) {
        this.c = null;
        this.d = null;
        int i2 = h;
        this.f = i2;
        h = i2 + 1;
        this.c = widgetRun;
        this.d = widgetRun;
        this.g = i;
    }

    private long c(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.d;
        if (widgetRun instanceof i) {
            return j;
        }
        int size = dependencyNode.k.size();
        long jMin = j;
        for (int i = 0; i < size; i++) {
            j90 j90Var = (j90) dependencyNode.k.get(i);
            if (j90Var instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) j90Var;
                if (dependencyNode2.d != widgetRun) {
                    jMin = Math.min(jMin, c(dependencyNode2, ((long) dependencyNode2.f) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.i) {
            return jMin;
        }
        long j2 = j - widgetRun.j();
        return Math.min(Math.min(jMin, c(widgetRun.h, j2)), j2 - ((long) widgetRun.h.f));
    }

    private long d(DependencyNode dependencyNode, long j) {
        WidgetRun widgetRun = dependencyNode.d;
        if (widgetRun instanceof i) {
            return j;
        }
        int size = dependencyNode.k.size();
        long jMax = j;
        for (int i = 0; i < size; i++) {
            j90 j90Var = (j90) dependencyNode.k.get(i);
            if (j90Var instanceof DependencyNode) {
                DependencyNode dependencyNode2 = (DependencyNode) j90Var;
                if (dependencyNode2.d != widgetRun) {
                    jMax = Math.max(jMax, d(dependencyNode2, ((long) dependencyNode2.f) + j));
                }
            }
        }
        if (dependencyNode != widgetRun.h) {
            return jMax;
        }
        long j2 = j + widgetRun.j();
        return Math.max(Math.max(jMax, d(widgetRun.i, j2)), j2 - ((long) widgetRun.i.f));
    }

    public void a(WidgetRun widgetRun) {
        this.e.add(widgetRun);
        this.d = widgetRun;
    }

    public long b(androidx.constraintlayout.core.widgets.d dVar, int i) {
        long j;
        int i2;
        WidgetRun widgetRun = this.c;
        if (widgetRun instanceof c) {
            if (((c) widgetRun).f != i) {
                return 0L;
            }
        } else if (i == 0) {
            if (!(widgetRun instanceof j)) {
                return 0L;
            }
        } else if (!(widgetRun instanceof l)) {
            return 0L;
        }
        DependencyNode dependencyNode = (i == 0 ? dVar.e : dVar.f).h;
        DependencyNode dependencyNode2 = (i == 0 ? dVar.e : dVar.f).i;
        boolean zContains = widgetRun.h.l.contains(dependencyNode);
        boolean zContains2 = this.c.i.l.contains(dependencyNode2);
        long j2 = this.c.j();
        if (zContains && zContains2) {
            long jD = d(this.c.h, 0L);
            long jC = c(this.c.i, 0L);
            long j3 = jD - j2;
            WidgetRun widgetRun2 = this.c;
            int i3 = widgetRun2.i.f;
            if (j3 >= (-i3)) {
                j3 += (long) i3;
            }
            int i4 = widgetRun2.h.f;
            long j4 = ((-jC) - j2) - ((long) i4);
            if (j4 >= i4) {
                j4 -= (long) i4;
            }
            float fS = widgetRun2.b.s(i);
            float f = fS > 0.0f ? (long) ((j4 / fS) + (j3 / (1.0f - fS))) : 0L;
            long j5 = ((long) ((f * fS) + 0.5f)) + j2 + ((long) ((f * (1.0f - fS)) + 0.5f));
            WidgetRun widgetRun3 = this.c;
            j = ((long) widgetRun3.h.f) + j5;
            i2 = widgetRun3.i.f;
        } else {
            if (zContains) {
                DependencyNode dependencyNode3 = this.c.h;
                return Math.max(d(dependencyNode3, dependencyNode3.f), ((long) this.c.h.f) + j2);
            }
            if (zContains2) {
                DependencyNode dependencyNode4 = this.c.i;
                return Math.max(-c(dependencyNode4, dependencyNode4.f), ((long) (-this.c.i.f)) + j2);
            }
            WidgetRun widgetRun4 = this.c;
            j = ((long) widgetRun4.h.f) + widgetRun4.j();
            i2 = this.c.i.f;
        }
        return j - ((long) i2);
    }
}
