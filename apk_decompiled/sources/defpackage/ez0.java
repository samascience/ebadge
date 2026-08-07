package defpackage;

import android.graphics.Bitmap;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProcessingUtil;
import androidx.camera.core.b0;
import androidx.camera.core.internal.utils.ImageUtil;
import androidx.camera.core.v;
import androidx.camera.core.w;
import java.nio.ByteBuffer;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes.dex */
public class ez0 implements uw1 {
    @Override // defpackage.uw1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap apply(xy1 xy1Var) throws Throwable {
        b0 b0Var;
        Bitmap bitmapK;
        b0 b0Var2 = null;
        try {
            try {
                if (xy1Var.e() == 35) {
                    v vVar = (v) xy1Var.c();
                    boolean z = xy1Var.f() % Opcodes.GETFIELD != 0;
                    b0Var = new b0(w.a(z ? vVar.getHeight() : vVar.getWidth(), z ? vVar.getWidth() : vVar.getHeight(), 1, 2));
                    try {
                        v vVarG = ImageProcessingUtil.g(vVar, b0Var, ByteBuffer.allocateDirect(vVar.getWidth() * vVar.getHeight() * 4), xy1Var.f(), false);
                        vVar.close();
                        if (vVarG == null) {
                            throw new ImageCaptureException(0, "Can't covert YUV to RGB", null);
                        }
                        bitmapK = ImageUtil.b(vVarG);
                        vVarG.close();
                    } catch (UnsupportedOperationException e) {
                        e = e;
                        throw new ImageCaptureException(0, "Can't convert " + (xy1Var.e() == 35 ? "YUV" : "JPEG") + " to bitmap", e);
                    } catch (Throwable th) {
                        th = th;
                        b0Var2 = b0Var;
                        if (b0Var2 != null) {
                            b0Var2.close();
                        }
                        throw th;
                    }
                } else {
                    if (xy1Var.e() != 256) {
                        throw new IllegalArgumentException("Invalid postview image format : " + xy1Var.e());
                    }
                    v vVar2 = (v) xy1Var.c();
                    Bitmap bitmapB = ImageUtil.b(vVar2);
                    vVar2.close();
                    b0Var = null;
                    bitmapK = ImageUtil.k(bitmapB, xy1Var.f());
                }
                if (b0Var != null) {
                    b0Var.close();
                }
                return bitmapK;
            } catch (UnsupportedOperationException e2) {
                e = e2;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
