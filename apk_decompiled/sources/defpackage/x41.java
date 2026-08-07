package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;
import androidx.camera.core.ImageCaptureException;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
final class x41 implements uw1 {
    x41() {
    }

    private Bitmap b(byte[] bArr, Rect rect) throws ImageCaptureException {
        try {
            return BitmapRegionDecoder.newInstance(bArr, 0, bArr.length, false).decodeRegion(rect, new BitmapFactory.Options());
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to decode JPEG.", e);
        }
    }

    @Override // defpackage.uw1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public xy1 apply(xy1 xy1Var) throws ImageCaptureException {
        Rect rectB = xy1Var.b();
        Bitmap bitmapB = b((byte[]) xy1Var.c(), rectB);
        bj0 bj0VarD = xy1Var.d();
        Objects.requireNonNull(bj0VarD);
        return xy1.j(bitmapB, bj0VarD, new Rect(0, 0, bitmapB.getWidth(), bitmapB.getHeight()), xy1Var.f(), y43.u(xy1Var.g(), rectB), xy1Var.a());
    }
}
