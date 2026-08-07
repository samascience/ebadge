package defpackage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: loaded from: classes4.dex */
public abstract class fn0 extends en0 {
    public static void a(File file, byte[] bArr) throws IOException {
        p31.f(file, "<this>");
        p31.f(bArr, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(bArr);
            k83 k83Var = k83.a;
            ty.a(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                ty.a(fileOutputStream, th);
                throw th2;
            }
        }
    }
}
