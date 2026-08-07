package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class x73 extends b83 {
    private final b83 i = new ue0();

    private static kh2 r(kh2 kh2Var) throws FormatException {
        String strF = kh2Var.f();
        if (strF.charAt(0) == '0') {
            return new kh2(strF.substring(1), null, kh2Var.e(), BarcodeFormat.UPC_A);
        }
        throw FormatException.getFormatInstance();
    }

    @Override // defpackage.nw1, defpackage.cd2
    public kh2 a(th thVar, Map map) {
        return r(this.i.a(thVar, map));
    }

    @Override // defpackage.b83, defpackage.nw1
    public kh2 c(int i, uh uhVar, Map map) {
        return r(this.i.c(i, uhVar, map));
    }

    @Override // defpackage.b83
    protected int l(uh uhVar, int[] iArr, StringBuilder sb) {
        return this.i.l(uhVar, iArr, sb);
    }

    @Override // defpackage.b83
    public kh2 m(int i, uh uhVar, int[] iArr, Map map) {
        return r(this.i.m(i, uhVar, iArr, map));
    }

    @Override // defpackage.b83
    BarcodeFormat q() {
        return BarcodeFormat.UPC_A;
    }
}
