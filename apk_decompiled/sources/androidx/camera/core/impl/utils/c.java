package androidx.camera.core.impl.utils;

import defpackage.b52;
import java.io.BufferedOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class c extends FilterOutputStream {
    private static final byte[] g = "Exif\u0000\u0000".getBytes(b.e);
    private final ExifData a;
    private final byte[] b;
    private final ByteBuffer c;
    private int d;
    private int e;
    private int f;

    static final class a {
        public static boolean a(short s) {
            return (s < -64 || s > -49 || s == -60 || s == -56 || s == -52) ? false : true;
        }
    }

    public c(OutputStream outputStream, ExifData exifData) {
        super(new BufferedOutputStream(outputStream, 65536));
        this.b = new byte[1];
        this.c = ByteBuffer.allocate(4);
        this.d = 0;
        this.a = exifData;
    }

    private int n(int i, byte[] bArr, int i2, int i3) {
        int iMin = Math.min(i3, i - this.c.position());
        this.c.put(bArr, i2, iMin);
        return iMin;
    }

    private void u(androidx.camera.core.impl.utils.a aVar) throws IOException {
        d[][] dVarArr = ExifData.i;
        int[] iArr = new int[dVarArr.length];
        int[] iArr2 = new int[dVarArr.length];
        for (d dVar : ExifData.g) {
            for (int i = 0; i < ExifData.i.length; i++) {
                this.a.c(i).remove(dVar.b);
            }
        }
        if (!this.a.c(1).isEmpty()) {
            this.a.c(0).put(ExifData.g[1].b, b.f(0L, this.a.d()));
        }
        if (!this.a.c(2).isEmpty()) {
            this.a.c(0).put(ExifData.g[2].b, b.f(0L, this.a.d()));
        }
        if (!this.a.c(3).isEmpty()) {
            this.a.c(1).put(ExifData.g[3].b, b.f(0L, this.a.d()));
        }
        for (int i2 = 0; i2 < ExifData.i.length; i2++) {
            Iterator it = this.a.c(i2).entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int iJ = ((b) ((Map.Entry) it.next()).getValue()).j();
                if (iJ > 4) {
                    i3 += iJ;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int size = 8;
        for (int i4 = 0; i4 < ExifData.i.length; i4++) {
            if (!this.a.c(i4).isEmpty()) {
                iArr[i4] = size;
                size += (this.a.c(i4).size() * 12) + 6 + iArr2[i4];
            }
        }
        int i5 = size + 8;
        if (!this.a.c(1).isEmpty()) {
            this.a.c(0).put(ExifData.g[1].b, b.f(iArr[1], this.a.d()));
        }
        if (!this.a.c(2).isEmpty()) {
            this.a.c(0).put(ExifData.g[2].b, b.f(iArr[2], this.a.d()));
        }
        if (!this.a.c(3).isEmpty()) {
            this.a.c(1).put(ExifData.g[3].b, b.f(iArr[3], this.a.d()));
        }
        aVar.D(i5);
        aVar.write(g);
        aVar.y(this.a.d() == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        aVar.n(this.a.d());
        aVar.D(42);
        aVar.C(8L);
        for (int i6 = 0; i6 < ExifData.i.length; i6++) {
            if (!this.a.c(i6).isEmpty()) {
                aVar.D(this.a.c(i6).size());
                int size2 = iArr[i6] + 2 + (this.a.c(i6).size() * 12) + 4;
                for (Map.Entry entry : this.a.c(i6).entrySet()) {
                    int i7 = ((d) b52.h((d) ((HashMap) ExifData.b.f.get(i6)).get(entry.getKey()), "Tag not supported: " + ((String) entry.getKey()) + ". Tag needs to be ported from ExifInterface to ExifData.")).a;
                    b bVar = (b) entry.getValue();
                    int iJ2 = bVar.j();
                    aVar.D(i7);
                    aVar.D(bVar.a);
                    aVar.w(bVar.b);
                    if (iJ2 > 4) {
                        aVar.C(size2);
                        size2 += iJ2;
                    } else {
                        aVar.write(bVar.d);
                        if (iJ2 < 4) {
                            while (iJ2 < 4) {
                                aVar.u(0);
                                iJ2++;
                            }
                        }
                    }
                }
                aVar.C(0L);
                Iterator it2 = this.a.c(i6).entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((b) ((Map.Entry) it2.next()).getValue()).d;
                    if (bArr.length > 4) {
                        aVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        aVar.n(ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr, int i, int i2) throws IOException {
        while (true) {
            int i3 = this.e;
            if ((i3 <= 0 && this.f <= 0 && this.d == 2) || i2 <= 0) {
                break;
            }
            if (i3 > 0) {
                int iMin = Math.min(i2, i3);
                i2 -= iMin;
                this.e -= iMin;
                i += iMin;
            }
            int i4 = this.f;
            if (i4 > 0) {
                int iMin2 = Math.min(i2, i4);
                ((FilterOutputStream) this).out.write(bArr, i, iMin2);
                i2 -= iMin2;
                this.f -= iMin2;
                i += iMin2;
            }
            if (i2 == 0) {
                return;
            }
            int i5 = this.d;
            if (i5 == 0) {
                int iN = n(2, bArr, i, i2);
                i += iN;
                i2 -= iN;
                if (this.c.position() < 2) {
                    return;
                }
                this.c.rewind();
                if (this.c.getShort() != -40) {
                    throw new IOException("Not a valid jpeg image, cannot write exif");
                }
                ((FilterOutputStream) this).out.write(this.c.array(), 0, 2);
                this.d = 1;
                this.c.rewind();
                androidx.camera.core.impl.utils.a aVar = new androidx.camera.core.impl.utils.a(((FilterOutputStream) this).out, ByteOrder.BIG_ENDIAN);
                aVar.y((short) -31);
                u(aVar);
            } else if (i5 != 1) {
                continue;
            } else {
                int iN2 = n(4, bArr, i, i2);
                i += iN2;
                i2 -= iN2;
                if (this.c.position() == 2 && this.c.getShort() == -39) {
                    ((FilterOutputStream) this).out.write(this.c.array(), 0, 2);
                    this.c.rewind();
                }
                if (this.c.position() < 4) {
                    return;
                }
                this.c.rewind();
                short s = this.c.getShort();
                if (s == -31) {
                    this.e = (this.c.getShort() & 65535) - 2;
                    this.d = 2;
                } else if (a.a(s)) {
                    ((FilterOutputStream) this).out.write(this.c.array(), 0, 4);
                    this.d = 2;
                } else {
                    ((FilterOutputStream) this).out.write(this.c.array(), 0, 4);
                    this.f = (this.c.getShort() & 65535) - 2;
                }
                this.c.rewind();
            }
        }
        if (i2 > 0) {
            ((FilterOutputStream) this).out.write(bArr, i, i2);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        byte[] bArr = this.b;
        bArr[0] = (byte) (i & 255);
        write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
