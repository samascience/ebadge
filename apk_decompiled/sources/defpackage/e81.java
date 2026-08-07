package defpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
public class e81 extends xm0 {
    private final List f(hz1 hz1Var, boolean z) throws IOException {
        File fileM = hz1Var.m();
        String[] list = fileM.list();
        if (list != null) {
            ArrayList arrayList = new ArrayList();
            for (String str : list) {
                p31.c(str);
                arrayList.add(hz1Var.l(str));
            }
            j.u(arrayList);
            return arrayList;
        }
        if (!z) {
            return null;
        }
        if (fileM.exists()) {
            throw new IOException("failed to list " + hz1Var);
        }
        throw new FileNotFoundException("no such file: " + hz1Var);
    }

    @Override // defpackage.xm0
    public List a(hz1 hz1Var) throws IOException {
        p31.f(hz1Var, "dir");
        List listF = f(hz1Var, true);
        p31.c(listF);
        return listF;
    }

    @Override // defpackage.xm0
    public List b(hz1 hz1Var) {
        p31.f(hz1Var, "dir");
        return f(hz1Var, false);
    }

    @Override // defpackage.xm0
    public lm0 d(hz1 hz1Var) {
        p31.f(hz1Var, "path");
        File fileM = hz1Var.m();
        boolean zIsFile = fileM.isFile();
        boolean zIsDirectory = fileM.isDirectory();
        long jLastModified = fileM.lastModified();
        long length = fileM.length();
        if (!zIsFile && !zIsDirectory && jLastModified == 0 && length == 0 && !fileM.exists()) {
            return null;
        }
        return new lm0(zIsFile, zIsDirectory, null, Long.valueOf(length), null, Long.valueOf(jLastModified), null, null, 128, null);
    }

    @Override // defpackage.xm0
    public hm0 e(hz1 hz1Var) {
        p31.f(hz1Var, "file");
        return new d81(false, new RandomAccessFile(hz1Var.m(), "r"));
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
