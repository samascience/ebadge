package kotlin.io.path;

import com.tenmeter.smlibrary.utils.FileUtils;
import defpackage.p31;
import defpackage.pr0;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.j;

/* JADX INFO: loaded from: classes4.dex */
abstract class g extends f {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            b = iArr2;
        }
    }

    public static final void c(Path path) throws IllegalFileNameException {
        p31.f(path, "<this>");
        String strJ = h.j(path);
        int iHashCode = strJ.hashCode();
        if (iHashCode != 46) {
            if (iHashCode != 1518) {
                if (iHashCode != 45679) {
                    if (iHashCode != 45724) {
                        if (iHashCode != 1472) {
                            if (iHashCode != 1473 || !strJ.equals("./")) {
                                return;
                            }
                        } else if (!strJ.equals("..")) {
                            return;
                        }
                    } else if (!strJ.equals("..\\")) {
                        return;
                    }
                } else if (!strJ.equals("../")) {
                    return;
                }
            } else if (!strJ.equals(".\\")) {
                return;
            }
        } else if (!strJ.equals(FileUtils.FILE_EXTENSION_SEPARATOR)) {
            return;
        }
        throw new IllegalFileNameException(path);
    }

    private static final void d(Path path, Path path2) throws FileSystemLoopException {
        if (!Files.isSymbolicLink(path) && Files.isSameFile(path, path2)) {
            throw new FileSystemLoopException(path.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult e(ArrayList arrayList, pr0 pr0Var, Path path, Path path2, Path path3, pr0 pr0Var2, Path path4, BasicFileAttributes basicFileAttributes) {
        try {
            if (!arrayList.isEmpty()) {
                c(path4);
                Object objO = j.O(arrayList);
                p31.e(objO, "last(...)");
                d(path4, (Path) objO);
            }
            return h((CopyActionResult) pr0Var.invoke(kotlin.io.path.a.a, path4, f(path, path2, path3, path4)));
        } catch (Exception e) {
            return g(pr0Var2, path, path2, path3, path4, e);
        }
    }

    private static final Path f(Path path, Path path2, Path path3, Path path4) throws IllegalFileNameException {
        Path pathResolve = path2.resolve(h.k(path4, path).toString());
        if (!pathResolve.normalize().startsWith(path3)) {
            throw new IllegalFileNameException(path4, pathResolve, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
        }
        p31.c(pathResolve);
        return pathResolve;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FileVisitResult g(pr0 pr0Var, Path path, Path path2, Path path3, Path path4, Exception exc) {
        return i((OnErrorResult) pr0Var.invoke(path4, f(path, path2, path3, path4), exc));
    }

    private static final FileVisitResult h(CopyActionResult copyActionResult) {
        int i = a.a[copyActionResult.ordinal()];
        if (i == 1) {
            return FileVisitResult.CONTINUE;
        }
        if (i == 2) {
            return FileVisitResult.TERMINATE;
        }
        if (i == 3) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }

    private static final FileVisitResult i(OnErrorResult onErrorResult) {
        int i = a.b[onErrorResult.ordinal()];
        if (i == 1) {
            return FileVisitResult.TERMINATE;
        }
        if (i == 2) {
            return FileVisitResult.SKIP_SUBTREE;
        }
        throw new NoWhenBranchMatchedException();
    }
}
