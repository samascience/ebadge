package defpackage;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ft0 extends yv0 {
    private String i;
    private List j;

    public static abstract class a extends yv0.a {
        private String n;
        private List o;

        @Override // yv0.a, wv0.a
        public String toString() {
            return "GenerationParamBase.GenerationParamBaseBuilder(super=" + super.toString() + ", prompt=" + this.n + ", history=" + this.o + ")";
        }
    }

    protected ft0(a aVar) {
        super(aVar);
        this.i = aVar.n;
        this.j = aVar.o;
    }

    @Override // defpackage.yv0, defpackage.wv0
    protected abstract boolean c(Object obj);

    @Override // defpackage.wv0
    public ByteBuffer e() {
        return null;
    }

    @Override // defpackage.yv0, defpackage.wv0
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ft0)) {
            return false;
        }
        ft0 ft0Var = (ft0) obj;
        if (!ft0Var.c(this) || !super.equals(obj)) {
            return false;
        }
        String strT = t();
        String strT2 = ft0Var.t();
        if (strT != null ? !strT.equals(strT2) : strT2 != null) {
            return false;
        }
        List listR = r();
        List listR2 = ft0Var.r();
        return listR != null ? listR.equals(listR2) : listR2 == null;
    }

    @Override // defpackage.wv0
    public o61 h() {
        o61 o61Var = new o61();
        o61Var.n("model", j());
        o61Var.j("input", s());
        Map mapK = k();
        if (mapK != null && !mapK.isEmpty()) {
            o61Var.j("parameters", t71.b(mapK));
        }
        return o61Var;
    }

    @Override // defpackage.yv0, defpackage.wv0
    public int hashCode() {
        int iHashCode = super.hashCode();
        String strT = t();
        int iHashCode2 = (iHashCode * 59) + (strT == null ? 43 : strT.hashCode());
        List listR = r();
        return (iHashCode2 * 59) + (listR != null ? listR.hashCode() : 43);
    }

    public List r() {
        return this.j;
    }

    public abstract o61 s();

    public String t() {
        return this.i;
    }
}
