package defpackage;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.d;
import kotlin.collections.j;
import kotlin.collections.u;

/* JADX INFO: loaded from: classes.dex */
public final class c4 extends b4 {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final Intent a(String[] strArr) {
            p31.f(strArr, "input");
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            p31.e(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
            return intentPutExtra;
        }

        private a() {
        }
    }

    @Override // defpackage.b4
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        p31.f(context, "context");
        p31.f(strArr, "input");
        return a.a(strArr);
    }

    @Override // defpackage.b4
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public b4.a b(Context context, String[] strArr) {
        p31.f(context, "context");
        p31.f(strArr, "input");
        if (strArr.length == 0) {
            return new b4.a(u.f());
        }
        for (String str : strArr) {
            if (q30.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(ga2.b(u.c(strArr.length), 16));
        for (String str2 : strArr) {
            Pair pairA = d63.a(str2, Boolean.TRUE);
            linkedHashMap.put(pairA.getFirst(), pairA.getSecond());
        }
        return new b4.a(linkedHashMap);
    }

    @Override // defpackage.b4
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i, Intent intent) {
        if (i == -1 && intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra == null || stringArrayExtra == null) {
                return u.f();
            }
            ArrayList arrayList = new ArrayList(intArrayExtra.length);
            for (int i2 : intArrayExtra) {
                arrayList.add(Boolean.valueOf(i2 == 0));
            }
            return u.l(j.b0(d.s(stringArrayExtra), arrayList));
        }
        return u.f();
    }
}
