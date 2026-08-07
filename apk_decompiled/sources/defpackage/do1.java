package defpackage;

import android.content.Context;
import androidx.work.NetworkType;

/* JADX INFO: loaded from: classes.dex */
public class do1 extends k20 {
    public do1(Context context, w03 w03Var) {
        super(p43.c(context, w03Var).d());
    }

    @Override // defpackage.k20
    boolean b(xk3 xk3Var) {
        return xk3Var.j.b() == NetworkType.CONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.k20
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(tq1 tq1Var) {
        return (tq1Var.a() && tq1Var.d()) ? false : true;
    }
}
