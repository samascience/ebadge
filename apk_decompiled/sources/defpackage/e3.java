package defpackage;

import android.app.Activity;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e3 {
    public static LinkedList a = new LinkedList();

    public static void a(Activity activity) {
        a.addLast(activity);
    }

    public static void b(Activity activity) {
        a.remove(activity);
    }
}
