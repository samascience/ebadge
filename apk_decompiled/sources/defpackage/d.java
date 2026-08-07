package defpackage;

import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.EOFException;
import java.util.ArrayList;
import kotlin.collections.j;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public abstract class d {
    private static final ByteString a;
    private static final ByteString b;
    private static final ByteString c;
    private static final ByteString d;
    private static final ByteString e;

    static {
        ByteString.a aVar = ByteString.Companion;
        a = aVar.d(WatchConstant.FAT_FS_ROOT);
        b = aVar.d("\\");
        c = aVar.d("/\\");
        d = aVar.d(FileUtils.FILE_EXTENSION_SEPARATOR);
        e = aVar.d("..");
    }

    public static final hz1 j(hz1 hz1Var, hz1 hz1Var2, boolean z) {
        p31.f(hz1Var, "<this>");
        p31.f(hz1Var2, "child");
        if (hz1Var2.e() || hz1Var2.o() != null) {
            return hz1Var2;
        }
        ByteString byteStringM = m(hz1Var);
        if (byteStringM == null && (byteStringM = m(hz1Var2)) == null) {
            byteStringM = s(hz1.c);
        }
        fo foVar = new fo();
        foVar.v0(hz1Var.b());
        if (foVar.size() > 0) {
            foVar.v0(byteStringM);
        }
        foVar.v0(hz1Var2.b());
        return q(foVar, z);
    }

    public static final hz1 k(String str, boolean z) {
        p31.f(str, "<this>");
        return q(new fo().S(str), z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int l(hz1 hz1Var) {
        int iLastIndexOf$default = ByteString.lastIndexOf$default(hz1Var.b(), a, 0, 2, (Object) null);
        return iLastIndexOf$default != -1 ? iLastIndexOf$default : ByteString.lastIndexOf$default(hz1Var.b(), b, 0, 2, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteString m(hz1 hz1Var) {
        ByteString byteStringB = hz1Var.b();
        ByteString byteString = a;
        if (ByteString.indexOf$default(byteStringB, byteString, 0, 2, (Object) null) != -1) {
            return byteString;
        }
        ByteString byteStringB2 = hz1Var.b();
        ByteString byteString2 = b;
        if (ByteString.indexOf$default(byteStringB2, byteString2, 0, 2, (Object) null) != -1) {
            return byteString2;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean n(hz1 hz1Var) {
        return hz1Var.b().endsWith(e) && (hz1Var.b().size() == 2 || hz1Var.b().rangeEquals(hz1Var.b().size() + (-3), a, 0, 1) || hz1Var.b().rangeEquals(hz1Var.b().size() + (-3), b, 0, 1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int o(hz1 hz1Var) {
        if (hz1Var.b().size() == 0) {
            return -1;
        }
        if (hz1Var.b().getByte(0) == 47) {
            return 1;
        }
        if (hz1Var.b().getByte(0) == 92) {
            if (hz1Var.b().size() <= 2 || hz1Var.b().getByte(1) != 92) {
                return 1;
            }
            int iIndexOf = hz1Var.b().indexOf(b, 2);
            return iIndexOf == -1 ? hz1Var.b().size() : iIndexOf;
        }
        if (hz1Var.b().size() > 2 && hz1Var.b().getByte(1) == 58 && hz1Var.b().getByte(2) == 92) {
            char c2 = (char) hz1Var.b().getByte(0);
            if ('a' <= c2 && c2 < '{') {
                return 3;
            }
            if ('A' <= c2 && c2 < '[') {
                return 3;
            }
        }
        return -1;
    }

    private static final boolean p(fo foVar, ByteString byteString) {
        if (!p31.a(byteString, b) || foVar.size() < 2 || foVar.e0(1L) != 58) {
            return false;
        }
        char cE0 = (char) foVar.e0(0L);
        return ('a' <= cE0 && cE0 < '{') || ('A' <= cE0 && cE0 < '[');
    }

    public static final hz1 q(fo foVar, boolean z) throws EOFException {
        ByteString byteString;
        ByteString byteStringX;
        p31.f(foVar, "<this>");
        fo foVar2 = new fo();
        ByteString byteStringR = null;
        int i = 0;
        while (true) {
            if (!foVar.m0(0L, a)) {
                byteString = b;
                if (!foVar.m0(0L, byteString)) {
                    break;
                }
            }
            byte b2 = foVar.readByte();
            if (byteStringR == null) {
                byteStringR = r(b2);
            }
            i++;
        }
        boolean z2 = i >= 2 && p31.a(byteStringR, byteString);
        if (z2) {
            p31.c(byteStringR);
            foVar2.v0(byteStringR);
            foVar2.v0(byteStringR);
        } else if (i > 0) {
            p31.c(byteStringR);
            foVar2.v0(byteStringR);
        } else {
            long jK = foVar.K(c);
            if (byteStringR == null) {
                byteStringR = jK == -1 ? s(hz1.c) : r(foVar.e0(jK));
            }
            if (p(foVar, byteStringR)) {
                if (jK == 2) {
                    foVar2.b0(foVar, 3L);
                } else {
                    foVar2.b0(foVar, 2L);
                }
            }
        }
        boolean z3 = foVar2.size() > 0;
        ArrayList arrayList = new ArrayList();
        while (!foVar.H()) {
            long jK2 = foVar.K(c);
            if (jK2 == -1) {
                byteStringX = foVar.f0();
            } else {
                byteStringX = foVar.x(jK2);
                foVar.readByte();
            }
            ByteString byteString2 = e;
            if (p31.a(byteStringX, byteString2)) {
                if (!z3 || !arrayList.isEmpty()) {
                    if (!z || (!z3 && (arrayList.isEmpty() || p31.a(j.O(arrayList), byteString2)))) {
                        arrayList.add(byteStringX);
                    } else if (!z2 || arrayList.size() != 1) {
                        j.A(arrayList);
                    }
                }
            } else if (!p31.a(byteStringX, d) && !p31.a(byteStringX, ByteString.EMPTY)) {
                arrayList.add(byteStringX);
            }
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                foVar2.v0(byteStringR);
            }
            foVar2.v0((ByteString) arrayList.get(i2));
        }
        if (foVar2.size() == 0) {
            foVar2.v0(d);
        }
        return new hz1(foVar2.f0());
    }

    private static final ByteString r(byte b2) {
        if (b2 == 47) {
            return a;
        }
        if (b2 == 92) {
            return b;
        }
        throw new IllegalArgumentException("not a directory separator: " + ((int) b2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteString s(String str) {
        if (p31.a(str, WatchConstant.FAT_FS_ROOT)) {
            return a;
        }
        if (p31.a(str, "\\")) {
            return b;
        }
        throw new IllegalArgumentException("not a directory separator: " + str);
    }
}
