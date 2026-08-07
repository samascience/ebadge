package no.nordicsemi.android.support.v18.scanner;

import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class n {
    private final int a;
    private final List b;
    private final SparseArray c;
    private final Map d;
    private final int e;
    private final String f;
    private final byte[] g;

    private n(List list, SparseArray sparseArray, Map map, int i, int i2, String str, byte[] bArr) {
        this.b = list;
        this.c = sparseArray;
        this.d = map;
        this.f = str;
        this.a = i;
        this.e = i2;
        this.g = bArr;
    }

    private static byte[] a(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0072  */
    /* JADX WARN: Code duplicated, block: B:37:0x0097  */
    /* JADX WARN: Code duplicated, block: B:38:0x009a  */
    /* JADX WARN: Code duplicated, block: B:40:0x009e  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:44:0x00b3 A[Catch: Exception -> 0x00ce, TryCatch #0 {Exception -> 0x00ce, blocks: (B:6:0x0010, B:8:0x0013, B:11:0x001e, B:17:0x0034, B:46:0x00bb, B:19:0x0039, B:20:0x003d, B:22:0x004a, B:23:0x004f, B:25:0x0058, B:26:0x005d, B:28:0x0064, B:29:0x0069, B:30:0x006d, B:32:0x0077, B:34:0x008c, B:35:0x0091, B:42:0x00a1, B:44:0x00b3, B:45:0x00b8, B:47:0x00bf), top: B:51:0x0010 }] */
    static n h(byte[] bArr) {
        int i;
        if (bArr == null) {
            return null;
        }
        int i2 = 0;
        HashMap map = null;
        String str = null;
        int i3 = -1;
        byte b = -2147483648;
        ArrayList arrayList = null;
        SparseArray sparseArray = null;
        while (i2 < bArr.length) {
            try {
                int i4 = i2 + 1;
                int i5 = bArr[i2] & 255;
                if (i5 == 0) {
                    return new n(arrayList, sparseArray, map, i3, b, str, bArr);
                }
                int i6 = i5 - 1;
                int i7 = i2 + 2;
                int i8 = bArr[i4] & 255;
                if (i8 == 22) {
                    if (i8 == 32) {
                        i = 4;
                    } else if (i8 == 33) {
                        i = 16;
                    } else {
                        i = 2;
                    }
                    ParcelUuid parcelUuidA = j.a(a(bArr, i7, i));
                    byte[] bArrA = a(bArr, i7 + i, i6 - i);
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(parcelUuidA, bArrA);
                } else if (i8 == 255) {
                    int i9 = ((bArr[i2 + 3] & 255) << 8) + (255 & bArr[i7]);
                    byte[] bArrA2 = a(bArr, i2 + 4, i5 - 3);
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                    }
                    sparseArray.put(i9, bArrA2);
                } else if (i8 != 32 && i8 != 33) {
                    switch (i8) {
                        case 1:
                            i3 = bArr[i7] & 255;
                            break;
                        case 2:
                        case 3:
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            i(bArr, i7, i6, 2, arrayList);
                            break;
                        case 4:
                        case 5:
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            i(bArr, i7, i6, 4, arrayList);
                            break;
                        case 6:
                        case 7:
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            i(bArr, i7, i6, 16, arrayList);
                            break;
                        case 8:
                        case 9:
                            str = new String(a(bArr, i7, i6));
                            break;
                        case 10:
                            b = bArr[i7];
                            break;
                    }
                } else {
                    if (i8 == 32) {
                        i = 4;
                    } else if (i8 == 33) {
                        i = 16;
                    } else {
                        i = 2;
                    }
                    ParcelUuid parcelUuidA2 = j.a(a(bArr, i7, i));
                    byte[] bArrA3 = a(bArr, i7 + i, i6 - i);
                    if (map == null) {
                        map = new HashMap();
                    }
                    map.put(parcelUuidA2, bArrA3);
                }
                i2 = i7 + i6;
            } catch (Exception unused) {
                Log.e("ScanRecord", "unable to parse scan record: " + Arrays.toString(bArr));
                return new n(null, null, null, -1, Integer.MIN_VALUE, null, bArr);
            }
        }
        return new n(arrayList, sparseArray, map, i3, b, str, bArr);
    }

    private static int i(byte[] bArr, int i, int i2, int i3, List list) {
        while (i2 > 0) {
            list.add(j.a(a(bArr, i, i3)));
            i2 -= i3;
            i += i3;
        }
        return i;
    }

    public byte[] b() {
        return this.g;
    }

    public String c() {
        return this.f;
    }

    public SparseArray d() {
        return this.c;
    }

    public byte[] e(int i) {
        SparseArray sparseArray = this.c;
        if (sparseArray == null) {
            return null;
        }
        return (byte[]) sparseArray.get(i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || n.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.g, ((n) obj).g);
    }

    public byte[] f(ParcelUuid parcelUuid) {
        Map map;
        if (parcelUuid == null || (map = this.d) == null) {
            return null;
        }
        return (byte[]) map.get(parcelUuid);
    }

    public List g() {
        return this.b;
    }

    public String toString() {
        return "ScanRecord [advertiseFlags=" + this.a + ", serviceUuids=" + this.b + ", manufacturerSpecificData=" + i.a(this.c) + ", serviceData=" + i.b(this.d) + ", txPowerLevel=" + this.e + ", deviceName=" + this.f + "]";
    }
}
