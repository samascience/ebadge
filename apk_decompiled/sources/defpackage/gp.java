package defpackage;

import android.graphics.ImageDecoder;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class gp implements ug2 {
    private final ji a = new ji();

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public qg2 b(ByteBuffer byteBuffer, int i, int i2, rx1 rx1Var) {
        return this.a.c(ImageDecoder.createSource(byteBuffer), i, i2, rx1Var);
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, rx1 rx1Var) {
        return true;
    }
}
