package defpackage;

import androidx.camera.core.impl.Timebase;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class tc extends fb {
    private final String a;
    private final int b;
    private final Timebase c;
    private final int d;
    private final int e;
    private final int f;

    static final class b extends fb.a {
        private String a;
        private Integer b;
        private Timebase c;
        private Integer d;
        private Integer e;
        private Integer f;

        b() {
        }

        @Override // fb.a
        fb a() {
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
                str2 = str2 + " bitrate";
            }
            if (this.e == null) {
                str2 = str2 + " sampleRate";
            }
            if (this.f == null) {
                str2 = str2 + " channelCount";
            }
            if (str2.isEmpty()) {
                return new tc(this.a, this.b.intValue(), this.c, this.d.intValue(), this.e.intValue(), this.f.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // fb.a
        public fb.a c(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        @Override // fb.a
        public fb.a d(int i) {
            this.f = Integer.valueOf(i);
            return this;
        }

        @Override // fb.a
        public fb.a e(Timebase timebase) {
            if (timebase == null) {
                throw new NullPointerException("Null inputTimebase");
            }
            this.c = timebase;
            return this;
        }

        @Override // fb.a
        public fb.a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.a = str;
            return this;
        }

        @Override // fb.a
        public fb.a g(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }

        @Override // fb.a
        public fb.a h(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }
    }

    @Override // defpackage.fb, defpackage.hg0
    public Timebase b() {
        return this.c;
    }

    @Override // defpackage.fb, defpackage.hg0
    public String c() {
        return this.a;
    }

    @Override // defpackage.fb
    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof fb)) {
            return false;
        }
        fb fbVar = (fb) obj;
        return this.a.equals(fbVar.c()) && this.b == fbVar.g() && this.c.equals(fbVar.b()) && this.d == fbVar.e() && this.e == fbVar.h() && this.f == fbVar.f();
    }

    @Override // defpackage.fb
    public int f() {
        return this.f;
    }

    @Override // defpackage.fb
    public int g() {
        return this.b;
    }

    @Override // defpackage.fb
    public int h() {
        return this.e;
    }

    public int hashCode() {
        return ((((((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f;
    }

    public String toString() {
        return "AudioEncoderConfig{mimeType=" + this.a + ", profile=" + this.b + ", inputTimebase=" + this.c + ", bitrate=" + this.d + ", sampleRate=" + this.e + ", channelCount=" + this.f + "}";
    }

    private tc(String str, int i, Timebase timebase, int i2, int i3, int i4) {
        this.a = str;
        this.b = i;
        this.c = timebase;
        this.d = i2;
        this.e = i3;
        this.f = i4;
    }
}
