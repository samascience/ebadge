package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class df1 extends ze1 implements ji1 {
    private ji1.a e;

    public df1(long j) {
        super(j);
    }

    @Override // defpackage.ji1
    public void a(int i) {
        if (i >= 40) {
            b();
        } else if (i >= 20 || i == 15) {
            m(h() / 2);
        }
    }

    @Override // defpackage.ji1
    public /* bridge */ /* synthetic */ qg2 c(w81 w81Var, qg2 qg2Var) {
        return (qg2) super.k(w81Var, qg2Var);
    }

    @Override // defpackage.ji1
    public void d(ji1.a aVar) {
        this.e = aVar;
    }

    @Override // defpackage.ji1
    public /* bridge */ /* synthetic */ qg2 e(w81 w81Var) {
        return (qg2) super.l(w81Var);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ze1
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public int i(qg2 qg2Var) {
        return qg2Var == null ? super.i(null) : qg2Var.o();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // defpackage.ze1
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public void j(w81 w81Var, qg2 qg2Var) {
        ji1.a aVar = this.e;
        if (aVar == null || qg2Var == null) {
            return;
        }
        aVar.d(qg2Var);
    }
}
