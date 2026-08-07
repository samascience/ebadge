package androidx.camera.video;

import android.util.Range;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class m extends x0 {
    private final v d;
    private final Range e;
    private final Range f;
    private final int g;

    static final class b extends x0.a {
        private v a;
        private Range b;
        private Range c;
        private Integer d;

        @Override // androidx.camera.video.x0.a
        public x0 a() {
            v vVar = this.a;
            String str = Constants.STR_EMPTY;
            if (vVar == null) {
                str = Constants.STR_EMPTY + " qualitySelector";
            }
            if (this.b == null) {
                str = str + " frameRate";
            }
            if (this.c == null) {
                str = str + " bitrate";
            }
            if (this.d == null) {
                str = str + " aspectRatio";
            }
            if (str.isEmpty()) {
                return new m(this.a, this.b, this.c, this.d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.video.x0.a
        x0.a b(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        @Override // androidx.camera.video.x0.a
        public x0.a c(Range range) {
            if (range == null) {
                throw new NullPointerException("Null bitrate");
            }
            this.c = range;
            return this;
        }

        @Override // androidx.camera.video.x0.a
        public x0.a d(Range range) {
            if (range == null) {
                throw new NullPointerException("Null frameRate");
            }
            this.b = range;
            return this;
        }

        @Override // androidx.camera.video.x0.a
        public x0.a e(v vVar) {
            if (vVar == null) {
                throw new NullPointerException("Null qualitySelector");
            }
            this.a = vVar;
            return this;
        }

        b() {
        }

        private b(x0 x0Var) {
            this.a = x0Var.e();
            this.b = x0Var.d();
            this.c = x0Var.c();
            this.d = Integer.valueOf(x0Var.b());
        }
    }

    @Override // androidx.camera.video.x0
    int b() {
        return this.g;
    }

    @Override // androidx.camera.video.x0
    public Range c() {
        return this.f;
    }

    @Override // androidx.camera.video.x0
    public Range d() {
        return this.e;
    }

    @Override // androidx.camera.video.x0
    public v e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x0)) {
            return false;
        }
        x0 x0Var = (x0) obj;
        return this.d.equals(x0Var.e()) && this.e.equals(x0Var.d()) && this.f.equals(x0Var.c()) && this.g == x0Var.b();
    }

    @Override // androidx.camera.video.x0
    public x0.a f() {
        return new b(this);
    }

    public int hashCode() {
        return ((((((this.d.hashCode() ^ 1000003) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g;
    }

    public String toString() {
        return "VideoSpec{qualitySelector=" + this.d + ", frameRate=" + this.e + ", bitrate=" + this.f + ", aspectRatio=" + this.g + "}";
    }

    private m(v vVar, Range range, Range range2, int i) {
        this.d = vVar;
        this.e = range;
        this.f = range2;
        this.g = i;
    }
}
