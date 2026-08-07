package androidx.camera.core.impl;

import android.util.Range;
import android.util.Size;
import com.tencent.connect.common.Constants;
import defpackage.ie0;

/* JADX INFO: loaded from: classes.dex */
final class e extends x {
    private final Size b;
    private final ie0 c;
    private final Range d;
    private final Config e;

    static final class b extends x.a {
        private Size a;
        private ie0 b;
        private Range c;
        private Config d;

        @Override // androidx.camera.core.impl.x.a
        public x a() {
            Size size = this.a;
            String str = Constants.STR_EMPTY;
            if (size == null) {
                str = Constants.STR_EMPTY + " resolution";
            }
            if (this.b == null) {
                str = str + " dynamicRange";
            }
            if (this.c == null) {
                str = str + " expectedFrameRateRange";
            }
            if (str.isEmpty()) {
                return new e(this.a, this.b, this.c, this.d);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.core.impl.x.a
        public x.a b(ie0 ie0Var) {
            if (ie0Var == null) {
                throw new NullPointerException("Null dynamicRange");
            }
            this.b = ie0Var;
            return this;
        }

        @Override // androidx.camera.core.impl.x.a
        public x.a c(Range range) {
            if (range == null) {
                throw new NullPointerException("Null expectedFrameRateRange");
            }
            this.c = range;
            return this;
        }

        @Override // androidx.camera.core.impl.x.a
        public x.a d(Config config) {
            this.d = config;
            return this;
        }

        @Override // androidx.camera.core.impl.x.a
        public x.a e(Size size) {
            if (size == null) {
                throw new NullPointerException("Null resolution");
            }
            this.a = size;
            return this;
        }

        b() {
        }

        private b(x xVar) {
            this.a = xVar.e();
            this.b = xVar.b();
            this.c = xVar.c();
            this.d = xVar.d();
        }
    }

    @Override // androidx.camera.core.impl.x
    public ie0 b() {
        return this.c;
    }

    @Override // androidx.camera.core.impl.x
    public Range c() {
        return this.d;
    }

    @Override // androidx.camera.core.impl.x
    public Config d() {
        return this.e;
    }

    @Override // androidx.camera.core.impl.x
    public Size e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        if (this.b.equals(xVar.e()) && this.c.equals(xVar.b()) && this.d.equals(xVar.c())) {
            Config config = this.e;
            if (config == null) {
                if (xVar.d() == null) {
                    return true;
                }
            } else if (config.equals(xVar.d())) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.camera.core.impl.x
    public x.a f() {
        return new b(this);
    }

    public int hashCode() {
        int iHashCode = (((((this.b.hashCode() ^ 1000003) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003;
        Config config = this.e;
        return iHashCode ^ (config == null ? 0 : config.hashCode());
    }

    public String toString() {
        return "StreamSpec{resolution=" + this.b + ", dynamicRange=" + this.c + ", expectedFrameRateRange=" + this.d + ", implementationOptions=" + this.e + "}";
    }

    private e(Size size, ie0 ie0Var, Range range, Config config) {
        this.b = size;
        this.c = ie0Var;
        this.d = range;
        this.e = config;
    }
}
