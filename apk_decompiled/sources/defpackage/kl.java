package defpackage;

import com.legend.mywatch.sdk.mywatchsdklib.android.model.RecordInfoModel;

/* JADX INFO: loaded from: classes3.dex */
public abstract class kl {
    public static final a a = new a(null);

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        private final RecordInfoModel a(byte[] bArr, int i) {
            int i2 = 0;
            for (int i3 = 0; i3 < 4; i3++) {
                i2 |= (bArr[i3] & 255) << (i3 * 8);
            }
            return new RecordInfoModel(i2 & 131071, (i2 >> 17) & 127, ((i2 >> 24) & 1) == 1, ((i2 >> 25) & 1) == 1, i);
        }

        public final RecordInfoModel b(byte[] bArr) {
            if (bArr == null) {
                return null;
            }
            if (bArr.length == 0) {
                return null;
            }
            if (bArr.length >= 12) {
                byte[] bArrC = da.c(bArr, 6, 10);
                int i = (bArr[11] & 255) == 221 ? bArr[10] & 255 : 0;
                p31.c(bArrC);
                return a(bArrC, i);
            }
            if (bArr.length != 10) {
                return null;
            }
            byte[] bArrC2 = da.c(bArr, 6, 10);
            p31.c(bArrC2);
            return a(bArrC2, 0);
        }

        private a() {
        }
    }
}
