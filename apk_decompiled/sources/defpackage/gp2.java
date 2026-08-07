package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class gp2 implements qg2 {
    protected final Object a;

    public gp2(Object obj) {
        this.a = z42.d(obj);
    }

    @Override // defpackage.qg2
    public void a() {
    }

    @Override // defpackage.qg2
    public final Object get() {
        return this.a;
    }

    @Override // defpackage.qg2
    public final int o() {
        return 1;
    }

    @Override // defpackage.qg2
    public Class p() {
        return this.a.getClass();
    }
}
