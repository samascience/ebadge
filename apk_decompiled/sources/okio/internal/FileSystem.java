package okio.internal;

import defpackage.hz1;
import defpackage.k83;
import defpackage.lm0;
import defpackage.p31;
import defpackage.sm2;
import defpackage.x30;
import defpackage.xm0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.c;
import kotlin.collections.j;
import kotlin.d;

/* JADX INFO: renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* JADX INFO: loaded from: classes4.dex */
public abstract class FileSystem {
    /* JADX WARN: Code duplicated, block: B:50:0x00f3 A[Catch: all -> 0x005d, TRY_LEAVE, TryCatch #1 {all -> 0x005d, blocks: (B:17:0x0058, B:48:0x00ed, B:50:0x00f3), top: B:69:0x0058 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x012f  */
    /* JADX WARN: Code duplicated, block: B:62:0x0142 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:65:0x0146  */
    /* JADX WARN: Code duplicated, block: B:72:0x011c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:74:? A[LOOP:0: B:48:0x00ed->B:74:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    public static final Object a(sm2 sm2Var, xm0 xm0Var, c cVar, hz1 hz1Var, boolean z, boolean z2, x30 x30Var) throws Throwable {
        FileSystem$collectRecursively$1 fileSystem$collectRecursively$1;
        xm0 xm0Var2;
        c cVar2;
        boolean z3;
        xm0 xm0Var3;
        sm2 sm2Var2;
        boolean z4;
        c cVar3;
        hz1 hz1Var2;
        boolean z5;
        boolean z6;
        Iterator it;
        hz1 hz1Var3;
        hz1 hz1Var4 = hz1Var;
        boolean z7 = z2;
        if (x30Var instanceof FileSystem$collectRecursively$1) {
            fileSystem$collectRecursively$1 = (FileSystem$collectRecursively$1) x30Var;
            int i = fileSystem$collectRecursively$1.label;
            if ((i & Integer.MIN_VALUE) != 0) {
                fileSystem$collectRecursively$1.label = i - Integer.MIN_VALUE;
            } else {
                fileSystem$collectRecursively$1 = new FileSystem$collectRecursively$1(x30Var);
            }
        } else {
            fileSystem$collectRecursively$1 = new FileSystem$collectRecursively$1(x30Var);
        }
        Object obj = fileSystem$collectRecursively$1.result;
        Object objD = kotlin.coroutines.intrinsics.a.d();
        int i2 = fileSystem$collectRecursively$1.label;
        int i3 = 0;
        if (i2 == 0) {
            d.b(obj);
            if (z7) {
                xm0Var2 = xm0Var;
                cVar2 = cVar;
                z3 = z;
            } else {
                fileSystem$collectRecursively$1.L$0 = sm2Var;
                xm0Var2 = xm0Var;
                fileSystem$collectRecursively$1.L$1 = xm0Var2;
                cVar2 = cVar;
                fileSystem$collectRecursively$1.L$2 = cVar2;
                fileSystem$collectRecursively$1.L$3 = hz1Var4;
                z3 = z;
                fileSystem$collectRecursively$1.Z$0 = z3;
                fileSystem$collectRecursively$1.Z$1 = z7;
                fileSystem$collectRecursively$1.label = 1;
                if (sm2Var.a(hz1Var4, fileSystem$collectRecursively$1) == objD) {
                    return objD;
                }
            }
            xm0Var3 = xm0Var2;
            boolean z8 = z3;
            sm2Var2 = sm2Var;
            z4 = z8;
        } else {
            if (i2 != 1) {
                if (i2 == 2) {
                    z6 = fileSystem$collectRecursively$1.Z$1;
                    z5 = fileSystem$collectRecursively$1.Z$0;
                    it = (Iterator) fileSystem$collectRecursively$1.L$4;
                    hz1Var2 = (hz1) fileSystem$collectRecursively$1.L$3;
                    cVar3 = (c) fileSystem$collectRecursively$1.L$2;
                    xm0Var3 = (xm0) fileSystem$collectRecursively$1.L$1;
                    sm2Var2 = (sm2) fileSystem$collectRecursively$1.L$0;
                    try {
                        d.b(obj);
                        while (it.hasNext()) {
                            hz1Var3 = (hz1) it.next();
                            fileSystem$collectRecursively$1.L$0 = sm2Var2;
                            fileSystem$collectRecursively$1.L$1 = xm0Var3;
                            fileSystem$collectRecursively$1.L$2 = cVar3;
                            fileSystem$collectRecursively$1.L$3 = hz1Var2;
                            fileSystem$collectRecursively$1.L$4 = it;
                            fileSystem$collectRecursively$1.Z$0 = z5;
                            fileSystem$collectRecursively$1.Z$1 = z6;
                            fileSystem$collectRecursively$1.label = 2;
                            if (a(sm2Var2, xm0Var3, cVar3, hz1Var3, z5, z6, fileSystem$collectRecursively$1) == objD) {
                                return objD;
                            }
                        }
                        cVar3.removeLast();
                        z7 = z6;
                        hz1Var4 = hz1Var2;
                        if (z7) {
                            return k83.a;
                        }
                        fileSystem$collectRecursively$1.L$0 = null;
                        fileSystem$collectRecursively$1.L$1 = null;
                        fileSystem$collectRecursively$1.L$2 = null;
                        fileSystem$collectRecursively$1.L$3 = null;
                        fileSystem$collectRecursively$1.L$4 = null;
                        fileSystem$collectRecursively$1.label = 3;
                        if (sm2Var2.a(hz1Var4, fileSystem$collectRecursively$1) == objD) {
                            return objD;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cVar3.removeLast();
                        throw th;
                    }
                } else {
                    if (i2 != 3) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    d.b(obj);
                }
                return k83.a;
            }
            boolean z9 = fileSystem$collectRecursively$1.Z$1;
            boolean z10 = fileSystem$collectRecursively$1.Z$0;
            hz1 hz1Var5 = (hz1) fileSystem$collectRecursively$1.L$3;
            cVar2 = (c) fileSystem$collectRecursively$1.L$2;
            xm0Var3 = (xm0) fileSystem$collectRecursively$1.L$1;
            sm2Var2 = (sm2) fileSystem$collectRecursively$1.L$0;
            d.b(obj);
            z7 = z9;
            z4 = z10;
            hz1Var4 = hz1Var5;
        }
        List listB = xm0Var3.b(hz1Var4);
        if (listB == null) {
            listB = j.j();
        }
        if (!listB.isEmpty()) {
            hz1 hz1Var6 = hz1Var4;
            while (true) {
                if (z4 && cVar2.contains(hz1Var6)) {
                    throw new IOException("symlink cycle at " + hz1Var4);
                }
                hz1 hz1VarC = c(xm0Var3, hz1Var6);
                if (hz1VarC != null) {
                    i3++;
                    hz1Var6 = hz1VarC;
                } else if (z4 || i3 == 0) {
                    cVar2.addLast(hz1Var6);
                    try {
                        cVar3 = cVar2;
                        hz1Var2 = hz1Var4;
                        z5 = z4;
                        z6 = z7;
                        it = listB.iterator();
                        while (it.hasNext()) {
                            hz1Var3 = (hz1) it.next();
                            fileSystem$collectRecursively$1.L$0 = sm2Var2;
                            fileSystem$collectRecursively$1.L$1 = xm0Var3;
                            fileSystem$collectRecursively$1.L$2 = cVar3;
                            fileSystem$collectRecursively$1.L$3 = hz1Var2;
                            fileSystem$collectRecursively$1.L$4 = it;
                            fileSystem$collectRecursively$1.Z$0 = z5;
                            fileSystem$collectRecursively$1.Z$1 = z6;
                            fileSystem$collectRecursively$1.label = 2;
                            if (a(sm2Var2, xm0Var3, cVar3, hz1Var3, z5, z6, fileSystem$collectRecursively$1) == objD) {
                                return objD;
                            }
                        }
                        cVar3.removeLast();
                        z7 = z6;
                        hz1Var4 = hz1Var2;
                    } catch (Throwable th2) {
                        th = th2;
                        cVar3 = cVar2;
                        cVar3.removeLast();
                        throw th;
                    }
                }
            }
        }
        if (z7) {
            return k83.a;
        }
        fileSystem$collectRecursively$1.L$0 = null;
        fileSystem$collectRecursively$1.L$1 = null;
        fileSystem$collectRecursively$1.L$2 = null;
        fileSystem$collectRecursively$1.L$3 = null;
        fileSystem$collectRecursively$1.L$4 = null;
        fileSystem$collectRecursively$1.label = 3;
        if (sm2Var2.a(hz1Var4, fileSystem$collectRecursively$1) == objD) {
            return objD;
        }
        return k83.a;
    }

    public static final lm0 b(xm0 xm0Var, hz1 hz1Var) throws FileNotFoundException {
        p31.f(xm0Var, "<this>");
        p31.f(hz1Var, "path");
        lm0 lm0VarD = xm0Var.d(hz1Var);
        if (lm0VarD != null) {
            return lm0VarD;
        }
        throw new FileNotFoundException("no such file: " + hz1Var);
    }

    public static final hz1 c(xm0 xm0Var, hz1 hz1Var) {
        p31.f(xm0Var, "<this>");
        p31.f(hz1Var, "path");
        hz1 hz1VarC = xm0Var.c(hz1Var).c();
        if (hz1VarC == null) {
            return null;
        }
        hz1 hz1VarH = hz1Var.h();
        p31.c(hz1VarH);
        return hz1VarH.j(hz1VarC);
    }
}
