package defpackage;

import com.tenmeter.smlibrary.utils.FileUtils;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import okio.ByteString;

/* JADX INFO: loaded from: classes4.dex */
public final class hz1 implements Comparable {
    public static final a b = new a(null);
    public static final String c;
    private final ByteString a;

    public static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        public static /* synthetic */ hz1 d(a aVar, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return aVar.a(file, z);
        }

        public static /* synthetic */ hz1 e(a aVar, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return aVar.b(str, z);
        }

        public static /* synthetic */ hz1 f(a aVar, Path path, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return aVar.c(path, z);
        }

        public final hz1 a(File file, boolean z) {
            p31.f(file, "<this>");
            String string = file.toString();
            p31.e(string, "toString(...)");
            return b(string, z);
        }

        public final hz1 b(String str, boolean z) {
            p31.f(str, "<this>");
            return d.k(str, z);
        }

        public final hz1 c(Path path, boolean z) {
            p31.f(path, "<this>");
            return b(path.toString(), z);
        }

        private a() {
        }
    }

    static {
        String str = File.separator;
        p31.e(str, "separator");
        c = str;
    }

    public hz1(ByteString byteString) {
        p31.f(byteString, "bytes");
        this.a = byteString;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compareTo(hz1 hz1Var) {
        p31.f(hz1Var, "other");
        return b().compareTo(hz1Var.b());
    }

    public final ByteString b() {
        return this.a;
    }

    public final hz1 c() {
        int iO = d.o(this);
        if (iO == -1) {
            return null;
        }
        return new hz1(b().substring(0, iO));
    }

    public final List d() {
        ArrayList arrayList = new ArrayList();
        int iO = d.o(this);
        if (iO == -1) {
            iO = 0;
        } else if (iO < b().size() && b().getByte(iO) == 92) {
            iO++;
        }
        int size = b().size();
        int i = iO;
        while (iO < size) {
            if (b().getByte(iO) == 47 || b().getByte(iO) == 92) {
                arrayList.add(b().substring(i, iO));
                i = iO + 1;
            }
            iO++;
        }
        if (i < b().size()) {
            arrayList.add(b().substring(i, b().size()));
        }
        return arrayList;
    }

    public final boolean e() {
        return d.o(this) != -1;
    }

    public boolean equals(Object obj) {
        return (obj instanceof hz1) && p31.a(((hz1) obj).b(), b());
    }

    public final String f() {
        return g().utf8();
    }

    public final ByteString g() {
        int iL = d.l(this);
        if (iL != -1) {
            return ByteString.substring$default(b(), iL + 1, 0, 2, null);
        }
        return (o() == null || b().size() != 2) ? b() : ByteString.EMPTY;
    }

    public final hz1 h() {
        hz1 hz1Var;
        if (p31.a(b(), d.d) || p31.a(b(), d.a) || p31.a(b(), d.b) || d.n(this)) {
            return null;
        }
        int iL = d.l(this);
        if (iL != 2 || o() == null) {
            if (iL == 1 && b().startsWith(d.b)) {
                return null;
            }
            if (iL != -1 || o() == null) {
                if (iL == -1) {
                    return new hz1(d.d);
                }
                if (iL != 0) {
                    return new hz1(ByteString.substring$default(b(), 0, iL, 1, null));
                }
                hz1Var = new hz1(ByteString.substring$default(b(), 0, 1, 1, null));
            } else {
                if (b().size() == 2) {
                    return null;
                }
                hz1Var = new hz1(ByteString.substring$default(b(), 0, 2, 1, null));
            }
        } else {
            if (b().size() == 3) {
                return null;
            }
            hz1Var = new hz1(ByteString.substring$default(b(), 0, 3, 1, null));
        }
        return hz1Var;
    }

    public int hashCode() {
        return b().hashCode();
    }

    public final hz1 i(hz1 hz1Var) {
        p31.f(hz1Var, "other");
        if (!p31.a(c(), hz1Var.c())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + hz1Var).toString());
        }
        List listD = d();
        List listD2 = hz1Var.d();
        int iMin = Math.min(listD.size(), listD2.size());
        int i = 0;
        while (i < iMin && p31.a(listD.get(i), listD2.get(i))) {
            i++;
        }
        if (i == iMin && b().size() == hz1Var.b().size()) {
            return a.e(b, FileUtils.FILE_EXTENSION_SEPARATOR, false, 1, null);
        }
        if (listD2.subList(i, listD2.size()).indexOf(d.e) != -1) {
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + hz1Var).toString());
        }
        fo foVar = new fo();
        ByteString byteStringM = d.m(hz1Var);
        if (byteStringM == null && (byteStringM = d.m(this)) == null) {
            byteStringM = d.s(c);
        }
        int size = listD2.size();
        for (int i2 = i; i2 < size; i2++) {
            foVar.v0(d.e);
            foVar.v0(byteStringM);
        }
        int size2 = listD.size();
        while (i < size2) {
            foVar.v0((ByteString) listD.get(i));
            foVar.v0(byteStringM);
            i++;
        }
        return d.q(foVar, false);
    }

    public final hz1 j(hz1 hz1Var) {
        p31.f(hz1Var, "child");
        return d.j(this, hz1Var, false);
    }

    public final hz1 k(hz1 hz1Var, boolean z) {
        p31.f(hz1Var, "child");
        return d.j(this, hz1Var, z);
    }

    public final hz1 l(String str) {
        p31.f(str, "child");
        return d.j(this, d.q(new fo().S(str), false), false);
    }

    public final File m() {
        return new File(toString());
    }

    public final Path n() {
        Path path = Paths.get(toString(), new String[0]);
        p31.e(path, "get(...)");
        return path;
    }

    public final Character o() {
        if (ByteString.indexOf$default(b(), d.a, 0, 2, (Object) null) != -1 || b().size() < 2 || b().getByte(1) != 58) {
            return null;
        }
        char c2 = (char) b().getByte(0);
        if (('a' > c2 || c2 >= '{') && ('A' > c2 || c2 >= '[')) {
            return null;
        }
        return Character.valueOf(c2);
    }

    public String toString() {
        return b().utf8();
    }
}
