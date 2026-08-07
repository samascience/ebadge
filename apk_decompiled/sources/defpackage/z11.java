package defpackage;

import android.os.Build;
import androidx.camera.core.v;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class z11 implements v92 {
    private static final Set a = new HashSet(Arrays.asList("A24"));

    private boolean f(byte[] bArr) {
        byte b;
        int i = 2;
        while (i + 4 <= bArr.length && (b = bArr[i]) == -1) {
            if (b == -1 && bArr[i + 1] == -38) {
                return true;
            }
            i += (((bArr[i + 2] & 255) << 8) | (bArr[i + 3] & 255)) + 2;
        }
        return false;
    }

    private int g(byte[] bArr) {
        int i = 2;
        while (true) {
            int i2 = i + 1;
            if (i2 > bArr.length) {
                return -1;
            }
            if (bArr[i] == -1 && bArr[i2] == -40) {
                return i;
            }
            i = i2;
        }
    }

    private static boolean h() {
        return "Samsung".equalsIgnoreCase(Build.BRAND) && a.contains(Build.DEVICE.toUpperCase(Locale.US));
    }

    static boolean j() {
        return h();
    }

    public byte[] i(v vVar) {
        int iG = 0;
        ByteBuffer byteBufferB = vVar.r()[0].b();
        byte[] bArr = new byte[byteBufferB.capacity()];
        byteBufferB.rewind();
        byteBufferB.get(bArr);
        return (f(bArr) || (iG = g(bArr)) != -1) ? Arrays.copyOfRange(bArr, iG, byteBufferB.limit()) : bArr;
    }
}
