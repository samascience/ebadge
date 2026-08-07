package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class kl1 extends nw1 {
    private final b83[] a;

    public kl1(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13)) {
                arrayList.add(new ue0());
            } else if (collection.contains(BarcodeFormat.UPC_A)) {
                arrayList.add(new x73());
            }
            if (collection.contains(BarcodeFormat.EAN_8)) {
                arrayList.add(new ve0());
            }
            if (collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new c83());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new ue0());
            arrayList.add(new ve0());
            arrayList.add(new c83());
        }
        this.a = (b83[]) arrayList.toArray(new b83[arrayList.size()]);
    }

    @Override // defpackage.nw1, defpackage.cd2
    public void b() {
        for (b83 b83Var : this.a) {
            b83Var.b();
        }
    }

    @Override // defpackage.nw1
    public kh2 c(int i, uh uhVar, Map map) throws NotFoundException {
        int[] iArrP = b83.p(uhVar);
        for (b83 b83Var : this.a) {
            try {
                kh2 kh2VarM = b83Var.m(i, uhVar, iArrP, map);
                boolean z = kh2VarM.b() == BarcodeFormat.EAN_13 && kh2VarM.f().charAt(0) == '0';
                Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
                boolean z2 = collection == null || collection.contains(BarcodeFormat.UPC_A);
                if (!z || !z2) {
                    return kh2VarM;
                }
                kh2 kh2Var = new kh2(kh2VarM.f().substring(1), kh2VarM.c(), kh2VarM.e(), BarcodeFormat.UPC_A);
                kh2Var.g(kh2VarM.d());
                return kh2Var;
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
