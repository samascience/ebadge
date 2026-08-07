package defpackage;

import com.tencent.open.SocialConstants;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.collections.d;
import kotlin.collections.j;
import kotlin.collections.u;
import kotlin.text.Regex;
import kotlin.text.i;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class pa3 {
    public static final byte[] a;
    public static final iw0 b = iw0.b.h(new String[0]);
    public static final fh2 c;
    public static final ff2 d;
    private static final qx1 e;
    public static final TimeZone f;
    private static final Regex g;
    public static final boolean h;
    public static final String i;

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        c = fh2.b.i(fh2.Companion, bArr, null, 1, null);
        d = ff2.a.p(ff2.Companion, bArr, null, 0, 0, 7, null);
        qx1.a aVar = qx1.c;
        ByteString.a aVar2 = ByteString.Companion;
        e = aVar.d(aVar2.b("efbbbf"), aVar2.b("feff"), aVar2.b("fffe"), aVar2.b("0000ffff"), aVar2.b("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        p31.c(timeZone);
        f = timeZone;
        g = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        h = false;
        String name = zt1.class.getName();
        p31.e(name, "OkHttpClient::class.java.name");
        i = i.q0(i.p0(name, "okhttp3."), "Client");
    }

    public static /* synthetic */ int A(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return z(str, i2, i3);
    }

    public static final int B(String str, int i2, int i3) {
        p31.f(str, "<this>");
        int i4 = i3 - 1;
        if (i2 <= i4) {
            while (true) {
                char cCharAt = str.charAt(i4);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i4 + 1;
                }
                if (i4 != i2) {
                    i4--;
                }
            }
        }
        return i2;
    }

    public static /* synthetic */ int C(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return B(str, i2, i3);
    }

    public static final int D(String str, int i2) {
        p31.f(str, "<this>");
        int length = str.length();
        while (i2 < length) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    public static final String[] E(String[] strArr, String[] strArr2, Comparator comparator) {
        p31.f(strArr, "<this>");
        p31.f(strArr2, "other");
        p31.f(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    arrayList.add(str);
                    break;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean F(Socket socket, so soVar) {
        p31.f(socket, "<this>");
        p31.f(soVar, SocialConstants.PARAM_SOURCE);
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                return !soVar.H();
            } finally {
                socket.setSoTimeout(soTimeout);
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean G(String str) {
        p31.f(str, "name");
        return i.v(str, "Authorization", true) || i.v(str, "Cookie", true) || i.v(str, "Proxy-Authorization", true) || i.v(str, "Set-Cookie", true);
    }

    public static final int H(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' > c2 || c2 >= 'G') {
            return -1;
        }
        return c2 - '7';
    }

    public static final Charset I(so soVar, Charset charset) {
        p31.f(soVar, "<this>");
        p31.f(charset, "default");
        int iJ = soVar.J(e);
        if (iJ == -1) {
            return charset;
        }
        if (iJ == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            p31.e(charset2, "UTF_8");
            return charset2;
        }
        if (iJ == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            p31.e(charset3, "UTF_16BE");
            return charset3;
        }
        if (iJ == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            p31.e(charset4, "UTF_16LE");
            return charset4;
        }
        if (iJ == 3) {
            return gx.a.a();
        }
        if (iJ == 4) {
            return gx.a.b();
        }
        throw new AssertionError();
    }

    public static final int J(so soVar) {
        p31.f(soVar, "<this>");
        return d(soVar.readByte(), 255) | (d(soVar.readByte(), 255) << 16) | (d(soVar.readByte(), 255) << 8);
    }

    public static final int K(fo foVar, byte b2) throws EOFException {
        p31.f(foVar, "<this>");
        int i2 = 0;
        while (!foVar.H() && foVar.e0(0L) == b2) {
            i2++;
            foVar.readByte();
        }
        return i2;
    }

    public static final boolean L(ks2 ks2Var, int i2, TimeUnit timeUnit) {
        p31.f(ks2Var, "<this>");
        p31.f(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jC = ks2Var.timeout().e() ? ks2Var.timeout().c() - jNanoTime : Long.MAX_VALUE;
        ks2Var.timeout().d(Math.min(jC, timeUnit.toNanos(i2)) + jNanoTime);
        try {
            fo foVar = new fo();
            while (ks2Var.read(foVar, 8192L) != -1) {
                foVar.u();
            }
            if (jC == Long.MAX_VALUE) {
                ks2Var.timeout().a();
            } else {
                ks2Var.timeout().d(jNanoTime + jC);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jC == Long.MAX_VALUE) {
                ks2Var.timeout().a();
            } else {
                ks2Var.timeout().d(jNanoTime + jC);
            }
            return false;
        } catch (Throwable th) {
            if (jC == Long.MAX_VALUE) {
                ks2Var.timeout().a();
            } else {
                ks2Var.timeout().d(jNanoTime + jC);
            }
            throw th;
        }
    }

    public static final ThreadFactory M(final String str, final boolean z) {
        p31.f(str, "name");
        return new ThreadFactory() { // from class: ma3
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return pa3.N(str, z, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread N(String str, boolean z, Runnable runnable) {
        p31.f(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z);
        return thread;
    }

    public static final List O(iw0 iw0Var) {
        p31.f(iw0Var, "<this>");
        e31 e31VarK = ga2.k(0, iw0Var.size());
        ArrayList arrayList = new ArrayList(j.t(e31VarK, 10));
        Iterator it = e31VarK.iterator();
        while (it.hasNext()) {
            int iA = ((b31) it).a();
            arrayList.add(new gw0(iw0Var.b(iA), iw0Var.g(iA)));
        }
        return arrayList;
    }

    public static final iw0 P(List list) {
        p31.f(list, "<this>");
        iw0.a aVar = new iw0.a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            gw0 gw0Var = (gw0) it.next();
            aVar.c(gw0Var.a().utf8(), gw0Var.b().utf8());
        }
        return aVar.e();
    }

    public static final String Q(int i2) {
        String hexString = Integer.toHexString(i2);
        p31.e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String R(long j) {
        String hexString = Long.toHexString(j);
        p31.e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String S(tx0 tx0Var, boolean z) {
        String strH;
        p31.f(tx0Var, "<this>");
        if (i.M(tx0Var.h(), ":", false, 2, null)) {
            strH = '[' + tx0Var.h() + ']';
        } else {
            strH = tx0Var.h();
        }
        if (!z && tx0Var.n() == tx0.k.c(tx0Var.r())) {
            return strH;
        }
        return strH + ':' + tx0Var.n();
    }

    public static /* synthetic */ String T(tx0 tx0Var, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return S(tx0Var, z);
    }

    public static final List U(List list) {
        p31.f(list, "<this>");
        List listUnmodifiableList = Collections.unmodifiableList(j.Z(list));
        p31.e(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final Map V(Map map) {
        p31.f(map, "<this>");
        if (map.isEmpty()) {
            return u.f();
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        p31.e(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final long W(String str, long j) {
        p31.f(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int X(String str, int i2) {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i2;
    }

    public static final String Y(String str, int i2, int i3) {
        p31.f(str, "<this>");
        int iZ = z(str, i2, i3);
        String strSubstring = str.substring(iZ, B(str, iZ, i3));
        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String Z(String str, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = str.length();
        }
        return Y(str, i2, i3);
    }

    public static final Throwable a0(Exception exc, List list) {
        p31.f(exc, "<this>");
        p31.f(list, "suppressed");
        Iterator it = list.iterator();
        while (it.hasNext()) {
            oi0.a(exc, (Exception) it.next());
        }
        return exc;
    }

    public static final void b0(ro roVar, int i2) {
        p31.f(roVar, "<this>");
        roVar.I((i2 >>> 16) & 255);
        roVar.I((i2 >>> 8) & 255);
        roVar.I(i2 & 255);
    }

    public static final void c(List list, Object obj) {
        p31.f(list, "<this>");
        if (list.contains(obj)) {
            return;
        }
        list.add(obj);
    }

    public static final int d(byte b2, int i2) {
        return b2 & i2;
    }

    public static final int e(short s, int i2) {
        return s & i2;
    }

    public static final long f(int i2, long j) {
        return ((long) i2) & j;
    }

    public static final fi0.c g(final fi0 fi0Var) {
        p31.f(fi0Var, "<this>");
        return new fi0.c() { // from class: la3
            @Override // fi0.c
            public final fi0 a(eq eqVar) {
                return pa3.h(fi0Var, eqVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final fi0 h(fi0 fi0Var, eq eqVar) {
        p31.f(fi0Var, "$this_asFactory");
        p31.f(eqVar, "it");
        return fi0Var;
    }

    public static final boolean i(String str) {
        p31.f(str, "<this>");
        return g.matches(str);
    }

    public static final boolean j(tx0 tx0Var, tx0 tx0Var2) {
        p31.f(tx0Var, "<this>");
        p31.f(tx0Var2, "other");
        return p31.a(tx0Var.h(), tx0Var2.h()) && tx0Var.n() == tx0Var2.n() && p31.a(tx0Var.r(), tx0Var2.r());
    }

    public static final int k(String str, long j, TimeUnit timeUnit) {
        p31.f(str, "name");
        if (j < 0) {
            throw new IllegalStateException((str + " < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null");
        }
        long millis = timeUnit.toMillis(j);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException((str + " too large.").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException((str + " too small.").toString());
    }

    public static final void l(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void m(Closeable closeable) {
        p31.f(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception unused) {
        }
    }

    public static final void n(Socket socket) {
        p31.f(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e2) {
            throw e2;
        } catch (RuntimeException e3) {
            if (!p31.a(e3.getMessage(), "bio == null")) {
                throw e3;
            }
        } catch (Exception unused) {
        }
    }

    public static final String[] o(String[] strArr, String str) {
        p31.f(strArr, "<this>");
        p31.f(str, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        p31.e(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[d.u(strArr2)] = str;
        return strArr2;
    }

    public static final int p(String str, char c2, int i2, int i3) {
        p31.f(str, "<this>");
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static final int q(String str, String str2, int i2, int i3) {
        p31.f(str, "<this>");
        p31.f(str2, "delimiters");
        while (i2 < i3) {
            if (i.L(str2, str.charAt(i2), false, 2, null)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static /* synthetic */ int r(String str, char c2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = str.length();
        }
        return p(str, c2, i2, i3);
    }

    public static final boolean s(ks2 ks2Var, int i2, TimeUnit timeUnit) {
        p31.f(ks2Var, "<this>");
        p31.f(timeUnit, "timeUnit");
        try {
            return L(ks2Var, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String t(String str, Object... objArr) {
        p31.f(str, "format");
        p31.f(objArr, "args");
        lv2 lv2Var = lv2.a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        p31.e(str2, "format(locale, format, *args)");
        return str2;
    }

    public static final boolean u(String[] strArr, String[] strArr2, Comparator comparator) {
        p31.f(strArr, "<this>");
        p31.f(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                Iterator itA = t9.a(strArr2);
                while (itA.hasNext()) {
                    if (comparator.compare(str, (String) itA.next()) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long v(eh2 eh2Var) {
        p31.f(eh2Var, "<this>");
        String strA = eh2Var.j0().a("Content-Length");
        if (strA != null) {
            return W(strA, -1L);
        }
        return -1L;
    }

    public static final List w(Object... objArr) {
        p31.f(objArr, "elements");
        Object[] objArr2 = (Object[]) objArr.clone();
        List listUnmodifiableList = Collections.unmodifiableList(j.m(Arrays.copyOf(objArr2, objArr2.length)));
        p31.e(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int x(String[] strArr, String str, Comparator comparator) {
        p31.f(strArr, "<this>");
        p31.f(str, "value");
        p31.f(comparator, "comparator");
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int y(String str) {
        p31.f(str, "<this>");
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (p31.g(cCharAt, 31) <= 0 || p31.g(cCharAt, 127) >= 0) {
                return i2;
            }
        }
        return -1;
    }

    public static final int z(String str, int i2, int i3) {
        p31.f(str, "<this>");
        while (i2 < i3) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }
}
