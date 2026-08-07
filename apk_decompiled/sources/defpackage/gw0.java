package defpackage;

import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class gw0 {
    public static final a d = new a(null);
    public static final ByteString e;
    public static final ByteString f;
    public static final ByteString g;
    public static final ByteString h;
    public static final ByteString i;
    public static final ByteString j;
    public final ByteString a;
    public final ByteString b;
    public final int c;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private a() {
        }
    }

    static {
        ByteString.a aVar = ByteString.Companion;
        e = aVar.d(":");
        f = aVar.d(":status");
        g = aVar.d(":method");
        h = aVar.d(":path");
        i = aVar.d(":scheme");
        j = aVar.d(":authority");
    }

    public gw0(ByteString byteString, ByteString byteString2) {
        p31.f(byteString, "name");
        p31.f(byteString2, "value");
        this.a = byteString;
        this.b = byteString2;
        this.c = byteString.size() + 32 + byteString2.size();
    }

    public final ByteString a() {
        return this.a;
    }

    public final ByteString b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof gw0)) {
            return false;
        }
        gw0 gw0Var = (gw0) obj;
        return p31.a(this.a, gw0Var.a) && p31.a(this.b, gw0Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return this.a.utf8() + ": " + this.b.utf8();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public gw0(String str, String str2) {
        p31.f(str, "name");
        p31.f(str2, "value");
        ByteString.a aVar = ByteString.Companion;
        this(aVar.d(str), aVar.d(str2));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gw0(ByteString byteString, String str) {
        this(byteString, ByteString.Companion.d(str));
        p31.f(byteString, "name");
        p31.f(str, "value");
    }
}
