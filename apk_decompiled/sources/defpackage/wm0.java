package defpackage;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class wm0 {
    wm0() {
    }

    public boolean a(File file) {
        return file.exists();
    }

    public File b(String str) {
        return new File(str);
    }

    public long c(File file) {
        return file.length();
    }
}
