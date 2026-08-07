package defpackage;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import yqy.yichip.ota3genbandupgrade.R$string;

/* JADX INFO: loaded from: classes4.dex */
public class bm3 {
    private static bm3 c = new bm3();
    private Application a;
    private pm3 b = new a();

    class a implements pm3 {
        a() {
        }

        @Override // defpackage.pm3
        public void a(boolean z) {
            Log.d("_3GenBandOtaApplication", "onInitManager()-->isSucceed = " + z);
            if (z) {
                return;
            }
            Toast.makeText(bm3.this.a, bm3.this.a.getString(R$string.f82APP), 1).show();
            bm3.this.d(true);
        }
    }

    public bm3() {
        c = this;
    }

    public static bm3 b() {
        return c;
    }

    public Context c() {
        return this.a;
    }

    public void d(boolean z) {
        em3.g(c()).f();
    }
}
