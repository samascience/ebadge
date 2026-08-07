package defpackage;

import android.util.Size;
import androidx.camera.core.impl.Timebase;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class ud extends kc3 {
    private final String a;
    private final int b;
    private final Timebase c;
    private final Size d;
    private final int e;
    private final oc3 f;
    private final int g;
    private final int h;
    private final int i;

    static final class b extends kc3.a {
        private String a;
        private Integer b;
        private Timebase c;
        private Size d;
        private Integer e;
        private oc3 f;
        private Integer g;
        private Integer h;
        private Integer i;

        b() {
        }

        @Override // kc3.a
        public kc3 a() {
            String str = this.a;
            String str2 = Constants.STR_EMPTY;
            if (str == null) {
                str2 = Constants.STR_EMPTY + " mimeType";
            }
            if (this.b == null) {
                str2 = str2 + " profile";
            }
            if (this.c == null) {
                str2 = str2 + " inputTimebase";
            }
            if (this.d == null) {
                str2 = str2 + " resolution";
            }
            if (this.e == null) {
                str2 = str2 + " colorFormat";
            }
            if (this.f == null) {
                str2 = str2 + " dataSpace";
            }
            if (this.g == null) {
                str2 = str2 + " frameRate";
            }
            if (this.h == null) {
                str2 = str2 + " IFrameInterval";
            }
            if (this.i == null) {
                str2 = str2 + " bitrate";
            }
            if (str2.isEmpty()) {
                return new ud(this.a, this.b.intValue(), this.c, this.d, this.e.intValue(), this.f, this.g.intValue(), this.h.intValue(), this.i.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // kc3.a
        public kc3.a b(int i) {
            this.i = Integer.valueOf(i);
            return this;
        }

        @Override // kc3.a
        public kc3.a c(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        @Override // kc3.a
        public kc3.a d(oc3 oc3Var) {
            if (oc3Var == null) {
                throw new NullPointerException("Null dataSpace");
            }
            this.f = oc3Var;
            return this;
        }

        @Override // kc3.a
        public kc3.a e(int i) {
            this.g = Integer.valueOf(i);
            return this;
        }

        @Override // kc3.a
        public kc3.a f(int i) {
            this.h = Integer.valueOf(i);
            return this;
        }

        @Override // kc3.a
        public kc3.a g(Timebase timebase) {
            if (timebase == null) {
                throw new NullPointerException("Null inputTimebase");
            }
            this.c = timebase;
            return this;
        }

        @Override // kc3.a
        public kc3.a h(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.a = str;
            return this;
        }

        @Override // kc3.a
        public kc3.a i(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // kc3.a
        public kc3.a j(Size size) {
            if (size == null) {
                throw new NullPointerException("Null resolution");
            }
            this.d = size;
            return this;
        }
    }

    @Override // defpackage.kc3, defpackage.hg0
    public Timebase b() {
        return this.c;
    }

    @Override // defpackage.kc3, defpackage.hg0
    public String c() {
        return this.a;
    }

    @Override // defpackage.kc3
    public int e() {
        return this.i;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kc3)) {
            return false;
        }
        kc3 kc3Var = (kc3) obj;
        return this.a.equals(kc3Var.c()) && this.b == kc3Var.j() && this.c.equals(kc3Var.b()) && this.d.equals(kc3Var.k()) && this.e == kc3Var.f() && this.f.equals(kc3Var.g()) && this.g == kc3Var.h() && this.h == kc3Var.i() && this.i == kc3Var.e();
    }

    @Override // defpackage.kc3
    public int f() {
        return this.e;
    }

    @Override // defpackage.kc3
    public oc3 g() {
        return this.f;
    }

    @Override // defpackage.kc3
    public int h() {
        return this.g;
    }

    public int hashCode() {
        return ((((((((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode()) * 1000003) ^ this.e) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g) * 1000003) ^ this.h) * 1000003) ^ this.i;
    }

    @Override // defpackage.kc3
    public int i() {
        return this.h;
    }

    @Override // defpackage.kc3
    public int j() {
        return this.b;
    }

    @Override // defpackage.kc3
    public Size k() {
        return this.d;
    }

    public String toString() {
        return "VideoEncoderConfig{mimeType=" + this.a + ", profile=" + this.b + ", inputTimebase=" + this.c + ", resolution=" + this.d + ", colorFormat=" + this.e + ", dataSpace=" + this.f + ", frameRate=" + this.g + ", IFrameInterval=" + this.h + ", bitrate=" + this.i + "}";
    }

    private ud(String str, int i, Timebase timebase, Size size, int i2, oc3 oc3Var, int i3, int i4, int i5) {
        this.a = str;
        this.b = i;
        this.c = timebase;
        this.d = size;
        this.e = i2;
        this.f = oc3Var;
        this.g = i3;
        this.h = i4;
        this.i = i5;
    }
}
