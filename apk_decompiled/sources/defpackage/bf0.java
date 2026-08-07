package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class bf0 implements q20 {
    private q20 a;

    public void a(q20 q20Var) {
        this.a = q20Var;
    }

    @Override // defpackage.q20
    public void accept(Object obj) {
        p31.d(this.a, "Listener is not set.");
        this.a.accept(obj);
    }
}
