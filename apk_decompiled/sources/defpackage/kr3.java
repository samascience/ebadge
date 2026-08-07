package defpackage;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.c;

/* JADX INFO: loaded from: classes.dex */
final class kr3 extends a.AbstractC0075a {
    kr3() {
    }

    @Override // com.google.android.gms.common.api.a.AbstractC0075a
    public final /* synthetic */ a.f c(Context context, Looper looper, ky kyVar, Object obj, c.b bVar, c.InterfaceC0078c interfaceC0078c) {
        xo2 xo2Var = (xo2) obj;
        if (xo2Var == null) {
            xo2Var = xo2.i;
        }
        return new vo2(context, looper, true, kyVar, xo2Var, bVar, interfaceC0078c);
    }
}
