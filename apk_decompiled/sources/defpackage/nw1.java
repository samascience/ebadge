package defpackage;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: classes3.dex */
public abstract class nw1 implements cd2 {
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    private kh2 d(th thVar, Map map) throws NotFoundException {
        Map map2;
        int i;
        int i2;
        Map map3 = map;
        int iD = thVar.d();
        int iC = thVar.c();
        uh uhVar = new uh(iD);
        int i3 = iC >> 1;
        int i4 = 0;
        int i5 = 1;
        boolean z = map3 != null && map3.containsKey(DecodeHintType.TRY_HARDER);
        int iMax = Math.max(1, iC >> (z ? 8 : 5));
        int i6 = z ? iC : 15;
        int i7 = 0;
        while (i7 < i6) {
            int i8 = i7 + 1;
            int i9 = i8 / 2;
            if ((i7 & 1) != 0) {
                i9 = -i9;
            }
            int i10 = (i9 * iMax) + i3;
            if (i10 < 0 || i10 >= iC) {
                break;
            }
            try {
                uhVar = thVar.b(i10, uhVar);
                int i11 = i4;
                while (i11 < 2) {
                    if (i11 == i5) {
                        uhVar.j();
                        if (map3 != null) {
                            DecodeHintType decodeHintType = DecodeHintType.NEED_RESULT_POINT_CALLBACK;
                            if (map3.containsKey(decodeHintType)) {
                                EnumMap enumMap = new EnumMap(DecodeHintType.class);
                                enumMap.putAll(map3);
                                enumMap.remove(decodeHintType);
                                map3 = enumMap;
                            }
                        }
                    }
                    try {
                        kh2 kh2VarC = c(i10, uhVar, map3);
                        if (i11 == i5) {
                            try {
                                kh2VarC.h(ResultMetadataType.ORIENTATION, Integer.valueOf(Opcodes.GETFIELD));
                                nh2[] nh2VarArrE = kh2VarC.e();
                                if (nh2VarArrE != null) {
                                    map2 = map3;
                                    float f = iD;
                                    try {
                                        i = iD;
                                        try {
                                            nh2VarArrE[0] = new nh2((f - nh2VarArrE[i4].c()) - 1.0f, nh2VarArrE[i4].d());
                                            i2 = 1;
                                            try {
                                                nh2VarArrE[1] = new nh2((f - nh2VarArrE[1].c()) - 1.0f, nh2VarArrE[1].d());
                                            } catch (ReaderException unused) {
                                                continue;
                                                i11++;
                                                i5 = i2;
                                                map3 = map2;
                                                iD = i;
                                                i4 = 0;
                                            }
                                        } catch (ReaderException unused2) {
                                            i2 = 1;
                                            i11++;
                                            i5 = i2;
                                            map3 = map2;
                                            iD = i;
                                            i4 = 0;
                                        }
                                    } catch (ReaderException unused3) {
                                        i = iD;
                                        i2 = 1;
                                        i11++;
                                        i5 = i2;
                                        map3 = map2;
                                        iD = i;
                                        i4 = 0;
                                    }
                                }
                            } catch (ReaderException unused4) {
                                map2 = map3;
                            }
                        }
                        return kh2VarC;
                    } catch (ReaderException unused5) {
                        map2 = map3;
                        i = iD;
                        i2 = i5;
                    }
                }
            } catch (NotFoundException unused6) {
            }
            i7 = i8;
            i5 = i5;
            iD = iD;
            i4 = 0;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    protected static float e(int[] iArr, int[] iArr2, float f) {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i += iArr[i3];
            i2 += iArr2[i3];
        }
        if (i < i2) {
            return Float.POSITIVE_INFINITY;
        }
        float f2 = i;
        float f3 = f2 / i2;
        float f4 = f * f3;
        float f5 = 0.0f;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            float f6 = iArr2[i4] * f3;
            float f7 = i5;
            float f8 = f7 > f6 ? f7 - f6 : f6 - f7;
            if (f8 > f4) {
                return Float.POSITIVE_INFINITY;
            }
            f5 += f8;
        }
        return f5 / f2;
    }

    protected static void f(uh uhVar, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        int i2 = 0;
        Arrays.fill(iArr, 0, length, 0);
        int iG = uhVar.g();
        if (i >= iG) {
            throw NotFoundException.getNotFoundInstance();
        }
        boolean z = !uhVar.c(i);
        while (i < iG) {
            if (!(uhVar.c(i) ^ z)) {
                i2++;
                if (i2 == length) {
                    break;
                }
                iArr[i2] = 1;
                z = !z;
            } else {
                iArr[i2] = iArr[i2] + 1;
            }
            i++;
        }
        if (i2 != length) {
            if (i2 != length - 1 || i != iG) {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    protected static void g(uh uhVar, int i, int[] iArr) throws NotFoundException {
        int length = iArr.length;
        boolean zC = uhVar.c(i);
        while (i > 0 && length >= 0) {
            i--;
            if (uhVar.c(i) != zC) {
                length--;
                zC = !zC;
            }
        }
        if (length >= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        f(uhVar, i + 1, iArr);
    }

    @Override // defpackage.cd2
    public kh2 a(th thVar, Map map) throws NotFoundException {
        try {
            return d(thVar, map);
        } catch (NotFoundException e) {
            if (map == null || !map.containsKey(DecodeHintType.TRY_HARDER) || !thVar.e()) {
                throw e;
            }
            th thVarF = thVar.f();
            kh2 kh2VarD = d(thVarF, map);
            Map mapD = kh2VarD.d();
            int iIntValue = 270;
            if (mapD != null) {
                ResultMetadataType resultMetadataType = ResultMetadataType.ORIENTATION;
                if (mapD.containsKey(resultMetadataType)) {
                    iIntValue = (((Integer) mapD.get(resultMetadataType)).intValue() + 270) % 360;
                }
            }
            kh2VarD.h(ResultMetadataType.ORIENTATION, Integer.valueOf(iIntValue));
            nh2[] nh2VarArrE = kh2VarD.e();
            if (nh2VarArrE != null) {
                int iC = thVarF.c();
                for (int i = 0; i < nh2VarArrE.length; i++) {
                    nh2VarArrE[i] = new nh2((iC - nh2VarArrE[i].d()) - 1.0f, nh2VarArrE[i].c());
                }
            }
            return kh2VarD;
        }
    }

    @Override // defpackage.cd2
    public void b() {
    }

    public abstract kh2 c(int i, uh uhVar, Map map);
}
