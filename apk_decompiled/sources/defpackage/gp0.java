package defpackage;

import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class gp0 extends ff2 {
    public static final b c = new b(null);
    private static final fi1 d = fi1.e.a("application/x-www-form-urlencoded");
    private final List a;
    private final List b;

    public static final class a {
        private final Charset a;
        private final List b;
        private final List c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public final a a(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            List list = this.b;
            tx0.b bVar = tx0.k;
            list.add(tx0.b.b(bVar, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.a, 91, null));
            this.c.add(tx0.b.b(bVar, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", false, false, true, false, this.a, 91, null));
            return this;
        }

        public final a b(String str, String str2) {
            p31.f(str, "name");
            p31.f(str2, "value");
            List list = this.b;
            tx0.b bVar = tx0.k;
            list.add(tx0.b.b(bVar, str, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.a, 83, null));
            this.c.add(tx0.b.b(bVar, str2, 0, 0, " \"':;<=>@[]^`{}|/\\?#&!$(),~", true, false, true, false, this.a, 83, null));
            return this;
        }

        public final gp0 c() {
            return new gp0(this.b, this.c);
        }

        public a(Charset charset) {
            this.a = charset;
            this.b = new ArrayList();
            this.c = new ArrayList();
        }

        public /* synthetic */ a(Charset charset, int i, y70 y70Var) {
            this((i & 1) != 0 ? null : charset);
        }
    }

    public static final class b {
        public /* synthetic */ b(y70 y70Var) {
            this();
        }

        private b() {
        }
    }

    public gp0(List list, List list2) {
        p31.f(list, "encodedNames");
        p31.f(list2, "encodedValues");
        this.a = pa3.U(list);
        this.b = pa3.U(list2);
    }

    private final long a(ro roVar, boolean z) throws EOFException {
        fo foVarB;
        if (z) {
            foVarB = new fo();
        } else {
            p31.c(roVar);
            foVarB = roVar.b();
        }
        int size = this.a.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                foVarB.I(38);
            }
            foVarB.S((String) this.a.get(i));
            foVarB.I(61);
            foVarB.S((String) this.b.get(i));
        }
        if (!z) {
            return 0L;
        }
        long size2 = foVarB.size();
        foVarB.u();
        return size2;
    }

    @Override // defpackage.ff2
    public long contentLength() {
        return a(null, true);
    }

    @Override // defpackage.ff2
    public fi1 contentType() {
        return d;
    }

    @Override // defpackage.ff2
    public void writeTo(ro roVar) throws EOFException {
        p31.f(roVar, "sink");
        a(roVar, false);
    }
}
