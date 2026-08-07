package defpackage;

import android.graphics.ImageDecoder;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class v21 implements ug2 {
    private final ji a = new ji();

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public qg2 b(InputStream inputStream, int i, int i2, rx1 rx1Var) {
        return this.a.c(ImageDecoder.createSource(lp.b(inputStream)), i, i2, rx1Var);
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, rx1 rx1Var) {
        return true;
    }
}
