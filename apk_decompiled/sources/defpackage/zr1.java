package defpackage;

import android.os.Bundle;
import androidx.core.graphics.drawable.IconCompat;

/* JADX INFO: loaded from: classes.dex */
abstract class zr1 {
    private static final Object a = new Object();
    private static final Object b = new Object();

    static Bundle a(xr1.a aVar) {
        Bundle bundle = new Bundle();
        IconCompat iconCompatD = aVar.d();
        bundle.putInt("icon", iconCompatD != null ? iconCompatD.b() : 0);
        bundle.putCharSequence("title", aVar.h());
        bundle.putParcelable("actionIntent", aVar.a());
        Bundle bundle2 = aVar.c() != null ? new Bundle(aVar.c()) : new Bundle();
        bundle2.putBoolean("android.support.allowGeneratedReplies", aVar.b());
        bundle.putBundle("extras", bundle2);
        bundle.putParcelableArray("remoteInputs", c(aVar.e()));
        bundle.putBoolean("showsUserInterface", aVar.g());
        bundle.putInt("semanticAction", aVar.f());
        return bundle;
    }

    private static Bundle b(ve2 ve2Var) {
        new Bundle();
        throw null;
    }

    private static Bundle[] c(ve2[] ve2VarArr) {
        if (ve2VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[ve2VarArr.length];
        for (int i = 0; i < ve2VarArr.length; i++) {
            ve2 ve2Var = ve2VarArr[i];
            bundleArr[i] = b(null);
        }
        return bundleArr;
    }
}
