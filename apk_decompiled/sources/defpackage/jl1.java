package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class jl1 implements cd2 {
    private Map a;
    private cd2[] b;

    private kh2 c(th thVar) throws NotFoundException {
        cd2[] cd2VarArr = this.b;
        if (cd2VarArr != null) {
            for (cd2 cd2Var : cd2VarArr) {
                try {
                    return cd2Var.a(thVar, this.a);
                } catch (ReaderException unused) {
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // defpackage.cd2
    public kh2 a(th thVar, Map map) {
        e(map);
        return c(thVar);
    }

    @Override // defpackage.cd2
    public void b() {
        cd2[] cd2VarArr = this.b;
        if (cd2VarArr != null) {
            for (cd2 cd2Var : cd2VarArr) {
                cd2Var.b();
            }
        }
    }

    public kh2 d(th thVar) {
        if (this.b == null) {
            e(null);
        }
        return c(thVar);
    }

    public void e(Map map) {
        this.a = map;
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            boolean z2 = collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.UPC_E) || collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.CODABAR) || collection.contains(BarcodeFormat.CODE_39) || collection.contains(BarcodeFormat.CODE_93) || collection.contains(BarcodeFormat.CODE_128) || collection.contains(BarcodeFormat.ITF) || collection.contains(BarcodeFormat.RSS_14) || collection.contains(BarcodeFormat.RSS_EXPANDED);
            if (z2 && !z) {
                arrayList.add(new il1(map));
            }
            if (collection.contains(BarcodeFormat.QR_CODE)) {
                arrayList.add(new n92());
            }
            if (collection.contains(BarcodeFormat.DATA_MATRIX)) {
                arrayList.add(new m60());
            }
            if (collection.contains(BarcodeFormat.AZTEC)) {
                arrayList.add(new be());
            }
            if (collection.contains(BarcodeFormat.PDF_417)) {
                arrayList.add(new oy1());
            }
            if (collection.contains(BarcodeFormat.MAXICODE)) {
                arrayList.add(new ih1());
            }
            if (z2 && z) {
                arrayList.add(new il1(map));
            }
        }
        if (arrayList.isEmpty()) {
            if (!z) {
                arrayList.add(new il1(map));
            }
            arrayList.add(new n92());
            arrayList.add(new m60());
            arrayList.add(new be());
            arrayList.add(new oy1());
            arrayList.add(new ih1());
            if (z) {
                arrayList.add(new il1(map));
            }
        }
        this.b = (cd2[]) arrayList.toArray(new cd2[arrayList.size()]);
    }
}
