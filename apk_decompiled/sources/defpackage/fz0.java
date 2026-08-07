package defpackage;

import android.graphics.Rect;
import android.util.Size;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.v;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class fz0 implements uw1 {
    private final d51 a;

    static abstract class a {
        a() {
        }

        static a c(xy1 xy1Var, int i) {
            return new fd(xy1Var, i);
        }

        abstract int a();

        abstract xy1 b();
    }

    fz0(w92 w92Var) {
        this.a = new d51(w92Var);
    }

    private static bj0 b(byte[] bArr) throws ImageCaptureException {
        try {
            return bj0.k(new ByteArrayInputStream(bArr));
        } catch (IOException e) {
            throw new ImageCaptureException(0, "Failed to extract Exif from YUV-generated JPEG", e);
        }
    }

    private xy1 c(a aVar, int i) {
        xy1 xy1VarB = aVar.b();
        byte[] bArrA = this.a.a((v) xy1VarB.c());
        bj0 bj0VarD = xy1VarB.d();
        Objects.requireNonNull(bj0VarD);
        return xy1.m(bArrA, bj0VarD, i, xy1VarB.h(), xy1VarB.b(), xy1VarB.f(), xy1VarB.g(), xy1VarB.a());
    }

    private xy1 d(a aVar) throws ImageCaptureException {
        xy1 xy1VarB = aVar.b();
        v vVar = (v) xy1VarB.c();
        Rect rectB = xy1VarB.b();
        try {
            byte[] bArrL = ImageUtil.l(vVar, rectB, aVar.a(), xy1VarB.f());
            return xy1.m(bArrL, b(bArrL), 256, new Size(rectB.width(), rectB.height()), new Rect(0, 0, rectB.width(), rectB.height()), xy1VarB.f(), y43.u(xy1VarB.g(), rectB), xy1VarB.a());
        } catch (ImageUtil.CodecFailedException e) {
            throw new ImageCaptureException(1, "Failed to encode the image to JPEG.", e);
        }
    }

    @Override // defpackage.uw1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public xy1 apply(a aVar) {
        xy1 xy1VarD;
        try {
            int iE = aVar.b().e();
            if (iE != 35) {
                if (iE != 256 && iE != 4101) {
                    throw new IllegalArgumentException("Unexpected format: " + iE);
                }
                xy1VarD = c(aVar, iE);
            } else {
                xy1VarD = d(aVar);
            }
            ((v) aVar.b().c()).close();
            return xy1VarD;
        } catch (Throwable th) {
            ((v) aVar.b().c()).close();
            throw th;
        }
    }
}
