package defpackage;

import android.content.Context;
import androidx.work.a;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class mk3 {
    protected mk3() {
    }

    public static mk3 c(Context context) {
        return nk3.j(context);
    }

    public static void d(Context context, a aVar) {
        nk3.d(context, aVar);
    }

    public final tw1 a(wk3 wk3Var) {
        return b(Collections.singletonList(wk3Var));
    }

    public abstract tw1 b(List list);
}
