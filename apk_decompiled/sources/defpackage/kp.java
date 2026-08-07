package defpackage;

import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class kp implements com.bumptech.glide.load.data.a {
    private final ByteBuffer a;

    public static class a implements com.bumptech.glide.load.data.a.InterfaceC0060a {
        @Override // com.bumptech.glide.load.data.a.InterfaceC0060a
        public Class a() {
            return ByteBuffer.class;
        }

        @Override // com.bumptech.glide.load.data.a.InterfaceC0060a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public com.bumptech.glide.load.data.a b(ByteBuffer byteBuffer) {
            return new kp(byteBuffer);
        }
    }

    public kp(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    @Override // com.bumptech.glide.load.data.a
    public void b() {
    }

    @Override // com.bumptech.glide.load.data.a
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public ByteBuffer a() {
        this.a.position(0);
        return this.a;
    }
}
