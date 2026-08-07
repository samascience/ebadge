package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class il1 extends nw1 {
    private final nw1[] a;

    public il1(Map map) {
        Collection collection = map == null ? null : (Collection) map.get(DecodeHintType.POSSIBLE_FORMATS);
        boolean z = (map == null || map.get(DecodeHintType.ASSUME_CODE_39_CHECK_DIGIT) == null) ? false : true;
        ArrayList arrayList = new ArrayList();
        if (collection != null) {
            if (collection.contains(BarcodeFormat.EAN_13) || collection.contains(BarcodeFormat.UPC_A) || collection.contains(BarcodeFormat.EAN_8) || collection.contains(BarcodeFormat.UPC_E)) {
                arrayList.add(new kl1(map));
            }
            if (collection.contains(BarcodeFormat.CODE_39)) {
                arrayList.add(new xy(z));
            }
            if (collection.contains(BarcodeFormat.CODE_93)) {
                arrayList.add(new yy());
            }
            if (collection.contains(BarcodeFormat.CODE_128)) {
                arrayList.add(new wy());
            }
            if (collection.contains(BarcodeFormat.ITF)) {
                arrayList.add(new ty0());
            }
            if (collection.contains(BarcodeFormat.CODABAR)) {
                arrayList.add(new vy());
            }
            if (collection.contains(BarcodeFormat.RSS_14)) {
                arrayList.add(new y92());
            }
            if (collection.contains(BarcodeFormat.RSS_EXPANDED)) {
                arrayList.add(new z92());
            }
        }
        if (arrayList.isEmpty()) {
            arrayList.add(new kl1(map));
            arrayList.add(new xy());
            arrayList.add(new vy());
            arrayList.add(new yy());
            arrayList.add(new wy());
            arrayList.add(new ty0());
            arrayList.add(new y92());
            arrayList.add(new z92());
        }
        this.a = (nw1[]) arrayList.toArray(new nw1[arrayList.size()]);
    }

    @Override // defpackage.nw1, defpackage.cd2
    public void b() {
        for (nw1 nw1Var : this.a) {
            nw1Var.b();
        }
    }

    @Override // defpackage.nw1
    public kh2 c(int i, uh uhVar, Map map) throws NotFoundException {
        for (nw1 nw1Var : this.a) {
            try {
                return nw1Var.c(i, uhVar, map);
            } catch (ReaderException unused) {
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
