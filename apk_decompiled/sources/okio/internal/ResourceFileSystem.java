package okio.internal;

import com.fasterxml.jackson.core.JsonPointer;
import com.jieli.jl_rcsp.constant.WatchConstant;
import com.tencent.connect.common.Constants;
import defpackage.ar0;
import defpackage.d63;
import defpackage.hm0;
import defpackage.hz1;
import defpackage.ja1;
import defpackage.lm0;
import defpackage.p31;
import defpackage.ul3;
import defpackage.xm0;
import defpackage.y70;
import defpackage.yq0;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.j;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
public final class ResourceFileSystem extends xm0 {
    private static final a h = new a(null);
    private static final hz1 i = hz1.a.e(hz1.b, WatchConstant.FAT_FS_ROOT, false, 1, null);
    private final ClassLoader e;
    private final xm0 f;
    private final ja1 g;

    /* JADX INFO: Access modifiers changed from: private */
    static final class a {
        public /* synthetic */ a(y70 y70Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean c(hz1 hz1Var) {
            return !i.t(hz1Var.f(), ".class", true);
        }

        public final hz1 b() {
            return ResourceFileSystem.i;
        }

        public final hz1 d(hz1 hz1Var, hz1 hz1Var2) {
            p31.f(hz1Var, "<this>");
            p31.f(hz1Var2, "base");
            return b().l(i.B(i.p0(hz1Var.toString(), hz1Var2.toString()), '\\', JsonPointer.SEPARATOR, false, 4, null));
        }

        private a() {
        }
    }

    public /* synthetic */ ResourceFileSystem(ClassLoader classLoader, boolean z, xm0 xm0Var, int i2, y70 y70Var) {
        this(classLoader, z, (i2 & 4) != 0 ? xm0.b : xm0Var);
    }

    private final hz1 j(hz1 hz1Var) {
        return i.k(hz1Var, true);
    }

    private final List k() {
        return (List) this.g.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List l(ClassLoader classLoader) throws IOException {
        Enumeration<URL> resources = classLoader.getResources(Constants.STR_EMPTY);
        p31.e(resources, "getResources(...)");
        ArrayList<URL> list = Collections.list(resources);
        p31.e(list, "list(this)");
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            p31.c(url);
            Pair pairM = m(url);
            if (pairM != null) {
                arrayList.add(pairM);
            }
        }
        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        p31.e(resources2, "getResources(...)");
        ArrayList<URL> list2 = Collections.list(resources2);
        p31.e(list2, "list(this)");
        ArrayList arrayList2 = new ArrayList();
        for (URL url2 : list2) {
            p31.c(url2);
            Pair pairN = n(url2);
            if (pairN != null) {
                arrayList2.add(pairN);
            }
        }
        return j.Q(arrayList, arrayList2);
    }

    private final Pair m(URL url) {
        if (p31.a(url.getProtocol(), "file")) {
            return d63.a(this.f, hz1.a.d(hz1.b, new File(url.toURI()), false, 1, null));
        }
        return null;
    }

    private final Pair n(URL url) {
        int iC0;
        String string = url.toString();
        p31.e(string, "toString(...)");
        if (!i.G(string, "jar:file:", false, 2, null) || (iC0 = i.c0(string, "!", 0, false, 6, null)) == -1) {
            return null;
        }
        hz1.a aVar = hz1.b;
        String strSubstring = string.substring(4, iC0);
        p31.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return d63.a(ZipFilesKt.d(hz1.a.d(aVar, new File(URI.create(strSubstring)), false, 1, null), this.f, new ar0() { // from class: okio.internal.ResourceFileSystem$toJarRoot$zip$1
            @Override // defpackage.ar0
            public final Boolean invoke(ul3 ul3Var) {
                p31.f(ul3Var, "entry");
                return Boolean.valueOf(ResourceFileSystem.h.c(ul3Var.a()));
            }
        }), i);
    }

    private final String o(hz1 hz1Var) {
        return j(hz1Var).i(i).toString();
    }

    @Override // defpackage.xm0
    public List a(hz1 hz1Var) throws FileNotFoundException {
        p31.f(hz1Var, "dir");
        String strO = o(hz1Var);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (Pair pair : k()) {
            xm0 xm0Var = (xm0) pair.component1();
            hz1 hz1Var2 = (hz1) pair.component2();
            try {
                List listA = xm0Var.a(hz1Var2.l(strO));
                ArrayList arrayList = new ArrayList();
                for (Object obj : listA) {
                    if (h.c((hz1) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(j.t(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(h.d((hz1) it.next(), hz1Var2));
                }
                j.w(linkedHashSet, arrayList2);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return j.X(linkedHashSet);
        }
        throw new FileNotFoundException("file not found: " + hz1Var);
    }

    @Override // defpackage.xm0
    public List b(hz1 hz1Var) {
        p31.f(hz1Var, "dir");
        String strO = o(hz1Var);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator it = k().iterator();
        boolean z = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            Pair pair = (Pair) it.next();
            xm0 xm0Var = (xm0) pair.component1();
            hz1 hz1Var2 = (hz1) pair.component2();
            List listB = xm0Var.b(hz1Var2.l(strO));
            if (listB != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listB) {
                    if (h.c((hz1) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(j.t(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(h.d((hz1) it2.next(), hz1Var2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                j.w(linkedHashSet, arrayList);
                z = true;
            }
        }
        if (z) {
            return j.X(linkedHashSet);
        }
        return null;
    }

    @Override // defpackage.xm0
    public lm0 d(hz1 hz1Var) {
        p31.f(hz1Var, "path");
        if (!h.c(hz1Var)) {
            return null;
        }
        String strO = o(hz1Var);
        for (Pair pair : k()) {
            lm0 lm0VarD = ((xm0) pair.component1()).d(((hz1) pair.component2()).l(strO));
            if (lm0VarD != null) {
                return lm0VarD;
            }
        }
        return null;
    }

    @Override // defpackage.xm0
    public hm0 e(hz1 hz1Var) throws FileNotFoundException {
        p31.f(hz1Var, "file");
        if (!h.c(hz1Var)) {
            throw new FileNotFoundException("file not found: " + hz1Var);
        }
        String strO = o(hz1Var);
        for (Pair pair : k()) {
            try {
                return ((xm0) pair.component1()).e(((hz1) pair.component2()).l(strO));
            } catch (FileNotFoundException unused) {
            }
        }
        throw new FileNotFoundException("file not found: " + hz1Var);
    }

    public ResourceFileSystem(ClassLoader classLoader, boolean z, xm0 xm0Var) {
        p31.f(classLoader, "classLoader");
        p31.f(xm0Var, "systemFileSystem");
        this.e = classLoader;
        this.f = xm0Var;
        this.g = kotlin.a.a(new yq0() { // from class: okio.internal.ResourceFileSystem$roots$2
            {
                super(0);
            }

            @Override // defpackage.yq0
            public final List<Pair<xm0, hz1>> invoke() {
                ResourceFileSystem resourceFileSystem = this.this$0;
                return resourceFileSystem.l(resourceFileSystem.e);
            }
        });
        if (z) {
            k().size();
        }
    }
}
