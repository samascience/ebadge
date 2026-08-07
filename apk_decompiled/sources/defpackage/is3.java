package defpackage;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class is3 extends qb0 {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ za1 b;
    private final /* synthetic */ int c;

    is3(Intent intent, za1 za1Var, int i) {
        this.a = intent;
        this.b = za1Var;
        this.c = i;
    }

    @Override // defpackage.qb0
    public final void c() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.c);
        }
    }
}
