package kotlin.io.path;

import defpackage.p31;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;

/* JADX INFO: loaded from: classes4.dex */
public abstract class e {
    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean c(c cVar) {
        for (c cVarC = cVar.c(); cVarC != null; cVarC = cVarC.c()) {
            if (cVarC.b() == null || cVar.b() == null) {
                try {
                    if (Files.isSameFile(cVarC.d(), cVar.d())) {
                        return true;
                    }
                } catch (IOException | SecurityException unused) {
                    continue;
                }
            } else if (p31.a(cVarC.b(), cVar.b())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Path path, LinkOption[] linkOptionArr) {
        try {
            LinkOption[] linkOptionArr2 = (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length);
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr2, linkOptionArr2.length));
            p31.e(attributes, "readAttributes(...)");
            return attributes.fileKey();
        } catch (Throwable unused) {
            return null;
        }
    }
}
