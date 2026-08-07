package defpackage;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes3.dex */
public final class ng3 {
    public static final ng3 a = new ng3();

    private ng3() {
    }

    public final boolean a(SparseArray sparseArray, int i, boolean z) {
        if (z) {
            return (sparseArray == null || sparseArray.size() == 0 || ((byte) ((sparseArray.keyAt(0) >> 8) & 255)) != -86) ? false : true;
        }
        return (sparseArray == null || sparseArray.size() == 0 || sparseArray.keyAt(0) != i) ? false : true;
    }
}
