package okhttp3.internal.http2;

import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import com.tencent.open.SocialConstants;
import defpackage.fo;
import defpackage.gw0;
import defpackage.hu1;
import defpackage.ks2;
import defpackage.p31;
import defpackage.pa3;
import defpackage.so;
import defpackage.vx0;
import defpackage.y70;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.j;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class a {
    public static final a a;
    private static final gw0[] b;
    private static final Map c;

    static {
        a aVar = new a();
        a = aVar;
        gw0 gw0Var = new gw0(gw0.j, Constants.STR_EMPTY);
        ByteString byteString = gw0.g;
        gw0 gw0Var2 = new gw0(byteString, Constants.HTTP_GET);
        gw0 gw0Var3 = new gw0(byteString, Constants.HTTP_POST);
        ByteString byteString2 = gw0.h;
        gw0 gw0Var4 = new gw0(byteString2, WatchConstant.FAT_FS_ROOT);
        gw0 gw0Var5 = new gw0(byteString2, "/index.html");
        ByteString byteString3 = gw0.i;
        gw0 gw0Var6 = new gw0(byteString3, "http");
        gw0 gw0Var7 = new gw0(byteString3, "https");
        ByteString byteString4 = gw0.f;
        b = new gw0[]{gw0Var, gw0Var2, gw0Var3, gw0Var4, gw0Var5, gw0Var6, gw0Var7, new gw0(byteString4, "200"), new gw0(byteString4, "204"), new gw0(byteString4, "206"), new gw0(byteString4, "304"), new gw0(byteString4, "400"), new gw0(byteString4, "404"), new gw0(byteString4, "500"), new gw0("accept-charset", Constants.STR_EMPTY), new gw0("accept-encoding", "gzip, deflate"), new gw0("accept-language", Constants.STR_EMPTY), new gw0("accept-ranges", Constants.STR_EMPTY), new gw0("accept", Constants.STR_EMPTY), new gw0("access-control-allow-origin", Constants.STR_EMPTY), new gw0("age", Constants.STR_EMPTY), new gw0("allow", Constants.STR_EMPTY), new gw0("authorization", Constants.STR_EMPTY), new gw0("cache-control", Constants.STR_EMPTY), new gw0("content-disposition", Constants.STR_EMPTY), new gw0("content-encoding", Constants.STR_EMPTY), new gw0("content-language", Constants.STR_EMPTY), new gw0("content-length", Constants.STR_EMPTY), new gw0("content-location", Constants.STR_EMPTY), new gw0("content-range", Constants.STR_EMPTY), new gw0("content-type", Constants.STR_EMPTY), new gw0("cookie", Constants.STR_EMPTY), new gw0("date", Constants.STR_EMPTY), new gw0("etag", Constants.STR_EMPTY), new gw0("expect", Constants.STR_EMPTY), new gw0("expires", Constants.STR_EMPTY), new gw0(Constants.FROM, Constants.STR_EMPTY), new gw0("host", Constants.STR_EMPTY), new gw0("if-match", Constants.STR_EMPTY), new gw0("if-modified-since", Constants.STR_EMPTY), new gw0("if-none-match", Constants.STR_EMPTY), new gw0("if-range", Constants.STR_EMPTY), new gw0("if-unmodified-since", Constants.STR_EMPTY), new gw0("last-modified", Constants.STR_EMPTY), new gw0("link", Constants.STR_EMPTY), new gw0("location", Constants.STR_EMPTY), new gw0("max-forwards", Constants.STR_EMPTY), new gw0("proxy-authenticate", Constants.STR_EMPTY), new gw0("proxy-authorization", Constants.STR_EMPTY), new gw0("range", Constants.STR_EMPTY), new gw0("referer", Constants.STR_EMPTY), new gw0("refresh", Constants.STR_EMPTY), new gw0("retry-after", Constants.STR_EMPTY), new gw0("server", Constants.STR_EMPTY), new gw0("set-cookie", Constants.STR_EMPTY), new gw0("strict-transport-security", Constants.STR_EMPTY), new gw0("transfer-encoding", Constants.STR_EMPTY), new gw0("user-agent", Constants.STR_EMPTY), new gw0("vary", Constants.STR_EMPTY), new gw0("via", Constants.STR_EMPTY), new gw0("www-authenticate", Constants.STR_EMPTY)};
        c = aVar.d();
    }

    private a() {
    }

    private final Map d() {
        gw0[] gw0VarArr = b;
        LinkedHashMap linkedHashMap = new LinkedHashMap(gw0VarArr.length);
        int length = gw0VarArr.length;
        for (int i = 0; i < length; i++) {
            gw0[] gw0VarArr2 = b;
            if (!linkedHashMap.containsKey(gw0VarArr2[i].a)) {
                linkedHashMap.put(gw0VarArr2[i].a, Integer.valueOf(i));
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        p31.e(mapUnmodifiableMap, "unmodifiableMap(result)");
        return mapUnmodifiableMap;
    }

    public final ByteString a(ByteString byteString) throws IOException {
        p31.f(byteString, "name");
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b2 = byteString.getByte(i);
            if (65 <= b2 && b2 < 91) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }

    public final Map b() {
        return c;
    }

    public final gw0[] c() {
        return b;
    }

    /* JADX INFO: renamed from: okhttp3.internal.http2.a$a, reason: collision with other inner class name */
    public static final class C0154a {
        private final int a;
        private int b;
        private final List c;
        private final so d;
        public gw0[] e;
        private int f;
        public int g;
        public int h;

        public C0154a(ks2 ks2Var, int i, int i2) {
            p31.f(ks2Var, SocialConstants.PARAM_SOURCE);
            this.a = i;
            this.b = i2;
            this.c = new ArrayList();
            this.d = hu1.b(ks2Var);
            gw0[] gw0VarArr = new gw0[8];
            this.e = gw0VarArr;
            this.f = gw0VarArr.length - 1;
        }

        private final void a() {
            int i = this.b;
            int i2 = this.h;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    d(i2 - i);
                }
            }
        }

        private final void b() {
            kotlin.collections.d.n(this.e, null, 0, 0, 6, null);
            this.f = this.e.length - 1;
            this.g = 0;
            this.h = 0;
        }

        private final int c(int i) {
            return this.f + 1 + i;
        }

        private final int d(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.e.length;
                while (true) {
                    length--;
                    i2 = this.f;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    gw0 gw0Var = this.e[length];
                    p31.c(gw0Var);
                    int i4 = gw0Var.c;
                    i -= i4;
                    this.h -= i4;
                    this.g--;
                    i3++;
                }
                gw0[] gw0VarArr = this.e;
                System.arraycopy(gw0VarArr, i2 + 1, gw0VarArr, i2 + 1 + i3, this.g);
                this.f += i3;
            }
            return i3;
        }

        private final ByteString f(int i) throws IOException {
            if (h(i)) {
                return a.a.c()[i].a;
            }
            int iC = c(i - a.a.c().length);
            if (iC >= 0) {
                gw0[] gw0VarArr = this.e;
                if (iC < gw0VarArr.length) {
                    gw0 gw0Var = gw0VarArr[iC];
                    p31.c(gw0Var);
                    return gw0Var.a;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private final void g(int i, gw0 gw0Var) {
            this.c.add(gw0Var);
            int i2 = gw0Var.c;
            if (i != -1) {
                gw0 gw0Var2 = this.e[c(i)];
                p31.c(gw0Var2);
                i2 -= gw0Var2.c;
            }
            int i3 = this.b;
            if (i2 > i3) {
                b();
                return;
            }
            int iD = d((this.h + i2) - i3);
            if (i == -1) {
                int i4 = this.g + 1;
                gw0[] gw0VarArr = this.e;
                if (i4 > gw0VarArr.length) {
                    gw0[] gw0VarArr2 = new gw0[gw0VarArr.length * 2];
                    System.arraycopy(gw0VarArr, 0, gw0VarArr2, gw0VarArr.length, gw0VarArr.length);
                    this.f = this.e.length - 1;
                    this.e = gw0VarArr2;
                }
                int i5 = this.f;
                this.f = i5 - 1;
                this.e[i5] = gw0Var;
                this.g++;
            } else {
                this.e[i + c(i) + iD] = gw0Var;
            }
            this.h += i2;
        }

        private final boolean h(int i) {
            return i >= 0 && i <= a.a.c().length - 1;
        }

        private final int i() {
            return pa3.d(this.d.readByte(), 255);
        }

        private final void l(int i) throws IOException {
            if (h(i)) {
                this.c.add(a.a.c()[i]);
                return;
            }
            int iC = c(i - a.a.c().length);
            if (iC >= 0) {
                gw0[] gw0VarArr = this.e;
                if (iC < gw0VarArr.length) {
                    List list = this.c;
                    gw0 gw0Var = gw0VarArr[iC];
                    p31.c(gw0Var);
                    list.add(gw0Var);
                    return;
                }
            }
            throw new IOException("Header index too large " + (i + 1));
        }

        private final void n(int i) {
            g(-1, new gw0(f(i), j()));
        }

        private final void o() {
            g(-1, new gw0(a.a.a(j()), j()));
        }

        private final void p(int i) throws IOException {
            this.c.add(new gw0(f(i), j()));
        }

        private final void q() throws IOException {
            this.c.add(new gw0(a.a.a(j()), j()));
        }

        public final List e() {
            List listX = j.X(this.c);
            this.c.clear();
            return listX;
        }

        public final ByteString j() {
            int i = i();
            boolean z = (i & 128) == 128;
            long jM = m(i, 127);
            if (!z) {
                return this.d.x(jM);
            }
            fo foVar = new fo();
            vx0.a.b(this.d, jM, foVar);
            return foVar.f0();
        }

        public final void k() throws IOException {
            while (!this.d.H()) {
                int iD = pa3.d(this.d.readByte(), 255);
                if (iD == 128) {
                    throw new IOException("index == 0");
                }
                if ((iD & 128) == 128) {
                    l(m(iD, 127) - 1);
                } else if (iD == 64) {
                    o();
                } else if ((iD & 64) == 64) {
                    n(m(iD, 63) - 1);
                } else if ((iD & 32) == 32) {
                    int iM = m(iD, 31);
                    this.b = iM;
                    if (iM < 0 || iM > this.a) {
                        throw new IOException("Invalid dynamic table size update " + this.b);
                    }
                    a();
                } else if (iD == 16 || iD == 0) {
                    q();
                } else {
                    p(m(iD, 15) - 1);
                }
            }
        }

        public final int m(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int i5 = i();
                if ((i5 & 128) == 0) {
                    return i2 + (i5 << i4);
                }
                i2 += (i5 & 127) << i4;
                i4 += 7;
            }
        }

        public /* synthetic */ C0154a(ks2 ks2Var, int i, int i2, int i3, y70 y70Var) {
            this(ks2Var, i, (i3 & 4) != 0 ? i : i2);
        }
    }

    public static final class b {
        public int a;
        private final boolean b;
        private final fo c;
        private int d;
        private boolean e;
        public int f;
        public gw0[] g;
        private int h;
        public int i;
        public int j;

        public b(int i, boolean z, fo foVar) {
            p31.f(foVar, "out");
            this.a = i;
            this.b = z;
            this.c = foVar;
            this.d = Integer.MAX_VALUE;
            this.f = i;
            gw0[] gw0VarArr = new gw0[8];
            this.g = gw0VarArr;
            this.h = gw0VarArr.length - 1;
        }

        private final void a() {
            int i = this.f;
            int i2 = this.j;
            if (i < i2) {
                if (i == 0) {
                    b();
                } else {
                    c(i2 - i);
                }
            }
        }

        private final void b() {
            kotlin.collections.d.n(this.g, null, 0, 0, 6, null);
            this.h = this.g.length - 1;
            this.i = 0;
            this.j = 0;
        }

        private final int c(int i) {
            int i2;
            int i3 = 0;
            if (i > 0) {
                int length = this.g.length;
                while (true) {
                    length--;
                    i2 = this.h;
                    if (length < i2 || i <= 0) {
                        break;
                    }
                    gw0 gw0Var = this.g[length];
                    p31.c(gw0Var);
                    i -= gw0Var.c;
                    int i4 = this.j;
                    gw0 gw0Var2 = this.g[length];
                    p31.c(gw0Var2);
                    this.j = i4 - gw0Var2.c;
                    this.i--;
                    i3++;
                }
                gw0[] gw0VarArr = this.g;
                System.arraycopy(gw0VarArr, i2 + 1, gw0VarArr, i2 + 1 + i3, this.i);
                gw0[] gw0VarArr2 = this.g;
                int i5 = this.h;
                Arrays.fill(gw0VarArr2, i5 + 1, i5 + 1 + i3, (Object) null);
                this.h += i3;
            }
            return i3;
        }

        private final void d(gw0 gw0Var) {
            int i = gw0Var.c;
            int i2 = this.f;
            if (i > i2) {
                b();
                return;
            }
            c((this.j + i) - i2);
            int i3 = this.i + 1;
            gw0[] gw0VarArr = this.g;
            if (i3 > gw0VarArr.length) {
                gw0[] gw0VarArr2 = new gw0[gw0VarArr.length * 2];
                System.arraycopy(gw0VarArr, 0, gw0VarArr2, gw0VarArr.length, gw0VarArr.length);
                this.h = this.g.length - 1;
                this.g = gw0VarArr2;
            }
            int i4 = this.h;
            this.h = i4 - 1;
            this.g[i4] = gw0Var;
            this.i++;
            this.j += i;
        }

        public final void e(int i) {
            this.a = i;
            int iMin = Math.min(i, 16384);
            int i2 = this.f;
            if (i2 == iMin) {
                return;
            }
            if (iMin < i2) {
                this.d = Math.min(this.d, iMin);
            }
            this.e = true;
            this.f = iMin;
            a();
        }

        public final void f(ByteString byteString) {
            p31.f(byteString, "data");
            if (this.b) {
                vx0 vx0Var = vx0.a;
                if (vx0Var.d(byteString) < byteString.size()) {
                    fo foVar = new fo();
                    vx0Var.c(byteString, foVar);
                    ByteString byteStringF0 = foVar.f0();
                    h(byteStringF0.size(), 127, 128);
                    this.c.v0(byteStringF0);
                    return;
                }
            }
            h(byteString.size(), 127, 0);
            this.c.v0(byteString);
        }

        /* JADX WARN: Code duplicated, block: B:22:0x0077  */
        public final void g(List list) {
            int length;
            int length2;
            p31.f(list, "headerBlock");
            if (this.e) {
                int i = this.d;
                if (i < this.f) {
                    h(i, 31, 32);
                }
                this.e = false;
                this.d = Integer.MAX_VALUE;
                h(this.f, 31, 32);
            }
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                gw0 gw0Var = (gw0) list.get(i2);
                ByteString asciiLowercase = gw0Var.a.toAsciiLowercase();
                ByteString byteString = gw0Var.b;
                a aVar = a.a;
                Integer num = (Integer) aVar.b().get(asciiLowercase);
                if (num != null) {
                    int iIntValue = num.intValue();
                    length2 = iIntValue + 1;
                    if (2 > length2 || length2 >= 8) {
                        length = length2;
                        length2 = -1;
                    } else if (p31.a(aVar.c()[iIntValue].b, byteString)) {
                        length = length2;
                    } else if (p31.a(aVar.c()[length2].b, byteString)) {
                        length = length2;
                        length2 = iIntValue + 2;
                    } else {
                        length = length2;
                        length2 = -1;
                    }
                } else {
                    length = -1;
                    length2 = -1;
                }
                if (length2 == -1) {
                    int length3 = this.g.length;
                    for (int i3 = this.h + 1; i3 < length3; i3++) {
                        gw0 gw0Var2 = this.g[i3];
                        p31.c(gw0Var2);
                        if (p31.a(gw0Var2.a, asciiLowercase)) {
                            gw0 gw0Var3 = this.g[i3];
                            p31.c(gw0Var3);
                            if (p31.a(gw0Var3.b, byteString)) {
                                length2 = a.a.c().length + (i3 - this.h);
                                break;
                            } else if (length == -1) {
                                length = (i3 - this.h) + a.a.c().length;
                            }
                        }
                    }
                }
                if (length2 != -1) {
                    h(length2, 127, 128);
                } else if (length == -1) {
                    this.c.I(64);
                    f(asciiLowercase);
                    f(byteString);
                    d(gw0Var);
                } else if (!asciiLowercase.startsWith(gw0.e) || p31.a(gw0.j, asciiLowercase)) {
                    h(length, 63, 64);
                    f(byteString);
                    d(gw0Var);
                } else {
                    h(length, 15, 0);
                    f(byteString);
                }
            }
        }

        public final void h(int i, int i2, int i3) {
            if (i < i2) {
                this.c.I(i | i3);
                return;
            }
            this.c.I(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.c.I(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.c.I(i4);
        }

        public /* synthetic */ b(int i, boolean z, fo foVar, int i2, y70 y70Var) {
            this((i2 & 1) != 0 ? 4096 : i, (i2 & 2) != 0 ? true : z, foVar);
        }
    }
}
