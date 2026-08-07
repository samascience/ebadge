package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class wd extends tc3 {
    private final String a;
    private final int b;
    private final eh0.c c;

    static final class b extends tc3.a {
        private String a;
        private Integer b;
        private eh0.c c;

        b() {
        }

        @Override // tc3.a
        public tc3 b() {
            String str = this.a;
            String str2 = Constants.STR_EMPTY;
            if (str == null) {
                str2 = Constants.STR_EMPTY + " mimeType";
            }
            if (this.b == null) {
                str2 = str2 + " profile";
            }
            if (str2.isEmpty()) {
                return new wd(this.a, this.b.intValue(), this.c);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // tc3.a
        public tc3.a c(eh0.c cVar) {
            this.c = cVar;
            return this;
        }

        protected tc3.a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null mimeType");
            }
            this.a = str;
            return this;
        }

        @Override // fk1.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public tc3.a a(int i) {
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

    @Override // defpackage.tc3
    public eh0.c d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof tc3)) {
            return false;
        }
        tc3 tc3Var = (tc3) obj;
        if (this.a.equals(tc3Var.a()) && this.b == tc3Var.b()) {
            eh0.c cVar = this.c;
            if (cVar == null) {
                if (tc3Var.d() == null) {
                    return true;
                }
            } else if (cVar.equals(tc3Var.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b) * 1000003;
        eh0.c cVar = this.c;
        return iHashCode ^ (cVar == null ? 0 : cVar.hashCode());
    }

    public String toString() {
        return "VideoMimeInfo{mimeType=" + this.a + ", profile=" + this.b + ", compatibleVideoProfile=" + this.c + "}";
    }

    private wd(String str, int i, eh0.c cVar) {
        this.a = str;
        this.b = i;
        this.c = cVar;
    }
}
