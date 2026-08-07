package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o33 {
    private static Toast a;
    private static Handler b = new Handler(Looper.getMainLooper());

    class a implements Runnable {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Toast.makeText(this.a.getApplicationContext(), this.b, 1).show();
        }
    }

    public static void a(Context context, String str) {
        b.post(new a(context, str));
    }

    public static void b(Context context, String str) {
        if (a == null) {
            a = Toast.makeText(context.getApplicationContext(), str, 0);
        }
        a.setText(str);
        a.show();
    }
}
