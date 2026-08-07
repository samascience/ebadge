package defpackage;

import android.content.Context;
import androidx.work.NetworkType;

/* JADX INFO: loaded from: classes.dex */
public class mq1 extends k20 {
    private static final String e = fd1.f("NetworkNotRoamingCtrlr");

    public mq1(Context context, w03 w03Var) {
        super(p43.c(context, w03Var).d());
    }

    @Override // defpackage.k20
    boolean b(xk3 xk3Var) {
        return xk3Var.j.b() == NetworkType.NOT_ROAMING;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // defpackage.k20
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public boolean c(tq1 tq1Var) {
        return (tq1Var.a() && tq1Var.c()) ? false : true;
    }
}
