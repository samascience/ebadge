package defpackage;

import com.legend.mywatch.sdk.mywatchsdklib.android.event.AIGlassesOtaStatusEvent;
import com.legend.mywatch.sdk.mywatchsdklib.android.event.AIGlassesWanStatusEvent;
import com.tencent.connect.common.Constants;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.d;

/* JADX INFO: loaded from: classes3.dex */
public final class e92 {
    public static final a a = new a(null);
    private static volatile e92 b;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public final e92 a() {
            e92 e92Var = e92.b;
            if (e92Var == null) {
                synchronized (this) {
                    e92Var = e92.b;
                    if (e92Var == null) {
                        e92Var = new e92(null);
                        e92.b = e92Var;
                    }
                }
            }
            return e92Var;
        }

        private a() {
        }
    }

    public /* synthetic */ e92(y70 y70Var) {
        this();
    }

    private final void c(ng ngVar) {
        tg3.g.b(ngVar);
    }

    /* JADX WARN: Code duplicated, block: B:133:0x0220  */
    /* JADX WARN: Code duplicated, block: B:169:0x029b  */
    /* JADX WARN: Code duplicated, block: B:286:0x0427  */
    /* JADX WARN: Multi-variable type inference failed */
    private final ng e(byte[] bArr) {
        Object objM69constructorimpl;
        Object objM69constructorimpl2;
        int i;
        int i2;
        int i3;
        Object objM69constructorimpl3;
        g0 g0Var;
        Object objM69constructorimpl4;
        e0 e0Var;
        Object objM69constructorimpl5;
        String str;
        k0 k0Var;
        Object objM69constructorimpl6;
        z zVar;
        int i4;
        int i5;
        Object objM69constructorimpl7;
        p pVar;
        Object objM69constructorimpl8;
        s sVar;
        ng uVar;
        int i6;
        int i7 = 3;
        int i8 = 2;
        int i9 = 0;
        int i10 = 0;
        byte b2 = bArr[0];
        if (b2 == 0) {
            return new c0(h(bArr, 1));
        }
        if (b2 == 1) {
            return new n(bArr[1] & 255);
        }
        if (b2 == 2) {
            return new m0((bArr[1] & 255) == 1);
        }
        if (b2 == 3) {
            return new x((bArr[1] & 255) == 1);
        }
        str = null;
        str = null;
        String str2 = null;
        if (b2 == 4) {
            if (bArr.length >= 9) {
                return new a0(g(bArr, 1), g(bArr, 5));
            }
        } else if (b2 == 5) {
            if (bArr.length >= 2) {
                return new i0(bArr[1] == 1);
            }
        } else if (b2 == 14) {
            if (bArr.length >= 2) {
                return new AIGlassesWanStatusEvent(AIGlassesWanStatusEvent.WanConnectionStatus.Companion.a(bArr[1]));
            }
        } else if (b2 != 6) {
            if (b2 == 7) {
                try {
                    Result.a aVar = Result.Companion;
                    int i11 = bArr[1] & 255;
                    Charset charset = StandardCharsets.UTF_8;
                    p31.e(charset, "UTF_8");
                    String str3 = new String(bArr, 2, i11, charset);
                    int i12 = bArr[2 + i11] & 255;
                    p31.e(charset, "UTF_8");
                    objM69constructorimpl = Result.m69constructorimpl(new q(str3, new String(bArr, i11 + 3, i12, charset)));
                } catch (Throwable th) {
                    Result.a aVar2 = Result.Companion;
                    objM69constructorimpl = Result.m69constructorimpl(d.a(th));
                }
                return (ng) (Result.m75isFailureimpl(objM69constructorimpl) ? null : objM69constructorimpl);
            }
            if (b2 == 8) {
                if (bArr.length >= 3) {
                    return new v(h(bArr, 1));
                }
            } else if (b2 == 9) {
                if (bArr.length >= 3) {
                    return new b0(h(bArr, 1));
                }
            } else if (b2 == 10) {
                if (bArr.length >= 3) {
                    return new j(h(bArr, 1));
                }
            } else if (b2 != 11) {
                if (b2 == 12) {
                    try {
                        Result.a aVar3 = Result.Companion;
                        ArrayList arrayList = new ArrayList();
                        int i13 = bArr[1] & 255;
                        int i14 = 2;
                        while (i9 < i13 && i14 + 2 <= bArr.length) {
                            int i15 = i14 + 1;
                            int i16 = bArr[i14] & 255;
                            int i17 = i14 + 2;
                            int i18 = bArr[i15] & 255;
                            int i19 = i17 + i18;
                            if (i19 > bArr.length) {
                                break;
                            }
                            Charset charset2 = gx.b;
                            String str4 = new String(bArr, i17, i18, charset2);
                            if (i19 >= bArr.length || (i3 = (i = i19 + 1) + (i2 = bArr[i19] & 255)) > bArr.length) {
                                break;
                            }
                            arrayList.add(new j0(i16, str4, new String(bArr, i, i2, charset2)));
                            i9++;
                            i14 = i3;
                        }
                        objM69constructorimpl2 = Result.m69constructorimpl(new h0(arrayList));
                    } catch (Throwable th2) {
                        Result.a aVar4 = Result.Companion;
                        objM69constructorimpl2 = Result.m69constructorimpl(d.a(th2));
                    }
                    return (ng) (Result.m75isFailureimpl(objM69constructorimpl2) ? null : objM69constructorimpl2);
                }
                if (b2 == 13) {
                    try {
                        Result.a aVar5 = Result.Companion;
                        if (bArr.length < 2) {
                            g0Var = null;
                        } else if ((bArr[1] & 255) == 0) {
                            g0Var = new g0(true, null, 2, null);
                        } else if (bArr.length < 3) {
                            g0Var = new g0(false, null, 2, null);
                        } else {
                            int i20 = bArr[2] & 255;
                            ArrayList arrayList2 = new ArrayList();
                            for (int i21 = 0; i21 < i20; i21++) {
                                int i22 = i7 + 1;
                                if (i22 > bArr.length) {
                                    break;
                                }
                                int i23 = bArr[i7] & 255;
                                i7 += 2;
                                arrayList2.add(new f0(i23, bArr[i22] & 255));
                            }
                            g0Var = new g0(false, arrayList2);
                        }
                        objM69constructorimpl3 = Result.m69constructorimpl(g0Var);
                    } catch (Throwable th3) {
                        Result.a aVar6 = Result.Companion;
                        objM69constructorimpl3 = Result.m69constructorimpl(d.a(th3));
                    }
                    return (ng) (Result.m75isFailureimpl(objM69constructorimpl3) ? null : objM69constructorimpl3);
                }
                if (b2 == 15) {
                    try {
                        Result.a aVar7 = Result.Companion;
                        if (bArr.length < 2) {
                            e0Var = null;
                        } else {
                            int i24 = bArr[1] & 255;
                            if (bArr.length >= i24 + 2) {
                                Charset charset3 = StandardCharsets.UTF_8;
                                p31.e(charset3, "UTF_8");
                                e0Var = new e0(new String(bArr, 2, i24, charset3));
                            } else {
                                e0Var = null;
                            }
                        }
                        objM69constructorimpl4 = Result.m69constructorimpl(e0Var);
                    } catch (Throwable th4) {
                        Result.a aVar8 = Result.Companion;
                        objM69constructorimpl4 = Result.m69constructorimpl(d.a(th4));
                    }
                    return (ng) (Result.m75isFailureimpl(objM69constructorimpl4) ? null : objM69constructorimpl4);
                }
                if (b2 == 16) {
                    if (bArr.length >= 2) {
                        return new i(bArr[1] & 255);
                    }
                } else if (b2 == 17) {
                    if (bArr.length >= 2) {
                        return new t(bArr[1] & 255);
                    }
                } else if (b2 != 18) {
                    if (b2 == 19) {
                        try {
                            Result.a aVar9 = Result.Companion;
                            if (bArr.length < 3) {
                                k0Var = null;
                            } else {
                                int i25 = bArr[1] & 255;
                                int i26 = i25 + 2;
                                int i27 = 3 + i25;
                                if (bArr.length < i27) {
                                    k0Var = null;
                                } else {
                                    String str5 = Constants.STR_EMPTY;
                                    if (i25 > 0) {
                                        Charset charset4 = StandardCharsets.UTF_8;
                                        p31.e(charset4, "UTF_8");
                                        str = new String(bArr, 2, i25, charset4);
                                    } else {
                                        str = Constants.STR_EMPTY;
                                    }
                                    int i28 = bArr[i26] & 255;
                                    if (bArr.length < i27 + i28) {
                                        k0Var = null;
                                    } else {
                                        if (i28 > 0) {
                                            Charset charset5 = StandardCharsets.UTF_8;
                                            p31.e(charset5, "UTF_8");
                                            str5 = new String(bArr, i27, i28, charset5);
                                        }
                                        k0Var = new k0(str, str5);
                                    }
                                }
                            }
                            objM69constructorimpl5 = Result.m69constructorimpl(k0Var);
                        } catch (Throwable th5) {
                            Result.a aVar10 = Result.Companion;
                            objM69constructorimpl5 = Result.m69constructorimpl(d.a(th5));
                        }
                        return (ng) (Result.m75isFailureimpl(objM69constructorimpl5) ? null : objM69constructorimpl5);
                    }
                    if (b2 == 20) {
                        try {
                            Result.a aVar11 = Result.Companion;
                            if (bArr.length < 2) {
                                zVar = null;
                            } else {
                                int i29 = bArr[1] & 255;
                                ArrayList arrayList3 = new ArrayList();
                                int i30 = 0;
                                while (i30 < i29) {
                                    int i31 = i8 + 1;
                                    if (i31 > bArr.length || (i5 = i31 + (i4 = bArr[i8] & 255)) > bArr.length) {
                                        break;
                                    }
                                    Charset charset6 = StandardCharsets.UTF_8;
                                    p31.e(charset6, "UTF_8");
                                    arrayList3.add(new l0(new String(bArr, i31, i4, charset6), 0));
                                    i30++;
                                    i8 = i5;
                                }
                                zVar = new z(arrayList3);
                            }
                            objM69constructorimpl6 = Result.m69constructorimpl(zVar);
                        } catch (Throwable th6) {
                            Result.a aVar12 = Result.Companion;
                            objM69constructorimpl6 = Result.m69constructorimpl(d.a(th6));
                        }
                        return (ng) (Result.m75isFailureimpl(objM69constructorimpl6) ? null : objM69constructorimpl6);
                    }
                    if (b2 == 21) {
                        try {
                            Result.a aVar13 = Result.Companion;
                            if (bArr.length < 2) {
                                pVar = null;
                            } else {
                                int i32 = bArr[1] & 255;
                                if (bArr.length < i32 + 2) {
                                    pVar = null;
                                } else {
                                    Charset charset7 = StandardCharsets.UTF_8;
                                    p31.e(charset7, "UTF_8");
                                    pVar = new p(new String(bArr, 2, i32, charset7));
                                }
                            }
                            objM69constructorimpl7 = Result.m69constructorimpl(pVar);
                        } catch (Throwable th7) {
                            Result.a aVar14 = Result.Companion;
                            objM69constructorimpl7 = Result.m69constructorimpl(d.a(th7));
                        }
                        return (ng) (Result.m75isFailureimpl(objM69constructorimpl7) ? null : objM69constructorimpl7);
                    }
                    if (b2 == 22) {
                        if (bArr.length >= 2) {
                            return new k((bArr[1] & 255) == 1);
                        }
                    } else if (b2 == 23) {
                        if (bArr.length >= 2) {
                            return new AIGlassesOtaStatusEvent(bArr[1]);
                        }
                    } else if (b2 == 29) {
                        if (bArr.length >= 2) {
                            return new d0((bArr[1] & 255) == 1);
                        }
                    } else if (b2 == 25) {
                        if (bArr.length >= 5) {
                            return new y(h(bArr, 1), h(bArr, 3));
                        }
                    } else if (b2 == 26) {
                        if (bArr.length >= 2) {
                            return new w(bArr[1] & 255);
                        }
                    } else if (b2 != 27) {
                        if (b2 == 28) {
                            try {
                                Result.a aVar15 = Result.Companion;
                                if (bArr.length < 2) {
                                    sVar = null;
                                } else {
                                    int i33 = bArr[1] & 255;
                                    if (bArr.length >= i33 + 2) {
                                        Charset charset8 = StandardCharsets.UTF_8;
                                        p31.e(charset8, "UTF_8");
                                        sVar = new s(new String(bArr, 2, i33, charset8));
                                    } else {
                                        sVar = null;
                                    }
                                }
                                objM69constructorimpl8 = Result.m69constructorimpl(sVar);
                            } catch (Throwable th8) {
                                Result.a aVar16 = Result.Companion;
                                objM69constructorimpl8 = Result.m69constructorimpl(d.a(th8));
                            }
                            return (ng) (Result.m75isFailureimpl(objM69constructorimpl8) ? null : objM69constructorimpl8);
                        }
                        if (b2 == 30 && bArr.length >= 2) {
                            int i34 = bArr[1] & 255;
                            if (bArr.length >= 3 && (i6 = bArr[2] & 255) > 0 && bArr.length >= i6 + 3) {
                                Charset charset9 = StandardCharsets.UTF_8;
                                p31.e(charset9, "UTF_8");
                                str2 = new String(bArr, 3, i6, charset9);
                            }
                            uVar = new u(i34, str2);
                            return uVar;
                        }
                    } else if (bArr.length >= 5) {
                        int i35 = ByteBuffer.wrap(bArr, 1, 4).order(ByteOrder.BIG_ENDIAN).getInt();
                        uVar = new o((i35 & 1) == 0, (2 & i35) != 0, (i35 & 4) != 0);
                        return uVar;
                    }
                } else if (bArr.length >= 2) {
                    return new h((bArr[1] & 255) == 1);
                }
            } else if (bArr.length >= 2) {
                int i36 = bArr[1] & 255;
                ArrayList arrayList4 = new ArrayList();
                while (i10 < i36) {
                    int i37 = i8 + 3;
                    if (i37 > bArr.length) {
                        break;
                    }
                    arrayList4.add(new m(bArr[i8] & 255, h(bArr, i8 + 1)));
                    i10++;
                    i8 = i37;
                }
                uVar = new l(arrayList4);
                return uVar;
            }
        } else if (bArr.length >= 2) {
            return new r(bArr[1] == 1);
        }
        return null;
    }

    private final ng f(byte b2, byte[] bArr) {
        return null;
    }

    private final ng i(byte b2, byte[] bArr) {
        if (b2 == 26) {
            return e(bArr);
        }
        return null;
    }

    public final void d(byte b2, byte b3, byte[] bArr) {
        ng ngVarF;
        p31.f(bArr, "payload");
        if (b2 == 21) {
            ngVarF = i(b3, bArr);
        } else {
            ngVarF = b2 == 28 ? f(b3, bArr) : null;
        }
        if (ngVarF == null) {
            return;
        }
        c(ngVarF);
    }

    public final int g(byte[] bArr, int i) {
        p31.f(bArr, "bytes");
        if (i + 3 >= bArr.length) {
            return 0;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 4);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        return byteBufferWrap.getInt();
    }

    public final int h(byte[] bArr, int i) {
        p31.f(bArr, "bytes");
        if (i + 1 >= bArr.length) {
            return 0;
        }
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr, i, 2);
        byteBufferWrap.order(ByteOrder.BIG_ENDIAN);
        return byteBufferWrap.getShort() & 65535;
    }

    private e92() {
    }
}
