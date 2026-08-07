package defpackage;

import android.graphics.Bitmap;
import android.os.Build;
import java.io.ByteArrayOutputStream;
import java.util.Objects;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes.dex */
class zh implements uw1 {

    private static class a {
        static boolean a(Bitmap bitmap) {
            return bitmap.hasGainmap();
        }
    }

    static abstract class b {
        b() {
        }

        static b c(xy1 xy1Var, int i) {
            return new wc(xy1Var, i);
        }

        abstract int a();

        abstract xy1 b();
    }

    zh() {
    }

    private static int b(Bitmap bitmap) {
        if (Build.VERSION.SDK_INT < 34 || !a.a(bitmap)) {
            return 256;
        }
        return DfuBaseService.ERROR_SERVICE_DISCOVERY_NOT_STARTED;
    }

    @Override // defpackage.uw1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public xy1 apply(b bVar) {
        xy1 xy1VarB = bVar.b();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) xy1VarB.c()).compress(Bitmap.CompressFormat.JPEG, bVar.a(), byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        bj0 bj0VarD = xy1VarB.d();
        Objects.requireNonNull(bj0VarD);
        return xy1.m(byteArray, bj0VarD, b((Bitmap) xy1VarB.c()), xy1VarB.h(), xy1VarB.b(), xy1VarB.f(), xy1VarB.g(), xy1VarB.a());
    }
}
