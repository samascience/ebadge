package defpackage;

/* JADX INFO: loaded from: classes.dex */
class cp3 implements Runnable {
    final /* synthetic */ vo3 a;

    cp3(vo3 vo3Var) {
        this.a = vo3Var;
    }

    @Override // java.lang.Runnable
    public void run() throws Throwable {
        ym3.b("postWithHttps start Thread id = " + String.valueOf(Thread.currentThread().getId()));
        this.a.d(new sp3(this.a.a).b(this.a.b));
    }
}
