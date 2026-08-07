package defpackage;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class yv0 extends wv0 {
    private String g;
    private Object h;

    public static abstract class a extends wv0.a {
        private String k;
        private boolean l;
        private Object m;

        public a p(String str) {
            if (str == null) {
                throw new NullPointerException("model is marked non-null but is null");
            }
            this.k = str;
            return q();
        }

        protected abstract a q();

        @Override // wv0.a
        public String toString() {
            return "HalfDuplexServiceParam.HalfDuplexServiceParamBuilder(super=" + super.toString() + ", model=" + this.k + ", resources$value=" + this.m + ")";
        }
    }

    protected yv0(a aVar) {
        super(aVar);
        String str = aVar.k;
        this.g = str;
        if (str == null) {
            throw new NullPointerException("model is marked non-null but is null");
        }
        this.h = aVar.l ? aVar.m : p();
    }

    private static Object p() {
        return null;
    }

    @Override // defpackage.wv0
    protected abstract boolean c(Object obj);

    @Override // defpackage.wv0
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof yv0)) {
            return false;
        }
        yv0 yv0Var = (yv0) obj;
        if (!yv0Var.c(this) || !super.equals(obj)) {
            return false;
        }
        String strJ = j();
        String strJ2 = yv0Var.j();
        if (strJ != null ? !strJ.equals(strJ2) : strJ2 != null) {
            return false;
        }
        Object objL = l();
        Object objL2 = yv0Var.l();
        return objL != null ? objL.equals(objL2) : objL2 == null;
    }

    @Override // defpackage.wv0
    public Map g() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f.entrySet()) {
            map.put((String) entry.getKey(), entry.getValue().toString());
        }
        return map;
    }

    @Override // defpackage.wv0
    public int hashCode() {
        int iHashCode = super.hashCode();
        String strJ = j();
        int iHashCode2 = (iHashCode * 59) + (strJ == null ? 43 : strJ.hashCode());
        Object objL = l();
        return (iHashCode2 * 59) + (objL != null ? objL.hashCode() : 43);
    }

    @Override // defpackage.wv0
    public String j() {
        return this.g;
    }

    @Override // defpackage.wv0
    public abstract Map k();

    @Override // defpackage.wv0
    public Object l() {
        return this.h;
    }

    public void q(String str, String str2) {
        if (this.f.isEmpty()) {
            this.f = new HashMap();
        } else {
            this.f = new HashMap(this.f);
        }
        this.f.put(str, str2);
    }
}
