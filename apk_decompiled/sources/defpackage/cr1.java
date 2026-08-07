package defpackage;

import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/* JADX INFO: loaded from: classes4.dex */
public class cr1 extends e81 {
    private final Long h(FileTime fileTime) {
        Long lValueOf = Long.valueOf(fileTime.toMillis());
        if (lValueOf.longValue() != 0) {
            return lValueOf;
        }
        return null;
    }

    @Override // defpackage.e81, defpackage.xm0
    public lm0 d(hz1 hz1Var) {
        p31.f(hz1Var, "path");
        return g(hz1Var.n());
    }

    protected final lm0 g(Path path) {
        p31.f(path, "nioPath");
        try {
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path symbolicLink = attributes.isSymbolicLink() ? Files.readSymbolicLink(path) : null;
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            hz1 hz1VarF = symbolicLink != null ? hz1.a.f(hz1.b, symbolicLink, false, 1, null) : null;
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lH = fileTimeCreationTime != null ? h(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lH2 = fileTimeLastModifiedTime != null ? h(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new lm0(zIsRegularFile, zIsDirectory, hz1VarF, lValueOf, lH, lH2, fileTimeLastAccessTime != null ? h(fileTimeLastAccessTime) : null, null, 128, null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    @Override // defpackage.e81
    public String toString() {
        return "NioSystemFileSystem";
    }
}
