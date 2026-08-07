package defpackage;

import android.content.res.AssetManager;
import android.location.Location;
import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.Os;
import android.system.OsConstants;
import android.util.Log;
import android.util.Pair;
import cn.bertsir.zbar.Qr.Config;
import com.baji.protocol.model.ProtocolConstants;
import com.fasterxml.jackson.core.JsonPointer;
import com.jieli.jl_rcsp.constant.AttrAndFunCode;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.jieli.jl_rcsp.model.SportHealthConfigure;
import com.jieli.lib.gif.GifError;
import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.DateFormatUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.CRC32;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes.dex */
public class dj0 {
    private static SimpleDateFormat U;
    private static SimpleDateFormat V;
    private static final e[] Z;
    private static final e[] a0;
    private static final e[] b0;
    private static final e[] c0;
    private static final e[] d0;
    private static final e e0;
    private static final e[] f0;
    private static final e[] g0;
    private static final e[] h0;
    private static final e[] i0;
    static final e[][] j0;
    private static final e[] k0;
    private static final e l0;
    private static final e m0;
    private static final HashMap[] n0;
    private static final HashMap[] o0;
    private static final HashSet p0;
    private static final HashMap q0;
    static final Charset r0;
    static final byte[] s0;
    private static final byte[] t0;
    private static final Pattern u0;
    private static final Pattern v0;
    private static final Pattern w0;
    private static final Pattern x0;
    private String a;
    private FileDescriptor b;
    private AssetManager.AssetInputStream c;
    private int d;
    private boolean e;
    private final HashMap[] f;
    private Set g;
    private ByteOrder h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private byte[] n;
    private int o;
    private int p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f324q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private static final boolean v = Log.isLoggable("ExifInterface", 3);
    private static final List w = Arrays.asList(1, 6, 3, 8);
    private static final List x = Arrays.asList(2, 7, 4, 5);
    public static final int[] y = {8, 8, 8};
    public static final int[] z = {4};
    public static final int[] A = {8};
    static final byte[] B = {-1, -40, -1};
    private static final byte[] C = {102, 116, 121, 112};
    private static final byte[] D = {109, 105, 102, 49};
    private static final byte[] E = {104, 101, 105, 99};
    private static final byte[] F = {79, 76, 89, 77, 80, 0};
    private static final byte[] G = {79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
    private static final byte[] H = {-119, 80, 78, 71, AttrAndFunCode.SYS_INFO_ATTR_CURRENT_NOISE_MODE, 10, 26, 10};
    private static final byte[] I = {101, 88, 73, 102};
    private static final byte[] J = {73, 72, 68, 82};
    private static final byte[] K = {73, 69, 78, 68};
    private static final byte[] L = {82, 73, 70, 70};
    private static final byte[] M = {87, 69, 66, 80};
    private static final byte[] N = {69, 88, 73, 70};
    private static final byte[] O = {-99, 1, 42};
    private static final byte[] P = "VP8X".getBytes(Charset.defaultCharset());
    private static final byte[] Q = "VP8L".getBytes(Charset.defaultCharset());
    private static final byte[] R = "VP8 ".getBytes(Charset.defaultCharset());
    private static final byte[] S = "ANIM".getBytes(Charset.defaultCharset());
    private static final byte[] T = "ANMF".getBytes(Charset.defaultCharset());
    static final String[] W = {Constants.STR_EMPTY, "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE", "IFD"};
    static final int[] X = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
    static final byte[] Y = {65, 83, 67, 73, 73, 0, 0, 0};

    class a extends MediaDataSource {
        long a;
        final /* synthetic */ b b;

        a(b bVar) {
            this.b = bVar;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // android.media.MediaDataSource
        public long getSize() {
            return -1L;
        }

        @Override // android.media.MediaDataSource
        public int readAt(long j, byte[] bArr, int i, int i2) {
            if (i2 == 0) {
                return 0;
            }
            if (j < 0) {
                return -1;
            }
            try {
                long j2 = this.a;
                if (j2 != j) {
                    if (j2 >= 0 && j >= j2 + ((long) this.b.available())) {
                        return -1;
                    }
                    this.b.y(j);
                    this.a = j;
                }
                if (i2 > this.b.available()) {
                    i2 = this.b.available();
                }
                int i3 = this.b.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.a += (long) i3;
                    return i3;
                }
            } catch (IOException unused) {
            }
            this.a = -1L;
            return -1;
        }
    }

    private static class b extends InputStream implements DataInput {
        private static final ByteOrder e = ByteOrder.LITTLE_ENDIAN;
        private static final ByteOrder f = ByteOrder.BIG_ENDIAN;
        private DataInputStream a;
        private ByteOrder b;
        final int c;
        int d;

        public b(InputStream inputStream) {
            this(inputStream, ByteOrder.BIG_ENDIAN);
        }

        public void C(ByteOrder byteOrder) {
            this.b = byteOrder;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.a.available();
        }

        @Override // java.io.InputStream
        public synchronized void mark(int i) {
            this.a.mark(i);
        }

        public int n() {
            return this.c;
        }

        @Override // java.io.InputStream
        public int read() {
            this.d++;
            return this.a.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.d++;
            return this.a.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() throws IOException {
            int i = this.d + 1;
            this.d = i;
            if (i > this.c) {
                throw new EOFException();
            }
            int i2 = this.a.read();
            if (i2 >= 0) {
                return (byte) i2;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.d += 2;
            return this.a.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.d + i2;
            this.d = i3;
            if (i3 > this.c) {
                throw new EOFException();
            }
            if (this.a.read(bArr, i, i2) != i2) {
                throw new IOException("Couldn't read up to the length of buffer");
            }
        }

        @Override // java.io.DataInput
        public int readInt() throws IOException {
            int i = this.d + 4;
            this.d = i;
            if (i > this.c) {
                throw new EOFException();
            }
            int i2 = this.a.read();
            int i3 = this.a.read();
            int i4 = this.a.read();
            int i5 = this.a.read();
            if ((i2 | i3 | i4 | i5) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.b;
            if (byteOrder == e) {
                return (i5 << 24) + (i4 << 16) + (i3 << 8) + i2;
            }
            if (byteOrder == f) {
                return (i2 << 24) + (i3 << 16) + (i4 << 8) + i5;
            }
            throw new IOException("Invalid byte order: " + this.b);
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() throws IOException {
            int i = this.d + 8;
            this.d = i;
            if (i > this.c) {
                throw new EOFException();
            }
            int i2 = this.a.read();
            int i3 = this.a.read();
            int i4 = this.a.read();
            int i5 = this.a.read();
            int i6 = this.a.read();
            int i7 = this.a.read();
            int i8 = this.a.read();
            int i9 = this.a.read();
            if ((i2 | i3 | i4 | i5 | i6 | i7 | i8 | i9) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.b;
            if (byteOrder == e) {
                return (((long) i9) << 56) + (((long) i8) << 48) + (((long) i7) << 40) + (((long) i6) << 32) + (((long) i5) << 24) + (((long) i4) << 16) + (((long) i3) << 8) + ((long) i2);
            }
            if (byteOrder == f) {
                return (((long) i2) << 56) + (((long) i3) << 48) + (((long) i4) << 40) + (((long) i5) << 32) + (((long) i6) << 24) + (((long) i7) << 16) + (((long) i8) << 8) + ((long) i9);
            }
            throw new IOException("Invalid byte order: " + this.b);
        }

        @Override // java.io.DataInput
        public short readShort() throws IOException {
            int i = this.d + 2;
            this.d = i;
            if (i > this.c) {
                throw new EOFException();
            }
            int i2 = this.a.read();
            int i3 = this.a.read();
            if ((i2 | i3) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.b;
            if (byteOrder == e) {
                return (short) ((i3 << 8) + i2);
            }
            if (byteOrder == f) {
                return (short) ((i2 << 8) + i3);
            }
            throw new IOException("Invalid byte order: " + this.b);
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.d += 2;
            return this.a.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.d++;
            return this.a.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() throws IOException {
            int i = this.d + 2;
            this.d = i;
            if (i > this.c) {
                throw new EOFException();
            }
            int i2 = this.a.read();
            int i3 = this.a.read();
            if ((i2 | i3) < 0) {
                throw new EOFException();
            }
            ByteOrder byteOrder = this.b;
            if (byteOrder == e) {
                return (i3 << 8) + i2;
            }
            if (byteOrder == f) {
                return (i2 << 8) + i3;
            }
            throw new IOException("Invalid byte order: " + this.b);
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int iMin = Math.min(i, this.c - this.d);
            int iSkipBytes = 0;
            while (iSkipBytes < iMin) {
                iSkipBytes += this.a.skipBytes(iMin - iSkipBytes);
            }
            this.d += iSkipBytes;
            return iSkipBytes;
        }

        public int u() {
            return this.d;
        }

        public long w() {
            return ((long) readInt()) & 4294967295L;
        }

        public void y(long j) throws IOException {
            int i = this.d;
            if (i > j) {
                this.d = 0;
                this.a.reset();
                this.a.mark(this.c);
            } else {
                j -= (long) i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        b(InputStream inputStream, ByteOrder byteOrder) throws IOException {
            this.b = ByteOrder.BIG_ENDIAN;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            this.a = dataInputStream;
            int iAvailable = dataInputStream.available();
            this.c = iAvailable;
            this.d = 0;
            this.a.mark(iAvailable);
            this.b = byteOrder;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            int i3 = this.a.read(bArr, i, i2);
            this.d += i3;
            return i3;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) throws IOException {
            int length = this.d + bArr.length;
            this.d = length;
            if (length <= this.c) {
                if (this.a.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public b(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }
    }

    private static class c extends FilterOutputStream {
        final OutputStream a;
        private ByteOrder b;

        public c(OutputStream outputStream, ByteOrder byteOrder) {
            super(outputStream);
            this.a = outputStream;
            this.b = byteOrder;
        }

        public void C(long j) throws IOException {
            w((int) j);
        }

        public void D(int i) throws IOException {
            y((short) i);
        }

        public void n(ByteOrder byteOrder) {
            this.b = byteOrder;
        }

        public void u(int i) throws IOException {
            this.a.write(i);
        }

        public void w(int i) throws IOException {
            ByteOrder byteOrder = this.b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.a.write(i & 255);
                this.a.write((i >>> 8) & 255);
                this.a.write((i >>> 16) & 255);
                this.a.write((i >>> 24) & 255);
                return;
            }
            if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.a.write((i >>> 24) & 255);
                this.a.write((i >>> 16) & 255);
                this.a.write((i >>> 8) & 255);
                this.a.write(i & 255);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.a.write(bArr);
        }

        public void y(short s) throws IOException {
            ByteOrder byteOrder = this.b;
            if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                this.a.write(s & 255);
                this.a.write((s >>> 8) & 255);
            } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                this.a.write((s >>> 8) & 255);
                this.a.write(s & 255);
            }
        }

        @Override // java.io.FilterOutputStream, java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.a.write(bArr, i, i2);
        }
    }

    private static class d {
        public final int a;
        public final int b;
        public final long c;
        public final byte[] d;

        d(int i, int i2, byte[] bArr) {
            this(i, i2, -1L, bArr);
        }

        public static d a(String str) {
            if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
                return new d(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
            }
            byte[] bytes = str.getBytes(dj0.r0);
            return new d(1, bytes.length, bytes);
        }

        public static d b(double[] dArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[dj0.X[12] * dArr.length]);
            byteBufferWrap.order(byteOrder);
            for (double d : dArr) {
                byteBufferWrap.putDouble(d);
            }
            return new d(12, dArr.length, byteBufferWrap.array());
        }

        public static d c(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[dj0.X[9] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putInt(i);
            }
            return new d(9, iArr.length, byteBufferWrap.array());
        }

        public static d d(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[dj0.X[10] * fVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (f fVar : fVarArr) {
                byteBufferWrap.putInt((int) fVar.a);
                byteBufferWrap.putInt((int) fVar.b);
            }
            return new d(10, fVarArr.length, byteBufferWrap.array());
        }

        public static d e(String str) {
            byte[] bytes = (str + (char) 0).getBytes(dj0.r0);
            return new d(2, bytes.length, bytes);
        }

        public static d f(long j, ByteOrder byteOrder) {
            return g(new long[]{j}, byteOrder);
        }

        public static d g(long[] jArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[dj0.X[4] * jArr.length]);
            byteBufferWrap.order(byteOrder);
            for (long j : jArr) {
                byteBufferWrap.putInt((int) j);
            }
            return new d(4, jArr.length, byteBufferWrap.array());
        }

        public static d h(f fVar, ByteOrder byteOrder) {
            return i(new f[]{fVar}, byteOrder);
        }

        public static d i(f[] fVarArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[dj0.X[5] * fVarArr.length]);
            byteBufferWrap.order(byteOrder);
            for (f fVar : fVarArr) {
                byteBufferWrap.putInt((int) fVar.a);
                byteBufferWrap.putInt((int) fVar.b);
            }
            return new d(5, fVarArr.length, byteBufferWrap.array());
        }

        public static d j(int i, ByteOrder byteOrder) {
            return k(new int[]{i}, byteOrder);
        }

        public static d k(int[] iArr, ByteOrder byteOrder) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[dj0.X[3] * iArr.length]);
            byteBufferWrap.order(byteOrder);
            for (int i : iArr) {
                byteBufferWrap.putShort((short) i);
            }
            return new d(3, iArr.length, byteBufferWrap.array());
        }

        public double l(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                throw new NumberFormatException("NULL can't be converted to a double value");
            }
            if (objO instanceof String) {
                return Double.parseDouble((String) objO);
            }
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                if (jArr.length == 1) {
                    return jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objO instanceof int[]) {
                int[] iArr = (int[]) objO;
                if (iArr.length == 1) {
                    return iArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (objO instanceof double[]) {
                double[] dArr = (double[]) objO;
                if (dArr.length == 1) {
                    return dArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objO instanceof f[])) {
                throw new NumberFormatException("Couldn't find a double value");
            }
            f[] fVarArr = (f[]) objO;
            if (fVarArr.length == 1) {
                return fVarArr[0].a();
            }
            throw new NumberFormatException("There are more than one component");
        }

        public int m(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                throw new NumberFormatException("NULL can't be converted to a integer value");
            }
            if (objO instanceof String) {
                return Integer.parseInt((String) objO);
            }
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                if (jArr.length == 1) {
                    return (int) jArr[0];
                }
                throw new NumberFormatException("There are more than one component");
            }
            if (!(objO instanceof int[])) {
                throw new NumberFormatException("Couldn't find a integer value");
            }
            int[] iArr = (int[]) objO;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }

        public String n(ByteOrder byteOrder) throws Throwable {
            Object objO = o(byteOrder);
            if (objO == null) {
                return null;
            }
            if (objO instanceof String) {
                return (String) objO;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (objO instanceof long[]) {
                long[] jArr = (long[]) objO;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objO instanceof int[]) {
                int[] iArr = (int[]) objO;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (objO instanceof double[]) {
                double[] dArr = (double[]) objO;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(",");
                    }
                }
                return sb.toString();
            }
            if (!(objO instanceof f[])) {
                return null;
            }
            f[] fVarArr = (f[]) objO;
            while (i < fVarArr.length) {
                sb.append(fVarArr[i].a);
                sb.append(JsonPointer.SEPARATOR);
                sb.append(fVarArr[i].b);
                i++;
                if (i != fVarArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }

        /* JADX WARN: Code duplicated, block: B:162:0x018f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Not initialized variable reg: 5, insn: 0x0030: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]), block:B:17:0x0030 */
        Object o(ByteOrder byteOrder) throws Throwable {
            b bVar;
            InputStream inputStream;
            byte b;
            byte b2;
            int length = 0;
            InputStream inputStream2 = null;
            try {
                try {
                    bVar = new b(this.d);
                    try {
                        bVar.C(byteOrder);
                        switch (this.a) {
                            case 1:
                            case 6:
                                byte[] bArr = this.d;
                                if (bArr.length != 1 || (b = bArr[0]) < 0 || b > 1) {
                                    String str = new String(bArr, dj0.r0);
                                    try {
                                        bVar.close();
                                        break;
                                    } catch (IOException e) {
                                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                    }
                                    return str;
                                }
                                String str2 = new String(new char[]{(char) (b + 48)});
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e2) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                                }
                                return str2;
                            case 2:
                            case 7:
                                if (this.b >= dj0.Y.length) {
                                    int i = 0;
                                    while (true) {
                                        byte[] bArr2 = dj0.Y;
                                        if (i >= bArr2.length) {
                                            length = bArr2.length;
                                        } else if (this.d[i] == bArr2[i]) {
                                            i++;
                                        }
                                    }
                                }
                                StringBuilder sb = new StringBuilder();
                                while (length < this.b && (b2 = this.d[length]) != 0) {
                                    if (b2 >= 32) {
                                        sb.append((char) b2);
                                    } else {
                                        sb.append('?');
                                    }
                                    length++;
                                }
                                String string = sb.toString();
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e3) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                                }
                                return string;
                            case 3:
                                int[] iArr = new int[this.b];
                                while (length < this.b) {
                                    iArr[length] = bVar.readUnsignedShort();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e4) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                                }
                                return iArr;
                            case 4:
                                long[] jArr = new long[this.b];
                                while (length < this.b) {
                                    jArr[length] = bVar.w();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e5) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                                }
                                return jArr;
                            case 5:
                                f[] fVarArr = new f[this.b];
                                while (length < this.b) {
                                    fVarArr[length] = new f(bVar.w(), bVar.w());
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e6) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                                }
                                return fVarArr;
                            case 8:
                                int[] iArr2 = new int[this.b];
                                while (length < this.b) {
                                    iArr2[length] = bVar.readShort();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e7) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                                }
                                return iArr2;
                            case 9:
                                int[] iArr3 = new int[this.b];
                                while (length < this.b) {
                                    iArr3[length] = bVar.readInt();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e8) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                                }
                                return iArr3;
                            case 10:
                                f[] fVarArr2 = new f[this.b];
                                while (length < this.b) {
                                    fVarArr2[length] = new f(bVar.readInt(), bVar.readInt());
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e9) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                                }
                                return fVarArr2;
                            case 11:
                                double[] dArr = new double[this.b];
                                while (length < this.b) {
                                    dArr[length] = bVar.readFloat();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e10) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                                }
                                return dArr;
                            case 12:
                                double[] dArr2 = new double[this.b];
                                while (length < this.b) {
                                    dArr2[length] = bVar.readDouble();
                                    length++;
                                }
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e11) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                                }
                                return dArr2;
                            default:
                                try {
                                    bVar.close();
                                    break;
                                } catch (IOException e12) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                                }
                                return null;
                        }
                    } catch (IOException e13) {
                        e = e13;
                        Log.w("ExifInterface", "IOException occurred during reading a value", e);
                        if (bVar != null) {
                            try {
                                bVar.close();
                            } catch (IOException e14) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                            }
                        }
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream2 = inputStream;
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (IOException e15) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                        }
                    }
                    throw th;
                }
            } catch (IOException e16) {
                e = e16;
                bVar = null;
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                throw th;
            }
        }

        public int p() {
            return dj0.X[this.a] * this.b;
        }

        public String toString() {
            return "(" + dj0.W[this.a] + ", data length:" + this.d.length + ")";
        }

        d(int i, int i2, long j, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = j;
            this.d = bArr;
        }
    }

    private static class f {
        public final long a;
        public final long b;

        f(double d) {
            this((long) (d * 10000.0d), ProtocolConstants.CONNECTION_TIMEOUT_MS);
        }

        public double a() {
            return this.a / this.b;
        }

        public String toString() {
            return this.a + WatchConstant.FAT_FS_ROOT + this.b;
        }

        f(long j, long j2) {
            if (j2 == 0) {
                this.a = 0L;
                this.b = 1L;
            } else {
                this.a = j;
                this.b = j2;
            }
        }
    }

    static {
        e[] eVarArr = {new e("NewSubfileType", SportHealthConfigure.CONFIGURE_TYPE_SPORT_MODE, 4), new e("SubfileType", 255, 4), new e("ImageWidth", 256, 3, 4), new e("ImageLength", Config.Y_DENSITY, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("Orientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", DfuBaseService.NOTIFICATION_ID, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", GifError.ERR_INVALID_PARAM, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("SensorTopBorder", 4, 4), new e("SensorLeftBorder", 5, 4), new e("SensorBottomBorder", 6, 4), new e("SensorRightBorder", 7, 4), new e("ISO", 23, 3), new e("JpgFromRaw", 46, 7), new e("Xmp", 700, 1)};
        Z = eVarArr;
        e[] eVarArr2 = {new e("ExposureTime", 33434, 5), new e("FNumber", 33437, 5), new e("ExposureProgram", 34850, 3), new e("SpectralSensitivity", 34852, 2), new e("PhotographicSensitivity", 34855, 3), new e("OECF", 34856, 7), new e("SensitivityType", 34864, 3), new e("StandardOutputSensitivity", 34865, 4), new e("RecommendedExposureIndex", 34866, 4), new e("ISOSpeed", 34867, 4), new e("ISOSpeedLatitudeyyy", 34868, 4), new e("ISOSpeedLatitudezzz", 34869, 4), new e("ExifVersion", 36864, 2), new e("DateTimeOriginal", 36867, 2), new e("DateTimeDigitized", 36868, 2), new e("OffsetTime", 36880, 2), new e("OffsetTimeOriginal", 36881, 2), new e("OffsetTimeDigitized", 36882, 2), new e("ComponentsConfiguration", 37121, 7), new e("CompressedBitsPerPixel", 37122, 5), new e("ShutterSpeedValue", 37377, 10), new e("ApertureValue", 37378, 5), new e("BrightnessValue", 37379, 10), new e("ExposureBiasValue", 37380, 10), new e("MaxApertureValue", 37381, 5), new e("SubjectDistance", 37382, 5), new e("MeteringMode", 37383, 3), new e("LightSource", 37384, 3), new e("Flash", 37385, 3), new e("FocalLength", 37386, 5), new e("SubjectArea", 37396, 3), new e("MakerNote", 37500, 7), new e("UserComment", 37510, 7), new e("SubSecTime", 37520, 2), new e("SubSecTimeOriginal", 37521, 2), new e("SubSecTimeDigitized", 37522, 2), new e("FlashpixVersion", 40960, 7), new e("ColorSpace", 40961, 3), new e("PixelXDimension", 40962, 3, 4), new e("PixelYDimension", 40963, 3, 4), new e("RelatedSoundFile", 40964, 2), new e("InteroperabilityIFDPointer", 40965, 4), new e("FlashEnergy", 41483, 5), new e("SpatialFrequencyResponse", 41484, 7), new e("FocalPlaneXResolution", 41486, 5), new e("FocalPlaneYResolution", 41487, 5), new e("FocalPlaneResolutionUnit", 41488, 3), new e("SubjectLocation", 41492, 3), new e("ExposureIndex", 41493, 5), new e("SensingMethod", 41495, 3), new e("FileSource", 41728, 7), new e("SceneType", 41729, 7), new e("CFAPattern", 41730, 7), new e("CustomRendered", 41985, 3), new e("ExposureMode", 41986, 3), new e("WhiteBalance", 41987, 3), new e("DigitalZoomRatio", 41988, 5), new e("FocalLengthIn35mmFilm", 41989, 3), new e("SceneCaptureType", 41990, 3), new e("GainControl", 41991, 3), new e("Contrast", 41992, 3), new e("Saturation", 41993, 3), new e("Sharpness", 41994, 3), new e("DeviceSettingDescription", 41995, 7), new e("SubjectDistanceRange", 41996, 3), new e("ImageUniqueID", 42016, 2), new e("CameraOwnerName", 42032, 2), new e("BodySerialNumber", 42033, 2), new e("LensSpecification", 42034, 5), new e("LensMake", 42035, 2), new e("LensModel", 42036, 2), new e("Gamma", 42240, 5), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        a0 = eVarArr2;
        e[] eVarArr3 = {new e("GPSVersionID", 0, 1), new e("GPSLatitudeRef", 1, 2), new e("GPSLatitude", 2, 5, 10), new e("GPSLongitudeRef", 3, 2), new e("GPSLongitude", 4, 5, 10), new e("GPSAltitudeRef", 5, 1), new e("GPSAltitude", 6, 5), new e("GPSTimeStamp", 7, 5), new e("GPSSatellites", 8, 2), new e("GPSStatus", 9, 2), new e("GPSMeasureMode", 10, 2), new e("GPSDOP", 11, 5), new e("GPSSpeedRef", 12, 2), new e("GPSSpeed", 13, 5), new e("GPSTrackRef", 14, 2), new e("GPSTrack", 15, 5), new e("GPSImgDirectionRef", 16, 2), new e("GPSImgDirection", 17, 5), new e("GPSMapDatum", 18, 2), new e("GPSDestLatitudeRef", 19, 2), new e("GPSDestLatitude", 20, 5), new e("GPSDestLongitudeRef", 21, 2), new e("GPSDestLongitude", 22, 5), new e("GPSDestBearingRef", 23, 2), new e("GPSDestBearing", 24, 5), new e("GPSDestDistanceRef", 25, 2), new e("GPSDestDistance", 26, 5), new e("GPSProcessingMethod", 27, 7), new e("GPSAreaInformation", 28, 7), new e("GPSDateStamp", 29, 2), new e("GPSDifferential", 30, 3), new e("GPSHPositioningError", 31, 5)};
        b0 = eVarArr3;
        e[] eVarArr4 = {new e("InteroperabilityIndex", 1, 2)};
        c0 = eVarArr4;
        e[] eVarArr5 = {new e("NewSubfileType", SportHealthConfigure.CONFIGURE_TYPE_SPORT_MODE, 4), new e("SubfileType", 255, 4), new e("ThumbnailImageWidth", 256, 3, 4), new e("ThumbnailImageLength", Config.Y_DENSITY, 3, 4), new e("BitsPerSample", 258, 3), new e("Compression", 259, 3), new e("PhotometricInterpretation", 262, 3), new e("ImageDescription", 270, 2), new e("Make", 271, 2), new e("Model", 272, 2), new e("StripOffsets", 273, 3, 4), new e("ThumbnailOrientation", 274, 3), new e("SamplesPerPixel", 277, 3), new e("RowsPerStrip", 278, 3, 4), new e("StripByteCounts", 279, 3, 4), new e("XResolution", 282, 5), new e("YResolution", DfuBaseService.NOTIFICATION_ID, 5), new e("PlanarConfiguration", 284, 3), new e("ResolutionUnit", 296, 3), new e("TransferFunction", GifError.ERR_INVALID_PARAM, 3), new e("Software", 305, 2), new e("DateTime", 306, 2), new e("Artist", 315, 2), new e("WhitePoint", 318, 5), new e("PrimaryChromaticities", 319, 5), new e("SubIFDPointer", 330, 4), new e("JPEGInterchangeFormat", 513, 4), new e("JPEGInterchangeFormatLength", 514, 4), new e("YCbCrCoefficients", 529, 5), new e("YCbCrSubSampling", 530, 3), new e("YCbCrPositioning", 531, 3), new e("ReferenceBlackWhite", 532, 5), new e("Copyright", 33432, 2), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("DNGVersion", 50706, 1), new e("DefaultCropSize", 50720, 3, 4)};
        d0 = eVarArr5;
        e0 = new e("StripOffsets", 273, 3);
        e[] eVarArr6 = {new e("ThumbnailImage", 256, 7), new e("CameraSettingsIFDPointer", 8224, 4), new e("ImageProcessingIFDPointer", 8256, 4)};
        f0 = eVarArr6;
        e[] eVarArr7 = {new e("PreviewImageStart", Config.Y_DENSITY, 4), new e("PreviewImageLength", 258, 4)};
        g0 = eVarArr7;
        e[] eVarArr8 = {new e("AspectFrame", 4371, 3)};
        h0 = eVarArr8;
        e[] eVarArr9 = {new e("ColorSpace", 55, 3)};
        i0 = eVarArr9;
        e[][] eVarArr10 = {eVarArr, eVarArr2, eVarArr3, eVarArr4, eVarArr5, eVarArr, eVarArr6, eVarArr7, eVarArr8, eVarArr9};
        j0 = eVarArr10;
        k0 = new e[]{new e("SubIFDPointer", 330, 4), new e("ExifIFDPointer", 34665, 4), new e("GPSInfoIFDPointer", 34853, 4), new e("InteroperabilityIFDPointer", 40965, 4), new e("CameraSettingsIFDPointer", 8224, 1), new e("ImageProcessingIFDPointer", 8256, 1)};
        l0 = new e("JPEGInterchangeFormat", 513, 4);
        m0 = new e("JPEGInterchangeFormatLength", 514, 4);
        n0 = new HashMap[eVarArr10.length];
        o0 = new HashMap[eVarArr10.length];
        p0 = new HashSet(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        q0 = new HashMap();
        Charset charsetForName = Charset.forName("US-ASCII");
        r0 = charsetForName;
        s0 = "Exif\u0000\u0000".getBytes(charsetForName);
        t0 = "http://ns.adobe.com/xap/1.0/\u0000".getBytes(charsetForName);
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", locale);
        U = simpleDateFormat;
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(DateFormatUtils.YYYY_MM_DD_HH_MM_SS, locale);
        V = simpleDateFormat2;
        simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
        int i = 0;
        while (true) {
            e[][] eVarArr11 = j0;
            if (i >= eVarArr11.length) {
                HashMap map = q0;
                e[] eVarArr12 = k0;
                map.put(Integer.valueOf(eVarArr12[0].a), 5);
                map.put(Integer.valueOf(eVarArr12[1].a), 1);
                map.put(Integer.valueOf(eVarArr12[2].a), 2);
                map.put(Integer.valueOf(eVarArr12[3].a), 3);
                map.put(Integer.valueOf(eVarArr12[4].a), 7);
                map.put(Integer.valueOf(eVarArr12[5].a), 8);
                u0 = Pattern.compile(".*[1-9].*");
                v0 = Pattern.compile("^(\\d{2}):(\\d{2}):(\\d{2})$");
                w0 = Pattern.compile("^(\\d{4}):(\\d{2}):(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                x0 = Pattern.compile("^(\\d{4})-(\\d{2})-(\\d{2})\\s(\\d{2}):(\\d{2}):(\\d{2})$");
                return;
            }
            n0[i] = new HashMap();
            o0[i] = new HashMap();
            for (e eVar : eVarArr11[i]) {
                n0[i].put(Integer.valueOf(eVar.a), eVar);
                o0[i].put(eVar.b, eVar);
            }
            i++;
        }
    }

    public dj0(String str) throws Throwable {
        e[][] eVarArr = j0;
        this.f = new HashMap[eVarArr.length];
        this.g = new HashSet(eVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        G(str);
    }

    private void C(b bVar) throws Throwable {
        if (v) {
            Log.d("ExifInterface", "getWebpAttributes starting with: " + bVar);
        }
        bVar.mark(0);
        bVar.C(ByteOrder.LITTLE_ENDIAN);
        bVar.skipBytes(L.length);
        int i = bVar.readInt() + 8;
        int iSkipBytes = bVar.skipBytes(M.length) + 8;
        while (true) {
            try {
                byte[] bArr = new byte[4];
                if (bVar.read(bArr) != 4) {
                    throw new IOException("Encountered invalid length while parsing WebP chunktype");
                }
                int i2 = bVar.readInt();
                int i3 = iSkipBytes + 8;
                if (Arrays.equals(N, bArr)) {
                    byte[] bArr2 = new byte[i2];
                    if (bVar.read(bArr2) == i2) {
                        this.p = i3;
                        X(bArr2, 0);
                        j0(new b(bArr2));
                        return;
                    } else {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + b(bArr));
                    }
                }
                if (i2 % 2 == 1) {
                    i2++;
                }
                int i4 = i3 + i2;
                if (i4 == i) {
                    return;
                }
                if (i4 > i) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                int iSkipBytes2 = bVar.skipBytes(i2);
                if (iSkipBytes2 != i2) {
                    throw new IOException("Encountered WebP file with invalid chunk size");
                }
                iSkipBytes = i3 + iSkipBytes2;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt WebP file.");
            }
        }
    }

    private static Pair D(String str) {
        if (str.contains(",")) {
            String[] strArrSplit = str.split(",", -1);
            Pair pairD = D(strArrSplit[0]);
            if (((Integer) pairD.first).intValue() == 2) {
                return pairD;
            }
            for (int i = 1; i < strArrSplit.length; i++) {
                Pair pairD2 = D(strArrSplit[i]);
                int iIntValue = (((Integer) pairD2.first).equals(pairD.first) || ((Integer) pairD2.second).equals(pairD.first)) ? ((Integer) pairD.first).intValue() : -1;
                int iIntValue2 = (((Integer) pairD.second).intValue() == -1 || !(((Integer) pairD2.first).equals(pairD.second) || ((Integer) pairD2.second).equals(pairD.second))) ? -1 : ((Integer) pairD.second).intValue();
                if (iIntValue == -1 && iIntValue2 == -1) {
                    return new Pair(2, -1);
                }
                if (iIntValue == -1) {
                    pairD = new Pair(Integer.valueOf(iIntValue2), -1);
                } else if (iIntValue2 == -1) {
                    pairD = new Pair(Integer.valueOf(iIntValue), -1);
                }
            }
            return pairD;
        }
        if (!str.contains(WatchConstant.FAT_FS_ROOT)) {
            try {
                try {
                    long j = Long.parseLong(str);
                    if (j < 0 || j > 65535) {
                        return j < 0 ? new Pair(9, -1) : new Pair(4, -1);
                    }
                    return new Pair(3, 4);
                } catch (NumberFormatException unused) {
                    return new Pair(2, -1);
                }
            } catch (NumberFormatException unused2) {
                Double.parseDouble(str);
                return new Pair(12, -1);
            }
        }
        String[] strArrSplit2 = str.split(WatchConstant.FAT_FS_ROOT, -1);
        if (strArrSplit2.length == 2) {
            try {
                long j2 = (long) Double.parseDouble(strArrSplit2[0]);
                long j3 = (long) Double.parseDouble(strArrSplit2[1]);
                if (j2 >= 0 && j3 >= 0) {
                    if (j2 <= 2147483647L && j3 <= 2147483647L) {
                        return new Pair(10, 5);
                    }
                    return new Pair(5, -1);
                }
                return new Pair(10, -1);
            } catch (NumberFormatException unused3) {
            }
        }
        return new Pair(2, -1);
    }

    private void E(b bVar, HashMap map) throws Throwable {
        d dVar = (d) map.get("JPEGInterchangeFormat");
        d dVar2 = (d) map.get("JPEGInterchangeFormatLength");
        if (dVar == null || dVar2 == null) {
            return;
        }
        int iM = dVar.m(this.h);
        int iM2 = dVar2.m(this.h);
        if (this.d == 7) {
            iM += this.f324q;
        }
        int iMin = Math.min(iM2, bVar.n() - iM);
        if (iM > 0 && iMin > 0) {
            this.i = true;
            if (this.a == null && this.c == null && this.b == null) {
                byte[] bArr = new byte[iMin];
                bVar.skip(iM);
                bVar.read(bArr);
                this.n = bArr;
            }
            this.l = iM;
            this.m = iMin;
        }
        if (v) {
            Log.d("ExifInterface", "Setting thumbnail attributes with offset: " + iM + ", length: " + iMin);
        }
    }

    private void F(b bVar, HashMap map) {
        d dVar = (d) map.get("StripOffsets");
        d dVar2 = (d) map.get("StripByteCounts");
        if (dVar == null || dVar2 == null) {
            return;
        }
        long[] jArrG = g(dVar.o(this.h));
        long[] jArrG2 = g(dVar2.o(this.h));
        if (jArrG == null || jArrG.length == 0) {
            Log.w("ExifInterface", "stripOffsets should not be null or have zero length.");
            return;
        }
        if (jArrG2 == null || jArrG2.length == 0) {
            Log.w("ExifInterface", "stripByteCounts should not be null or have zero length.");
            return;
        }
        if (jArrG.length != jArrG2.length) {
            Log.w("ExifInterface", "stripOffsets and stripByteCounts should have same length.");
            return;
        }
        long j = 0;
        for (long j2 : jArrG2) {
            j += j2;
        }
        int i = (int) j;
        byte[] bArr = new byte[i];
        this.k = true;
        this.j = true;
        this.i = true;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < jArrG.length; i4++) {
            int i5 = (int) jArrG[i4];
            int i6 = (int) jArrG2[i4];
            if (i4 < jArrG.length - 1 && i5 + i6 != jArrG[i4 + 1]) {
                this.k = false;
            }
            int i7 = i5 - i2;
            if (i7 < 0) {
                Log.d("ExifInterface", "Invalid strip offset value");
                return;
            }
            long j3 = i7;
            if (bVar.skip(j3) != j3) {
                Log.d("ExifInterface", "Failed to skip " + i7 + " bytes.");
                return;
            }
            int i8 = i2 + i7;
            byte[] bArr2 = new byte[i6];
            if (bVar.read(bArr2) != i6) {
                Log.d("ExifInterface", "Failed to read " + i6 + " bytes.");
                return;
            }
            i2 = i8 + i6;
            System.arraycopy(bArr2, 0, bArr, i3, i6);
            i3 += i6;
        }
        this.n = bArr;
        if (this.k) {
            this.l = (int) jArrG[0];
            this.m = i;
        }
    }

    private void G(String str) throws Throwable {
        if (str == null) {
            throw new NullPointerException("filename cannot be null");
        }
        FileInputStream fileInputStream = null;
        this.c = null;
        this.a = str;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(str);
            try {
                if (O(fileInputStream2.getFD())) {
                    this.b = fileInputStream2.getFD();
                } else {
                    this.b = null;
                }
                T(fileInputStream2);
                d(fileInputStream2);
            } catch (Throwable th) {
                th = th;
                fileInputStream = fileInputStream2;
                d(fileInputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean H(BufferedInputStream bufferedInputStream) throws IOException {
        byte[] bArr = s0;
        bufferedInputStream.mark(bArr.length);
        byte[] bArr2 = new byte[bArr.length];
        bufferedInputStream.read(bArr2);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr3 = s0;
            if (i >= bArr3.length) {
                return true;
            }
            if (bArr2[i] != bArr3[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean I(byte[] bArr) throws Throwable {
        long j;
        b bVar = null;
        try {
            try {
                b bVar2 = new b(bArr);
                try {
                    long length = bVar2.readInt();
                    byte[] bArr2 = new byte[4];
                    bVar2.read(bArr2);
                    if (!Arrays.equals(bArr2, C)) {
                        bVar2.close();
                        return false;
                    }
                    if (length == 1) {
                        length = bVar2.readLong();
                        j = 16;
                        if (length < 16) {
                            bVar2.close();
                            return false;
                        }
                    } else {
                        j = 8;
                    }
                    if (length > bArr.length) {
                        length = bArr.length;
                    }
                    long j2 = length - j;
                    if (j2 < 8) {
                        bVar2.close();
                        return false;
                    }
                    byte[] bArr3 = new byte[4];
                    boolean z2 = false;
                    boolean z3 = false;
                    for (long j3 = 0; j3 < j2 / 4; j3++) {
                        if (bVar2.read(bArr3) != 4) {
                            bVar2.close();
                            return false;
                        }
                        if (j3 != 1) {
                            if (Arrays.equals(bArr3, D)) {
                                z2 = true;
                            } else if (Arrays.equals(bArr3, E)) {
                                z3 = true;
                            }
                            if (z2 && z3) {
                                bVar2.close();
                                return true;
                            }
                        }
                    }
                    bVar2.close();
                } catch (Exception e2) {
                    e = e2;
                    bVar = bVar2;
                    if (v) {
                        Log.d("ExifInterface", "Exception parsing HEIF file type box.", e);
                    }
                    if (bVar != null) {
                        bVar.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    bVar = bVar2;
                    if (bVar != null) {
                        bVar.close();
                    }
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean J(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = B;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean K(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderW = W(bVar2);
                this.h = byteOrderW;
                bVar2.C(byteOrderW);
                short s = bVar2.readShort();
                boolean z2 = s == 20306 || s == 21330;
                bVar2.close();
                return z2;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private boolean L(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = H;
            if (i >= bArr2.length) {
                return true;
            }
            if (bArr[i] != bArr2[i]) {
                return false;
            }
            i++;
        }
    }

    private boolean M(byte[] bArr) {
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        for (int i = 0; i < bytes.length; i++) {
            if (bArr[i] != bytes[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean N(byte[] bArr) throws Throwable {
        b bVar = null;
        try {
            b bVar2 = new b(bArr);
            try {
                ByteOrder byteOrderW = W(bVar2);
                this.h = byteOrderW;
                bVar2.C(byteOrderW);
                boolean z2 = bVar2.readShort() == 85;
                bVar2.close();
                return z2;
            } catch (Exception unused) {
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                return false;
            } catch (Throwable th) {
                th = th;
                bVar = bVar2;
                if (bVar != null) {
                    bVar.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean O(FileDescriptor fileDescriptor) {
        try {
            Os.lseek(fileDescriptor, 0L, OsConstants.SEEK_CUR);
            return true;
        } catch (Exception unused) {
            if (!v) {
                return false;
            }
            Log.d("ExifInterface", "The file descriptor for the given input is not seekable");
            return false;
        }
    }

    private boolean P(HashMap map) {
        d dVar;
        int iM;
        d dVar2 = (d) map.get("BitsPerSample");
        if (dVar2 != null) {
            int[] iArr = (int[]) dVar2.o(this.h);
            int[] iArr2 = y;
            if (Arrays.equals(iArr2, iArr)) {
                return true;
            }
            if (this.d == 3 && (dVar = (d) map.get("PhotometricInterpretation")) != null && (((iM = dVar.m(this.h)) == 1 && Arrays.equals(iArr, A)) || (iM == 6 && Arrays.equals(iArr, iArr2)))) {
                return true;
            }
        }
        if (!v) {
            return false;
        }
        Log.d("ExifInterface", "Unsupported data type value");
        return false;
    }

    private boolean Q() {
        int i = this.d;
        return i == 4 || i == 13 || i == 14;
    }

    private boolean R(HashMap map) {
        d dVar = (d) map.get("ImageLength");
        d dVar2 = (d) map.get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            return false;
        }
        return dVar.m(this.h) <= 512 && dVar2.m(this.h) <= 512;
    }

    private boolean S(byte[] bArr) {
        int i = 0;
        while (true) {
            byte[] bArr2 = L;
            if (i >= bArr2.length) {
                int i2 = 0;
                while (true) {
                    byte[] bArr3 = M;
                    if (i2 >= bArr3.length) {
                        return true;
                    }
                    if (bArr[L.length + i2 + 4] != bArr3[i2]) {
                        return false;
                    }
                    i2++;
                }
            } else {
                if (bArr[i] != bArr2[i]) {
                    return false;
                }
                i++;
            }
        }
    }

    private void T(InputStream inputStream) {
        if (inputStream == null) {
            throw new NullPointerException("inputstream shouldn't be null");
        }
        for (int i = 0; i < j0.length; i++) {
            try {
                try {
                    this.f[i] = new HashMap();
                } catch (IOException e2) {
                    boolean z2 = v;
                    if (z2) {
                        Log.w("ExifInterface", "Invalid image: ExifInterface got an unsupported image format file(ExifInterface supports JPEG and some RAW image formats only) or a corrupted JPEG file to ExifInterface.", e2);
                    }
                    a();
                    if (!z2) {
                        return;
                    }
                }
            } catch (Throwable th) {
                a();
                if (v) {
                    V();
                }
                throw th;
            }
        }
        if (!this.e) {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.d = t(bufferedInputStream);
            inputStream = bufferedInputStream;
        }
        b bVar = new b(inputStream);
        if (this.e) {
            z(bVar);
        } else {
            switch (this.d) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    x(bVar);
                    break;
                case 4:
                    r(bVar, 0, 0);
                    a();
                    if (v) {
                        V();
                        return;
                    }
                    return;
                case 7:
                    u(bVar);
                    break;
                case 9:
                    w(bVar);
                    a();
                    if (v) {
                        V();
                        return;
                    }
                    return;
                case 10:
                    y(bVar);
                    a();
                    if (v) {
                        V();
                        return;
                    }
                    return;
                case 12:
                    q(bVar);
                    break;
                case 13:
                    v(bVar);
                    a();
                    if (v) {
                        V();
                        return;
                    }
                    return;
                case 14:
                    C(bVar);
                    a();
                    if (v) {
                        V();
                        return;
                    }
                    return;
            }
        }
        bVar.y(this.p);
        j0(bVar);
        a();
        if (!v) {
            return;
        }
        V();
    }

    private void U(b bVar, int i) throws IOException {
        ByteOrder byteOrderW = W(bVar);
        this.h = byteOrderW;
        bVar.C(byteOrderW);
        int unsignedShort = bVar.readUnsignedShort();
        int i2 = this.d;
        if (i2 != 7 && i2 != 10 && unsignedShort != 42) {
            throw new IOException("Invalid start code: " + Integer.toHexString(unsignedShort));
        }
        int i3 = bVar.readInt();
        if (i3 < 8 || i3 >= i) {
            throw new IOException("Invalid first Ifd offset: " + i3);
        }
        int i4 = i3 - 8;
        if (i4 <= 0 || bVar.skipBytes(i4) == i4) {
            return;
        }
        throw new IOException("Couldn't jump to first Ifd: " + i4);
    }

    private void V() {
        for (int i = 0; i < this.f.length; i++) {
            Log.d("ExifInterface", "The size of tag group[" + i + "]: " + this.f[i].size());
            for (Map.Entry entry : this.f[i].entrySet()) {
                d dVar = (d) entry.getValue();
                Log.d("ExifInterface", "tagName: " + ((String) entry.getKey()) + ", tagType: " + dVar.toString() + ", tagValue: '" + dVar.n(this.h) + "'");
            }
        }
    }

    private ByteOrder W(b bVar) throws IOException {
        short s = bVar.readShort();
        if (s == 18761) {
            if (v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align II");
            }
            return ByteOrder.LITTLE_ENDIAN;
        }
        if (s == 19789) {
            if (v) {
                Log.d("ExifInterface", "readExifSegment: Byte Align MM");
            }
            return ByteOrder.BIG_ENDIAN;
        }
        throw new IOException("Invalid byte order: " + Integer.toHexString(s));
    }

    private void X(byte[] bArr, int i) throws IOException {
        b bVar = new b(bArr);
        U(bVar, bArr.length);
        Y(bVar, i);
    }

    /* JADX WARN: Code duplicated, block: B:101:0x026c  */
    /* JADX WARN: Code duplicated, block: B:108:0x02af A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:109:0x02b1  */
    /* JADX WARN: Code duplicated, block: B:111:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:113:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:116:0x030a  */
    /* JADX WARN: Code duplicated, block: B:118:0x0314  */
    /* JADX WARN: Code duplicated, block: B:127:0x0342  */
    /* JADX WARN: Code duplicated, block: B:156:0x0345 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:51:0x013b  */
    /* JADX WARN: Code duplicated, block: B:52:0x0140  */
    /* JADX WARN: Code duplicated, block: B:54:0x0148  */
    /* JADX WARN: Code duplicated, block: B:56:0x014e  */
    /* JADX WARN: Code duplicated, block: B:59:0x0167  */
    /* JADX WARN: Code duplicated, block: B:61:0x0175  */
    /* JADX WARN: Code duplicated, block: B:64:0x017c  */
    /* JADX WARN: Code duplicated, block: B:66:0x017f  */
    /* JADX WARN: Code duplicated, block: B:69:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x01d3  */
    /* JADX WARN: Code duplicated, block: B:73:0x01d7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:74:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:76:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:79:0x0205  */
    /* JADX WARN: Code duplicated, block: B:82:0x0226  */
    /* JADX WARN: Code duplicated, block: B:84:0x022a  */
    /* JADX WARN: Code duplicated, block: B:86:0x022d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:87:0x022f  */
    /* JADX WARN: Code duplicated, block: B:89:0x0233  */
    /* JADX WARN: Code duplicated, block: B:94:0x0240  */
    /* JADX WARN: Code duplicated, block: B:95:0x0245  */
    /* JADX WARN: Code duplicated, block: B:96:0x024a  */
    /* JADX WARN: Code duplicated, block: B:98:0x0251  */
    /* JADX WARN: Instruction removed from duplicated block: B:109:0x02b1, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:56:0x014e, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:74:0x01d9, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:79:0x0205, please report this as an issue */
    private void Y(b bVar, int i) throws IOException {
        e eVar;
        long j;
        boolean z2;
        int i2;
        Integer num;
        e eVar2;
        int i3;
        int unsignedShort;
        long jW;
        int i4;
        long j2;
        e eVar3;
        this.g.add(Integer.valueOf(bVar.d));
        if (bVar.d + 2 > bVar.c) {
            return;
        }
        short s = bVar.readShort();
        if (v) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + ((int) s));
        }
        if (bVar.d + (s * 12) > bVar.c || s <= 0) {
            return;
        }
        short s2 = 0;
        while (s2 < s) {
            int unsignedShort2 = bVar.readUnsignedShort();
            int unsignedShort3 = bVar.readUnsignedShort();
            int i5 = bVar.readInt();
            long jU = ((long) bVar.u()) + 4;
            e eVar4 = (e) n0[i].get(Integer.valueOf(unsignedShort2));
            boolean z3 = v;
            if (z3) {
                Log.d("ExifInterface", String.format("ifdType: %d, tagNumber: %d, tagName: %s, dataFormat: %d, numberOfComponents: %d", Integer.valueOf(i), Integer.valueOf(unsignedShort2), eVar4 != null ? eVar4.b : null, Integer.valueOf(unsignedShort3), Integer.valueOf(i5)));
            }
            if (eVar4 != null) {
                if (unsignedShort3 > 0) {
                    int[] iArr = X;
                    if (unsignedShort3 < iArr.length) {
                        if (eVar4.a(unsignedShort3)) {
                            if (unsignedShort3 == 7) {
                                unsignedShort3 = eVar4.c;
                            }
                            eVar = eVar4;
                            j = ((long) iArr[unsignedShort3]) * ((long) i5);
                            if (j < 0 || j > 2147483647L) {
                                if (z3) {
                                    Log.d("ExifInterface", "Skip the tag entry since the number of components is invalid: " + i5);
                                }
                                z2 = false;
                            } else {
                                z2 = true;
                            }
                        } else if (z3) {
                            Log.d("ExifInterface", "Skip the tag entry since data format (" + W[unsignedShort3] + ") is unexpected for tag: " + eVar4.b);
                        }
                    }
                    if (z2) {
                        if (j > 4) {
                            i4 = bVar.readInt();
                            if (z3) {
                                Log.d("ExifInterface", "seek to data offset: " + i4);
                            }
                            if (this.d == 7) {
                                eVar3 = eVar;
                                i2 = unsignedShort3;
                                if ("MakerNote".equals(eVar3.b)) {
                                    this.f324q = i4;
                                } else {
                                    if (i != 6 && "ThumbnailImage".equals(eVar3.b)) {
                                        this.r = i4;
                                        this.s = i5;
                                        d dVarJ = d.j(6, this.h);
                                        d dVarF = d.f(this.r, this.h);
                                        eVar = eVar3;
                                        d dVarF2 = d.f(this.s, this.h);
                                        this.f[4].put("Compression", dVarJ);
                                        this.f[4].put("JPEGInterchangeFormat", dVarF);
                                        this.f[4].put("JPEGInterchangeFormatLength", dVarF2);
                                    }
                                    j2 = i4;
                                    if (j2 + j <= bVar.c) {
                                        bVar.y(j2);
                                    } else {
                                        if (z3) {
                                            Log.d("ExifInterface", "Skip the tag entry since data offset is invalid: " + i4);
                                        }
                                        bVar.y(jU);
                                    }
                                }
                                eVar = eVar3;
                            } else {
                                i2 = unsignedShort3;
                            }
                            j2 = i4;
                            if (j2 + j <= bVar.c) {
                                bVar.y(j2);
                            } else {
                                if (z3) {
                                    Log.d("ExifInterface", "Skip the tag entry since data offset is invalid: " + i4);
                                }
                                bVar.y(jU);
                            }
                        } else {
                            i2 = unsignedShort3;
                            i5 = i5;
                        }
                        num = (Integer) q0.get(Integer.valueOf(unsignedShort2));
                        if (z3) {
                            Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j);
                        }
                        if (num != null) {
                            i3 = i2;
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    jW = bVar.w();
                                } else if (i3 == 8) {
                                    unsignedShort = bVar.readShort();
                                } else if (i3 != 9 || i3 == 13) {
                                    unsignedShort = bVar.readInt();
                                } else {
                                    jW = -1;
                                }
                                if (z3) {
                                    Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jW), eVar.b));
                                }
                                if (jW > 0 || jW >= bVar.c) {
                                    if (z3) {
                                        Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                                    }
                                } else if (!this.g.contains(Integer.valueOf((int) jW))) {
                                    bVar.y(jW);
                                    Y(bVar, num.intValue());
                                } else if (z3) {
                                    Log.d("ExifInterface", "Skip jump into the IFD since it has already been read: IfdType " + num + " (at " + jW + ")");
                                }
                                bVar.y(jU);
                            } else {
                                unsignedShort = bVar.readUnsignedShort();
                            }
                            jW = unsignedShort;
                            if (z3) {
                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jW), eVar.b));
                            }
                            if (jW > 0) {
                                if (z3) {
                                    Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                                }
                            } else if (z3) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                            }
                            bVar.y(jU);
                        } else {
                            eVar2 = eVar;
                            int iU = bVar.u() + this.p;
                            byte[] bArr = new byte[(int) j];
                            bVar.readFully(bArr);
                            d dVar = new d(i2, i5, iU, bArr);
                            this.f[i].put(eVar2.b, dVar);
                            if ("DNGVersion".equals(eVar2.b)) {
                                this.d = 3;
                            }
                            if (((!"Make".equals(eVar2.b) || "Model".equals(eVar2.b)) && dVar.n(this.h).contains("PENTAX")) || ("Compression".equals(eVar2.b) && dVar.m(this.h) == 65535)) {
                                this.d = 8;
                            }
                            if (bVar.u() != jU) {
                                bVar.y(jU);
                            }
                        }
                    } else {
                        bVar.y(jU);
                    }
                    s2 = (short) (s2 + 1);
                    s = s;
                }
                eVar = eVar4;
                if (z3) {
                    Log.d("ExifInterface", "Skip the tag entry since data format is invalid: " + unsignedShort3);
                }
                j = 0;
                z2 = false;
                if (z2) {
                    bVar.y(jU);
                } else {
                    if (j > 4) {
                        i4 = bVar.readInt();
                        if (z3) {
                            Log.d("ExifInterface", "seek to data offset: " + i4);
                        }
                        if (this.d == 7) {
                            eVar3 = eVar;
                            i2 = unsignedShort3;
                            if ("MakerNote".equals(eVar3.b)) {
                                this.f324q = i4;
                            } else if (i != 6) {
                            }
                            eVar = eVar3;
                        } else {
                            i2 = unsignedShort3;
                        }
                        j2 = i4;
                        if (j2 + j <= bVar.c) {
                            bVar.y(j2);
                        } else {
                            if (z3) {
                                Log.d("ExifInterface", "Skip the tag entry since data offset is invalid: " + i4);
                            }
                            bVar.y(jU);
                        }
                    } else {
                        i2 = unsignedShort3;
                        i5 = i5;
                    }
                    num = (Integer) q0.get(Integer.valueOf(unsignedShort2));
                    if (z3) {
                        Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j);
                    }
                    if (num != null) {
                        i3 = i2;
                        if (i3 != 3) {
                            if (i3 == 4) {
                                jW = bVar.w();
                            } else if (i3 == 8) {
                                if (i3 != 9) {
                                }
                                unsignedShort = bVar.readInt();
                            } else {
                                unsignedShort = bVar.readShort();
                            }
                            if (z3) {
                                Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jW), eVar.b));
                            }
                            if (jW > 0) {
                                if (z3) {
                                    Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                                }
                            } else if (z3) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                            }
                            bVar.y(jU);
                        } else {
                            unsignedShort = bVar.readUnsignedShort();
                        }
                        jW = unsignedShort;
                        if (z3) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jW), eVar.b));
                        }
                        if (jW > 0) {
                            if (z3) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                            }
                        } else if (z3) {
                            Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                        }
                        bVar.y(jU);
                    } else {
                        eVar2 = eVar;
                        int iU2 = bVar.u() + this.p;
                        byte[] bArr2 = new byte[(int) j];
                        bVar.readFully(bArr2);
                        d dVar2 = new d(i2, i5, iU2, bArr2);
                        this.f[i].put(eVar2.b, dVar2);
                        if ("DNGVersion".equals(eVar2.b)) {
                            this.d = 3;
                        }
                        if (!"Make".equals(eVar2.b)) {
                        }
                        this.d = 8;
                        if (bVar.u() != jU) {
                            bVar.y(jU);
                        }
                    }
                }
                s2 = (short) (s2 + 1);
                s = s;
            } else if (z3) {
                Log.d("ExifInterface", "Skip the tag entry since tag number is not defined: " + unsignedShort2);
            }
            eVar = eVar4;
            j = 0;
            z2 = false;
            if (z2) {
                bVar.y(jU);
            } else {
                if (j > 4) {
                    i4 = bVar.readInt();
                    if (z3) {
                        Log.d("ExifInterface", "seek to data offset: " + i4);
                    }
                    if (this.d == 7) {
                        eVar3 = eVar;
                        i2 = unsignedShort3;
                        if ("MakerNote".equals(eVar3.b)) {
                            this.f324q = i4;
                        } else if (i != 6) {
                        }
                        eVar = eVar3;
                    } else {
                        i2 = unsignedShort3;
                    }
                    j2 = i4;
                    if (j2 + j <= bVar.c) {
                        bVar.y(j2);
                    } else {
                        if (z3) {
                            Log.d("ExifInterface", "Skip the tag entry since data offset is invalid: " + i4);
                        }
                        bVar.y(jU);
                    }
                } else {
                    i2 = unsignedShort3;
                    i5 = i5;
                }
                num = (Integer) q0.get(Integer.valueOf(unsignedShort2));
                if (z3) {
                    Log.d("ExifInterface", "nextIfdType: " + num + " byteCount: " + j);
                }
                if (num != null) {
                    i3 = i2;
                    if (i3 != 3) {
                        if (i3 == 4) {
                            jW = bVar.w();
                        } else if (i3 == 8) {
                            if (i3 != 9) {
                            }
                            unsignedShort = bVar.readInt();
                        } else {
                            unsignedShort = bVar.readShort();
                        }
                        if (z3) {
                            Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jW), eVar.b));
                        }
                        if (jW > 0) {
                            if (z3) {
                                Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                            }
                        } else if (z3) {
                            Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                        }
                        bVar.y(jU);
                    } else {
                        unsignedShort = bVar.readUnsignedShort();
                    }
                    jW = unsignedShort;
                    if (z3) {
                        Log.d("ExifInterface", String.format("Offset: %d, tagName: %s", Long.valueOf(jW), eVar.b));
                    }
                    if (jW > 0) {
                        if (z3) {
                            Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                        }
                    } else if (z3) {
                        Log.d("ExifInterface", "Skip jump into the IFD since its offset is invalid: " + jW);
                    }
                    bVar.y(jU);
                } else {
                    eVar2 = eVar;
                    int iU3 = bVar.u() + this.p;
                    byte[] bArr3 = new byte[(int) j];
                    bVar.readFully(bArr3);
                    d dVar3 = new d(i2, i5, iU3, bArr3);
                    this.f[i].put(eVar2.b, dVar3);
                    if ("DNGVersion".equals(eVar2.b)) {
                        this.d = 3;
                    }
                    if (!"Make".equals(eVar2.b)) {
                    }
                    this.d = 8;
                    if (bVar.u() != jU) {
                        bVar.y(jU);
                    }
                }
            }
            s2 = (short) (s2 + 1);
            s = s;
        }
        if (bVar.u() + 4 <= bVar.c) {
            int i6 = bVar.readInt();
            boolean z4 = v;
            if (z4) {
                Log.d("ExifInterface", String.format("nextIfdOffset: %d", Integer.valueOf(i6)));
            }
            long j3 = i6;
            if (j3 <= 0 || i6 >= bVar.c) {
                if (z4) {
                    Log.d("ExifInterface", "Stop reading file since a wrong offset may cause an infinite loop: " + i6);
                    return;
                }
                return;
            }
            if (this.g.contains(Integer.valueOf(i6))) {
                if (z4) {
                    Log.d("ExifInterface", "Stop reading file since re-reading an IFD may cause an infinite loop: " + i6);
                    return;
                }
                return;
            }
            bVar.y(j3);
            if (this.f[4].isEmpty()) {
                Y(bVar, 4);
            } else if (this.f[5].isEmpty()) {
                Y(bVar, 5);
            }
        }
    }

    private void Z(String str) {
        for (int i = 0; i < j0.length; i++) {
            this.f[i].remove(str);
        }
    }

    private void a() {
        String strM = m("DateTimeOriginal");
        if (strM != null && m("DateTime") == null) {
            this.f[0].put("DateTime", d.e(strM));
        }
        if (m("ImageWidth") == null) {
            this.f[0].put("ImageWidth", d.f(0L, this.h));
        }
        if (m("ImageLength") == null) {
            this.f[0].put("ImageLength", d.f(0L, this.h));
        }
        if (m("Orientation") == null) {
            this.f[0].put("Orientation", d.f(0L, this.h));
        }
        if (m("LightSource") == null) {
            this.f[1].put("LightSource", d.f(0L, this.h));
        }
    }

    private void a0(b bVar, int i) throws Throwable {
        d dVar = (d) this.f[i].get("ImageLength");
        d dVar2 = (d) this.f[i].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            d dVar3 = (d) this.f[i].get("JPEGInterchangeFormat");
            d dVar4 = (d) this.f[i].get("JPEGInterchangeFormatLength");
            if (dVar3 == null || dVar4 == null) {
                return;
            }
            int iM = dVar3.m(this.h);
            int iM2 = dVar3.m(this.h);
            bVar.y(iM);
            byte[] bArr = new byte[iM2];
            bVar.read(bArr);
            r(new b(bArr), iM, i);
        }
    }

    private static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b2 : bArr) {
            sb.append(String.format("%02x", Byte.valueOf(b2)));
        }
        return sb.toString();
    }

    private static void c(FileDescriptor fileDescriptor) {
        try {
            Os.close(fileDescriptor);
        } catch (Exception unused) {
            Log.e("ExifInterface", "Error closing fd.");
        }
    }

    private void c0(InputStream inputStream, OutputStream outputStream) throws IOException {
        if (v) {
            Log.d("ExifInterface", "saveJpegAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        c cVar = new c(outputStream, ByteOrder.BIG_ENDIAN);
        if (dataInputStream.readByte() != -1) {
            throw new IOException("Invalid marker");
        }
        cVar.u(-1);
        if (dataInputStream.readByte() != -40) {
            throw new IOException("Invalid marker");
        }
        cVar.u(-40);
        d dVar = (m("Xmp") == null || !this.u) ? null : (d) this.f[0].remove("Xmp");
        cVar.u(-1);
        cVar.u(-31);
        o0(cVar);
        if (dVar != null) {
            this.f[0].put("Xmp", dVar);
        }
        byte[] bArr = new byte[4096];
        while (dataInputStream.readByte() == -1) {
            byte b2 = dataInputStream.readByte();
            if (b2 == -39 || b2 == -38) {
                cVar.u(-1);
                cVar.u(b2);
                h(dataInputStream, cVar);
                return;
            }
            if (b2 != -31) {
                cVar.u(-1);
                cVar.u(b2);
                int unsignedShort = dataInputStream.readUnsignedShort();
                cVar.D(unsignedShort);
                int i = unsignedShort - 2;
                if (i < 0) {
                    throw new IOException("Invalid length");
                }
                while (i > 0) {
                    int i2 = dataInputStream.read(bArr, 0, Math.min(i, 4096));
                    if (i2 < 0) {
                        break;
                    }
                    cVar.write(bArr, 0, i2);
                    i -= i2;
                }
            } else {
                int unsignedShort2 = dataInputStream.readUnsignedShort();
                int i3 = unsignedShort2 - 2;
                if (i3 < 0) {
                    throw new IOException("Invalid length");
                }
                byte[] bArr2 = new byte[6];
                if (i3 >= 6) {
                    if (dataInputStream.read(bArr2) != 6) {
                        throw new IOException("Invalid exif");
                    }
                    if (Arrays.equals(bArr2, s0)) {
                        int i4 = unsignedShort2 - 8;
                        if (dataInputStream.skipBytes(i4) != i4) {
                            throw new IOException("Invalid length");
                        }
                    }
                }
                cVar.u(-1);
                cVar.u(b2);
                cVar.D(unsignedShort2);
                if (i3 >= 6) {
                    i3 = unsignedShort2 - 8;
                    cVar.write(bArr2);
                }
                while (i3 > 0) {
                    int i5 = dataInputStream.read(bArr, 0, Math.min(i3, 4096));
                    if (i5 < 0) {
                        break;
                    }
                    cVar.write(bArr, 0, i5);
                    i3 -= i5;
                }
            }
        }
        throw new IOException("Invalid marker");
    }

    private static void d(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    private void d0(InputStream inputStream, OutputStream outputStream) throws Throwable {
        if (v) {
            Log.d("ExifInterface", "savePngAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = H;
        i(dataInputStream, cVar, bArr.length);
        int i = this.p;
        if (i == 0) {
            int i2 = dataInputStream.readInt();
            cVar.w(i2);
            i(dataInputStream, cVar, i2 + 8);
        } else {
            i(dataInputStream, cVar, (i - bArr.length) - 8);
            dataInputStream.skipBytes(dataInputStream.readInt() + 8);
        }
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                o0(cVar2);
                byte[] byteArray = ((ByteArrayOutputStream) cVar2.a).toByteArray();
                cVar.write(byteArray);
                CRC32 crc32 = new CRC32();
                crc32.update(byteArray, 4, byteArray.length - 4);
                cVar.w((int) crc32.getValue());
                d(byteArrayOutputStream2);
                h(dataInputStream, cVar);
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream = byteArrayOutputStream2;
                d(byteArrayOutputStream);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private String e(double d2) {
        long j = (long) d2;
        double d3 = d2 - j;
        long j2 = (long) (d3 * 60.0d);
        return j + "/1," + j2 + "/1," + Math.round((d3 - (j2 / 60.0d)) * 3600.0d * 1.0E7d) + "/10000000";
    }

    private void e0(InputStream inputStream, OutputStream outputStream) throws Throwable {
        int i;
        int i2;
        int i3;
        int i4;
        if (v) {
            Log.d("ExifInterface", "saveWebpAttributes starting with (inputStream: " + inputStream + ", outputStream: " + outputStream + ")");
        }
        ByteOrder byteOrder = ByteOrder.LITTLE_ENDIAN;
        b bVar = new b(inputStream, byteOrder);
        c cVar = new c(outputStream, byteOrder);
        byte[] bArr = L;
        i(bVar, cVar, bArr.length);
        byte[] bArr2 = M;
        bVar.skipBytes(bArr2.length + 4);
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            try {
                ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                try {
                    c cVar2 = new c(byteArrayOutputStream2, byteOrder);
                    int i5 = this.p;
                    if (i5 != 0) {
                        i(bVar, cVar2, (i5 - ((bArr.length + 4) + bArr2.length)) - 8);
                        bVar.skipBytes(4);
                        bVar.skipBytes(bVar.readInt());
                        o0(cVar2);
                    } else {
                        byte[] bArr3 = new byte[4];
                        if (bVar.read(bArr3) != 4) {
                            throw new IOException("Encountered invalid length while parsing WebP chunk type");
                        }
                        byte[] bArr4 = P;
                        if (Arrays.equals(bArr3, bArr4)) {
                            int i6 = bVar.readInt();
                            byte[] bArr5 = new byte[i6 % 2 == 1 ? i6 + 1 : i6];
                            bVar.read(bArr5);
                            byte b2 = (byte) (8 | bArr5[0]);
                            bArr5[0] = b2;
                            boolean z2 = ((b2 >> 1) & 1) == 1;
                            cVar2.write(bArr4);
                            cVar2.w(i6);
                            cVar2.write(bArr5);
                            if (z2) {
                                j(bVar, cVar2, S, null);
                                while (true) {
                                    byte[] bArr6 = new byte[4];
                                    inputStream.read(bArr6);
                                    if (!Arrays.equals(bArr6, T)) {
                                        break;
                                    } else {
                                        k(bVar, cVar2, bArr6);
                                    }
                                }
                                o0(cVar2);
                            } else {
                                j(bVar, cVar2, R, Q);
                                o0(cVar2);
                            }
                        } else {
                            byte[] bArr7 = R;
                            if (Arrays.equals(bArr3, bArr7) || Arrays.equals(bArr3, Q)) {
                                int i7 = bVar.readInt();
                                int i8 = i7 % 2 == 1 ? i7 + 1 : i7;
                                byte[] bArr8 = new byte[3];
                                if (Arrays.equals(bArr3, bArr7)) {
                                    bVar.read(bArr8);
                                    byte[] bArr9 = new byte[3];
                                    if (bVar.read(bArr9) != 3 || !Arrays.equals(O, bArr9)) {
                                        throw new IOException("Encountered error while checking VP8 signature");
                                    }
                                    i = bVar.readInt();
                                    i2 = (i << 18) >> 18;
                                    i3 = (i << 2) >> 18;
                                    i8 -= 10;
                                    i4 = 0;
                                } else if (!Arrays.equals(bArr3, Q)) {
                                    i = 0;
                                    i2 = 0;
                                    i3 = 0;
                                    i4 = 0;
                                } else {
                                    if (bVar.readByte() != 47) {
                                        throw new IOException("Encountered error while checking VP8L signature");
                                    }
                                    i = bVar.readInt();
                                    i4 = i & 8;
                                    i8 -= 5;
                                    i3 = ((i << 4) >> 18) + 1;
                                    i2 = ((i << 18) >> 18) + 1;
                                }
                                cVar2.write(bArr4);
                                cVar2.w(10);
                                byte[] bArr10 = new byte[10];
                                byte b3 = (byte) (bArr10[0] | 8);
                                bArr10[0] = b3;
                                bArr10[0] = (byte) (b3 | (i4 << 4));
                                int i9 = i2 - 1;
                                int i10 = i3 - 1;
                                bArr10[4] = (byte) i9;
                                bArr10[5] = (byte) (i9 >> 8);
                                bArr10[6] = (byte) (i9 >> 16);
                                bArr10[7] = (byte) i10;
                                bArr10[8] = (byte) (i10 >> 8);
                                bArr10[9] = (byte) (i10 >> 16);
                                cVar2.write(bArr10);
                                cVar2.write(bArr3);
                                cVar2.w(i7);
                                if (Arrays.equals(bArr3, bArr7)) {
                                    cVar2.write(bArr8);
                                    cVar2.write(O);
                                    cVar2.w(i);
                                } else if (Arrays.equals(bArr3, Q)) {
                                    cVar2.write(47);
                                    cVar2.w(i);
                                }
                                i(bVar, cVar2, i8);
                                o0(cVar2);
                            }
                        }
                    }
                    h(bVar, cVar2);
                    int size = byteArrayOutputStream2.size();
                    byte[] bArr11 = M;
                    cVar.w(size + bArr11.length);
                    cVar.write(bArr11);
                    byteArrayOutputStream2.writeTo(cVar);
                    d(byteArrayOutputStream2);
                } catch (Exception e2) {
                    e = e2;
                    throw new IOException("Failed to save WebP file", e);
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    d(byteArrayOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    private static double f(String str, String str2) {
        try {
            String[] strArrSplit = str.split(",", -1);
            String[] strArrSplit2 = strArrSplit[0].split(WatchConstant.FAT_FS_ROOT, -1);
            double d2 = Double.parseDouble(strArrSplit2[0].trim()) / Double.parseDouble(strArrSplit2[1].trim());
            String[] strArrSplit3 = strArrSplit[1].split(WatchConstant.FAT_FS_ROOT, -1);
            double d3 = Double.parseDouble(strArrSplit3[0].trim()) / Double.parseDouble(strArrSplit3[1].trim());
            String[] strArrSplit4 = strArrSplit[2].split(WatchConstant.FAT_FS_ROOT, -1);
            double d4 = d2 + (d3 / 60.0d) + ((Double.parseDouble(strArrSplit4[0].trim()) / Double.parseDouble(strArrSplit4[1].trim())) / 3600.0d);
            if (!str2.equals("S") && !str2.equals("W")) {
                if (!str2.equals("N") && !str2.equals("E")) {
                    throw new IllegalArgumentException();
                }
                return d4;
            }
            return -d4;
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException unused) {
            throw new IllegalArgumentException();
        }
    }

    private static long[] g(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            jArr[i] = iArr[i];
        }
        return jArr;
    }

    private static int h(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i = 0;
        while (true) {
            int i2 = inputStream.read(bArr);
            if (i2 == -1) {
                return i;
            }
            i += i2;
            outputStream.write(bArr, 0, i2);
        }
    }

    private static void i(InputStream inputStream, OutputStream outputStream, int i) throws IOException {
        byte[] bArr = new byte[8192];
        while (i > 0) {
            int iMin = Math.min(i, 8192);
            int i2 = inputStream.read(bArr, 0, iMin);
            if (i2 != iMin) {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
            i -= i2;
            outputStream.write(bArr, 0, i2);
        }
    }

    private void j(b bVar, c cVar, byte[] bArr, byte[] bArr2) throws IOException {
        String str;
        while (true) {
            byte[] bArr3 = new byte[4];
            if (bVar.read(bArr3) != 4) {
                StringBuilder sb = new StringBuilder();
                sb.append("Encountered invalid length while copying WebP chunks up tochunk type ");
                Charset charset = r0;
                sb.append(new String(bArr, charset));
                if (bArr2 == null) {
                    str = Constants.STR_EMPTY;
                } else {
                    str = " or " + new String(bArr2, charset);
                }
                sb.append(str);
                throw new IOException(sb.toString());
            }
            k(bVar, cVar, bArr3);
            if (Arrays.equals(bArr3, bArr)) {
                return;
            }
            if (bArr2 != null && Arrays.equals(bArr3, bArr2)) {
                return;
            }
        }
    }

    private void j0(b bVar) throws Throwable {
        HashMap map = this.f[4];
        d dVar = (d) map.get("Compression");
        if (dVar == null) {
            this.o = 6;
            E(bVar, map);
            return;
        }
        int iM = dVar.m(this.h);
        this.o = iM;
        if (iM != 1) {
            if (iM == 6) {
                E(bVar, map);
                return;
            } else if (iM != 7) {
                return;
            }
        }
        if (P(map)) {
            F(bVar, map);
        }
    }

    private void k(b bVar, c cVar, byte[] bArr) throws IOException {
        int i = bVar.readInt();
        cVar.write(bArr);
        cVar.w(i);
        if (i % 2 == 1) {
            i++;
        }
        i(bVar, cVar, i);
    }

    private static boolean k0(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i = 0; i < bArr2.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private void l0(int i, int i2) throws Throwable {
        if (this.f[i].isEmpty() || this.f[i2].isEmpty()) {
            if (v) {
                Log.d("ExifInterface", "Cannot perform swap since only one image data exists");
                return;
            }
            return;
        }
        d dVar = (d) this.f[i].get("ImageLength");
        d dVar2 = (d) this.f[i].get("ImageWidth");
        d dVar3 = (d) this.f[i2].get("ImageLength");
        d dVar4 = (d) this.f[i2].get("ImageWidth");
        if (dVar == null || dVar2 == null) {
            if (v) {
                Log.d("ExifInterface", "First image does not contain valid size information");
                return;
            }
            return;
        }
        if (dVar3 == null || dVar4 == null) {
            if (v) {
                Log.d("ExifInterface", "Second image does not contain valid size information");
                return;
            }
            return;
        }
        int iM = dVar.m(this.h);
        int iM2 = dVar2.m(this.h);
        int iM3 = dVar3.m(this.h);
        int iM4 = dVar4.m(this.h);
        if (iM >= iM3 || iM2 >= iM4) {
            return;
        }
        HashMap[] mapArr = this.f;
        HashMap map = mapArr[i];
        mapArr[i] = mapArr[i2];
        mapArr[i2] = map;
    }

    private void m0(b bVar, int i) throws Throwable {
        d dVarJ;
        d dVarJ2;
        d dVar = (d) this.f[i].get("DefaultCropSize");
        d dVar2 = (d) this.f[i].get("SensorTopBorder");
        d dVar3 = (d) this.f[i].get("SensorLeftBorder");
        d dVar4 = (d) this.f[i].get("SensorBottomBorder");
        d dVar5 = (d) this.f[i].get("SensorRightBorder");
        if (dVar == null) {
            if (dVar2 == null || dVar3 == null || dVar4 == null || dVar5 == null) {
                a0(bVar, i);
                return;
            }
            int iM = dVar2.m(this.h);
            int iM2 = dVar4.m(this.h);
            int iM3 = dVar5.m(this.h);
            int iM4 = dVar3.m(this.h);
            if (iM2 <= iM || iM3 <= iM4) {
                return;
            }
            d dVarJ3 = d.j(iM2 - iM, this.h);
            d dVarJ4 = d.j(iM3 - iM4, this.h);
            this.f[i].put("ImageLength", dVarJ3);
            this.f[i].put("ImageWidth", dVarJ4);
            return;
        }
        if (dVar.a == 5) {
            f[] fVarArr = (f[]) dVar.o(this.h);
            if (fVarArr == null || fVarArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(fVarArr));
                return;
            }
            dVarJ = d.h(fVarArr[0], this.h);
            dVarJ2 = d.h(fVarArr[1], this.h);
        } else {
            int[] iArr = (int[]) dVar.o(this.h);
            if (iArr == null || iArr.length != 2) {
                Log.w("ExifInterface", "Invalid crop size values. cropSize=" + Arrays.toString(iArr));
                return;
            }
            dVarJ = d.j(iArr[0], this.h);
            dVarJ2 = d.j(iArr[1], this.h);
        }
        this.f[i].put("ImageWidth", dVarJ);
        this.f[i].put("ImageLength", dVarJ2);
    }

    private void n0() throws Throwable {
        l0(0, 5);
        l0(0, 4);
        l0(5, 4);
        d dVar = (d) this.f[1].get("PixelXDimension");
        d dVar2 = (d) this.f[1].get("PixelYDimension");
        if (dVar != null && dVar2 != null) {
            this.f[0].put("ImageWidth", dVar);
            this.f[0].put("ImageLength", dVar2);
        }
        if (this.f[4].isEmpty() && R(this.f[5])) {
            HashMap[] mapArr = this.f;
            mapArr[4] = mapArr[5];
            mapArr[5] = new HashMap();
        }
        if (R(this.f[4])) {
            return;
        }
        Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
    }

    private int o0(c cVar) throws IOException {
        e[][] eVarArr = j0;
        int[] iArr = new int[eVarArr.length];
        int[] iArr2 = new int[eVarArr.length];
        for (e eVar : k0) {
            Z(eVar.b);
        }
        Z(l0.b);
        Z(m0.b);
        for (int i = 0; i < j0.length; i++) {
            for (Object obj : this.f[i].entrySet().toArray()) {
                Map.Entry entry = (Map.Entry) obj;
                if (entry.getValue() == null) {
                    this.f[i].remove(entry.getKey());
                }
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(k0[1].b, d.f(0L, this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(k0[2].b, d.f(0L, this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(k0[3].b, d.f(0L, this.h));
        }
        if (this.i) {
            this.f[4].put(l0.b, d.f(0L, this.h));
            this.f[4].put(m0.b, d.f(this.m, this.h));
        }
        for (int i2 = 0; i2 < j0.length; i2++) {
            Iterator it = this.f[i2].entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                int iP = ((d) ((Map.Entry) it.next()).getValue()).p();
                if (iP > 4) {
                    i3 += iP;
                }
            }
            iArr2[i2] = iArr2[i2] + i3;
        }
        int size = 8;
        for (int i4 = 0; i4 < j0.length; i4++) {
            if (!this.f[i4].isEmpty()) {
                iArr[i4] = size;
                size += (this.f[i4].size() * 12) + 6 + iArr2[i4];
            }
        }
        if (this.i) {
            this.f[4].put(l0.b, d.f(size, this.h));
            this.l = size;
            size += this.m;
        }
        if (this.d == 4) {
            size += 8;
        }
        if (v) {
            for (int i5 = 0; i5 < j0.length; i5++) {
                Log.d("ExifInterface", String.format("index: %d, offsets: %d, tag count: %d, data sizes: %d, total size: %d", Integer.valueOf(i5), Integer.valueOf(iArr[i5]), Integer.valueOf(this.f[i5].size()), Integer.valueOf(iArr2[i5]), Integer.valueOf(size)));
            }
        }
        if (!this.f[1].isEmpty()) {
            this.f[0].put(k0[1].b, d.f(iArr[1], this.h));
        }
        if (!this.f[2].isEmpty()) {
            this.f[0].put(k0[2].b, d.f(iArr[2], this.h));
        }
        if (!this.f[3].isEmpty()) {
            this.f[1].put(k0[3].b, d.f(iArr[3], this.h));
        }
        int i6 = this.d;
        if (i6 == 4) {
            cVar.D(size);
            cVar.write(s0);
        } else if (i6 == 13) {
            cVar.w(size);
            cVar.write(I);
        } else if (i6 == 14) {
            cVar.write(N);
            cVar.w(size);
        }
        cVar.y(this.h == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
        cVar.n(this.h);
        cVar.D(42);
        cVar.C(8L);
        for (int i7 = 0; i7 < j0.length; i7++) {
            if (!this.f[i7].isEmpty()) {
                cVar.D(this.f[i7].size());
                int size2 = iArr[i7] + 2 + (this.f[i7].size() * 12) + 4;
                for (Map.Entry entry2 : this.f[i7].entrySet()) {
                    int i8 = ((e) o0[i7].get(entry2.getKey())).a;
                    d dVar = (d) entry2.getValue();
                    int iP2 = dVar.p();
                    cVar.D(i8);
                    cVar.D(dVar.a);
                    cVar.w(dVar.b);
                    if (iP2 > 4) {
                        cVar.C(size2);
                        size2 += iP2;
                    } else {
                        cVar.write(dVar.d);
                        if (iP2 < 4) {
                            while (iP2 < 4) {
                                cVar.u(0);
                                iP2++;
                            }
                        }
                    }
                }
                if (i7 != 0 || this.f[4].isEmpty()) {
                    cVar.C(0L);
                } else {
                    cVar.C(iArr[4]);
                }
                Iterator it2 = this.f[i7].entrySet().iterator();
                while (it2.hasNext()) {
                    byte[] bArr = ((d) ((Map.Entry) it2.next()).getValue()).d;
                    if (bArr.length > 4) {
                        cVar.write(bArr, 0, bArr.length);
                    }
                }
            }
        }
        if (this.i) {
            cVar.write(B());
        }
        if (this.d == 14 && size % 2 == 1) {
            cVar.u(0);
        }
        cVar.n(ByteOrder.BIG_ENDIAN);
        return size;
    }

    private d p(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if ("ISOSpeedRatings".equals(str)) {
            if (v) {
                Log.d("ExifInterface", "getExifAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < j0.length; i++) {
            d dVar = (d) this.f[i].get(str);
            if (dVar != null) {
                return dVar;
            }
        }
        return null;
    }

    private void q(b bVar) throws IOException {
        String strExtractMetadata;
        String strExtractMetadata2;
        String strExtractMetadata3;
        int i;
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            mediaMetadataRetriever.setDataSource(new a(bVar));
            String strExtractMetadata4 = mediaMetadataRetriever.extractMetadata(33);
            String strExtractMetadata5 = mediaMetadataRetriever.extractMetadata(34);
            String strExtractMetadata6 = mediaMetadataRetriever.extractMetadata(26);
            String strExtractMetadata7 = mediaMetadataRetriever.extractMetadata(17);
            if ("yes".equals(strExtractMetadata6)) {
                strExtractMetadata = mediaMetadataRetriever.extractMetadata(29);
                strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(30);
                strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(31);
            } else if ("yes".equals(strExtractMetadata7)) {
                strExtractMetadata = mediaMetadataRetriever.extractMetadata(18);
                strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                strExtractMetadata3 = mediaMetadataRetriever.extractMetadata(24);
            } else {
                strExtractMetadata = null;
                strExtractMetadata2 = null;
                strExtractMetadata3 = null;
            }
            if (strExtractMetadata != null) {
                this.f[0].put("ImageWidth", d.j(Integer.parseInt(strExtractMetadata), this.h));
            }
            if (strExtractMetadata2 != null) {
                this.f[0].put("ImageLength", d.j(Integer.parseInt(strExtractMetadata2), this.h));
            }
            if (strExtractMetadata3 != null) {
                int i2 = Integer.parseInt(strExtractMetadata3);
                if (i2 == 90) {
                    i = 6;
                } else if (i2 != 180) {
                    i = i2 != 270 ? 1 : 8;
                } else {
                    i = 3;
                }
                this.f[0].put("Orientation", d.j(i, this.h));
            }
            if (strExtractMetadata4 != null && strExtractMetadata5 != null) {
                int i3 = Integer.parseInt(strExtractMetadata4);
                int i4 = Integer.parseInt(strExtractMetadata5);
                if (i4 <= 6) {
                    throw new IOException("Invalid exif length");
                }
                bVar.y(i3);
                byte[] bArr = new byte[6];
                if (bVar.read(bArr) != 6) {
                    throw new IOException("Can't read identifier");
                }
                int i5 = i3 + 6;
                int i6 = i4 - 6;
                if (!Arrays.equals(bArr, s0)) {
                    throw new IOException("Invalid identifier");
                }
                byte[] bArr2 = new byte[i6];
                if (bVar.read(bArr2) != i6) {
                    throw new IOException("Can't read exif");
                }
                this.p = i5;
                X(bArr2, 0);
            }
            if (v) {
                Log.d("ExifInterface", "Heif meta: " + strExtractMetadata + "x" + strExtractMetadata2 + ", rotation " + strExtractMetadata3);
            }
            mediaMetadataRetriever.release();
        } catch (Throwable th) {
            mediaMetadataRetriever.release();
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:34:0x00ba A[FALL_THROUGH] */
    /* JADX WARN: Code duplicated, block: B:36:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:79:0x00eb A[SYNTHETIC] */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1095)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:419)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:399)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:89)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:31)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:91)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:21)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private void r(dj0.b r21, int r22, int r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 548
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dj0.r(dj0$b, int, int):void");
    }

    private int t(BufferedInputStream bufferedInputStream) throws IOException {
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        if (J(bArr)) {
            return 4;
        }
        if (M(bArr)) {
            return 9;
        }
        if (I(bArr)) {
            return 12;
        }
        if (K(bArr)) {
            return 7;
        }
        if (N(bArr)) {
            return 10;
        }
        if (L(bArr)) {
            return 13;
        }
        return S(bArr) ? 14 : 0;
    }

    private void u(b bVar) throws Throwable {
        int i;
        int i2;
        x(bVar);
        d dVar = (d) this.f[1].get("MakerNote");
        if (dVar != null) {
            b bVar2 = new b(dVar.d);
            bVar2.C(this.h);
            byte[] bArr = F;
            byte[] bArr2 = new byte[bArr.length];
            bVar2.readFully(bArr2);
            bVar2.y(0L);
            byte[] bArr3 = G;
            byte[] bArr4 = new byte[bArr3.length];
            bVar2.readFully(bArr4);
            if (Arrays.equals(bArr2, bArr)) {
                bVar2.y(8L);
            } else if (Arrays.equals(bArr4, bArr3)) {
                bVar2.y(12L);
            }
            Y(bVar2, 6);
            d dVar2 = (d) this.f[7].get("PreviewImageStart");
            d dVar3 = (d) this.f[7].get("PreviewImageLength");
            if (dVar2 != null && dVar3 != null) {
                this.f[5].put("JPEGInterchangeFormat", dVar2);
                this.f[5].put("JPEGInterchangeFormatLength", dVar3);
            }
            d dVar4 = (d) this.f[8].get("AspectFrame");
            if (dVar4 != null) {
                int[] iArr = (int[]) dVar4.o(this.h);
                if (iArr == null || iArr.length != 4) {
                    Log.w("ExifInterface", "Invalid aspect frame values. frame=" + Arrays.toString(iArr));
                    return;
                }
                int i3 = iArr[2];
                int i4 = iArr[0];
                if (i3 <= i4 || (i = iArr[3]) <= (i2 = iArr[1])) {
                    return;
                }
                int i5 = (i3 - i4) + 1;
                int i6 = (i - i2) + 1;
                if (i5 < i6) {
                    int i7 = i5 + i6;
                    i6 = i7 - i6;
                    i5 = i7 - i6;
                }
                d dVarJ = d.j(i5, this.h);
                d dVarJ2 = d.j(i6, this.h);
                this.f[0].put("ImageWidth", dVarJ);
                this.f[0].put("ImageLength", dVarJ2);
            }
        }
    }

    private void v(b bVar) throws Throwable {
        if (v) {
            Log.d("ExifInterface", "getPngAttributes starting with: " + bVar);
        }
        bVar.mark(0);
        bVar.C(ByteOrder.BIG_ENDIAN);
        byte[] bArr = H;
        bVar.skipBytes(bArr.length);
        int length = bArr.length;
        while (true) {
            try {
                int i = bVar.readInt();
                byte[] bArr2 = new byte[4];
                if (bVar.read(bArr2) != 4) {
                    throw new IOException("Encountered invalid length while parsing PNG chunktype");
                }
                int i2 = length + 8;
                if (i2 == 16 && !Arrays.equals(bArr2, J)) {
                    throw new IOException("Encountered invalid PNG file--IHDR chunk should appearas the first chunk");
                }
                if (Arrays.equals(bArr2, K)) {
                    return;
                }
                if (Arrays.equals(bArr2, I)) {
                    byte[] bArr3 = new byte[i];
                    if (bVar.read(bArr3) != i) {
                        throw new IOException("Failed to read given length for given PNG chunk type: " + b(bArr2));
                    }
                    int i3 = bVar.readInt();
                    CRC32 crc32 = new CRC32();
                    crc32.update(bArr2);
                    crc32.update(bArr3);
                    if (((int) crc32.getValue()) == i3) {
                        this.p = i2;
                        X(bArr3, 0);
                        n0();
                        j0(new b(bArr3));
                        return;
                    }
                    throw new IOException("Encountered invalid CRC value for PNG-EXIF chunk.\n recorded CRC value: " + i3 + ", calculated CRC value: " + crc32.getValue());
                }
                int i4 = i + 4;
                bVar.skipBytes(i4);
                length = i2 + i4;
            } catch (EOFException unused) {
                throw new IOException("Encountered corrupt PNG file.");
            }
        }
    }

    private void w(b bVar) throws Throwable {
        boolean z2 = v;
        if (z2) {
            Log.d("ExifInterface", "getRafAttributes starting with: " + bVar);
        }
        bVar.mark(0);
        bVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        byte[] bArr3 = new byte[4];
        bVar.read(bArr);
        bVar.read(bArr2);
        bVar.read(bArr3);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        int i3 = ByteBuffer.wrap(bArr3).getInt();
        byte[] bArr4 = new byte[i2];
        bVar.y(i);
        bVar.read(bArr4);
        r(new b(bArr4), i, 5);
        bVar.y(i3);
        bVar.C(ByteOrder.BIG_ENDIAN);
        int i4 = bVar.readInt();
        if (z2) {
            Log.d("ExifInterface", "numberOfDirectoryEntry: " + i4);
        }
        for (int i5 = 0; i5 < i4; i5++) {
            int unsignedShort = bVar.readUnsignedShort();
            int unsignedShort2 = bVar.readUnsignedShort();
            if (unsignedShort == e0.a) {
                short s = bVar.readShort();
                short s2 = bVar.readShort();
                d dVarJ = d.j(s, this.h);
                d dVarJ2 = d.j(s2, this.h);
                this.f[0].put("ImageLength", dVarJ);
                this.f[0].put("ImageWidth", dVarJ2);
                if (v) {
                    Log.d("ExifInterface", "Updated to length: " + ((int) s) + ", width: " + ((int) s2));
                    return;
                }
                return;
            }
            bVar.skipBytes(unsignedShort2);
        }
    }

    private void x(b bVar) throws Throwable {
        d dVar;
        U(bVar, bVar.available());
        Y(bVar, 0);
        m0(bVar, 0);
        m0(bVar, 5);
        m0(bVar, 4);
        n0();
        if (this.d != 8 || (dVar = (d) this.f[1].get("MakerNote")) == null) {
            return;
        }
        b bVar2 = new b(dVar.d);
        bVar2.C(this.h);
        bVar2.y(6L);
        Y(bVar2, 9);
        d dVar2 = (d) this.f[9].get("ColorSpace");
        if (dVar2 != null) {
            this.f[1].put("ColorSpace", dVar2);
        }
    }

    private void y(b bVar) throws Throwable {
        if (v) {
            Log.d("ExifInterface", "getRw2Attributes starting with: " + bVar);
        }
        x(bVar);
        d dVar = (d) this.f[0].get("JpgFromRaw");
        if (dVar != null) {
            r(new b(dVar.d), (int) dVar.c, 5);
        }
        d dVar2 = (d) this.f[0].get("ISO");
        d dVar3 = (d) this.f[1].get("PhotographicSensitivity");
        if (dVar2 == null || dVar3 != null) {
            return;
        }
        this.f[1].put("PhotographicSensitivity", dVar2);
    }

    private void z(b bVar) throws IOException {
        byte[] bArr = s0;
        bVar.skipBytes(bArr.length);
        byte[] bArr2 = new byte[bVar.available()];
        bVar.readFully(bArr2);
        this.p = bArr.length;
        X(bArr2, 0);
    }

    public byte[] A() {
        int i = this.o;
        if (i == 6 || i == 7) {
            return B();
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:57:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b0  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v5, types: [android.content.res.AssetManager$AssetInputStream, java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.Closeable, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r2v3 */
    public byte[] B() throws Throwable {
        FileDescriptor fileDescriptor;
        Exception e2;
        FileDescriptor fileDescriptor2;
        ?? fileInputStream;
        ?? r2 = 0;
        r2 = 0;
        if (!this.i) {
            return null;
        }
        ?? fileInputStream2 = this.n;
        try {
            if (fileInputStream2 != 0) {
                return fileInputStream2;
            }
            try {
                fileInputStream2 = this.c;
                if (fileInputStream2 != 0) {
                    try {
                        if (!fileInputStream2.markSupported()) {
                            Log.d("ExifInterface", "Cannot read thumbnail from inputstream without mark/reset support");
                            d(fileInputStream2);
                            return null;
                        }
                        fileInputStream2.reset();
                        fileInputStream = fileInputStream2;
                        fileDescriptor2 = null;
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e3) {
                        e2 = e3;
                        fileDescriptor2 = null;
                        Log.d("ExifInterface", "Encountered exception while getting thumbnail", e2);
                        d(fileInputStream2);
                        if (fileDescriptor2 != null) {
                            c(fileDescriptor2);
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileDescriptor = null;
                        r2 = fileInputStream2;
                        d(r2);
                        if (fileDescriptor != null) {
                            c(fileDescriptor);
                        }
                        throw th;
                    }
                } else if (this.a != null) {
                    fileInputStream = new FileInputStream(this.a);
                    fileDescriptor2 = null;
                    fileInputStream2 = fileInputStream;
                } else {
                    FileDescriptor fileDescriptorDup = Os.dup(this.b);
                    try {
                        Os.lseek(fileDescriptorDup, 0L, OsConstants.SEEK_SET);
                        fileDescriptor2 = fileDescriptorDup;
                        fileInputStream2 = new FileInputStream(fileDescriptorDup);
                    } catch (Exception e4) {
                        e2 = e4;
                        fileDescriptor2 = fileDescriptorDup;
                        fileInputStream2 = 0;
                        Log.d("ExifInterface", "Encountered exception while getting thumbnail", e2);
                        d(fileInputStream2);
                        if (fileDescriptor2 != null) {
                            c(fileDescriptor2);
                        }
                        return null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileDescriptor = fileDescriptorDup;
                        d(r2);
                        if (fileDescriptor != null) {
                            c(fileDescriptor);
                        }
                        throw th;
                    }
                }
                try {
                    if (fileInputStream2.skip(this.l + this.p) != this.l + this.p) {
                        throw new IOException("Corrupted image");
                    }
                    byte[] bArr = new byte[this.m];
                    if (fileInputStream2.read(bArr) != this.m) {
                        throw new IOException("Corrupted image");
                    }
                    this.n = bArr;
                    d(fileInputStream2);
                    if (fileDescriptor2 != null) {
                        c(fileDescriptor2);
                    }
                    return bArr;
                } catch (Exception e5) {
                    e2 = e5;
                    Log.d("ExifInterface", "Encountered exception while getting thumbnail", e2);
                    d(fileInputStream2);
                    if (fileDescriptor2 != null) {
                        c(fileDescriptor2);
                    }
                    return null;
                }
            } catch (Exception e6) {
                fileInputStream2 = 0;
                e2 = e6;
                fileDescriptor2 = null;
            } catch (Throwable th3) {
                th = th3;
                fileDescriptor = null;
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:61:0x00da A[Catch: all -> 0x00ea, Exception -> 0x00ed, TryCatch #20 {Exception -> 0x00ed, all -> 0x00ea, blocks: (B:59:0x00d6, B:61:0x00da, B:68:0x00f7, B:67:0x00ef), top: B:111:0x00d6 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00ef A[Catch: all -> 0x00ea, Exception -> 0x00ed, TryCatch #20 {Exception -> 0x00ed, all -> 0x00ea, blocks: (B:59:0x00d6, B:61:0x00da, B:68:0x00f7, B:67:0x00ef), top: B:111:0x00d6 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x013b  */
    public void b0() throws Throwable {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileOutputStream fileOutputStream2;
        Exception exc;
        FileOutputStream fileOutputStream3;
        InputStream fileInputStream2;
        Exception e2;
        FileOutputStream fileOutputStream4;
        if (!Q()) {
            throw new IOException("ExifInterface only supports saving attributes on JPEG, PNG, or WebP formats.");
        }
        if (this.b == null && this.a == null) {
            throw new IOException("ExifInterface does not support saving attributes for the current input.");
        }
        this.t = true;
        this.n = A();
        InputStream inputStream = null;
        try {
            File fileCreateTempFile = File.createTempFile("temp", "tmp");
            if (this.a != null) {
                fileInputStream = new FileInputStream(this.a);
            } else {
                Os.lseek(this.b, 0L, OsConstants.SEEK_SET);
                fileInputStream = new FileInputStream(this.b);
            }
            try {
                fileOutputStream = new FileOutputStream(fileCreateTempFile);
                try {
                    h(fileInputStream, fileOutputStream);
                    d(fileInputStream);
                    d(fileOutputStream);
                    try {
                        try {
                            try {
                                FileInputStream fileInputStream3 = new FileInputStream(fileCreateTempFile);
                                try {
                                    if (this.a != null) {
                                        fileOutputStream3 = new FileOutputStream(this.a);
                                    } else {
                                        Os.lseek(this.b, 0L, OsConstants.SEEK_SET);
                                        fileOutputStream3 = new FileOutputStream(this.b);
                                    }
                                    try {
                                        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream3);
                                        try {
                                            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream3);
                                            try {
                                                int i = this.d;
                                                if (i == 4) {
                                                    c0(bufferedInputStream, bufferedOutputStream);
                                                } else if (i == 13) {
                                                    d0(bufferedInputStream, bufferedOutputStream);
                                                } else if (i == 14) {
                                                    e0(bufferedInputStream, bufferedOutputStream);
                                                }
                                                d(bufferedInputStream);
                                                d(bufferedOutputStream);
                                                fileCreateTempFile.delete();
                                                this.n = null;
                                            } catch (Exception e3) {
                                                exc = e3;
                                                inputStream = fileInputStream3;
                                                try {
                                                    fileInputStream2 = new FileInputStream(fileCreateTempFile);
                                                    try {
                                                        if (this.a == null) {
                                                            Os.lseek(this.b, 0L, OsConstants.SEEK_SET);
                                                            fileOutputStream4 = new FileOutputStream(this.b);
                                                        } else {
                                                            fileOutputStream4 = new FileOutputStream(this.a);
                                                        }
                                                        fileOutputStream3 = fileOutputStream4;
                                                        h(fileInputStream2, fileOutputStream3);
                                                        d(fileInputStream2);
                                                        d(fileOutputStream3);
                                                        throw new IOException("Failed to save new file", exc);
                                                    } catch (Exception e4) {
                                                        e2 = e4;
                                                        try {
                                                            throw new IOException("Failed to save new file. Original file is stored in " + fileCreateTempFile.getAbsolutePath(), e2);
                                                        } catch (Throwable th) {
                                                            th = th;
                                                            inputStream = fileInputStream2;
                                                            d(inputStream);
                                                            d(fileOutputStream3);
                                                            throw th;
                                                        }
                                                    } catch (Throwable th2) {
                                                        th = th2;
                                                        inputStream = fileInputStream2;
                                                        d(inputStream);
                                                        d(fileOutputStream3);
                                                        throw th;
                                                    }
                                                } catch (Exception e5) {
                                                    fileInputStream2 = inputStream;
                                                    e2 = e5;
                                                } catch (Throwable th3) {
                                                    th = th3;
                                                    d(inputStream);
                                                    d(fileOutputStream3);
                                                    throw th;
                                                }
                                            }
                                        } catch (Exception e6) {
                                            inputStream = fileInputStream3;
                                            exc = e6;
                                        } catch (Throwable th4) {
                                            th = th4;
                                            inputStream = bufferedInputStream;
                                            d(inputStream);
                                            d(0);
                                            if (0 == 0) {
                                                fileCreateTempFile.delete();
                                            }
                                            throw th;
                                        }
                                    } catch (Exception e7) {
                                        inputStream = fileInputStream3;
                                        exc = e7;
                                    }
                                } catch (Exception e8) {
                                    e = e8;
                                    fileOutputStream2 = null;
                                    inputStream = fileInputStream3;
                                    exc = e;
                                    fileOutputStream3 = fileOutputStream2;
                                    fileInputStream2 = new FileInputStream(fileCreateTempFile);
                                    if (this.a == null) {
                                        Os.lseek(this.b, 0L, OsConstants.SEEK_SET);
                                        fileOutputStream4 = new FileOutputStream(this.b);
                                    } else {
                                        fileOutputStream4 = new FileOutputStream(this.a);
                                    }
                                    fileOutputStream3 = fileOutputStream4;
                                    h(fileInputStream2, fileOutputStream3);
                                    d(fileInputStream2);
                                    d(fileOutputStream3);
                                    throw new IOException("Failed to save new file", exc);
                                }
                            } catch (Exception e9) {
                                e = e9;
                                fileOutputStream2 = null;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            d(inputStream);
                            d(0);
                            if (0 == 0) {
                                fileCreateTempFile.delete();
                            }
                            throw th;
                        }
                    } catch (Throwable th6) {
                        th = th6;
                    }
                } catch (Exception e10) {
                    e = e10;
                    inputStream = fileInputStream;
                    try {
                        throw new IOException("Failed to copy original file to temp file", e);
                    } catch (Throwable th7) {
                        th = th7;
                        d(inputStream);
                        d(fileOutputStream);
                        throw th;
                    }
                } catch (Throwable th8) {
                    th = th8;
                    inputStream = fileInputStream;
                    d(inputStream);
                    d(fileOutputStream);
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
                fileOutputStream = null;
            } catch (Throwable th9) {
                th = th9;
                fileOutputStream = null;
            }
        } catch (Exception e12) {
            e = e12;
            fileOutputStream = null;
        } catch (Throwable th10) {
            th = th10;
            fileOutputStream = null;
        }
    }

    public void f0(double d2) {
        String str = d2 >= 0.0d ? "0" : "1";
        g0("GPSAltitude", new f(Math.abs(d2)).toString());
        g0("GPSAltitudeRef", str);
    }

    public void g0(String str, String str2) {
        e eVar;
        int i;
        int i2;
        String str3 = str;
        String strReplaceAll = str2;
        if (str3 == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        if (("DateTime".equals(str3) || "DateTimeOriginal".equals(str3) || "DateTimeDigitized".equals(str3)) && strReplaceAll != null) {
            boolean zFind = w0.matcher(strReplaceAll).find();
            boolean zFind2 = x0.matcher(strReplaceAll).find();
            if (str2.length() != 19 || (!zFind && !zFind2)) {
                Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                return;
            }
            if (zFind2) {
                strReplaceAll = strReplaceAll.replaceAll("-", ":");
            }
        }
        if ("ISOSpeedRatings".equals(str3)) {
            if (v) {
                Log.d("ExifInterface", "setAttribute: Replacing TAG_ISO_SPEED_RATINGS with TAG_PHOTOGRAPHIC_SENSITIVITY.");
            }
            str3 = "PhotographicSensitivity";
        }
        int i3 = 2;
        int i4 = 1;
        if (strReplaceAll != null && p0.contains(str3)) {
            if (str3.equals("GPSTimeStamp")) {
                Matcher matcher = v0.matcher(strReplaceAll);
                if (!matcher.find()) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
                strReplaceAll = Integer.parseInt(matcher.group(1)) + "/1," + Integer.parseInt(matcher.group(2)) + "/1," + Integer.parseInt(matcher.group(3)) + "/1";
            } else {
                try {
                    strReplaceAll = new f(Double.parseDouble(strReplaceAll)).toString();
                } catch (NumberFormatException unused) {
                    Log.w("ExifInterface", "Invalid value for " + str3 + " : " + strReplaceAll);
                    return;
                }
            }
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 < j0.length) {
            if ((i6 != 4 || this.i) && (eVar = (e) o0[i6].get(str3)) != null) {
                if (strReplaceAll != null) {
                    Pair pairD = D(strReplaceAll);
                    int i7 = -1;
                    if (eVar.c == ((Integer) pairD.first).intValue() || eVar.c == ((Integer) pairD.second).intValue()) {
                        i = eVar.c;
                    } else {
                        int i8 = eVar.d;
                        if (i8 == -1 || !(i8 == ((Integer) pairD.first).intValue() || eVar.d == ((Integer) pairD.second).intValue())) {
                            int i9 = eVar.c;
                            if (i9 == i4 || i9 == 7 || i9 == i3) {
                                i = i9;
                            } else if (v) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("Given tag (");
                                sb.append(str3);
                                sb.append(") value didn't match with one of expected formats: ");
                                String[] strArr = W;
                                sb.append(strArr[eVar.c]);
                                int i10 = eVar.d;
                                String str4 = Constants.STR_EMPTY;
                                sb.append(i10 == -1 ? Constants.STR_EMPTY : ", " + strArr[eVar.d]);
                                sb.append(" (guess: ");
                                sb.append(strArr[((Integer) pairD.first).intValue()]);
                                if (((Integer) pairD.second).intValue() != -1) {
                                    str4 = ", " + strArr[((Integer) pairD.second).intValue()];
                                }
                                sb.append(str4);
                                sb.append(")");
                                Log.d("ExifInterface", sb.toString());
                            }
                        } else {
                            i = eVar.d;
                        }
                    }
                    switch (i) {
                        case 1:
                            i2 = i4;
                            this.f[i6].put(str3, d.a(strReplaceAll));
                            break;
                        case 2:
                        case 7:
                            i2 = i4;
                            this.f[i6].put(str3, d.e(strReplaceAll));
                            break;
                        case 3:
                            i2 = i4;
                            String[] strArrSplit = strReplaceAll.split(",", -1);
                            int[] iArr = new int[strArrSplit.length];
                            for (int i11 = 0; i11 < strArrSplit.length; i11++) {
                                iArr[i11] = Integer.parseInt(strArrSplit[i11]);
                            }
                            this.f[i6].put(str3, d.k(iArr, this.h));
                            break;
                        case 4:
                            i2 = i4;
                            String[] strArrSplit2 = strReplaceAll.split(",", -1);
                            long[] jArr = new long[strArrSplit2.length];
                            for (int i12 = 0; i12 < strArrSplit2.length; i12++) {
                                jArr[i12] = Long.parseLong(strArrSplit2[i12]);
                            }
                            this.f[i6].put(str3, d.g(jArr, this.h));
                            break;
                        case 5:
                            String[] strArrSplit3 = strReplaceAll.split(",", -1);
                            f[] fVarArr = new f[strArrSplit3.length];
                            int i13 = 0;
                            while (i13 < strArrSplit3.length) {
                                String[] strArrSplit4 = strArrSplit3[i13].split(WatchConstant.FAT_FS_ROOT, i7);
                                fVarArr[i13] = new f((long) Double.parseDouble(strArrSplit4[0]), (long) Double.parseDouble(strArrSplit4[1]));
                                i13++;
                                i7 = -1;
                            }
                            i2 = 1;
                            this.f[i6].put(str3, d.i(fVarArr, this.h));
                            break;
                        case 6:
                        case 8:
                        case 11:
                        default:
                            if (v) {
                                Log.d("ExifInterface", "Data format isn't one of expected formats: " + i);
                            }
                            break;
                        case 9:
                            String[] strArrSplit5 = strReplaceAll.split(",", -1);
                            int[] iArr2 = new int[strArrSplit5.length];
                            for (int i14 = 0; i14 < strArrSplit5.length; i14++) {
                                iArr2[i14] = Integer.parseInt(strArrSplit5[i14]);
                            }
                            this.f[i6].put(str3, d.c(iArr2, this.h));
                            i2 = 1;
                            break;
                        case 10:
                            String[] strArrSplit6 = strReplaceAll.split(",", -1);
                            f[] fVarArr2 = new f[strArrSplit6.length];
                            int i15 = i5;
                            while (i15 < strArrSplit6.length) {
                                String[] strArrSplit7 = strArrSplit6[i15].split(WatchConstant.FAT_FS_ROOT, -1);
                                fVarArr2[i15] = new f((long) Double.parseDouble(strArrSplit7[i5]), (long) Double.parseDouble(strArrSplit7[i4]));
                                i15++;
                                strArrSplit6 = strArrSplit6;
                                i5 = 0;
                                i4 = 1;
                            }
                            this.f[i6].put(str3, d.d(fVarArr2, this.h));
                            i2 = 1;
                            break;
                        case 12:
                            String[] strArrSplit8 = strReplaceAll.split(",", -1);
                            double[] dArr = new double[strArrSplit8.length];
                            for (int i16 = i5; i16 < strArrSplit8.length; i16++) {
                                dArr[i16] = Double.parseDouble(strArrSplit8[i16]);
                            }
                            this.f[i6].put(str3, d.b(dArr, this.h));
                            break;
                    }
                } else {
                    this.f[i6].remove(str3);
                }
                i2 = i4;
            } else {
                i2 = i4;
            }
            i6++;
            i4 = i2;
            i3 = 2;
            i5 = 0;
        }
    }

    public void h0(Location location) {
        if (location == null) {
            return;
        }
        g0("GPSProcessingMethod", location.getProvider());
        i0(location.getLatitude(), location.getLongitude());
        f0(location.getAltitude());
        g0("GPSSpeedRef", "K");
        g0("GPSSpeed", new f((location.getSpeed() * TimeUnit.HOURS.toSeconds(1L)) / 1000.0f).toString());
        String[] strArrSplit = U.format(new Date(location.getTime())).split("\\s+", -1);
        g0("GPSDateStamp", strArrSplit[0]);
        g0("GPSTimeStamp", strArrSplit[1]);
    }

    public void i0(double d2, double d3) {
        if (d2 < -90.0d || d2 > 90.0d || Double.isNaN(d2)) {
            throw new IllegalArgumentException("Latitude value " + d2 + " is not valid.");
        }
        if (d3 < -180.0d || d3 > 180.0d || Double.isNaN(d3)) {
            throw new IllegalArgumentException("Longitude value " + d3 + " is not valid.");
        }
        g0("GPSLatitudeRef", d2 >= 0.0d ? "N" : "S");
        g0("GPSLatitude", e(Math.abs(d2)));
        g0("GPSLongitudeRef", d3 >= 0.0d ? "E" : "W");
        g0("GPSLongitude", e(Math.abs(d3)));
    }

    public double l(double d2) {
        double dN = n("GPSAltitude", -1.0d);
        int iO = o("GPSAltitudeRef", -1);
        if (dN < 0.0d || iO < 0) {
            return d2;
        }
        return dN * ((double) (iO != 1 ? 1 : -1));
    }

    public String m(String str) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarP = p(str);
        if (dVarP != null) {
            if (!p0.contains(str)) {
                return dVarP.n(this.h);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = dVarP.a;
                if (i != 5 && i != 10) {
                    Log.w("ExifInterface", "GPS Timestamp format is not rational. format=" + dVarP.a);
                    return null;
                }
                f[] fVarArr = (f[]) dVarP.o(this.h);
                if (fVarArr == null || fVarArr.length != 3) {
                    Log.w("ExifInterface", "Invalid GPS Timestamp array. array=" + Arrays.toString(fVarArr));
                    return null;
                }
                f fVar = fVarArr[0];
                Integer numValueOf = Integer.valueOf((int) (fVar.a / fVar.b));
                f fVar2 = fVarArr[1];
                Integer numValueOf2 = Integer.valueOf((int) (fVar2.a / fVar2.b));
                f fVar3 = fVarArr[2];
                return String.format("%02d:%02d:%02d", numValueOf, numValueOf2, Integer.valueOf((int) (fVar3.a / fVar3.b)));
            }
            try {
                return Double.toString(dVarP.l(this.h));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public double n(String str, double d2) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarP = p(str);
        if (dVarP == null) {
            return d2;
        }
        try {
            return dVarP.l(this.h);
        } catch (NumberFormatException unused) {
            return d2;
        }
    }

    public int o(String str, int i) {
        if (str == null) {
            throw new NullPointerException("tag shouldn't be null");
        }
        d dVarP = p(str);
        if (dVarP == null) {
            return i;
        }
        try {
            return dVarP.m(this.h);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public double[] s() {
        String strM = m("GPSLatitude");
        String strM2 = m("GPSLatitudeRef");
        String strM3 = m("GPSLongitude");
        String strM4 = m("GPSLongitudeRef");
        if (strM == null || strM2 == null || strM3 == null || strM4 == null) {
            return null;
        }
        try {
            return new double[]{f(strM, strM2), f(strM3, strM4)};
        } catch (IllegalArgumentException unused) {
            Log.w("ExifInterface", "Latitude/longitude values are not parsable. " + String.format("latValue=%s, latRef=%s, lngValue=%s, lngRef=%s", strM, strM2, strM3, strM4));
            return null;
        }
    }

    static class e {
        public final int a;
        public final String b;
        public final int c;
        public final int d;

        e(String str, int i, int i2) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = -1;
        }

        boolean a(int i) {
            int i2;
            int i3 = this.c;
            if (i3 == 7 || i == 7 || i3 == i || (i2 = this.d) == i) {
                return true;
            }
            if ((i3 == 4 || i2 == 4) && i == 3) {
                return true;
            }
            if ((i3 == 9 || i2 == 9) && i == 8) {
                return true;
            }
            return (i3 == 12 || i2 == 12) && i == 11;
        }

        e(String str, int i, int i2, int i3) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public dj0(InputStream inputStream) {
        this(inputStream, 0);
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0061  */
    public dj0(InputStream inputStream, int i) {
        e[][] eVarArr = j0;
        this.f = new HashMap[eVarArr.length];
        this.g = new HashSet(eVarArr.length);
        this.h = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.a = null;
            if (i == 1) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
                if (!H(bufferedInputStream)) {
                    Log.w("ExifInterface", "Given data does not follow the structure of an Exif-only data.");
                    return;
                }
                this.e = true;
                this.c = null;
                this.b = null;
                inputStream = bufferedInputStream;
            } else if (inputStream instanceof AssetManager.AssetInputStream) {
                this.c = (AssetManager.AssetInputStream) inputStream;
                this.b = null;
            } else if (inputStream instanceof FileInputStream) {
                FileInputStream fileInputStream = (FileInputStream) inputStream;
                if (O(fileInputStream.getFD())) {
                    this.c = null;
                    this.b = fileInputStream.getFD();
                } else {
                    this.c = null;
                    this.b = null;
                }
            } else {
                this.c = null;
                this.b = null;
            }
            T(inputStream);
            return;
        }
        throw new NullPointerException("inputStream cannot be null");
    }
}
