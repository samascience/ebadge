package androidx.camera.video;

import android.util.Range;
import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class c extends androidx.camera.video.a {
    private final Range d;
    private final int e;
    private final int f;
    private final Range g;
    private final int h;

    static final class b extends androidx.camera.video.a.AbstractC0009a {
        private Range a;
        private Integer b;
        private Integer c;
        private Range d;
        private Integer e;

        b() {
        }

        @Override // androidx.camera.video.a.AbstractC0009a
        public androidx.camera.video.a a() {
            Range range = this.a;
            String str = Constants.STR_EMPTY;
            if (range == null) {
                str = Constants.STR_EMPTY + " bitrate";
            }
            if (this.b == null) {
                str = str + " sourceFormat";
            }
            if (this.c == null) {
                str = str + " source";
            }
            if (this.d == null) {
                str = str + " sampleRate";
            }
            if (this.e == null) {
                str = str + " channelCount";
            }
            if (str.isEmpty()) {
                return new c(this.a, this.b.intValue(), this.c.intValue(), this.d, this.e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.video.a.AbstractC0009a
        public androidx.camera.video.a.AbstractC0009a b(Range range) {
            if (range == null) {
                throw new NullPointerException("Null bitrate");
            }
            this.a = range;
            return this;
        }

        @Override // androidx.camera.video.a.AbstractC0009a
        public androidx.camera.video.a.AbstractC0009a c(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        @Override // androidx.camera.video.a.AbstractC0009a
        public androidx.camera.video.a.AbstractC0009a d(Range range) {
            if (range == null) {
                throw new NullPointerException("Null sampleRate");
            }
            this.d = range;
            return this;
        }

        @Override // androidx.camera.video.a.AbstractC0009a
        public androidx.camera.video.a.AbstractC0009a e(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        public androidx.camera.video.a.AbstractC0009a f(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }
    }

    @Override // androidx.camera.video.a
    public Range b() {
        return this.d;
    }

    @Override // androidx.camera.video.a
    public int c() {
        return this.h;
    }

    @Override // androidx.camera.video.a
    public Range d() {
        return this.g;
    }

    @Override // androidx.camera.video.a
    public int e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof androidx.camera.video.a)) {
            return false;
        }
        androidx.camera.video.a aVar = (androidx.camera.video.a) obj;
        return this.d.equals(aVar.b()) && this.e == aVar.f() && this.f == aVar.e() && this.g.equals(aVar.d()) && this.h == aVar.c();
    }

    @Override // androidx.camera.video.a
    public int f() {
        return this.e;
    }

    public int hashCode() {
        return ((((((((this.d.hashCode() ^ 1000003) * 1000003) ^ this.e) * 1000003) ^ this.f) * 1000003) ^ this.g.hashCode()) * 1000003) ^ this.h;
    }

    public String toString() {
        return "AudioSpec{bitrate=" + this.d + ", sourceFormat=" + this.e + ", source=" + this.f + ", sampleRate=" + this.g + ", channelCount=" + this.h + "}";
    }

    private c(Range range, int i, int i2, Range range2, int i3) {
        this.d = range;
        this.e = i;
        this.f = i2;
        this.g = range2;
        this.h = i3;
    }
}
