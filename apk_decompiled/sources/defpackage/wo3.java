package defpackage;

import android.os.Bundle;
import com.jieli.lib.gif.GifError;

/* JADX INFO: loaded from: classes.dex */
public class wo3 {
    private static Object b = new Object();
    private static wo3 c;
    private int a = -1;

    public static wo3 a() {
        wo3 wo3Var;
        synchronized (b) {
            try {
                if (c == null) {
                    c = new wo3();
                }
                wo3Var = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return wo3Var;
    }

    public void b(int i, int i2, String str) {
        if (i2 != this.a) {
            this.a = i2;
            Bundle bundle = new Bundle();
            bundle.putInt("loctype", i);
            bundle.putInt("diagtype", i2);
            bundle.putByteArray("diagmessage", str.getBytes());
            ro3.b().c(bundle, GifError.ERR_SAVE_FILE);
        }
    }
}
