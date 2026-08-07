package defpackage;

import com.alibaba.dashscope.exception.UploadFileException;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class j52 {

    public static class a {
        private String a;
        private ns1 b;

        public a(String str, ns1 ns1Var) {
            this.a = str;
            this.b = ns1Var;
        }

        public ns1 a() {
            return this.b;
        }

        public String b() {
            return this.a;
        }
    }

    public static class b {
        private boolean a;
        private ns1 b;

        public b(boolean z, ns1 ns1Var) {
            this.a = z;
            this.b = ns1Var;
        }

        public ns1 a() {
            return this.b;
        }

        public boolean b() {
            return this.a;
        }
    }

    public static class c {
        private boolean a;
        private ns1 b;

        public c(boolean z, ns1 ns1Var) {
            this.a = z;
            this.b = ns1Var;
        }

        public ns1 a() {
            return this.b;
        }

        public boolean b() {
            return this.a;
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x00ee  */
    public static b a(String str, xl1 xl1Var, String str2, ns1 ns1Var) throws UploadFileException {
        boolean z = true;
        if (!xl1Var.a().equals("text") && xl1Var.c().startsWith("file://")) {
            try {
                File file = new File(new URI(xl1Var.c()));
                if (!file.exists()) {
                    throw new UploadFileException(uv2.a("Local file: %s not exists.", xl1Var.c()));
                }
                z93 z93VarD = os1.d(str, file.getAbsolutePath(), str2, ns1Var);
                if (z93VarD.c() == null) {
                    throw new UploadFileException(uv2.a("Uploading file: %s failed", xl1Var.c()));
                }
                xl1Var.b(z93VarD.c());
                ns1Var = z93VarD.b();
            } catch (URISyntaxException e) {
                throw new UploadFileException(e.getMessage());
            }
        } else if (xl1Var.a().equals("text") || !xl1Var.c().startsWith("oss://")) {
            if (xl1Var.a().equals("text") || xl1Var.c().startsWith("http") || !d(xl1Var.c())) {
                z = false;
            } else {
                File file2 = new File(xl1Var.c());
                if (file2.exists()) {
                    z93 z93VarD2 = os1.d(str, file2.getAbsolutePath(), str2, ns1Var);
                    if (z93VarD2.c() == null) {
                        throw new UploadFileException(uv2.a("Uploading file: %s failed", xl1Var.c()));
                    }
                    xl1Var.b(z93VarD2.c());
                    ns1Var = z93VarD2.b();
                } else {
                    z = false;
                }
            }
        }
        return new b(z, ns1Var);
    }

    public static b b(String str, Map.Entry entry, String str2, ns1 ns1Var) throws UploadFileException {
        String str3 = (String) entry.getKey();
        Object value = entry.getValue();
        boolean z = true;
        if (value instanceof List) {
            List list = (List) value;
            boolean z2 = false;
            for (int i = 0; i < list.size(); i++) {
                Object obj = list.get(i);
                if (obj instanceof String) {
                    if (str3.equals("text") || !((String) obj).startsWith("oss://")) {
                        a aVarC = c(str, str2, str3, (String) obj, ns1Var);
                        if (!aVarC.b().equals(obj)) {
                            list.set(i, aVarC.b());
                            z2 = true;
                        }
                        ns1Var = aVarC.a();
                    } else {
                        z2 = true;
                    }
                }
            }
            entry.setValue(list);
            z = z2;
        } else if (!(value instanceof String)) {
            z = false;
        } else if (str3.equals("text") || !((String) value).startsWith("oss://")) {
            a aVarC2 = c(str, str2, str3, (String) value, ns1Var);
            if (aVarC2.b().equals(value)) {
                z = false;
            } else {
                entry.setValue(aVarC2.b());
            }
            ns1Var = aVarC2.a();
        }
        return new b(z, ns1Var);
    }

    public static a c(String str, String str2, String str3, String str4, ns1 ns1Var) throws UploadFileException {
        if (str4.startsWith("file://")) {
            try {
                File file = new File(new URI(str4));
                if (!file.exists()) {
                    throw new UploadFileException(uv2.a("Local file: %s not exists.", str4));
                }
                z93 z93VarD = os1.d(str, file.getAbsolutePath(), str2, ns1Var);
                if (z93VarD.c() == null) {
                    throw new UploadFileException(uv2.a("Uploading file: %s failed", str4));
                }
                str4 = z93VarD.c();
                ns1Var = z93VarD.b();
            } catch (URISyntaxException e) {
                throw new UploadFileException(e.getMessage());
            }
        } else if (!str3.equals("text") && !str4.startsWith("http") && d(str4)) {
            File file2 = new File(str4);
            if (file2.exists()) {
                z93 z93VarD2 = os1.d(str, file2.getAbsolutePath(), str2, ns1Var);
                if (z93VarD2.c() == null) {
                    throw new UploadFileException(uv2.a("Uploading file: %s failed", str4));
                }
                str4 = z93VarD2.c();
                ns1Var = z93VarD2.b();
            }
        }
        return new a(str4, ns1Var);
    }

    public static boolean d(String str) {
        try {
            Paths.get(str, new String[0]);
            return true;
        } catch (InvalidPathException unused) {
            return false;
        }
    }

    public static c e(String str, List list, String str2, ns1 ns1Var) throws UploadFileException {
        Iterator it = list.iterator();
        boolean z = false;
        while (it.hasNext()) {
            e43.a(it.next());
            b bVarA = a(str, null, str2, ns1Var);
            if (bVarA.b() && !z) {
                z = true;
            }
            ns1Var = bVarA.a();
        }
        return new c(z, ns1Var);
    }

    public static c f(String str, vl1 vl1Var, String str2, ns1 ns1Var) throws UploadFileException {
        ArrayList arrayList = new ArrayList();
        Iterator it = vl1Var.c().iterator();
        while (it.hasNext()) {
            arrayList.add(new HashMap((Map) it.next()));
        }
        Iterator it2 = arrayList.iterator();
        boolean z = false;
        while (it2.hasNext()) {
            Iterator it3 = ((Map) it2.next()).entrySet().iterator();
            while (it3.hasNext()) {
                b bVarB = b(str, (Map.Entry) it3.next(), str2, ns1Var);
                if (bVarB.b() && !z) {
                    z = true;
                }
                ns1Var = bVarB.a();
            }
        }
        vl1Var.j(arrayList);
        return new c(z, ns1Var);
    }
}
