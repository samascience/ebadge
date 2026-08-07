package defpackage;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ai implements ah2 {
    private final Bitmap.CompressFormat a;
    private final int b;

    public ai() {
        this(Bitmap.CompressFormat.JPEG, 100);
    }

    @Override // defpackage.ah2
    public qg2 a(qg2 qg2Var, rx1 rx1Var) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) qg2Var.get()).compress(this.a, this.b, byteArrayOutputStream);
        qg2Var.a();
        return new qp(byteArrayOutputStream.toByteArray());
    }

    public ai(Bitmap.CompressFormat compressFormat, int i) {
        this.a = compressFormat;
        this.b = i;
    }
}
