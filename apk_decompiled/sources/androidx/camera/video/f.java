package androidx.camera.video;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class f extends p {
    private final x0 a;
    private final androidx.camera.video.a b;
    private final int c;

    static final class b extends p.a {
        private x0 a;
        private androidx.camera.video.a b;
        private Integer c;

        @Override // androidx.camera.video.p.a
        public p a() {
            x0 x0Var = this.a;
            String str = Constants.STR_EMPTY;
            if (x0Var == null) {
                str = Constants.STR_EMPTY + " videoSpec";
            }
            if (this.b == null) {
                str = str + " audioSpec";
            }
            if (this.c == null) {
                str = str + " outputFormat";
            }
            if (str.isEmpty()) {
                return new f(this.a, this.b, this.c.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.video.p.a
        x0 c() {
            x0 x0Var = this.a;
            if (x0Var != null) {
                return x0Var;
            }
            throw new IllegalStateException("Property \"videoSpec\" has not been set");
        }

        @Override // androidx.camera.video.p.a
        public p.a d(androidx.camera.video.a aVar) {
            if (aVar == null) {
                throw new NullPointerException("Null audioSpec");
            }
            this.b = aVar;
            return this;
        }

        @Override // androidx.camera.video.p.a
        public p.a e(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @Override // androidx.camera.video.p.a
        public p.a f(x0 x0Var) {
            if (x0Var == null) {
                throw new NullPointerException("Null videoSpec");
            }
            this.a = x0Var;
            return this;
        }

        b() {
        }

        private b(p pVar) {
            this.a = pVar.d();
            this.b = pVar.b();
            this.c = Integer.valueOf(pVar.c());
        }
    }

    @Override // androidx.camera.video.p
    public androidx.camera.video.a b() {
        return this.b;
    }

    @Override // androidx.camera.video.p
    public int c() {
        return this.c;
    }

    @Override // androidx.camera.video.p
    public x0 d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return this.a.equals(pVar.d()) && this.b.equals(pVar.b()) && this.c == pVar.c();
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c;
    }

    @Override // androidx.camera.video.p
    public p.a i() {
        return new b(this);
    }

    public String toString() {
        return "MediaSpec{videoSpec=" + this.a + ", audioSpec=" + this.b + ", outputFormat=" + this.c + "}";
    }

    private f(x0 x0Var, androidx.camera.video.a aVar, int i) {
        this.a = x0Var;
        this.b = aVar;
        this.c = i;
    }
}
