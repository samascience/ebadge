package kotlin.io.path;

import defpackage.ob1;
import defpackage.p31;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
final class b extends SimpleFileVisitor {
    private final boolean a;
    private c b;
    private kotlin.collections.c c = new kotlin.collections.c();

    public b(boolean z) {
        this.a = z;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public FileVisitResult preVisitDirectory(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        p31.f(path, "dir");
        p31.f(basicFileAttributes, "attrs");
        this.c.add(new c(path, basicFileAttributes.fileKey(), this.b));
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(path, basicFileAttributes);
        p31.e(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    public final List b(c cVar) throws IOException {
        p31.f(cVar, "directoryNode");
        this.b = cVar;
        Files.walkFileTree(cVar.d(), ob1.a.a(this.a), 1, this);
        this.c.removeFirst();
        kotlin.collections.c cVar2 = this.c;
        this.c = new kotlin.collections.c();
        return cVar2;
    }

    @Override // java.nio.file.SimpleFileVisitor, java.nio.file.FileVisitor
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) throws IOException {
        p31.f(path, "file");
        p31.f(basicFileAttributes, "attrs");
        this.c.add(new c(path, null, this.b));
        FileVisitResult fileVisitResultVisitFile = super.visitFile(path, basicFileAttributes);
        p31.e(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }
}
