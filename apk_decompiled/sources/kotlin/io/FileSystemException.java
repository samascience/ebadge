package kotlin.io;

import defpackage.ni0;
import defpackage.p31;
import defpackage.y70;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes4.dex */
public class FileSystemException extends IOException {
    private final File file;
    private final File other;
    private final String reason;

    public /* synthetic */ FileSystemException(File file, File file2, String str, int i, y70 y70Var) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }

    public final File getFile() {
        return this.file;
    }

    public final File getOther() {
        return this.other;
    }

    public final String getReason() {
        return this.reason;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystemException(File file, File file2, String str) {
        super(ni0.b(file, file2, str));
        p31.f(file, "file");
        this.file = file;
        this.other = file2;
        this.reason = str;
    }
}
