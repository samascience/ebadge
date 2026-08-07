package defpackage;

import androidx.work.WorkerParameters;

/* JADX INFO: loaded from: classes.dex */
public class pt2 implements Runnable {
    private nk3 a;
    private String b;
    private WorkerParameters.a c;

    public pt2(nk3 nk3Var, String str, WorkerParameters.a aVar) {
        this.a = nk3Var;
        this.b = str;
        this.c = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.l().k(this.b, this.c);
    }
}
