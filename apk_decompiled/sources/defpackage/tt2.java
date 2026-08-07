package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class tt2 {

    private static class b extends tt2 {
        private volatile boolean a;

        b() {
            super();
        }

        @Override // defpackage.tt2
        public void b(boolean z) {
            this.a = z;
        }

        @Override // defpackage.tt2
        public void c() {
            if (this.a) {
                throw new IllegalStateException("Already released");
            }
        }
    }

    public static tt2 a() {
        return new b();
    }

    abstract void b(boolean z);

    public abstract void c();

    private tt2() {
    }
}
