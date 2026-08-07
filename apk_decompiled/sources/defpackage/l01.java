package defpackage;

import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: classes3.dex */
public class l01 {
    private static final byte[] b = "Exif\u0000\u0000".getBytes(StandardCharsets.UTF_8);
    private static final int[] c = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};
    private final b a;

    private static class a {
        private final ByteBuffer a;

        public a(byte[] bArr, int i) {
            this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public short a(int i) {
            return this.a.getShort(i);
        }

        public int b(int i) {
            return this.a.getInt(i);
        }

        public int c() {
            return this.a.remaining();
        }

        public void d(ByteOrder byteOrder) {
            this.a.order(byteOrder);
        }
    }

    private interface b {
        long a(long j);

        int b();

        int c(byte[] bArr, int i);

        short d();
    }

    private static class c implements b {
        private final InputStream a;

        public c(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // l01.b
        public long a(long j) throws IOException {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long jSkip = this.a.skip(j2);
                if (jSkip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j2 -= jSkip;
            }
            return j - j2;
        }

        @Override // l01.b
        public int b() {
            return ((this.a.read() << 8) & 65280) | (this.a.read() & 255);
        }

        @Override // l01.b
        public int c(byte[] bArr, int i) throws IOException {
            int i2 = i;
            while (i2 > 0) {
                int i3 = this.a.read(bArr, i - i2, i2);
                if (i3 == -1) {
                    break;
                }
                i2 -= i3;
            }
            return i - i2;
        }

        @Override // l01.b
        public short d() {
            return (short) (this.a.read() & 255);
        }
    }

    public l01(InputStream inputStream) {
        this.a = new c(inputStream);
    }

    private static int a(int i, int i2) {
        return i + 2 + (i2 * 12);
    }

    public static void b(dj0 dj0Var, int i, int i2, String str) throws Throwable {
        String[] strArr = {"FNumber", "DateTime", "DateTimeDigitized", "ExposureTime", "Flash", "FocalLength", "GPSAltitude", "GPSAltitudeRef", "GPSDateStamp", "GPSLatitude", "GPSLatitudeRef", "GPSLongitude", "GPSLongitudeRef", "GPSProcessingMethod", "GPSTimeStamp", "PhotographicSensitivity", "Make", "Model", "SubSecTime", "SubSecTimeDigitized", "SubSecTimeOriginal", "WhiteBalance"};
        try {
            dj0 dj0Var2 = new dj0(str);
            for (int i3 = 0; i3 < 22; i3++) {
                String str2 = strArr[i3];
                String strM = dj0Var.m(str2);
                if (!TextUtils.isEmpty(strM)) {
                    dj0Var2.g0(str2, strM);
                }
            }
            dj0Var2.g0("ImageWidth", String.valueOf(i));
            dj0Var2.g0("ImageLength", String.valueOf(i2));
            dj0Var2.g0("Orientation", "0");
            dj0Var2.b0();
        } catch (IOException e) {
            Log.d("ImageHeaderParser", e.getMessage());
        }
    }

    private static boolean d(int i) {
        return (i & 65496) == 65496 || i == 19789 || i == 18761;
    }

    private boolean e(byte[] bArr, int i) {
        boolean z = bArr != null && i > b.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = b;
                if (i2 >= bArr2.length) {
                    break;
                }
                if (bArr[i2] != bArr2[i2]) {
                    return false;
                }
                i2++;
            }
        }
        return z;
    }

    private int f() {
        short sD;
        int iB;
        long j;
        long jA;
        do {
            short sD2 = this.a.d();
            if (sD2 != 255) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Unknown segmentId=" + ((int) sD2));
                }
                return -1;
            }
            sD = this.a.d();
            if (sD == 218) {
                return -1;
            }
            if (sD == 217) {
                if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iB = this.a.b() - 2;
            if (sD == 225) {
                return iB;
            }
            j = iB;
            jA = this.a.a(j);
        } while (jA == j);
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to skip enough data, type: " + ((int) sD) + ", wanted to skip: " + iB + ", but actually skipped: " + jA);
        }
        return -1;
    }

    private static int g(a aVar) {
        ByteOrder byteOrder;
        short sA = aVar.a(6);
        if (sA == 19789) {
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else if (sA == 18761) {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        } else {
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        }
        aVar.d(byteOrder);
        int iB = aVar.b(10) + 6;
        short sA2 = aVar.a(iB);
        for (int i = 0; i < sA2; i++) {
            int iA = a(iB, i);
            short sA3 = aVar.a(iA);
            if (sA3 == 274) {
                short sA4 = aVar.a(iA + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = aVar.b(iA + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got tagIndex=" + i + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i2 = iB2 + c[sA4];
                        if (i2 <= 4) {
                            int i3 = iA + 8;
                            if (i3 >= 0 && i3 <= aVar.c()) {
                                if (i2 >= 0 && i2 + i3 <= aVar.c()) {
                                    return aVar.a(i3);
                                }
                                if (Log.isLoggable("ImageHeaderParser", 3)) {
                                    Log.d("ImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) sA3));
                                }
                            } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                                Log.d("ImageHeaderParser", "Illegal tagValueOffset=" + i3 + " tagType=" + ((int) sA3));
                            }
                        } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                            Log.d("ImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) sA4));
                        }
                    } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                        Log.d("ImageHeaderParser", "Negative tiff component count");
                    }
                } else if (Log.isLoggable("ImageHeaderParser", 3)) {
                    Log.d("ImageHeaderParser", "Got invalid format code = " + ((int) sA4));
                }
            }
        }
        return -1;
    }

    private int h(byte[] bArr, int i) {
        int iC = this.a.c(bArr, i);
        if (iC == i) {
            if (e(bArr, i)) {
                return g(new a(bArr, i));
            }
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + iC);
        }
        return -1;
    }

    public int c() {
        int iB = this.a.b();
        if (d(iB)) {
            int iF = f();
            if (iF != -1) {
                return h(new byte[iF], iF);
            }
            if (Log.isLoggable("ImageHeaderParser", 3)) {
                Log.d("ImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
            }
            return -1;
        }
        if (Log.isLoggable("ImageHeaderParser", 3)) {
            Log.d("ImageHeaderParser", "Parser doesn't handle magic number: " + iB);
        }
        return -1;
    }
}
