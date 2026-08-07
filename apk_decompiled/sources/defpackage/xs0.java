package defpackage;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class xs0 extends wv0 {

    public static abstract class b extends wv0.a {
        public abstract xs0 m();

        @Override // wv0.a
        public String toString() {
            return "GeneralGetParam.GeneralGetParamBuilder(super=" + super.toString() + ")";
        }
    }

    private static final class c extends b {
        private c() {
        }

        @Override // xs0.b
        public xs0 m() {
            return new xs0(this);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // wv0.a
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public c l() {
            return this;
        }
    }

    protected xs0(b bVar) {
        super(bVar);
    }

    public static b p() {
        return new c();
    }

    @Override // defpackage.wv0
    protected boolean c(Object obj) {
        return obj instanceof xs0;
    }

    @Override // defpackage.wv0
    public ByteBuffer e() {
        throw new UnsupportedOperationException("Unimplemented method 'getBinaryData'");
    }

    @Override // defpackage.wv0
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof xs0) && ((xs0) obj).c(this) && super.equals(obj);
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
    public o61 h() {
        return null;
    }

    @Override // defpackage.wv0
    public int hashCode() {
        return super.hashCode();
    }

    @Override // defpackage.wv0
    public Object i() {
        throw new UnsupportedOperationException("Unimplemented method 'getInput'");
    }

    @Override // defpackage.wv0
    public String j() {
        throw new UnsupportedOperationException("Unimplemented method 'getModel'");
    }

    @Override // defpackage.wv0
    public Map k() {
        HashMap map = new HashMap();
        map.putAll(this.e);
        return map;
    }

    @Override // defpackage.wv0
    public Object l() {
        return null;
    }

    public String toString() {
        return "GeneralGetParam()";
    }
}
