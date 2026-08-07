package defpackage;

/* JADX INFO: loaded from: classes.dex */
final class iu3 implements Runnable {
    final /* synthetic */ u03 a;
    final /* synthetic */ ku3 b;

    iu3(ku3 ku3Var, u03 u03Var) {
        this.b = ku3Var;
        this.a = u03Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.b.b) {
            try {
                ku3 ku3Var = this.b;
                if (ku3Var.c != null) {
                    ku3Var.c.a(this.a);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
