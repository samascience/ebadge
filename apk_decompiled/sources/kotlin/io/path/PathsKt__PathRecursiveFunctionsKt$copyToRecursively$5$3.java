package kotlin.io.path;

import defpackage.or0;
import defpackage.p31;
import defpackage.pr0;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes4.dex */
final /* synthetic */ class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3 extends FunctionReferenceImpl implements or0 {
    final /* synthetic */ Path $normalizedTarget;
    final /* synthetic */ pr0 $onError;
    final /* synthetic */ Path $target;
    final /* synthetic */ Path $this_copyToRecursively;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3(pr0 pr0Var, Path path, Path path2, Path path3) {
        super(2, p31.a.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
        this.$onError = pr0Var;
        this.$this_copyToRecursively = path;
        this.$target = path2;
        this.$normalizedTarget = path3;
    }

    @Override // defpackage.or0
    public final FileVisitResult invoke(Path path, Exception exc) {
        p31.f(path, "p0");
        p31.f(exc, "p1");
        return g.g(this.$onError, this.$this_copyToRecursively, this.$target, this.$normalizedTarget, path, exc);
    }
}
