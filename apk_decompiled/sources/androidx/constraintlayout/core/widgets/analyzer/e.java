package androidx.constraintlayout.core.widgets.analyzer;

import defpackage.j90;

/* JADX INFO: loaded from: classes.dex */
class e extends DependencyNode {
    public int m;

    public e(WidgetRun widgetRun) {
        super(widgetRun);
        if (widgetRun instanceof j) {
            this.e = DependencyNode.Type.HORIZONTAL_DIMENSION;
        } else {
            this.e = DependencyNode.Type.VERTICAL_DIMENSION;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.DependencyNode
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
}
