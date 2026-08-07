package defpackage;

import android.util.Log;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public class cu0 implements xg2 {
    @Override // defpackage.xg2
    public EncodeStrategy b(rx1 rx1Var) {
        return EncodeStrategy.SOURCE;
    }

    @Override // defpackage.fg0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(qg2 qg2Var, File file, rx1 rx1Var) throws Throwable {
        try {
            lp.e(((au0) qg2Var.get()).c(), file);
            return true;
        } catch (IOException e) {
            if (Log.isLoggable("GifEncoder", 5)) {
                Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            }
            return false;
        }
    }
}
