package defpackage;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
public final class d4 extends b4 {
    @Override // defpackage.b4
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        p31.f(context, "context");
        p31.f(str, "input");
        return c4.a.a(new String[]{str});
    }

    @Override // defpackage.b4
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b4.a b(Context context, String str) {
        p31.f(context, "context");
        p31.f(str, "input");
        if (q30.a(context, str) == 0) {
            return new b4.a(Boolean.TRUE);
        }
        return null;
    }

    @Override // defpackage.b4
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Boolean c(int i, Intent intent) {
        if (intent == null || i != -1) {
            return Boolean.FALSE;
        }
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        boolean z = false;
        if (intArrayExtra != null) {
            for (int i2 : intArrayExtra) {
                if (i2 == 0) {
                    z = true;
                    break;
                }
            }
        }
        return Boolean.valueOf(z);
    }
}
