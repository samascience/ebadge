package defpackage;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public final class kh2 {
    private final String a;
    private final byte[] b;
    private final int c;
    private nh2[] d;
    private final BarcodeFormat e;
    private Map f;
    private final long g;

    public kh2(String str, byte[] bArr, nh2[] nh2VarArr, BarcodeFormat barcodeFormat) {
        this(str, bArr, nh2VarArr, barcodeFormat, System.currentTimeMillis());
    }

    public void a(nh2[] nh2VarArr) {
        nh2[] nh2VarArr2 = this.d;
        if (nh2VarArr2 == null) {
            this.d = nh2VarArr;
            return;
        }
        if (nh2VarArr == null || nh2VarArr.length <= 0) {
            return;
        }
        nh2[] nh2VarArr3 = new nh2[nh2VarArr2.length + nh2VarArr.length];
        System.arraycopy(nh2VarArr2, 0, nh2VarArr3, 0, nh2VarArr2.length);
        System.arraycopy(nh2VarArr, 0, nh2VarArr3, nh2VarArr2.length, nh2VarArr.length);
        this.d = nh2VarArr3;
    }

    public BarcodeFormat b() {
        return this.e;
    }

    public byte[] c() {
        return this.b;
    }

    public Map d() {
        return this.f;
    }

    public nh2[] e() {
        return this.d;
    }

    public String f() {
        return this.a;
    }

    public void g(Map map) {
        if (map != null) {
            Map map2 = this.f;
            if (map2 == null) {
                this.f = map;
            } else {
                map2.putAll(map);
            }
        }
    }

    public void h(ResultMetadataType resultMetadataType, Object obj) {
        if (this.f == null) {
            this.f = new EnumMap(ResultMetadataType.class);
        }
        this.f.put(resultMetadataType, obj);
    }

    public String toString() {
        return this.a;
    }

    public kh2(String str, byte[] bArr, nh2[] nh2VarArr, BarcodeFormat barcodeFormat, long j) {
        this(str, bArr, bArr == null ? 0 : bArr.length * 8, nh2VarArr, barcodeFormat, j);
    }

    public kh2(String str, byte[] bArr, int i, nh2[] nh2VarArr, BarcodeFormat barcodeFormat, long j) {
        this.a = str;
        this.b = bArr;
        this.c = i;
        this.d = nh2VarArr;
        this.e = barcodeFormat;
        this.f = null;
        this.g = j;
    }
}
