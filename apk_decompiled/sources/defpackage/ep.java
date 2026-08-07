package defpackage;

import com.bumptech.glide.load.resource.bitmap.a;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ep implements ug2 {
    private final a a;

    public ep(a aVar) {
        this.a = aVar;
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public qg2 b(ByteBuffer byteBuffer, int i, int i2, rx1 rx1Var) {
        return this.a.f(lp.f(byteBuffer), i, i2, rx1Var);
    }

    @Override // defpackage.ug2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, rx1 rx1Var) {
        return this.a.q(byteBuffer);
    }
}
