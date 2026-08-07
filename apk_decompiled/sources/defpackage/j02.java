package defpackage;

import android.app.Activity;
import android.content.Context;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public abstract class j02 {
    private static int a = -1;
    private static a b;

    public interface a {
        void a();

        void b(String[] strArr);
    }

    public static abstract class b {
    }

    private static String[] a(Context context, String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (q30.a(context, str) == -1) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static void b(Activity activity, int i, String[] strArr, int[] iArr) {
        int i2 = a;
        if (i2 == -1 || i != i2 || b == null) {
            return;
        }
        String[] strArrA = a(activity, strArr);
        if (strArrA.length > 0) {
            b.b(strArrA);
        } else {
            b.a();
        }
    }

    public static void c(Context context, int i, String[] strArr, a aVar) {
        d(context, i, strArr, aVar, null);
    }

    public static void d(Context context, int i, String[] strArr, a aVar, b bVar) {
        if (!(context instanceof Activity)) {
            throw new RuntimeException("Context must be an Activity");
        }
        a = i;
        b = aVar;
        String[] strArrA = a(context, strArr);
        if (strArrA.length > 0) {
            e(context, strArrA);
            ((Activity) context).requestPermissions(strArrA, i);
        } else {
            a aVar2 = b;
            if (aVar2 != null) {
                aVar2.a();
            }
        }
    }

    private static boolean e(Context context, String... strArr) {
        for (String str : strArr) {
            if (g3.v((Activity) context, str)) {
                return true;
            }
        }
        return false;
    }
}
