package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class sd3 {
    private String a;
    private String b;
    private String c;
    private String d;

    public static abstract class a {
        private boolean a;
        private String b;
        private boolean c;
        private String d;
        private boolean e;
        private String f;
        private boolean g;
        private String h;

        public abstract sd3 i();

        public a j(String str) {
            this.h = str;
            this.g = true;
            return l();
        }

        public a k(String str) {
            this.f = str;
            this.e = true;
            return l();
        }

        protected abstract a l();

        public a m(String str) {
            this.d = str;
            this.c = true;
            return l();
        }

        public a n(String str) {
            this.b = str;
            this.a = true;
            return l();
        }

        public String toString() {
            return "VideoSynthesisParam.Media.MediaBuilder(url$value=" + this.b + ", type$value=" + this.d + ", referenceVoice$value=" + this.f + ", referenceDescription$value=" + this.h + ")";
        }
    }

    private static final class b extends a {
        private b() {
        }

        @Override // sd3.a
        public sd3 i() {
            return new sd3(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // sd3.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b l() {
            return this;
        }
    }

    protected sd3(a aVar) {
        this.a = aVar.a ? aVar.b : d();
        this.b = aVar.c ? aVar.d : c();
        this.c = aVar.e ? aVar.f : b();
        this.d = aVar.g ? aVar.h : a();
    }

    private static String a() {
        return null;
    }

    private static String b() {
        return null;
    }

    private static String c() {
        return null;
    }

    private static String d() {
        return null;
    }

    public static a e() {
        return new b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof sd3)) {
            return false;
        }
        sd3 sd3Var = (sd3) obj;
        if (!sd3Var.f(this)) {
            return false;
        }
        String strJ = j();
        String strJ2 = sd3Var.j();
        if (strJ != null ? !strJ.equals(strJ2) : strJ2 != null) {
            return false;
        }
        String strI = i();
        String strI2 = sd3Var.i();
        if (strI != null ? !strI.equals(strI2) : strI2 != null) {
            return false;
        }
        String strH = h();
        String strH2 = sd3Var.h();
        if (strH != null ? !strH.equals(strH2) : strH2 != null) {
            return false;
        }
        String strG = g();
        String strG2 = sd3Var.g();
        return strG != null ? strG.equals(strG2) : strG2 == null;
    }

    protected boolean f(Object obj) {
        return obj instanceof sd3;
    }

    public String g() {
        return this.d;
    }

    public String h() {
        return this.c;
    }

    public int hashCode() {
        String strJ = j();
        int iHashCode = strJ == null ? 43 : strJ.hashCode();
        String strI = i();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strI == null ? 43 : strI.hashCode());
        String strH = h();
        int iHashCode3 = (iHashCode2 * 59) + (strH == null ? 43 : strH.hashCode());
        String strG = g();
        return (iHashCode3 * 59) + (strG != null ? strG.hashCode() : 43);
    }

    public String i() {
        return this.b;
    }

    public String j() {
        return this.a;
    }

    public String toString() {
        return "VideoSynthesisParam.Media(url=" + j() + ", type=" + i() + ", referenceVoice=" + h() + ", referenceDescription=" + g() + ")";
    }
}
