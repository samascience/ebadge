package okhttp3.internal.publicsuffix;

import com.tencent.connect.common.Constants;
import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.hu1;
import defpackage.k83;
import defpackage.p31;
import defpackage.pa3;
import defpackage.r32;
import defpackage.so;
import defpackage.ty;
import defpackage.uv0;
import defpackage.y70;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.collections.j;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.sequences.d;
import kotlin.text.i;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes4.dex */
public final class PublicSuffixDatabase {
    public static final a e = new a(null);
    private static final byte[] f = {42};
    private static final List g = j.e(Marker.ANY_MARKER);
    private static final PublicSuffixDatabase h = new PublicSuffixDatabase();
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final CountDownLatch b = new CountDownLatch(1);
    private byte[] c;
    private byte[] d;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String b(byte[] bArr, byte[][] bArr2, int i) {
            int i2;
            int iD;
            boolean z;
            int iD2;
            int length = bArr.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = (i3 + length) / 2;
                while (i4 > -1 && bArr[i4] != 10) {
                    i4--;
                }
                int i5 = i4 + 1;
                int i6 = 1;
                while (true) {
                    i2 = i5 + i6;
                    if (bArr[i2] == 10) {
                        break;
                    }
                    i6++;
                }
                int i7 = i2 - i5;
                int i8 = i;
                boolean z2 = false;
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    if (z2) {
                        iD = 46;
                        z = false;
                    } else {
                        boolean z3 = z2;
                        iD = pa3.d(bArr2[i8][i9], 255);
                        z = z3;
                    }
                    iD2 = iD - pa3.d(bArr[i5 + i10], 255);
                    if (iD2 != 0) {
                        break;
                    }
                    i10++;
                    i9++;
                    if (i10 == i7) {
                        break;
                    }
                    if (bArr2[i8].length != i9) {
                        z2 = z;
                    } else {
                        if (i8 == bArr2.length - 1) {
                            break;
                        }
                        i8++;
                        z2 = true;
                        i9 = -1;
                    }
                }
                if (iD2 >= 0) {
                    if (iD2 <= 0) {
                        int i11 = i7 - i10;
                        int length2 = bArr2[i8].length - i9;
                        int length3 = bArr2.length;
                        for (int i12 = i8 + 1; i12 < length3; i12++) {
                            length2 += bArr2[i12].length;
                        }
                        if (length2 >= i11) {
                            if (length2 <= i11) {
                                Charset charset = StandardCharsets.UTF_8;
                                p31.e(charset, "UTF_8");
                                return new String(bArr, i5, i7, charset);
                            }
                        }
                    }
                    i3 = i2 + 1;
                }
                length = i4;
            }
            return null;
        }

        public final PublicSuffixDatabase c() {
            return PublicSuffixDatabase.h;
        }

        private a() {
        }
    }

    private final List b(List list) {
        String str;
        String strB;
        String str2;
        List listJ;
        List listJ2;
        if (this.a.get() || !this.a.compareAndSet(false, true)) {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        } else {
            e();
        }
        if (this.c == null) {
            throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
        }
        int size = list.size();
        byte[][] bArr = new byte[size][];
        for (int i = 0; i < size; i++) {
            String str3 = (String) list.get(i);
            Charset charset = StandardCharsets.UTF_8;
            p31.e(charset, "UTF_8");
            byte[] bytes = str3.getBytes(charset);
            p31.e(bytes, "this as java.lang.String).getBytes(charset)");
            bArr[i] = bytes;
        }
        int i2 = 0;
        while (true) {
            str = null;
            if (i2 >= size) {
                strB = null;
                break;
            }
            a aVar = e;
            byte[] bArr2 = this.c;
            if (bArr2 == null) {
                p31.t("publicSuffixListBytes");
                bArr2 = null;
            }
            strB = aVar.b(bArr2, bArr, i2);
            if (strB != null) {
                break;
            }
            i2++;
        }
        if (size <= 1) {
            str2 = null;
            break;
        }
        byte[][] bArr3 = (byte[][]) bArr.clone();
        int length = bArr3.length - 1;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                str2 = null;
                break;
            }
            bArr3[i3] = f;
            a aVar2 = e;
            byte[] bArr4 = this.c;
            if (bArr4 == null) {
                p31.t("publicSuffixListBytes");
                bArr4 = null;
            }
            String strB2 = aVar2.b(bArr4, bArr3, i3);
            if (strB2 != null) {
                str2 = strB2;
                break;
            }
            i3++;
        }
        if (str2 != null) {
            int i4 = size - 1;
            for (int i5 = 0; i5 < i4; i5++) {
                a aVar3 = e;
                byte[] bArr5 = this.d;
                if (bArr5 == null) {
                    p31.t("publicSuffixExceptionListBytes");
                    bArr5 = null;
                }
                String strB3 = aVar3.b(bArr5, bArr, i5);
                if (strB3 != null) {
                    str = strB3;
                    break;
                }
            }
        }
        if (str != null) {
            return i.x0('!' + str, new char[]{'.'}, false, 0, 6, null);
        }
        if (strB == null && str2 == null) {
            return g;
        }
        if (strB == null || (listJ = i.x0(strB, new char[]{'.'}, false, 0, 6, null)) == null) {
            listJ = j.j();
        }
        if (str2 == null || (listJ2 = i.x0(str2, new char[]{'.'}, false, 0, 6, null)) == null) {
            listJ2 = j.j();
        }
        return listJ.size() > listJ2.size() ? listJ : listJ2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, byte[]] */
    /* JADX WARN: Type inference failed for: r3v7, types: [T, byte[]] */
    private final void d() {
        try {
            Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
            Ref$ObjectRef ref$ObjectRef2 = new Ref$ObjectRef();
            InputStream resourceAsStream = PublicSuffixDatabase.class.getResourceAsStream("publicsuffixes.gz");
            if (resourceAsStream == null) {
                this.b.countDown();
                return;
            }
            so soVarB = hu1.b(new uv0(hu1.f(resourceAsStream)));
            try {
                ref$ObjectRef.element = soVarB.p0(soVarB.readInt());
                ref$ObjectRef2.element = soVarB.p0(soVarB.readInt());
                k83 k83Var = k83.a;
                ty.a(soVarB, null);
                synchronized (this) {
                    T t = ref$ObjectRef.element;
                    p31.c(t);
                    this.c = (byte[]) t;
                    T t2 = ref$ObjectRef2.element;
                    p31.c(t2);
                    this.d = (byte[]) t2;
                }
                this.b.countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    ty.a(soVarB, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            this.b.countDown();
            throw th3;
        }
    }

    private final void e() {
        boolean z = false;
        while (true) {
            try {
                try {
                    d();
                    break;
                } catch (InterruptedIOException unused) {
                    Thread.interrupted();
                    z = true;
                } catch (IOException e2) {
                    r32.a.g().j("Failed to read public suffix list", 5, e2);
                    if (z) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final List f(String str) {
        List listX0 = i.x0(str, new char[]{'.'}, false, 0, 6, null);
        return p31.a(j.O(listX0), Constants.STR_EMPTY) ? j.E(listX0, 1) : listX0;
    }

    public final String c(String str) {
        int size;
        int size2;
        p31.f(str, "domain");
        String unicode = IDN.toUnicode(str);
        p31.e(unicode, "unicodeDomain");
        List listF = f(unicode);
        List listB = b(listF);
        if (listF.size() == listB.size() && ((String) listB.get(0)).charAt(0) != '!') {
            return null;
        }
        if (((String) listB.get(0)).charAt(0) == '!') {
            size = listF.size();
            size2 = listB.size();
        } else {
            size = listF.size();
            size2 = listB.size() + 1;
        }
        return d.t(d.m(j.C(f(str)), size - size2), FileUtils.FILE_EXTENSION_SEPARATOR, null, null, 0, null, null, 62, null);
    }
}
