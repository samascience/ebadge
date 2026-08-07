package defpackage;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ei implements xg2 {
    private final oi a;
    private final xg2 b;

    public ei(oi oiVar, xg2 xg2Var) {
        this.a = oiVar;
        this.b = xg2Var;
    }

    @Override // defpackage.xg2
    public EncodeStrategy b(rx1 rx1Var) {
        return this.b.b(rx1Var);
    }

    @Override // defpackage.fg0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(qg2 qg2Var, File file, rx1 rx1Var) {
        return this.b.a(new qi(((BitmapDrawable) qg2Var.get()).getBitmap(), this.a), file, rx1Var);
    }
}
