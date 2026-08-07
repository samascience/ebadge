package defpackage;

import android.hardware.camera2.params.OutputConfiguration;
import android.view.Surface;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
class cy1 extends by1 {

    private static final class a {
        final OutputConfiguration a;
        long b = 1;

        a(OutputConfiguration outputConfiguration) {
            this.a = outputConfiguration;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Objects.equals(this.a, aVar.a) && this.b == aVar.b;
        }

        public int hashCode() {
            int iHashCode = this.a.hashCode() ^ 31;
            return Long.hashCode(this.b) ^ ((iHashCode << 5) - iHashCode);
        }
    }

    cy1(int i, Surface surface) {
        this(new a(new OutputConfiguration(i, surface)));
    }

    static cy1 k(OutputConfiguration outputConfiguration) {
        return new cy1(new a(outputConfiguration));
    }

    @Override // defpackage.by1, zx1.a
    public void d(long j) {
        ((a) this.a).b = j;
    }

    @Override // defpackage.by1, zx1.a
    public String e() {
        return null;
    }

    @Override // defpackage.by1, zx1.a
    public void g(String str) {
        ((OutputConfiguration) i()).setPhysicalCameraId(str);
    }

    @Override // defpackage.by1, defpackage.ay1, zx1.a
    public Object i() {
        b52.a(this.a instanceof a);
        return ((a) this.a).a;
    }

    cy1(Object obj) {
        super(obj);
    }
}
