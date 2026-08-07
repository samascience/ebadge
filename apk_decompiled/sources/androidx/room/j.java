package androidx.room;

import defpackage.pw2;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
class j implements pw2.c {
    private final String a;
    private final File b;
    private final pw2.c c;

    j(String str, File file, pw2.c cVar) {
        this.a = str;
        this.b = file;
        this.c = cVar;
    }

    @Override // pw2.c
    public pw2 a(pw2.b bVar) {
        return new i(bVar.a, this.a, this.b, bVar.c.a, this.c.a(bVar));
    }
}
