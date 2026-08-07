package defpackage;

/* JADX INFO: loaded from: classes4.dex */
public final /* synthetic */ class a82 implements Runnable {
    public final /* synthetic */ d82 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ String c;

    public /* synthetic */ a82(d82 d82Var, int i, String str) {
        this.a = d82Var;
        this.b = i;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        d82.i(this.a, this.b, this.c);
    }
}
