package defpackage;

/* JADX INFO: loaded from: classes.dex */
class nq3 implements Runnable {
    final /* synthetic */ boolean a;
    final /* synthetic */ jq3.a b;

    nq3(jq3.a aVar, boolean z) {
        this.b = aVar;
        this.a = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!jq3.this.i) {
            jq3.this.i = this.a;
        }
        jq3.this.y();
        qq3.s().H();
        if (System.currentTimeMillis() - uq3.f() <= 5000) {
            ar3.b().f();
        }
    }
}
