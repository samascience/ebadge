package defpackage;

/* JADX INFO: loaded from: classes.dex */
public class u33 extends t33 {
    private Integer b;
    private String c;
    private String d = "function";
    private a e;

    public class a {
        private String a;
        private String b;
        private String c;

        public a() {
        }

        protected boolean a(Object obj) {
            return obj instanceof a;
        }

        public String b() {
            return this.b;
        }

        public String c() {
            return this.a;
        }

        public String d() {
            return this.c;
        }

        public void e(String str) {
            this.b = str;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (!aVar.a(this)) {
                return false;
            }
            String strC = c();
            String strC2 = aVar.c();
            if (strC != null ? !strC.equals(strC2) : strC2 != null) {
                return false;
            }
            String strB = b();
            String strB2 = aVar.b();
            if (strB != null ? !strB.equals(strB2) : strB2 != null) {
                return false;
            }
            String strD = d();
            String strD2 = aVar.d();
            return strD != null ? strD.equals(strD2) : strD2 == null;
        }

        public void f(String str) {
            this.a = str;
        }

        public void g(String str) {
            this.c = str;
        }

        public int hashCode() {
            String strC = c();
            int iHashCode = strC == null ? 43 : strC.hashCode();
            String strB = b();
            int iHashCode2 = ((iHashCode + 59) * 59) + (strB == null ? 43 : strB.hashCode());
            String strD = d();
            return (iHashCode2 * 59) + (strD != null ? strD.hashCode() : 43);
        }

        public String toString() {
            return "ToolCallFunction.CallFunction(name=" + c() + ", arguments=" + b() + ", output=" + d() + ")";
        }
    }

    static {
        t33.e("function", u33.class);
    }

    @Override // defpackage.t33
    public String a() {
        return this.c;
    }

    @Override // defpackage.t33
    public Integer b() {
        return this.b;
    }

    @Override // defpackage.t33
    public String d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof u33)) {
            return false;
        }
        u33 u33Var = (u33) obj;
        if (!u33Var.f(this)) {
            return false;
        }
        Integer numB = b();
        Integer numB2 = u33Var.b();
        if (numB != null ? !numB.equals(numB2) : numB2 != null) {
            return false;
        }
        String strA = a();
        String strA2 = u33Var.a();
        if (strA != null ? !strA.equals(strA2) : strA2 != null) {
            return false;
        }
        String strD = d();
        String strD2 = u33Var.d();
        if (strD != null ? !strD.equals(strD2) : strD2 != null) {
            return false;
        }
        a aVarG = g();
        a aVarG2 = u33Var.g();
        return aVarG != null ? aVarG.equals(aVarG2) : aVarG2 == null;
    }

    protected boolean f(Object obj) {
        return obj instanceof u33;
    }

    public a g() {
        return this.e;
    }

    public void h(a aVar) {
        this.e = aVar;
    }

    public int hashCode() {
        Integer numB = b();
        int iHashCode = numB == null ? 43 : numB.hashCode();
        String strA = a();
        int iHashCode2 = ((iHashCode + 59) * 59) + (strA == null ? 43 : strA.hashCode());
        String strD = d();
        int iHashCode3 = (iHashCode2 * 59) + (strD == null ? 43 : strD.hashCode());
        a aVarG = g();
        return (iHashCode3 * 59) + (aVarG != null ? aVarG.hashCode() : 43);
    }

    public void i(String str) {
        this.c = str;
    }

    public void j(Integer num) {
        this.b = num;
    }

    public void k(String str) {
        this.d = str;
    }

    public String toString() {
        return "ToolCallFunction(index=" + b() + ", id=" + a() + ", type=" + d() + ", function=" + g() + ")";
    }
}
