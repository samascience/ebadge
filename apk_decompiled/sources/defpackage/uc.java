package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class uc extends jb {
    private final String a;
    private final int b;
    private final eh0.a c;

    static final class b extends jb.a {
        private String a;
        private Integer b;
        private eh0.a c;

        b() {
        }

        @Override // jb.a
        public jb b() {
            String str = this.a;
            String str2 = Constants.STR_EMPTY;
            if (str == null) {
                str2 = Constants.STR_EMPTY + " mimeType";
            }
            if (this.b == null) {
                str2 = str2 + " profile";
            }
            if (str2.isEmpty()) {
                return new uc(this.a, this.b.intValue(), this.c);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // jb.a
        public jb.a c(eh0.a aVar) {
            this.c = aVar;
            return this;
        }

        protected jb.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.a = str;
            return this;
        }

        @Override // fk1.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public jb.a a(int i) {
            this.b = Integer.valueOf(i);
            return this;
        }
    }

    @Override // defpackage.fk1
    public String a() {
        return this.a;
    }

    @Override // defpackage.fk1
    public int b() {
        return this.b;
    }

    @Override // defpackage.jb
    public eh0.a d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof jb)) {
            return false;
        }
        jb jbVar = (jb) obj;
        if (this.a.equals(jbVar.a()) && this.b == jbVar.b()) {
            eh0.a aVar = this.c;
            if (aVar == null) {
                if (jbVar.d() == null) {
                    return true;
                }
            } else if (aVar.equals(jbVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003;
        eh0.a aVar = this.c;
        return iHashCode ^ (aVar == null ? 0 : aVar.hashCode());
    }

    public String toString() {
        return "AudioMimeInfo{mimeType=" + this.a + ", profile=" + this.b + ", compatibleAudioProfile=" + this.c + "}";
    }

    private uc(String str, int i, eh0.a aVar) {
        this.a = str;
        this.b = i;
        this.c = aVar;
    }
}
