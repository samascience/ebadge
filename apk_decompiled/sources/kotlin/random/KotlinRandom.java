package kotlin.random;

import defpackage.p31;
import defpackage.y70;

/* JADX INFO: loaded from: classes4.dex */
final class KotlinRandom extends java.util.Random {
    private static final a Companion = new a(null);
    private static final long serialVersionUID = 0;
    private final Random impl;
    private boolean seedInitialized;

    private static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    public KotlinRandom(Random random) {
        p31.f(random, "impl");
        this.impl = random;
    }

    public final Random getImpl() {
        return this.impl;
    }

    @Override // java.util.Random
    protected int next(int i) {
        return this.impl.nextBits(i);
    }

    @Override // java.util.Random
    public boolean nextBoolean() {
        return this.impl.nextBoolean();
    }

    @Override // java.util.Random
    public void nextBytes(byte[] bArr) {
        p31.f(bArr, "bytes");
        this.impl.nextBytes(bArr);
    }

    @Override // java.util.Random
    public double nextDouble() {
        return this.impl.nextDouble();
    }

    @Override // java.util.Random
    public float nextFloat() {
        return this.impl.nextFloat();
    }

    @Override // java.util.Random
    public int nextInt() {
        return this.impl.nextInt();
    }

    @Override // java.util.Random
    public long nextLong() {
        return this.impl.nextLong();
    }

    @Override // java.util.Random
    public void setSeed(long j) {
        if (this.seedInitialized) {
            throw new UnsupportedOperationException("Setting seed is not supported.");
        }
        this.seedInitialized = true;
    }

    @Override // java.util.Random
    public int nextInt(int i) {
        return this.impl.nextInt(i);
    }
}
