package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class d53 extends c53 {
    public d53(ue3 ue3Var) {
        super(ue3Var);
    }

    @Override // defpackage.c53
    public void d(boolean z) {
        this.b.reset();
        if (!z) {
            this.b.postTranslate(this.c.y(), this.c.l() - this.c.x());
        } else {
            this.b.setTranslate(-(this.c.m() - this.c.z()), this.c.l() - this.c.x());
            this.b.postScale(-1.0f, 1.0f);
        }
    }
}
