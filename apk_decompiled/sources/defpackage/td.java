package defpackage;

import android.graphics.Matrix;
import android.graphics.Rect;
import androidx.camera.core.u;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes.dex */
final class td extends i03 {
    private final Executor b;
    private final u.f c;
    private final u.g d;
    private final Rect e;
    private final Matrix f;
    private final int g;
    private final int h;
    private final int i;
    private final List j;

    td(Executor executor, u.e eVar, u.f fVar, u.g gVar, Rect rect, Matrix matrix, int i, int i2, int i3, List list) {
        if (executor == null) {
            throw new NullPointerException("Null appExecutor");
        }
        this.b = executor;
        this.c = fVar;
        this.d = gVar;
        if (rect == null) {
            throw new NullPointerException("Null cropRect");
        }
        this.e = rect;
        if (matrix == null) {
            throw new NullPointerException("Null sensorToBufferTransform");
        }
        this.f = matrix;
        this.g = i;
        this.h = i2;
        this.i = i3;
        if (list == null) {
            throw new NullPointerException("Null sessionConfigCameraCaptureCallbacks");
        }
        this.j = list;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof i03)) {
            return false;
        }
        i03 i03Var = (i03) obj;
        if (this.b.equals(i03Var.f())) {
            i03Var.i();
            u.f fVar = this.c;
            if (fVar != null ? fVar.equals(i03Var.k()) : i03Var.k() == null) {
                u.g gVar = this.d;
                if (gVar != null ? gVar.equals(i03Var.l()) : i03Var.l() == null) {
                    if (this.e.equals(i03Var.h()) && this.f.equals(i03Var.n()) && this.g == i03Var.m() && this.h == i03Var.j() && this.i == i03Var.g() && this.j.equals(i03Var.o())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // defpackage.i03
    Executor f() {
        return this.b;
    }

    @Override // defpackage.i03
    int g() {
        return this.i;
    }

    @Override // defpackage.i03
    Rect h() {
        return this.e;
    }

    public int hashCode() {
        int iHashCode = (this.b.hashCode() ^ 1000003) * (-721379959);
        u.f fVar = this.c;
        int iHashCode2 = (iHashCode ^ (fVar == null ? 0 : fVar.hashCode())) * 1000003;
        u.g gVar = this.d;
        return ((((((((((((iHashCode2 ^ (gVar != null ? gVar.hashCode() : 0)) * 1000003) ^ this.e.hashCode()) * 1000003) ^ this.f.hashCode()) * 1000003) ^ this.g) * 1000003) ^ this.h) * 1000003) ^ this.i) * 1000003) ^ this.j.hashCode();
    }

    @Override // defpackage.i03
    public u.e i() {
        return null;
    }

    @Override // defpackage.i03
    int j() {
        return this.h;
    }

    @Override // defpackage.i03
    public u.f k() {
        return this.c;
    }

    @Override // defpackage.i03
    u.g l() {
        return this.d;
    }

    @Override // defpackage.i03
    int m() {
        return this.g;
    }

    @Override // defpackage.i03
    Matrix n() {
        return this.f;
    }

    @Override // defpackage.i03
    List o() {
        return this.j;
    }

    public String toString() {
        return "TakePictureRequest{appExecutor=" + this.b + ", inMemoryCallback=" + ((Object) null) + ", onDiskCallback=" + this.c + ", outputFileOptions=" + this.d + ", cropRect=" + this.e + ", sensorToBufferTransform=" + this.f + ", rotationDegrees=" + this.g + ", jpegQuality=" + this.h + ", captureMode=" + this.i + ", sessionConfigCameraCaptureCallbacks=" + this.j + "}";
    }
}
