package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ot2 implements zt0 {
    private static final String u = "ot2";
    private int[] a;
    private final int[] b;
    private final zt0.a c;
    private ByteBuffer d;
    private byte[] e;
    private short[] f;
    private byte[] g;
    private byte[] h;
    private byte[] i;
    private int[] j;
    private int k;
    private iu0 l;
    private Bitmap m;
    private boolean n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f369q;
    private int r;
    private Boolean s;
    private Bitmap.Config t;

    public ot2(zt0.a aVar, iu0 iu0Var, ByteBuffer byteBuffer, int i) {
        this(aVar);
        r(iu0Var, byteBuffer, i);
    }

    private int j(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.p + i; i9++) {
            byte[] bArr = this.i;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.a[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.p + i11; i12++) {
            byte[] bArr2 = this.i;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.a[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    private void k(fu0 fu0Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = this.j;
        int i6 = fu0Var.d;
        int i7 = this.p;
        int i8 = i6 / i7;
        int i9 = fu0Var.b / i7;
        int i10 = fu0Var.c / i7;
        int i11 = fu0Var.a / i7;
        boolean z = this.k == 0;
        int i12 = this.r;
        int i13 = this.f369q;
        byte[] bArr = this.i;
        int[] iArr2 = this.a;
        Boolean bool = this.s;
        int i14 = 8;
        int i15 = 0;
        int i16 = 0;
        int i17 = 1;
        while (i16 < i8) {
            Boolean bool2 = bool;
            if (fu0Var.e) {
                if (i15 >= i8) {
                    int i18 = i17 + 1;
                    i = i8;
                    if (i18 == 2) {
                        i15 = 4;
                    } else if (i18 == 3) {
                        i14 = 4;
                        i17 = i18;
                        i15 = 2;
                    } else if (i18 == 4) {
                        i17 = i18;
                        i15 = 1;
                        i14 = 2;
                    }
                    i17 = i18;
                } else {
                    i = i8;
                }
                i2 = i15 + i14;
            } else {
                i = i8;
                i2 = i15;
                i15 = i16;
            }
            int i19 = i15 + i9;
            boolean z2 = i7 == 1;
            if (i19 < i13) {
                int i20 = i19 * i12;
                int i21 = i20 + i11;
                int i22 = i21 + i10;
                int i23 = i20 + i12;
                if (i23 < i22) {
                    i22 = i23;
                }
                i3 = i2;
                int i24 = i16 * i7 * fu0Var.c;
                if (!z2) {
                    i5 = i9;
                    int i25 = ((i22 - i21) * i7) + i24;
                    int i26 = i21;
                    while (true) {
                        i4 = i10;
                        if (i26 >= i22) {
                            break;
                        }
                        int iJ = j(i24, i25, fu0Var.c);
                        if (iJ != 0) {
                            iArr[i26] = iJ;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i24 += i7;
                        i26++;
                        i10 = i4;
                    }
                } else {
                    int i27 = i21;
                    while (i27 < i22) {
                        int i28 = i9;
                        int i29 = iArr2[bArr[i24] & 255];
                        if (i29 != 0) {
                            iArr[i27] = i29;
                        } else if (z && bool2 == null) {
                            bool2 = Boolean.TRUE;
                        }
                        i24 += i7;
                        i27++;
                        i9 = i28;
                    }
                }
                bool = bool2;
                i16++;
                i9 = i5;
                i8 = i;
                i10 = i4;
                i15 = i3;
            } else {
                i3 = i2;
            }
            i5 = i9;
            i4 = i10;
            bool = bool2;
            i16++;
            i9 = i5;
            i8 = i;
            i10 = i4;
            i15 = i3;
        }
        Boolean bool3 = bool;
        if (this.s == null) {
            this.s = Boolean.valueOf(bool3 == null ? false : bool3.booleanValue());
        }
    }

    private void l(fu0 fu0Var) {
        fu0 fu0Var2 = fu0Var;
        int[] iArr = this.j;
        int i = fu0Var2.d;
        int i2 = fu0Var2.b;
        int i3 = fu0Var2.c;
        int i4 = fu0Var2.a;
        boolean z = this.k == 0;
        int i5 = this.r;
        byte[] bArr = this.i;
        int[] iArr2 = this.a;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = fu0Var2.c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int i13 = i;
                int i14 = b2 & 255;
                if (i14 != b) {
                    int i15 = iArr2[i14];
                    if (i15 != 0) {
                        iArr[i12] = i15;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                i = i13;
            }
            i6++;
            fu0Var2 = fu0Var;
        }
        Boolean bool = this.s;
        this.s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.s == null && z && b != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12 */
    /* JADX WARN: Type inference failed for: r7v15, types: [short] */
    /* JADX WARN: Type inference failed for: r7v17 */
    private void m(fu0 fu0Var) {
        int i;
        int i2;
        short s;
        this = this;
        if (fu0Var != null) {
            this.d.position(fu0Var.j);
        }
        if (fu0Var == null) {
            iu0 iu0Var = this.l;
            i = iu0Var.f;
            i2 = iu0Var.g;
        } else {
            i = fu0Var.c;
            i2 = fu0Var.d;
        }
        int i3 = i * i2;
        byte[] bArr = this.i;
        if (bArr == null || bArr.length < i3) {
            this.i = this.c.e(i3);
        }
        byte[] bArr2 = this.i;
        if (this.f == null) {
            this.f = new short[4096];
        }
        short[] sArr = this.f;
        if (this.g == null) {
            this.g = new byte[4096];
        }
        byte[] bArr3 = this.g;
        if (this.h == null) {
            this.h = new byte[4097];
        }
        byte[] bArr4 = this.h;
        int iQ = q();
        int i4 = 1 << iQ;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = iQ + 1;
        int i8 = (1 << i7) - 1;
        int i9 = 0;
        for (int i10 = 0; i10 < i4; i10++) {
            sArr[i10] = 0;
            bArr3[i10] = (byte) i10;
        }
        byte[] bArr5 = this.e;
        int i11 = i7;
        int i12 = i6;
        int i13 = i8;
        int iP = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        while (i9 < i3) {
            if (iP == 0) {
                iP = p();
                if (iP <= 0) {
                    this.o = 3;
                    break;
                }
                i14 = 0;
            }
            i16 += (bArr5[i14] & 255) << i15;
            i14++;
            iP--;
            int i21 = i15 + 8;
            i12 = i12;
            i11 = i11;
            i20 = i20;
            i7 = i7;
            i18 = i18;
            while (true) {
                if (i21 < i11) {
                    i15 = i21;
                    break;
                }
                int i22 = i6;
                int i23 = i16 & i13;
                i16 >>= i11;
                i21 -= i11;
                if (i23 == i4) {
                    i13 = i8;
                    i11 = i7;
                    i12 = i22;
                    i6 = i12;
                    i20 = -1;
                } else {
                    if (i23 == i5) {
                        i15 = i21;
                        i6 = i22;
                        break;
                    }
                    if (i20 == -1) {
                        bArr2[i17] = bArr3[i23];
                        i17++;
                        i9++;
                        i20 = i23;
                        i18 = i20;
                        i6 = i22;
                        i21 = i21;
                    } else {
                        if (i23 >= i12) {
                            bArr4[i19] = (byte) i18;
                            i19++;
                            s = i20;
                        } else {
                            s = i23;
                        }
                        while (s >= i4) {
                            bArr4[i19] = bArr3[s];
                            i19++;
                            s = sArr[s];
                        }
                        i18 = bArr3[s] & 255;
                        byte b = (byte) i18;
                        bArr2[i17] = b;
                        while (true) {
                            i17++;
                            i9++;
                            if (i19 <= 0) {
                                break;
                            }
                            i19--;
                            bArr2[i17] = bArr4[i19];
                        }
                        byte[] bArr6 = bArr4;
                        if (i12 < 4096) {
                            sArr[i12] = (short) i20;
                            bArr3[i12] = b;
                            i12++;
                            if ((i12 & i13) == 0 && i12 < 4096) {
                                i11++;
                                i13 += i12;
                            }
                        }
                        i20 = i23;
                        i6 = i22;
                        i21 = i21;
                        bArr4 = bArr6;
                    }
                }
            }
        }
        Arrays.fill(bArr2, i17, i3, (byte) 0);
    }

    private Bitmap o() {
        Boolean bool = this.s;
        Bitmap bitmapA = this.c.a(this.r, this.f369q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    private int p() {
        int iQ = q();
        if (iQ <= 0) {
            return iQ;
        }
        ByteBuffer byteBuffer = this.d;
        byteBuffer.get(this.e, 0, Math.min(iQ, byteBuffer.remaining()));
        return iQ;
    }

    private int q() {
        return this.d.get() & 255;
    }

    private Bitmap s(fu0 fu0Var, fu0 fu0Var2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.j;
        int i3 = 0;
        if (fu0Var2 == null) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                this.c.c(bitmap2);
            }
            this.m = null;
            Arrays.fill(iArr, 0);
        }
        if (fu0Var2 != null && fu0Var2.g == 3 && this.m == null) {
            Arrays.fill(iArr, 0);
        }
        if (fu0Var2 != null && (i2 = fu0Var2.g) > 0) {
            if (i2 == 2) {
                if (!fu0Var.f) {
                    iu0 iu0Var = this.l;
                    int i4 = iu0Var.l;
                    if (fu0Var.k == null || iu0Var.j != fu0Var.h) {
                        i3 = i4;
                    }
                }
                int i5 = fu0Var2.d;
                int i6 = this.p;
                int i7 = i5 / i6;
                int i8 = fu0Var2.b / i6;
                int i9 = fu0Var2.c / i6;
                int i10 = fu0Var2.a / i6;
                int i11 = this.r;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.r;
                }
            } else if (i2 == 3 && (bitmap = this.m) != null) {
                int i16 = this.r;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.f369q);
            }
        }
        m(fu0Var);
        if (fu0Var.e || this.p != 1) {
            k(fu0Var);
        } else {
            l(fu0Var);
        }
        if (this.n && ((i = fu0Var.g) == 0 || i == 1)) {
            if (this.m == null) {
                this.m = o();
            }
            Bitmap bitmap3 = this.m;
            int i17 = this.r;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.f369q);
        }
        Bitmap bitmapO = o();
        int i18 = this.r;
        bitmapO.setPixels(iArr, 0, i18, 0, 0, i18, this.f369q);
        return bitmapO;
    }

    @Override // defpackage.zt0
    public synchronized Bitmap a() {
        try {
            if (this.l.c <= 0 || this.k < 0) {
                String str = u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.l.c + ", framePointer=" + this.k);
                }
                this.o = 1;
            }
            int i = this.o;
            if (i != 1 && i != 2) {
                this.o = 0;
                if (this.e == null) {
                    this.e = this.c.e(255);
                }
                fu0 fu0Var = (fu0) this.l.e.get(this.k);
                int i2 = this.k - 1;
                fu0 fu0Var2 = i2 >= 0 ? (fu0) this.l.e.get(i2) : null;
                int[] iArr = fu0Var.k;
                if (iArr == null) {
                    iArr = this.l.a;
                }
                this.a = iArr;
                if (iArr == null) {
                    String str2 = u;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.k);
                    }
                    this.o = 1;
                    return null;
                }
                if (fu0Var.f) {
                    System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                    int[] iArr2 = this.b;
                    this.a = iArr2;
                    iArr2[fu0Var.h] = 0;
                    if (fu0Var.g == 2 && this.k == 0) {
                        this.s = Boolean.TRUE;
                    }
                }
                return s(fu0Var, fu0Var2);
            }
            String str3 = u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.zt0
    public void b() {
        this.k = (this.k + 1) % this.l.c;
    }

    @Override // defpackage.zt0
    public int c() {
        return this.l.c;
    }

    @Override // defpackage.zt0
    public void clear() {
        this.l = null;
        byte[] bArr = this.i;
        if (bArr != null) {
            this.c.d(bArr);
        }
        int[] iArr = this.j;
        if (iArr != null) {
            this.c.f(iArr);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.c.c(bitmap);
        }
        this.m = null;
        this.d = null;
        this.s = null;
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            this.c.d(bArr2);
        }
    }

    @Override // defpackage.zt0
    public int d() {
        int i;
        if (this.l.c <= 0 || (i = this.k) < 0) {
            return 0;
        }
        return n(i);
    }

    @Override // defpackage.zt0
    public void e(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    @Override // defpackage.zt0
    public ByteBuffer f() {
        return this.d;
    }

    @Override // defpackage.zt0
    public void g() {
        this.k = -1;
    }

    @Override // defpackage.zt0
    public int h() {
        return this.k;
    }

    @Override // defpackage.zt0
    public int i() {
        return this.d.limit() + this.i.length + (this.j.length * 4);
    }

    public int n(int i) {
        if (i >= 0) {
            iu0 iu0Var = this.l;
            if (i < iu0Var.c) {
                return ((fu0) iu0Var.e.get(i)).i;
            }
        }
        return -1;
    }

    public synchronized void r(iu0 iu0Var, ByteBuffer byteBuffer, int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
            int iHighestOneBit = Integer.highestOneBit(i);
            this.o = 0;
            this.l = iu0Var;
            this.k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.d.order(ByteOrder.LITTLE_ENDIAN);
            this.n = false;
            Iterator it = iu0Var.e.iterator();
            while (it.hasNext()) {
                if (((fu0) it.next()).g == 3) {
                    this.n = true;
                    break;
                }
            }
            this.p = iHighestOneBit;
            int i2 = iu0Var.f;
            this.r = i2 / iHighestOneBit;
            int i3 = iu0Var.g;
            this.f369q = i3 / iHighestOneBit;
            this.i = this.c.e(i2 * i3);
            this.j = this.c.b(this.r * this.f369q);
        } catch (Throwable th) {
            throw th;
        }
    }

    public ot2(zt0.a aVar) {
        this.b = new int[256];
        this.t = Bitmap.Config.ARGB_8888;
        this.c = aVar;
        this.l = new iu0();
    }
}
