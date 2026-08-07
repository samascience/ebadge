package defpackage;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class wv0 {
    private String a;
    private boolean b;
    private String c;
    private Boolean d;
    protected Map e;
    protected Map f;

    public static abstract class a {
        private String a;
        private boolean b;
        private boolean c;
        private String d;
        private boolean e;
        private Boolean f;
        private ArrayList g;
        private ArrayList h;
        private ArrayList i;
        private ArrayList j;

        public a k(String str) {
            this.a = str;
            return l();
        }

        protected abstract a l();

        public String toString() {
            return "HalfDuplexParamBase.HalfDuplexParamBaseBuilder(apiKey=" + this.a + ", securityCheck$value=" + this.c + ", workspace=" + this.d + ", enableEncrypt$value=" + this.f + ", parameters$key=" + this.g + ", parameters$value=" + this.h + ", headers$key=" + this.i + ", headers$value=" + this.j + ")";
        }
    }

    protected wv0(a aVar) {
        Map mapEmptyMap;
        Map mapEmptyMap2;
        this.a = aVar.a;
        this.b = aVar.b ? aVar.c : b();
        this.c = aVar.d;
        this.d = aVar.e ? aVar.f : a();
        int size = aVar.g == null ? 0 : aVar.g.size();
        if (size == 0) {
            mapEmptyMap = Collections.emptyMap();
        } else if (size != 1) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(aVar.g.size() < 1073741824 ? aVar.g.size() + 1 + ((aVar.g.size() - 3) / 3) : Integer.MAX_VALUE);
            for (int i = 0; i < aVar.g.size(); i++) {
                linkedHashMap.put(aVar.g.get(i), aVar.h.get(i));
            }
            mapEmptyMap = Collections.unmodifiableMap(linkedHashMap);
        } else {
            mapEmptyMap = Collections.singletonMap(aVar.g.get(0), aVar.h.get(0));
        }
        this.e = mapEmptyMap;
        int size2 = aVar.i == null ? 0 : aVar.i.size();
        if (size2 == 0) {
            mapEmptyMap2 = Collections.emptyMap();
        } else if (size2 != 1) {
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(aVar.i.size() < 1073741824 ? aVar.i.size() + 1 + ((aVar.i.size() - 3) / 3) : Integer.MAX_VALUE);
            for (int i2 = 0; i2 < aVar.i.size(); i2++) {
                linkedHashMap2.put(aVar.i.get(i2), aVar.j.get(i2));
            }
            mapEmptyMap2 = Collections.unmodifiableMap(linkedHashMap2);
        } else {
            mapEmptyMap2 = Collections.singletonMap(aVar.i.get(0), aVar.j.get(0));
        }
        this.f = mapEmptyMap2;
    }

    private static Boolean a() {
        return Boolean.FALSE;
    }

    private static boolean b() {
        return false;
    }

    protected abstract boolean c(Object obj);

    public String d() {
        return this.a;
    }

    public abstract ByteBuffer e();

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wv0)) {
            return false;
        }
        wv0 wv0Var = (wv0) obj;
        if (!wv0Var.c(this) || n() != wv0Var.n()) {
            return false;
        }
        Boolean boolF = f();
        Boolean boolF2 = wv0Var.f();
        if (boolF != null ? !boolF.equals(boolF2) : boolF2 != null) {
            return false;
        }
        String strD = d();
        String strD2 = wv0Var.d();
        if (strD != null ? !strD.equals(strD2) : strD2 != null) {
            return false;
        }
        String strM = m();
        String strM2 = wv0Var.m();
        if (strM != null ? !strM.equals(strM2) : strM2 != null) {
            return false;
        }
        Map mapK = k();
        Map mapK2 = wv0Var.k();
        if (mapK != null ? !mapK.equals(mapK2) : mapK2 != null) {
            return false;
        }
        Map mapG = g();
        Map mapG2 = wv0Var.g();
        return mapG != null ? mapG.equals(mapG2) : mapG2 == null;
    }

    public Boolean f() {
        return this.d;
    }

    public abstract Map g();

    public abstract o61 h();

    public int hashCode() {
        int i = n() ? 79 : 97;
        Boolean boolF = f();
        int iHashCode = ((i + 59) * 59) + (boolF == null ? 43 : boolF.hashCode());
        String strD = d();
        int iHashCode2 = (iHashCode * 59) + (strD == null ? 43 : strD.hashCode());
        String strM = m();
        int iHashCode3 = (iHashCode2 * 59) + (strM == null ? 43 : strM.hashCode());
        Map mapK = k();
        int iHashCode4 = (iHashCode3 * 59) + (mapK == null ? 43 : mapK.hashCode());
        Map mapG = g();
        return (iHashCode4 * 59) + (mapG != null ? mapG.hashCode() : 43);
    }

    public abstract Object i();

    public abstract String j();

    public abstract Map k();

    public abstract Object l();

    public String m() {
        return this.c;
    }

    public boolean n() {
        return this.b;
    }

    public abstract void o();
}
