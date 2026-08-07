package defpackage;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class bv0 extends l91 {
    private final zu0 g;

    public bv0(List list) {
        super(list);
        zu0 zu0Var = (zu0) ((k91) list.get(0)).b;
        int iC = zu0Var != null ? zu0Var.c() : 0;
        this.g = new zu0(new float[iC], new int[iC]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.tg
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public zu0 i(k91 k91Var, float f) {
        this.g.d((zu0) k91Var.b, (zu0) k91Var.c, f);
        return this.g;
    }
}
