package defpackage;

import java.nio.file.FileVisitOption;
import java.nio.file.LinkOption;
import java.util.Set;
import kotlin.collections.b0;

/* JADX INFO: loaded from: classes4.dex */
public final class ob1 {
    public static final ob1 a = new ob1();
    private static final LinkOption[] b = {LinkOption.NOFOLLOW_LINKS};
    private static final LinkOption[] c = new LinkOption[0];
    private static final Set d = b0.d();
    private static final Set e = b0.c(FileVisitOption.FOLLOW_LINKS);

    private ob1() {
    }

    public final Set a(boolean z) {
        return z ? e : d;
    }
}
