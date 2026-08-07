package kotlin.io;

import defpackage.p31;
import java.io.File;

/* JADX INFO: loaded from: classes4.dex */
final class TerminateException extends FileSystemException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TerminateException(File file) {
        super(file, null, null, 6, null);
        p31.f(file, "file");
    }
}
