package defpackage;

import com.tencent.connect.common.Constants;

/* JADX INFO: loaded from: classes.dex */
final class kd extends rw1.a {
    private final String a;
    private final String b;
    private final String c;
    private final String d;

    static final class b extends rw1.a.AbstractC0168a {
        private String a;
        private String b;
        private String c;
        private String d;

        b() {
        }

        @Override // rw1.a.AbstractC0168a
        rw1.a a() {
            String str = this.a;
            String str2 = Constants.STR_EMPTY;
            if (str == null) {
                str2 = Constants.STR_EMPTY + " glVersion";
            }
            if (this.b == null) {
                str2 = str2 + " eglVersion";
            }
            if (this.c == null) {
                str2 = str2 + " glExtensions";
            }
            if (this.d == null) {
                str2 = str2 + " eglExtensions";
            }
            if (str2.isEmpty()) {
                return new kd(this.a, this.b, this.c, this.d);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // rw1.a.AbstractC0168a
        rw1.a.AbstractC0168a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null eglExtensions");
            }
            this.d = str;
            return this;
        }

        @Override // rw1.a.AbstractC0168a
        rw1.a.AbstractC0168a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null eglVersion");
            }
            this.b = str;
            return this;
        }

        @Override // rw1.a.AbstractC0168a
        rw1.a.AbstractC0168a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null glExtensions");
            }
            this.c = str;
            return this;
        }

        @Override // rw1.a.AbstractC0168a
        rw1.a.AbstractC0168a e(String str) {
            if (str == null) {
                throw new NullPointerException("Null glVersion");
            }
            this.a = str;
            return this;
        }
    }

    @Override // rw1.a
    public String b() {
        return this.d;
    }

    @Override // rw1.a
    public String c() {
        return this.b;
    }

    @Override // rw1.a
    public String d() {
        return this.c;
    }

    @Override // rw1.a
    public String e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof rw1.a)) {
            return false;
        }
        rw1.a aVar = (rw1.a) obj;
        return this.a.equals(aVar.e()) && this.b.equals(aVar.c()) && this.c.equals(aVar.d()) && this.d.equals(aVar.b());
    }

    public int hashCode() {
        return ((((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003) ^ this.c.hashCode()) * 1000003) ^ this.d.hashCode();
    }

    public String toString() {
        return "GraphicDeviceInfo{glVersion=" + this.a + ", eglVersion=" + this.b + ", glExtensions=" + this.c + ", eglExtensions=" + this.d + "}";
    }

    private kd(String str, String str2, String str3, String str4) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
    }
}
