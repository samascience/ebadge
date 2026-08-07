package defpackage;

import android.util.Range;
import android.util.Size;
import androidx.camera.core.x;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class rc3 implements pc3 {
    private final pc3 a;
    private final Range b;
    private final Range c;
    private final Set d;

    private rc3(pc3 pc3Var) {
        HashSet hashSet = new HashSet();
        this.d = hashSet;
        this.a = pc3Var;
        int iB = pc3Var.b();
        this.b = Range.create(Integer.valueOf(iB), Integer.valueOf(((int) Math.ceil(4096.0d / ((double) iB))) * iB));
        int iG = pc3Var.g();
        this.c = Range.create(Integer.valueOf(iG), Integer.valueOf(((int) Math.ceil(2160.0d / ((double) iG))) * iG));
        hashSet.addAll(oh1.f());
    }

    private void k(Size size) {
        this.d.add(size);
    }

    public static pc3 l(pc3 pc3Var, Size size) {
        if (!(pc3Var instanceof rc3)) {
            if (va0.a(oh1.class) != null) {
                pc3Var = new rc3(pc3Var);
            } else if (size != null && !pc3Var.a(size.getWidth(), size.getHeight())) {
                x.k("VideoEncoderInfoWrapper", String.format("Detected that the device does not support a size %s that should be valid in widths/heights = %s/%s", size, pc3Var.h(), pc3Var.j()));
                pc3Var = new rc3(pc3Var);
            }
        }
        if (size != null && (pc3Var instanceof rc3)) {
            ((rc3) pc3Var).k(size);
        }
        return pc3Var;
    }

    @Override // defpackage.pc3
    public int b() {
        return this.a.b();
    }

    @Override // defpackage.pc3
    public Range c() {
        return this.a.c();
    }

    @Override // defpackage.pc3
    public boolean d() {
        return this.a.d();
    }

    @Override // defpackage.pc3
    public Range e(int i) {
        b52.b(this.c.contains(Integer.valueOf(i)) && i % this.a.g() == 0, "Not supported height: " + i + " which is not in " + this.c + " or can not be divided by alignment " + this.a.g());
        return this.b;
    }

    @Override // defpackage.pc3
    public Range f(int i) {
        b52.b(this.b.contains(Integer.valueOf(i)) && i % this.a.b() == 0, "Not supported width: " + i + " which is not in " + this.b + " or can not be divided by alignment " + this.a.b());
        return this.c;
    }

    @Override // defpackage.pc3
    public int g() {
        return this.a.g();
    }

    @Override // defpackage.pc3
    public Range h() {
        return this.b;
    }

    @Override // defpackage.pc3
    public boolean i(int i, int i2) {
        if (this.a.i(i, i2)) {
            return true;
        }
        for (Size size : this.d) {
            if (size.getWidth() == i && size.getHeight() == i2) {
                return true;
            }
        }
        return this.b.contains(Integer.valueOf(i)) && this.c.contains(Integer.valueOf(i2)) && i % this.a.b() == 0 && i2 % this.a.g() == 0;
    }

    @Override // defpackage.pc3
    public Range j() {
        return this.c;
    }
}
