package defpackage;

import android.content.Context;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.b;

/* JADX INFO: loaded from: classes.dex */
public class wu0 {
    private final SparseIntArray a = new SparseIntArray();
    private b b;

    public wu0(b bVar) {
        a52.g(bVar);
        this.b = bVar;
    }

    public void a() {
        this.a.clear();
    }

    public int b(Context context, a.f fVar) {
        a52.g(context);
        a52.g(fVar);
        int iH = 0;
        if (!fVar.k()) {
            return 0;
        }
        int iL = fVar.l();
        int i = this.a.get(iL, -1);
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= this.a.size()) {
                iH = i;
                break;
            }
            int iKeyAt = this.a.keyAt(i2);
            if (iKeyAt > iL && this.a.get(iKeyAt) == 0) {
                break;
            }
            i2++;
        }
        if (iH == -1) {
            iH = this.b.h(context, iL);
        }
        this.a.put(iL, iH);
        return iH;
    }
}
