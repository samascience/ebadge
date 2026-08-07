package defpackage;

import android.content.Context;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
public abstract class uc2 {

    public interface a {
        void a(Context context, String[] strArr, String str, File file, vc2 vc2Var);
    }

    public interface b {
        String a(String str);

        String b(String str);

        String[] c();

        void d(String str);

        void loadLibrary(String str);
    }

    public interface c {
    }

    public static void a(Context context, String str) {
        b(context, str, null, null);
    }

    public static void b(Context context, String str, String str2, c cVar) {
        new vc2().f(context, str, str2, cVar);
    }
}
