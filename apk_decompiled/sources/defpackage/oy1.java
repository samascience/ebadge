package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import com.google.zxing.pdf417.decoder.i;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class oy1 implements cd2 {
    private static kh2[] c(th thVar, Map map, boolean z) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        ny1 ny1VarB = t90.b(thVar, map, z);
        for (nh2[] nh2VarArr : ny1VarB.b()) {
            q70 q70VarI = i.i(ny1VarB.a(), nh2VarArr[4], nh2VarArr[5], nh2VarArr[6], nh2VarArr[7], f(nh2VarArr), d(nh2VarArr));
            kh2 kh2Var = new kh2(q70VarI.h(), q70VarI.e(), nh2VarArr, BarcodeFormat.PDF_417);
            kh2Var.h(ResultMetadataType.ERROR_CORRECTION_LEVEL, q70VarI.b());
            py1 py1Var = (py1) q70VarI.d();
            if (py1Var != null) {
                kh2Var.h(ResultMetadataType.PDF417_EXTRA_METADATA, py1Var);
            }
            arrayList.add(kh2Var);
        }
        return (kh2[]) arrayList.toArray(new kh2[arrayList.size()]);
    }

    private static int d(nh2[] nh2VarArr) {
        return Math.max(Math.max(e(nh2VarArr[0], nh2VarArr[4]), (e(nh2VarArr[6], nh2VarArr[2]) * 17) / 18), Math.max(e(nh2VarArr[1], nh2VarArr[5]), (e(nh2VarArr[7], nh2VarArr[3]) * 17) / 18));
    }

    private static int e(nh2 nh2Var, nh2 nh2Var2) {
        if (nh2Var == null || nh2Var2 == null) {
            return 0;
        }
        return (int) Math.abs(nh2Var.c() - nh2Var2.c());
    }

    private static int f(nh2[] nh2VarArr) {
        return Math.min(Math.min(g(nh2VarArr[0], nh2VarArr[4]), (g(nh2VarArr[6], nh2VarArr[2]) * 17) / 18), Math.min(g(nh2VarArr[1], nh2VarArr[5]), (g(nh2VarArr[7], nh2VarArr[3]) * 17) / 18));
    }

    private static int g(nh2 nh2Var, nh2 nh2Var2) {
        if (nh2Var == null || nh2Var2 == null) {
            return Integer.MAX_VALUE;
        }
        return (int) Math.abs(nh2Var.c() - nh2Var2.c());
    }

    @Override // defpackage.cd2
    public kh2 a(th thVar, Map map) throws NotFoundException {
        kh2 kh2Var;
        kh2[] kh2VarArrC = c(thVar, map, false);
        if (kh2VarArrC == null || kh2VarArrC.length == 0 || (kh2Var = kh2VarArrC[0]) == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        return kh2Var;
    }

    @Override // defpackage.cd2
    public void b() {
    }
}
