package okio;

import defpackage.e;
import defpackage.f;
import defpackage.fo;
import defpackage.im2;
import defpackage.p31;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import kotlin.collections.d;

/* JADX INFO: loaded from: classes4.dex */
public final class SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SegmentedByteString(byte[][] bArr, int[] iArr) {
        super(ByteString.EMPTY.getData$okio());
        p31.f(bArr, "segments");
        p31.f(iArr, "directory");
        this.segments = bArr;
        this.directory = iArr;
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        p31.d(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }

    @Override // okio.ByteString
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        p31.e(byteBufferAsReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override // okio.ByteString
    public String base64() {
        return toByteString().base64();
    }

    @Override // okio.ByteString
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override // okio.ByteString
    public void copyInto(int i, byte[] bArr, int i2, int i3) {
        p31.f(bArr, "target");
        long j = i3;
        f.b(size(), i, j);
        f.b(bArr.length, i2, j);
        int i4 = i3 + i;
        int iB = e.b(this, i);
        while (i < i4) {
            int i5 = iB == 0 ? 0 : getDirectory$okio()[iB - 1];
            int i6 = getDirectory$okio()[iB] - i5;
            int i7 = getDirectory$okio()[getSegments$okio().length + iB];
            int iMin = Math.min(i4, i6 + i5) - i;
            int i8 = i7 + (i - i5);
            d.d(getSegments$okio()[iB], bArr, i2, i8, i8 + iMin);
            i2 += iMin;
            i += iMin;
            iB++;
        }
    }

    @Override // okio.ByteString
    public ByteString digest$okio(String str) throws NoSuchAlgorithmException {
        p31.f(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            messageDigest.update(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        p31.c(bArrDigest);
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == size() && rangeEquals(0, byteString, 0, size())) {
                return true;
            }
        }
        return false;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    @Override // okio.ByteString
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override // okio.ByteString
    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            byte[] bArr = getSegments$okio()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        setHashCode$okio(i2);
        return i2;
    }

    @Override // okio.ByteString
    public String hex() {
        return toByteString().hex();
    }

    @Override // okio.ByteString
    public ByteString hmac$okio(String str, ByteString byteString) throws NoSuchAlgorithmException {
        p31.f(str, "algorithm");
        p31.f(byteString, "key");
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            int length = getSegments$okio().length;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                int i3 = getDirectory$okio()[length + i];
                int i4 = getDirectory$okio()[i];
                mac.update(getSegments$okio()[i], i3, i4 - i2);
                i++;
                i2 = i4;
            }
            byte[] bArrDoFinal = mac.doFinal();
            p31.e(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override // okio.ByteString
    public int indexOf(byte[] bArr, int i) {
        p31.f(bArr, "other");
        return toByteString().indexOf(bArr, i);
    }

    @Override // okio.ByteString
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override // okio.ByteString
    public byte internalGet$okio(int i) {
        f.b(getDirectory$okio()[getSegments$okio().length - 1], i, 1L);
        int iB = e.b(this, i);
        return getSegments$okio()[iB][(i - (iB == 0 ? 0 : getDirectory$okio()[iB - 1])) + getDirectory$okio()[getSegments$okio().length + iB]];
    }

    @Override // okio.ByteString
    public int lastIndexOf(byte[] bArr, int i) {
        p31.f(bArr, "other");
        return toByteString().lastIndexOf(bArr, i);
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, ByteString byteString, int i2, int i3) {
        p31.f(byteString, "other");
        if (i < 0 || i > size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iB = e.b(this, i);
        while (i < i4) {
            int i5 = iB == 0 ? 0 : getDirectory$okio()[iB - 1];
            int i6 = getDirectory$okio()[iB] - i5;
            int i7 = getDirectory$okio()[getSegments$okio().length + iB];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!byteString.rangeEquals(i2, getSegments$okio()[iB], i7 + (i - i5), iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iB++;
        }
        return true;
    }

    @Override // okio.ByteString
    public String string(Charset charset) {
        p31.f(charset, "charset");
        return toByteString().string(charset);
    }

    @Override // okio.ByteString
    public ByteString substring(int i, int i2) {
        int iE = f.e(this, i2);
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (iE > size()) {
            throw new IllegalArgumentException(("endIndex=" + iE + " > length(" + size() + ')').toString());
        }
        int i3 = iE - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(("endIndex=" + iE + " < beginIndex=" + i).toString());
        }
        if (i == 0 && iE == size()) {
            return this;
        }
        if (i == iE) {
            return ByteString.EMPTY;
        }
        int iB = e.b(this, i);
        int iB2 = e.b(this, iE - 1);
        byte[][] bArr = (byte[][]) d.l(getSegments$okio(), iB, iB2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iB <= iB2) {
            int i4 = iB;
            int i5 = 0;
            while (true) {
                iArr[i5] = Math.min(getDirectory$okio()[i4] - i, i3);
                int i6 = i5 + 1;
                iArr[i5 + bArr.length] = getDirectory$okio()[getSegments$okio().length + i4];
                if (i4 == iB2) {
                    break;
                }
                i4++;
                i5 = i6;
            }
        }
        int i7 = iB != 0 ? getDirectory$okio()[iB - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i - i7);
        return new SegmentedByteString(bArr, iArr);
    }

    @Override // okio.ByteString
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override // okio.ByteString
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override // okio.ByteString
    public byte[] toByteArray() {
        byte[] bArr = new byte[size()];
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = getDirectory$okio()[length + i];
            int i5 = getDirectory$okio()[i];
            int i6 = i5 - i2;
            d.d(getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return toByteString().toString();
    }

    @Override // okio.ByteString
    public void write(OutputStream outputStream) throws IOException {
        p31.f(outputStream, "out");
        int length = getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = getDirectory$okio()[length + i];
            int i4 = getDirectory$okio()[i];
            outputStream.write(getSegments$okio()[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // okio.ByteString
    public void write$okio(fo foVar, int i, int i2) {
        p31.f(foVar, "buffer");
        int i3 = i + i2;
        int iB = e.b(this, i);
        while (i < i3) {
            int i4 = iB == 0 ? 0 : getDirectory$okio()[iB - 1];
            int i5 = getDirectory$okio()[iB] - i4;
            int i6 = getDirectory$okio()[getSegments$okio().length + iB];
            int iMin = Math.min(i3, i5 + i4) - i;
            int i7 = i6 + (i - i4);
            im2 im2Var = new im2(getSegments$okio()[iB], i7, i7 + iMin, true, false);
            im2 im2Var2 = foVar.a;
            if (im2Var2 == null) {
                im2Var.g = im2Var;
                im2Var.f = im2Var;
                foVar.a = im2Var;
            } else {
                p31.c(im2Var2);
                im2 im2Var3 = im2Var2.g;
                p31.c(im2Var3);
                im2Var3.c(im2Var);
            }
            i += iMin;
            iB++;
        }
        foVar.I0(foVar.size() + ((long) i2));
    }

    @Override // okio.ByteString
    public boolean rangeEquals(int i, byte[] bArr, int i2, int i3) {
        p31.f(bArr, "other");
        if (i < 0 || i > size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iB = e.b(this, i);
        while (i < i4) {
            int i5 = iB == 0 ? 0 : getDirectory$okio()[iB - 1];
            int i6 = getDirectory$okio()[iB] - i5;
            int i7 = getDirectory$okio()[getSegments$okio().length + iB];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!f.a(getSegments$okio()[iB], i7 + (i - i5), bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iB++;
        }
        return true;
    }
}
