package kotlin.io.path;

import com.tencent.connect.common.Constants;
import defpackage.p31;
import java.nio.file.Path;

/* JADX INFO: loaded from: classes4.dex */
abstract class h extends g {
    public static final String j(Path path) {
        p31.f(path, "<this>");
        Path fileName = path.getFileName();
        String string = fileName != null ? fileName.toString() : null;
        return string == null ? Constants.STR_EMPTY : string;
    }

    public static final Path k(Path path, Path path2) {
        p31.f(path, "<this>");
        p31.f(path2, "base");
        try {
            return d.a.a(path, path2);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + path + "\nbase path: " + path2, e);
        }
    }
}
