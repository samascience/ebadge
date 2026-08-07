package kotlin.io.path;

import com.tencent.connect.common.Constants;
import defpackage.p31;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.text.i;

/* JADX INFO: loaded from: classes4.dex */
final class d {
    public static final d a = new d();
    private static final Path b = Paths.get(Constants.STR_EMPTY, new String[0]);
    private static final Path c = Paths.get("..", new String[0]);

    private d() {
    }

    public final Path a(Path path, Path path2) {
        p31.f(path, "path");
        p31.f(path2, "base");
        Path pathNormalize = path2.normalize();
        Path pathNormalize2 = path.normalize();
        Path pathRelativize = pathNormalize.relativize(pathNormalize2);
        int iMin = Math.min(pathNormalize.getNameCount(), pathNormalize2.getNameCount());
        for (int i = 0; i < iMin; i++) {
            Path name = pathNormalize.getName(i);
            Path path3 = c;
            if (!p31.a(name, path3)) {
                break;
            }
            if (!p31.a(pathNormalize2.getName(i), path3)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (p31.a(pathNormalize2, pathNormalize) || !p31.a(pathNormalize, b)) {
            String string = pathRelativize.toString();
            String separator = pathRelativize.getFileSystem().getSeparator();
            p31.e(separator, "getSeparator(...)");
            pathNormalize2 = i.u(string, separator, false, 2, null) ? pathRelativize.getFileSystem().getPath(i.Q0(string, pathRelativize.getFileSystem().getSeparator().length()), new String[0]) : pathRelativize;
        }
        p31.c(pathNormalize2);
        return pathNormalize2;
    }
}
