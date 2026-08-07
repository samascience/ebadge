package androidx.camera.core.impl;

import com.tencent.connect.common.Constants;
import defpackage.ie0;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
final class d extends SessionConfig.e {
    private final DeferrableSurface a;
    private final List b;
    private final String c;
    private final int d;
    private final int e;
    private final ie0 f;

    static final class b extends SessionConfig.e.a {
        private DeferrableSurface a;
        private List b;
        private String c;
        private Integer d;
        private Integer e;
        private ie0 f;

        b() {
        }

        @Override // androidx.camera.core.impl.SessionConfig.e.a
        public SessionConfig.e a() {
            DeferrableSurface deferrableSurface = this.a;
            String str = Constants.STR_EMPTY;
            if (deferrableSurface == null) {
                str = Constants.STR_EMPTY + " surface";
            }
            if (this.b == null) {
                str = str + " sharedSurfaces";
            }
            if (this.d == null) {
                str = str + " mirrorMode";
            }
            if (this.e == null) {
                str = str + " surfaceGroupId";
            }
            if (this.f == null) {
                str = str + " dynamicRange";
            }
            if (str.isEmpty()) {
                return new d(this.a, this.b, this.c, this.d.intValue(), this.e.intValue(), this.f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // androidx.camera.core.impl.SessionConfig.e.a
        public SessionConfig.e.a b(ie0 ie0Var) {
            if (ie0Var == null) {
                throw new NullPointerException("Null dynamicRange");
            }
            this.f = ie0Var;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.e.a
        public SessionConfig.e.a c(int i) {
            this.d = Integer.valueOf(i);
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.e.a
        public SessionConfig.e.a d(String str) {
            this.c = str;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.e.a
        public SessionConfig.e.a e(List list) {
            if (list == null) {
                throw new NullPointerException("Null sharedSurfaces");
            }
            this.b = list;
            return this;
        }

        @Override // androidx.camera.core.impl.SessionConfig.e.a
        public SessionConfig.e.a f(int i) {
            this.e = Integer.valueOf(i);
            return this;
        }

        public SessionConfig.e.a g(DeferrableSurface deferrableSurface) {
            if (deferrableSurface == null) {
                throw new NullPointerException("Null surface");
            }
            this.a = deferrableSurface;
            return this;
        }
    }

    @Override // androidx.camera.core.impl.SessionConfig.e
    public ie0 b() {
        return this.f;
    }

    @Override // androidx.camera.core.impl.SessionConfig.e
    public int c() {
        return this.d;
    }

    @Override // androidx.camera.core.impl.SessionConfig.e
    public String d() {
        return this.c;
    }

    @Override // androidx.camera.core.impl.SessionConfig.e
    public List e() {
        return this.b;
    }

    public boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SessionConfig.e)) {
            return false;
        }
        SessionConfig.e eVar = (SessionConfig.e) obj;
        return this.a.equals(eVar.f()) && this.b.equals(eVar.e()) && ((str = this.c) != null ? str.equals(eVar.d()) : eVar.d() == null) && this.d == eVar.c() && this.e == eVar.g() && this.f.equals(eVar.b());
    }

    @Override // androidx.camera.core.impl.SessionConfig.e
    public DeferrableSurface f() {
        return this.a;
    }

    @Override // androidx.camera.core.impl.SessionConfig.e
    public int g() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = (((this.a.hashCode() ^ 1000003) * 1000003) ^ this.b.hashCode()) * 1000003;
        String str = this.c;
        return ((((((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.d) * 1000003) ^ this.e) * 1000003) ^ this.f.hashCode();
    }

    public String toString() {
        return "OutputConfig{surface=" + this.a + ", sharedSurfaces=" + this.b + ", physicalCameraId=" + this.c + ", mirrorMode=" + this.d + ", surfaceGroupId=" + this.e + ", dynamicRange=" + this.f + "}";
    }

    private d(DeferrableSurface deferrableSurface, List list, String str, int i, int i2, ie0 ie0Var) {
        this.a = deferrableSurface;
        this.b = list;
        this.c = str;
        this.d = i;
        this.e = i2;
        this.f = ie0Var;
    }
}
