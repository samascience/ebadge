package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class by1 extends ay1 {

    private static final class a {
        final OutputConfiguration a;
        String b;
        long c = 1;

        a(OutputConfiguration outputConfiguration) {
            this.a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.a, aVar.a) && this.c == aVar.c && Objects.equals(this.b, aVar.b);
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() ^ 31;
            int i = (iHashCode << 5) - iHashCode;
            String str = this.b;
            int iHashCode2 = (str == null ? 0 : str.hashCode()) ^ i;
            return Long.hashCode(this.c) ^ ((iHashCode2 << 5) - iHashCode2);
        }
    }

    by1(int i, Surface surface) {
        this(new a(new OutputConfiguration(i, surface)));
    }

    static by1 j(OutputConfiguration outputConfiguration) {
        return new by1(new a(outputConfiguration));
    }

    @Override // zx1.a
    public void c(Surface surface) {
        ((OutputConfiguration) i()).addSurface(surface);
    }

    @Override // zx1.a
    public void d(long j) {
        ((a) this.a).c = j;
    }

    @Override // zx1.a
    public String e() {
        return ((a) this.a).b;
    }

    @Override // zx1.a
    public void f() {
        ((OutputConfiguration) i()).enableSurfaceSharing();
    }

    @Override // zx1.a
    public void g(String str) {
        ((a) this.a).b = str;
    }

    @Override // defpackage.ay1, zx1.a
    public Object i() {
        b52.a(this.a instanceof a);
        return ((a) this.a).a;
    }

    by1(Object obj) {
        super(obj);
    }
}
