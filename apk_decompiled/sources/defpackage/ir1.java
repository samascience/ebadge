package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class ir1 extends lr1 {
    private ByteBuffer z0;

    public ir1(oy0 oy0Var, int i, mp mpVar) {
        super(oy0Var, i, mpVar);
        this.z0 = ByteBuffer.wrap(ez1.f);
    }

    @Override // defpackage.lr1
    protected byte q4(int i) {
        return this.z0.get(i);
    }

    @Override // defpackage.lr1
    protected byte r4() {
        ByteBuffer byteBuffer = this.z0;
        int i = this.r;
        this.r = i + 1;
        return byteBuffer.get(i);
    }

    @Override // defpackage.lr1
    protected int s4() {
        ByteBuffer byteBuffer = this.z0;
        int i = this.r;
        this.r = i + 1;
        return byteBuffer.get(i) & 255;
    }
}
