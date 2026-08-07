package defpackage;

import java.util.Hashtable;

/* JADX INFO: loaded from: classes.dex */
class cq3 implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ String d;
    final /* synthetic */ Hashtable e;
    final /* synthetic */ p91 f;

    cq3(p91 p91Var, int i, boolean z, String str, String str2, Hashtable hashtable) {
        this.f = p91Var;
        this.a = i;
        this.b = z;
        this.c = str;
        this.d = str2;
        this.e = hashtable;
    }

    @Override // java.lang.Runnable
    public void run() {
        ym3.b("status = " + this.a + "; forced = " + this.b + "checkAK = " + this.f.n(this.c));
        int i = this.a;
        if (i != 601 && !this.b && i != -1 && !this.f.n(this.c)) {
            if (602 == this.a) {
                ym3.b("authenticate wait ");
                if (p91.f != null) {
                    p91.f.b();
                }
            } else {
                ym3.b("authenticate else");
            }
            this.f.i(null, this.c);
            return;
        }
        ym3.b("authenticate sendAuthRequest");
        String[] strArrF = p91.m != null ? p91.m : qo3.f(p91.e);
        if (strArrF == null || strArrF.length <= 1) {
            this.f.j(this.b, this.d, this.e, this.c);
            return;
        }
        ym3.b("authStrings.length:" + strArrF.length);
        ym3.b("more sha1 auth");
        this.f.k(this.b, this.d, this.e, strArrF, this.c);
    }
}
