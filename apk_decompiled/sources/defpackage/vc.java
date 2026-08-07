package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class vc extends kb {
    private final int b;
    private final int c;
    private final int d;
    private final int e;

    static final class b extends kb.a {
        private Integer a;
        private Integer b;
        private Integer c;
        private Integer d;

        b() {
        }

        @Override // kb.a
        kb a() {
            Integer num = this.a;
            String str = Constants.STR_EMPTY;
            if (num == null) {
                str = Constants.STR_EMPTY + " audioSource";
            }
            if (this.b == null) {
                str = str + " sampleRate";
            }
            if (this.c == null) {
                str = str + " channelCount";
            }
            if (this.d == null) {
                str = str + " audioFormat";
            }
            if (str.isEmpty()) {
                return new vc(this.a.intValue(), this.b.intValue(), this.c.intValue(), this.d.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // kb.a
        public kb.a c(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        @Override // kb.a
        public kb.a d(int i) {
            this.a = Integer.valueOf(i);
            return this;
        }

        @Override // kb.a
        public kb.a e(int i) {
            this.c = Integer.valueOf(i);
            return this;
        }

        @Override // kb.a
        public kb.a f(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }
    }

    @Override // defpackage.kb
    public int b() {
        return this.e;
    }

    @Override // defpackage.kb
    public int c() {
        return this.b;
    }

    @Override // defpackage.kb
    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof kb)) {
            return false;
        }
        kb kbVar = (kb) obj;
        return this.b == kbVar.c() && this.c == kbVar.f() && this.d == kbVar.e() && this.e == kbVar.b();
    }

    @Override // defpackage.kb
    public int f() {
        return this.c;
    }

    public int hashCode() {
        return ((((((this.b ^ 1000003) * 1000003) ^ this.c) * 1000003) ^ this.d) * 1000003) ^ this.e;
    }

    public String toString() {
        return "AudioSettings{audioSource=" + this.b + ", sampleRate=" + this.c + ", channelCount=" + this.d + ", audioFormat=" + this.e + "}";
    }

    private vc(int i, int i2, int i3, int i4) {
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
    }
}
