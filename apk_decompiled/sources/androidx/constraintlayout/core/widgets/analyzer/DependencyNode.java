package androidx.constraintlayout.core.widgets.analyzer;

import defpackage.j90;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DependencyNode implements j90 {
    WidgetRun d;
    int f;
    public int g;
    public j90 a = null;
    public boolean b = false;
    public boolean c = false;
    Type e = Type.UNKNOWN;
    int h = 1;
    e i = null;
    public boolean j = false;
    List k = new ArrayList();
    List l = new ArrayList();

    enum Type {
        UNKNOWN,
        HORIZONTAL_DIMENSION,
        VERTICAL_DIMENSION,
        LEFT,
        RIGHT,
        TOP,
        BOTTOM,
        BASELINE
    }

    public DependencyNode(WidgetRun widgetRun) {
        this.d = widgetRun;
    }

    @Override // defpackage.j90
    public void a(j90 j90Var) {
        Iterator it = this.l.iterator();
        while (it.hasNext()) {
            if (!((DependencyNode) it.next()).j) {
                return;
            }
        }
        this.c = true;
        j90 j90Var2 = this.a;
        if (j90Var2 != null) {
            j90Var2.a(this);
        }
        if (this.b) {
            this.d.a(this);
            return;
        }
        DependencyNode dependencyNode = null;
        int i = 0;
        for (DependencyNode dependencyNode2 : this.l) {
            if (!(dependencyNode2 instanceof e)) {
                i++;
                dependencyNode = dependencyNode2;
            }
        }
        if (dependencyNode != null && i == 1 && dependencyNode.j) {
            e eVar = this.i;
            if (eVar != null) {
                if (!eVar.j) {
                    return;
                } else {
                    this.f = this.h * eVar.g;
                }
            }
            d(dependencyNode.g + this.f);
        }
        j90 j90Var3 = this.a;
        if (j90Var3 != null) {
            j90Var3.a(this);
        }
    }

    public void b(j90 j90Var) {
        this.k.add(j90Var);
        if (this.j) {
            j90Var.a(j90Var);
        }
    }

    public void c() {
        this.l.clear();
        this.k.clear();
        this.j = false;
        this.g = 0;
        this.c = false;
        this.b = false;
    }

    public void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (j90 j90Var : this.k) {
            j90Var.a(j90Var);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.b.v());
        sb.append(":");
        sb.append(this.e);
        sb.append("(");
        sb.append(this.j ? Integer.valueOf(this.g) : "unresolved");
        sb.append(") <t=");
        sb.append(this.l.size());
        sb.append(":d=");
        sb.append(this.k.size());
        sb.append(">");
        return sb.toString();
    }
}
